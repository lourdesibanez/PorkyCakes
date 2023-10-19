/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;

/**
 *
 * @author Luly
 */

import java.util.Date;
import lombok.Data;
import java.util.List;

@Data
public class PedidoVista {
    private String nombre_completo_usuario, nombre_estado; 
    private List<ProductosXPedido> nombre_producto;
    private Date fecha_pedido, fecha_entrega;
    private float precio;
    
    
    public void setNombreProductos(List<ProductosXPedido> nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
}
