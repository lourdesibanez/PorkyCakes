/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Luly
 */

@Data
public class ProductosXPedido {
    int codigo_producto, numero_pedido, cantidad; 
    float precio;
}
