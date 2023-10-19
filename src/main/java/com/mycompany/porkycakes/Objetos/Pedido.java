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

@Data
public class Pedido {
    private int numero;
    private Date fecha_pedido;
    private Date fecha_entrega;
    private String comentario;
    private String nombre_usuario, nombre_producto;
    private int id_estado;
    private int id_metodo_de_pago;
}
