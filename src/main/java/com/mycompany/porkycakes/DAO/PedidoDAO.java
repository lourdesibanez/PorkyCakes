/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

/**
 *
 * @author Luly
 */

import com.mycompany.porkycakes.Objetos.*;
import java.util.List;
import org.sql2o.Connection;

public class PedidoDAO {
    
     private final BaseDeDatosFactory bdF = new Sql2oDAOFactory(); //aca le digo que voy a trabajar con una bd de tipo sql2o
    
    public List<Pedido> selectAllPedidos(){
        BaseDeDatosDAO bdDAO = bdF.createBD();
        
        String selectAllSQL = "SELECT * FROM PEDIDO;";
        List<Pedido> pedidos = null;
        try(Connection con = bdDAO.getConnection()){
            pedidos = con.createQuery(selectAllSQL).executeAndFetch(Pedido.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return pedidos;
    }
}
