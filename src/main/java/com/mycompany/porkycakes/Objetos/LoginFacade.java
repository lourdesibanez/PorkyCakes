/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Objetos;

import com.mycompany.porkycakes.DAO.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Luly
 */

//interfaz unificada para registrar cambios
public class LoginFacade {
    
   public static void registrarInicioSesion(String nombreUsuario) {
        Logger logger = LoggerFactory.getLogger(LoginFacade.class);

        logger.info("Usuario {} logueado correctamente.", nombreUsuario);
        logger.info("Fecha: {}", new Date());
        logger.info("Hora: {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
   
   public static void registrarStock(String codigo, String cantidad) {
        Logger logger = LoggerFactory.getLogger(LoginFacade.class);

        logger.info("Se actualizo el stock del ingrediente {} con cantidad {}", codigo, cantidad);
        logger.info("Fecha: {}", new Date());
        logger.info("Hora: {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
   
   public static void registrarNuevaReceta(String nombreReceta) {
        Logger logger = LoggerFactory.getLogger(LoginFacade.class);

        logger.info("Se creo la receta: {} correctamente.", nombreReceta);
        logger.info("Fecha: {}", new Date());
        logger.info("Hora: {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
    
}
