/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.EstadosXPedido;
import java.util.Date;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class EstadosXPedidoDAO {
    public List<EstadosXPedido> selectAllEstadosXPedido(int numero_pedido){
        String selectAllSQL = "SELECT * FROM ESTADOXPEDIDO WHERE numero_pedido = :numero_pedido;";
        List<EstadosXPedido> exp = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            exp = con.createQuery(selectAllSQL).addParameter("numero_pedido", numero_pedido).executeAndFetch(EstadosXPedido.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return exp;
    }
    
    public String getNombreEstadoActual(int numero_pedido){
        List<EstadosXPedido> exp = this.selectAllEstadosXPedido(numero_pedido);
        
        int id_estado_actual = 0;
        Date fecha_est_actual = null;
        
        for(EstadosXPedido e : exp){
            Date fecha = e.getFecha();
            if((fecha_est_actual == null)|| fecha.after(fecha_est_actual)){
                fecha_est_actual = fecha;
                id_estado_actual = e.getId_estado();
            }
        }
        
        EstadoDAO eDAO = new EstadoDAO();
        return eDAO.getNombre(id_estado_actual);
    }
}
