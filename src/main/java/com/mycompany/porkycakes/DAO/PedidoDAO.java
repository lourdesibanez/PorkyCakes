/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

/**
 *
 * @author Luly
 */

import com.mycompany.porkycakes.Objetos.Pedido;
import java.util.List;
import org.sql2o.Connection;

public class PedidoDAO {
    public List<Pedido> selectAllPedidos(){
        String selectAllSQL = "SELECT * FROM PEDIDO;";
        List<Pedido> pedidos = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            pedidos = con.createQuery(selectAllSQL).executeAndFetch(Pedido.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return pedidos;
    }
}