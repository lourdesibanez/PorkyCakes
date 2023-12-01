/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.*;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class PasoDAO {
    
    private final BaseDeDatosFactory bdF = new Sql2oDAOFactory(); //aca le digo que voy a trabajar con una bd de tipo sql2o
    
    public void insert(Paso paso){
        BaseDeDatosDAO bdDAO = bdF.createBD();
        String sql = "INSERT INTO PASO "
            + "VALUES(:numero, :instruccion, :id_receta)";
        
            try (Connection con = bdDAO.getConnection()) {
            con.createQuery(sql)
            .addParameter("numero" , paso.getNumero())
            .addParameter("instruccion" , paso.getInstruccion())
            .addParameter("id_receta", paso.getId_receta())
            .executeUpdate();
            }
    }
}
