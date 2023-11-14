/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.porkycakes;

/**
 *
 * @author Luly
 */

import com.mycompany.porkycakes.Controladores.*;
import static spark.Spark.*;

public class PorkyCakes {

    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/verPedidos", PedidoControlador.getPedidos);
        
        get("/crearReceta",RecetaControlador.crearReceta);
        post("/insertarReceta", RecetaControlador.insertarReceta);
        
        get("/cargarStock", IngredienteControlador.cargarStock);
        post("/actualizarStock", IngredienteControlador.actualizarStock);
        
        get("/login", LoginControlador.iniciarSesion);
        post("/autenticarUsuario", LoginControlador.autenticarUsuario);
        
        get("/generarListaCompras", ListaControlador.generarListaCompras);
                
    }
}
