/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.Producto;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Luly
 */
public class ProductoDAO {
    
    private final BaseDeDatosDAO bdDAO = new Sql2oDAO(); //aca le digo que voy a trabajar con una bd de tipo sql2o
    
    //aca hago la conexion a la bd buscando todos los productos
    public List<Producto> selectAllProductos(){
        String selectAllSQL = "SELECT * FROM PRODUCTO;";
        List<Producto> productos = null;
        try(Connection con = bdDAO.getConnection()){
            productos = con.createQuery(selectAllSQL).executeAndFetch(Producto.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return productos;
    }
    
    //aca hago lo mismo pero filtrando por codigo
    public float getPrecio(int codigo){
        String selectSQL = "SELECT * FROM PRODUCTO WHERE codigo = :codigo;";
        List<Producto> productos = null;
        try(Connection con = bdDAO.getConnection()){
            productos = con.createQuery(selectSQL).addParameter("codigo",codigo).executeAndFetch(Producto.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return productos.get(0).getPrecio(); //.get(0) para obtener el primer y unico nombre de la fila por la que filtre
    }
}
