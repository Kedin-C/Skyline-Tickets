/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import javax.swing.JFrame;


/**
 *
 * @author david
 */
public class Seleccion_modificacion_vuelo_usuario_controlador {
    
    Seleccion_de_vuelo_usuarioRegistrado_view vista = new Seleccion_de_vuelo_usuarioRegistrado_view();
    Ticket_dao dao = new Ticket_dao();
    Ticket ticket;
    Usuario usua;
    Usuario usu = new Usuario();
    
    
    public Seleccion_modificacion_vuelo_usuario_controlador(Seleccion_de_vuelo_usuarioRegistrado_view vista, Usuario usu, Ticket ticket) {
        this.vista = vista;
        this.usua = usu;
        this.ticket = ticket;

    
    vista.SetVuelos(dao.getTotalVuelos(usu));
        
    }

}
