/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.porkycakes;

/**
 *
 * @author Luly
 */

import com.mycompany.porkycakes.Controladores.PedidoControlador;
import com.mycompany.porkycakes.Controladores.RecetaControlador;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class PorkyCakes {

    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/verPedidos", PedidoControlador.getPedidos);
        get("/crearReceta",RecetaControlador.crearReceta);
        post("/insertarReceta", RecetaControlador.insertarReceta);
    }
}
