/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

/**
 *
 * @author Luly
 */
import com.mycompany.porkycakes.Objetos.*;
import com.mycompany.porkycakes.DAO.*;
import java.util.*;
import spark.*;
import spark.template.velocity.VelocityTemplateEngine;

public class PedidoControlador {
    
    public static Route getPedidos = (Request request, Response response) -> {
        if(UsuarioDAO.getUsuario() != null){
           if(UsuarioDAO.getRol() == 1){
                    PedidoDAO pDAO = new PedidoDAO();
                    List<Pedido> pedidos = pDAO.selectAllPedidos();

                    List<PedidoVista> pedidosVista = new ArrayList<>();
                    for (Pedido p : pedidos){
                        PedidoVista pv = new PedidoVista();
                        pv.setFecha_pedido(p.getFecha_pedido());
                        pv.setFecha_entrega(p.getFecha_entrega());

                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        pv.setNombre_completo_usuario(usuarioDAO.getNombreCompletoUsuario(p.getNombre_usuario()));

                        ProductosXPedidoDAO pxpDAO = new ProductosXPedidoDAO();
                        pv.setPrecio(pxpDAO.getPrecioPedido(p.getNumero()));

                        List<ProductosXPedido> nombresProductos = pxpDAO.getProductosXPedido(p.getNumero());
                        pv.setNombreProductos(nombresProductos);

                        EstadosXPedidoDAO estadoDAO = new EstadosXPedidoDAO();
                        pv.setNombre_estado(estadoDAO.getNombreEstadoActual(p.getNumero()));

                        pedidosVista.add(pv);
                    }

                    HashMap model = new HashMap();
                    model.put("pedidos",pedidosVista);
                    model.put("template","templates/verPedidos.vsl");
                    return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl"));
           }else{
               HashMap model = new HashMap();
               return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/sinPermisos.vsl"));
           }
        }else{
            response.redirect("/iniciarSesion");
           return null;
        }
    };
}
