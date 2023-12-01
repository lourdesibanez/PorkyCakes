/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.*;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class IngredienteDAO {
    
     private final BaseDeDatosFactory bdF = new Sql2oDAOFactory(); //aca le digo que voy a trabajar con una bd de tipo sql2o
    
    public List<Ingrediente> selectAllIngredientes(){
        BaseDeDatosDAO bdDAO = bdF.createBD();
        
        String selectAllSQL = "SELECT * FROM INGREDIENTE;";
        List<Ingrediente> ingredientes = null;
        try(Connection con = bdDAO.getConnection()){
            ingredientes = con.createQuery(selectAllSQL).executeAndFetch(Ingrediente.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ingredientes;
    }
    
    public void updateStock(int cantidad, int codigo){
        BaseDeDatosDAO bdDAO = bdF.createBD();
        
        String updateSQL = "UPDATE ingrediente SET cantidad =: cantidad WHERE codigo =: codigo";
        try(Connection con = bdDAO.getConnection()){
            con.createQuery(updateSQL).executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
