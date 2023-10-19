/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.RecetasBaseXReceta;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class RecetasBaseXRecetaDAO {
    public void insert(RecetasBaseXReceta rbxr){
        String sql = "INSERT INTO RECETASBASEXRECETA "
            + "VALUES(:id_receta_principal, :id_receta_base)";

            try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(sql)
            .addParameter("id_receta_principal" , rbxr.getId_receta_principal())
            .addParameter("id_receta_base" , rbxr.getId_receta_base())
            .executeUpdate();
            }
    }
}
