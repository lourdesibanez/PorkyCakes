/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.Estado;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Luly
 */
public class EstadoDAO {
    public List<Estado> selectAllEstados(){
        String selectAllSQL = "SELECT * FROM ESTADO;";
        List<Estado> estados = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            estados = con.createQuery(selectAllSQL).executeAndFetch(Estado.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return estados;
    }
    
    public String getNombre(int id){
        String selectAllSQL = "SELECT * FROM ESTADO WHERE id = :id;";
        List<Estado> estados = null;
        
        try(Connection con = Sql2oDAO.getSql2o().open()){
            estados = con.createQuery(selectAllSQL).addParameter("id",id).executeAndFetch(Estado.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return estados.get(0).getNombre(); //.get(0) para obtener el primer y unico nombre de la fila por la que filtre
    }
}
