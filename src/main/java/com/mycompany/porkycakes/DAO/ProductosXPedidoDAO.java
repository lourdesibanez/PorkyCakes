/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.ProductosXPedido;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Luly
 */
public class ProductosXPedidoDAO {
    public List<ProductosXPedido> getProductosXPedido(int numero){
        String selectSQL = "SELECT * FROM PRODUCTOSXPEDIDO WHERE numero_pedido = :numero;";
        List<ProductosXPedido> pxp = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            pxp = con.createQuery(selectSQL).addParameter("numero",numero).executeAndFetch(ProductosXPedido.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return pxp;
    }
    
    public float getPrecioPedido(int numero){
        List<ProductosXPedido> productosXPedido = getProductosXPedido(numero);
        float precio = 0;
        
        for(ProductosXPedido pxp: productosXPedido){
            int cantidad = pxp.getCantidad();

            precio += pxp.getPrecio()*cantidad;
        }
        
        return precio;
    }
}

