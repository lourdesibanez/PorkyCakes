/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

/**
 *
 * @author Luly
 */
import spark.*;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.*;
import com.mycompany.porkycakes.Objetos.*;
import com.mycompany.porkycakes.DAO.*;

public class IngredienteControlador {
   public static Route cargarStock = (Request request, Response response) ->{
       if(UsuarioDAO.getUsuario() != null){
           if(UsuarioDAO.getRol() == 1){
                IngredienteDAO iDAO = new IngredienteDAO();
                //para mandarle todos los ingredientes asi elije a cual cargarle stock
                List<Ingrediente> ingredientes = iDAO.selectAllIngredientes();
                HashMap model = new HashMap();
                model.put("ingredientes",ingredientes);
                return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
           }else{
               HashMap model = new HashMap();
               return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/sinPermisos.vsl"));
           }
       }else{
           response.redirect("/iniciarSesion");
           return null;
       }
   };
           
    public static Route actualizarStock = (Request request, Response response) ->{
       String cantidad = request.queryParams("");
       String codigo = request.queryParams("");
       
       IngredienteDAO iDAO = new IngredienteDAO();
       iDAO.updateStock(Integer.parseInt(cantidad),Integer.parseInt(codigo));
       
        //cuando carga el formulario esto hace que vuelva a la pagina principal para seguir cargando otro stock
       response.redirect("/cargarStock");
       return null;
   };
    
}
