/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;
import com.mycompany.porkycakes.DAO.UsuarioDAO;
import com.mycompany.porkycakes.Objetos.*;
import java.util.HashMap;


/**
 *
 * @author Luly
 */
public class LoginControlador {
    
 
    public static Route iniciarSesion = (Request request, Response response) -> {
        
        HashMap model = new HashMap();
        model.put("template", "templates/login.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/login.vsl"));
        
    };
    
     public static Route autenticarUsuario = (Request request, Response response) -> {
        String username = request.queryParams("username");
        String password = request.queryParams("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.autenticarUsuario(username, password)) {
                request.session(true);
                request.session().attribute("username", username);
                response.redirect("/verPedidos");
                
                LoginFacade.registrarInicioSesion(username);
            } else {
                response.redirect("/login.vsl");
                return "Credenciales incorrectas";
            }
        return null;
    };

}

