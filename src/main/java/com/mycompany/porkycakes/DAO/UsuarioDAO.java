/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.DAO;

/**
 *
 * @author Luly
 */
import com.mycompany.porkycakes.Objetos.Usuario;
import java.util.List;
import org.sql2o.Connection;

public class UsuarioDAO {
    public List<Usuario> selectAllPedidos(){
        String selectAllSQL = "SELECT * FROM USUARIO;";
        List<Usuario> usuarios = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
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
        
        return usuarios != null && !usuarios.isEmpty();
    }
    
}
