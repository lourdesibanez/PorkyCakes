/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;

import lombok.Data;

/**
 *
 * @author Martin
 */
@Data
public class Receta {
    int id, tiempo_prep, porciones, codigo_producto;
    String nombre;
}
