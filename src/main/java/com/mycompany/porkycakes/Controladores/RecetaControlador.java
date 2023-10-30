/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

import com.mycompany.porkycakes.DAO.IngredienteDAO;
import com.mycompany.porkycakes.DAO.IngredientesXRecetaDAO;
import com.mycompany.porkycakes.DAO.PasoDAO;
import com.mycompany.porkycakes.DAO.ProductoDAO;
import com.mycompany.porkycakes.DAO.RecetaDAO;
import com.mycompany.porkycakes.DAO.RecetasBaseXRecetaDAO;
import com.mycompany.porkycakes.Objetos.Ingrediente;
import com.mycompany.porkycakes.Objetos.Receta;
import com.mycompany.porkycakes.Objetos.Paso;
import com.mycompany.porkycakes.Objetos.IngredientesXReceta;
import com.mycompany.porkycakes.Objetos.Producto;
import com.mycompany.porkycakes.Objetos.RecetasBaseXReceta;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author Martin
 */
public class RecetaControlador {
    public static Route crearReceta = (Request request, Response response) -> {
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productos = pDAO.selectAllProductos();
        
        RecetaDAO rDAO = new RecetaDAO();
        List<Receta> recetasBase = rDAO.selectRecetasBase();
        
        IngredienteDAO iDAO = new IngredienteDAO();
        List<Ingrediente> ingredientes = iDAO.selectAllIngredientes();
        
        HashMap model = new HashMap();
        model.put("productos",productos);
        model.put("recetasbase", recetasBase);
        model.put("ingredientes",ingredientes);
        model.put("template","templates/cargarReceta.vsl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
    };
    
    public static Route insertarReceta = (Request request, Response response) -> {
        String nombreReceta = request.queryParams("recetaname");
        String porciones = request.queryParams("porciones");
        String tiempo_prep = request.queryParams("tiempo");
        String codigo_producto = request.queryParams("producto");
        String receta_base = request.queryParams("preparacion");
        String[] ingrediente = request.queryParamsValues("ingrediente[]");
        String[] cantidad = request.queryParamsValues("cantidad[]");
        String[] unidad = request.queryParamsValues("unidad[]");
        String[] pasos = request.queryParamsValues("ta-instruccion[]");
        
        Receta receta = new Receta();
        receta.setNombre(nombreReceta);
        receta.setCodigo_producto(Integer.parseInt(codigo_producto));
        receta.setTiempo_prep(Integer.parseInt(tiempo_prep));
        receta.setPorciones(Integer.parseInt(porciones));
        
        RecetaDAO rDAO = new RecetaDAO();
        int id_receta = rDAO.insert(receta);

        IngredientesXRecetaDAO ixrDAO = new IngredientesXRecetaDAO();
        for (int i = 0; i < ingrediente.length; i++) {
            IngredientesXReceta ixr = new IngredientesXReceta();
            ixr.setCodigo_ingrediente(Integer.parseInt(ingrediente[i]));
            ixr.setId_receta(id_receta);
            ixr.setCantidad(Integer.parseInt(cantidad[i+1]));
            ixr.setTipo_unidad(unidad[i+1]);
            ixrDAO.insert(ixr);
        }
        
        PasoDAO pDAO = new PasoDAO();
        for (int i = 1; i < pasos.length; i++) {
            Paso paso = new Paso();
            paso.setNumero(i);
            paso.setInstruccion(pasos[i]);
            paso.setId_receta(id_receta);
            pDAO.insert(paso);
        }
        
        if(!receta_base.equals("null")){
            RecetasBaseXRecetaDAO rbxrDAO = new RecetasBaseXRecetaDAO();
            RecetasBaseXReceta rbxr = new RecetasBaseXReceta();
            rbxr.setId_receta_principal(id_receta);
            rbxr.setId_receta_base(Integer.parseInt(receta_base));
            rbxrDAO.insert(rbxr);
        }
        //cuando carga el formulario esto hace que vuelva a la pagina principal para seguir cargando otro stock
        response.redirect("/crearReceta");
        return null;
    };
}
