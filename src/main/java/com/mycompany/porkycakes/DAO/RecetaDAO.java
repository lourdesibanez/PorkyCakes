/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

import com.mycompany.porkycakes.Objetos.Receta;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author Martin
 */
public class RecetaDAO {
    
    private final BaseDeDatosDAO bdDAO = new Sql2oDAO(); //aca le digo que voy a trabajar con una bd de tipo sql2o
    
    public List<Receta> selectAllRecetas(){
        String selectAllSQL = "SELECT * FROM RECETA;";
        List<Receta> recetas = null;
        try(Connection con = bdDAO.getConnection()){
            recetas = con.createQuery(selectAllSQL).executeAndFetch(Receta.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return recetas;
    }
    
    public List<Receta> selectRecetasBase(){
        String SQL = "SELECT * FROM RECETA WHERE codigo_producto IS NULL";
        List<Receta> recetasBase = null;
        try(Connection con = bdDAO.getConnection()){
            recetasBase = con.createQuery(SQL).executeAndFetch(Receta.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        /*List<Receta> recetas = this.selectAllRecetas(), recetasBase = null;
        
        for(Receta r : recetas){
            if(r.getCodigo_producto().wasNull()){
                recetasBase.add(r);
            }
        }*/
        
        return recetasBase;
    }
    
    public int insert(Receta receta) {
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            if(receta.getCodigo_producto() != 0){
                String sql = "INSERT INTO RECETA (nombre, tiempo_prep, porciones, codigo_producto) "
                + "VALUES (:nombre, :tiempo_prep, :porciones, :codigo_producto)";
                int id = con.createQuery(sql, true)
                        .addParameter("nombre", receta.getNombre())
                        .addParameter("tiempo_prep", receta.getTiempo_prep())
                        .addParameter("porciones", receta.getPorciones())
                        .addParameter("codigo_producto", receta.getCodigo_producto())
                        .executeUpdate()
                        .getKey(Integer.class);

                return id;
            }
            else{
                String sql = "INSERT INTO RECETA (nombre, tiempo_prep, porciones) "
                + "VALUES (:nombre, :tiempo_prep, :porciones)";
                int id = con.createQuery(sql, true)
                        .addParameter("nombre", receta.getNombre())
                        .addParameter("tiempo_prep", receta.getTiempo_prep())
                        .addParameter("porciones", receta.getPorciones())
                        .executeUpdate()
                        .getKey(Integer.class);

                return id;
            }
        }
    }
}
