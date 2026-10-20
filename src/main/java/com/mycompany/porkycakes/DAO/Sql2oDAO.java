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
import org.sql2o.Sql2o;

public class Sql2oDAO extends BaseDeDatosDAO{
    protected static Sql2o sql2o;
    
    public static Sql2o getSql2o(){
        if(sql2o == null){
            sql2o = new Sql2o(env("DB_URL", "jdbc:mysql://localhost:3306/porkydb"), env("DB_USER", "root"), env("DB_PASS", ""));
        }
        return sql2o;
    }

    private static String env(String nombre, String valorPorDefecto){
        String valor = System.getenv(nombre);
        return valor != null ? valor : valorPorDefecto;
    }

    @Override
    public Connection getConnection() {
        return getSql2o().open();
    }
}
