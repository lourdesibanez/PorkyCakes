/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

/**
 *
 * @author Luly
 */
import com.mycompany.porkycakes.DAO.IngredienteDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.porkycakes.Objetos.Ingrediente;

public class ListaControlador {
    public static Route generarListaCompras = (Request request, Response response) -> {
       
       IngredienteDAO iDAO = new IngredienteDAO();
  
       //para mandarle todos los ingredientes asi elije a cual cargarle stock
       List<Ingrediente> ingredientes = iDAO.selectAllIngredientes();
       
       ArrayList<Ingrediente> ingredienteLista = new ArrayList<>();
       for(Ingrediente i : ingredientes){
           int cantidad = i.getCantidad();
           int umbralMinimo = i.getUmbralMinimo();
           if(cantidad < umbralMinimo){
               ingredienteLista.add(i);
           }
       }
       HashMap model = new HashMap();
       model.put("ingredientes",ingredienteLista);
       return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
}
