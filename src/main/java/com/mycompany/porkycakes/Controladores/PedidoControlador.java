/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.porkycakes.Controladores;

/**
 *
 * @author Luly
 */
import com.mycompany.porkycakes.Objetos.Pedido;
import com.mycompany.porkycakes.Objetos.ProductosXPedido;
import com.mycompany.porkycakes.DAO.EstadosXPedidoDAO;
import com.mycompany.porkycakes.DAO.PedidoDAO;
import com.mycompany.porkycakes.Objetos.PedidoVista;
import com.mycompany.porkycakes.DAO.ProductosXPedidoDAO;
import com.mycompany.porkycakes.DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class PedidoControlador {
    
    public static Route getPedidos = (Request request, Response response) -> {
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
    };
}
