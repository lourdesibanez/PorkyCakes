/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.Ingrediente;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class IngredienteDAO {
    public List<Ingrediente> selectAllIngredientes(){
        String selectAllSQL = "SELECT * FROM INGREDIENTE;";
        List<Ingrediente> ingredientes = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            ingredientes = con.createQuery(selectAllSQL).executeAndFetch(Ingrediente.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ingredientes;
    }
}
