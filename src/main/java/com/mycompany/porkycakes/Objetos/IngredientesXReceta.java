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
public class IngredientesXReceta {
    int id_receta, codigo_ingrediente, cantidad;
    String tipo_unidad;
}
