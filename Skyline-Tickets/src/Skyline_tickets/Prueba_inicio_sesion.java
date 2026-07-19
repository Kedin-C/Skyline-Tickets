/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Skyline_tickets;

import Controller.Login_controller;
import Controller.Seleccion_modificacion_vuelo_usuario_controlador;
import Controller.ViewPrincipal_controlador;
import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Login_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Seleccion_forma_de_pago_view;
import View.Seleccion_forma_de_pago_view;
import View.ViewPrincipal;
import View.ViewPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class Prueba_inicio_sesion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Seleccion_forma_de_pago_view pr = new Seleccion_forma_de_pago_view();
         Usuario usu = new Usuario();
         Ticket ticket = new Ticket();
         ViewPrincipal pv = new ViewPrincipal();
         Login_view in = new Login_view();
//         Seleccion_de_vuelo_usuarioRegistrado_view seR = new  Seleccion_de_vuelo_usuarioRegistrado_view();
//         ViewPrincipal_controlador prinC = new ViewPrincipal_controlador(pv,usu,ticket,seR);
//         Login_controller con = new Login_controller(in,pv,usu);
//         
//         Seleccion_modificacion_vuelo_usuario_controlador cont_select_vuelo_registrado = new Seleccion_modificacion_vuelo_usuario_controlador(seR,usu,ticket,pv,prinC);
        
        Ticket_dao dao = new Ticket_dao();
         
             in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             in.setVisible(true);
             in.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                
        
        
        
        
    }
    
}
