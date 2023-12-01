/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

/**
 *
 * @author Luly
 */
import com.mycompany.porkycakes.Objetos.*;
import java.util.List;
import org.sql2o.Connection;

public class UsuarioDAO {
    protected static Usuario usuario;
     private final BaseDeDatosFactory bdF = new Sql2oDAOFactory();
    
    //para que si el usuario no esta logueado retorne null y si esta logueado que te retorne ese usuario
    public static Usuario getUsuario(){
        return usuario;
    }
    
    public static int getRol(){
        return usuario.getRol_id();
    }
    
    public static void setUsuario(Usuario user){
        usuario = user;
    }
    
    public List<Usuario> selectAllUsuarios(){
        BaseDeDatosDAO bdDAO = bdF.createBD();
        
        String selectAllSQL = "SELECT * FROM USUARIO;";
        List<Usuario> usuarios = null;
        try(Connection con = bdDAO.getConnection()){
            usuarios = con.createQuery(selectAllSQL).executeAndFetch(Usuario.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public String getNombreCompletoUsuario(String nombre_usuario){
        String selectSQL = "SELECT * FROM USUARIO WHERE nombre_usuario = :nombre_usuario;";
        List<Usuario> usuario = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            usuario = con.createQuery(selectSQL).addParameter("nombre_usuario",nombre_usuario).executeAndFetch(Usuario.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        /*Acá van .get(0) porque solo hay un usuario en la tabla con ese nombre
        y sabemos que el usuario existe porque hizo el pedido, así que nunca devuelve una lista vacía*/
        String nombre = usuario.get(0).getNombre();
        String apellido = usuario.get(0).getApellido();
        return nombre + " " + apellido;
    }
    
    public boolean autenticarUsuario(String nombre_usuario, String contrasena) {
        String selectSQL = "SELECT * FROM USUARIO WHERE nombre_usuario = :nombre_usuario AND contrasena = :contrasena;";
        List<Usuario> usuarios = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            usuarios = con.createQuery(selectSQL)
                .addParameter("nombre_usuario", nombre_usuario)
                .addParameter("contrasena", contrasena)
                .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(usuarios != null){
            setUsuario(usuarios.get(0));
        }
        return usuarios != null && !usuarios.isEmpty();
    }
    
}
