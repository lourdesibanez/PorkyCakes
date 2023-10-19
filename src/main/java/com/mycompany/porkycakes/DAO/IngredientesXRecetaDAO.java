/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.IngredientesXReceta;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class IngredientesXRecetaDAO {
    public void insert(IngredientesXReceta ixr){
        String sql = "INSERT INTO INGREDIENTESXRECETA "
            + "VALUES(:id_receta, :codigo_ingrediente, :cantidad, :tipo_unidad)";
        
            try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(sql)
            .addParameter("id_receta" , ixr.getId_receta())
            .addParameter("codigo_ingrediente", ixr.getCodigo_ingrediente())
            .addParameter("cantidad",ixr.getCantidad())
            .addParameter("tipo_unidad", ixr.getTipo_unidad())
            .executeUpdate();
            }
    }
}
