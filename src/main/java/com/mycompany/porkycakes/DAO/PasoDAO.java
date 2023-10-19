/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.Paso;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class PasoDAO {
    public void insert(Paso paso){
        String sql = "INSERT INTO PASO "
            + "VALUES(:numero, :instruccion, :id_receta)";
        
            try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(sql)
            .addParameter("numero" , paso.getNumero())
            .addParameter("instruccion" , paso.getInstruccion())
            .addParameter("id_receta", paso.getId_receta())
            .executeUpdate();
            }
    }
}
