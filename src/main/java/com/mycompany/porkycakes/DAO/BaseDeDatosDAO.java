/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

/**
 *
 * @author Luly
 */

import org.sql2o.Connection;

public abstract class BaseDeDatosDAO {
    public abstract Connection getConnection(); //ya que el sql2oDAO.getSql2o().open() devuelve un objeto tipo Connection
}
