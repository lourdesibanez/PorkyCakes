/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;

/**
 *
 * @author Luly
 */
import lombok.Data;

@Data
public class Usuario {
    
    private String nombre_usuario, contrasena;
    private String apellido, nombre;
    private int id_rol;
}
