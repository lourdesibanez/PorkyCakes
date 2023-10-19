/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Martin
 */

@Data
public class EstadosXPedido {
    int numero_pedido, id_estado;
    Date fecha;
}
