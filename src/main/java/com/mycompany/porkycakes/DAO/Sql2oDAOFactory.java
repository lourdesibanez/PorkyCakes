/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;
import com.mycompany.porkycakes.Objetos.*;

/**
 *
 * @author Luly
 */
public class Sql2oDAOFactory extends BaseDeDatosFactory{
    
    @Override
    public BaseDeDatosDAO createBD() {
        return new Sql2oDAO();
    }
}
