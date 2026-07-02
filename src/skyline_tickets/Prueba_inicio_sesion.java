/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;

import Controller.LoginController;
import Controller.ViewPrincipal_controlador;
import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.LoginView;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Seleccion_forma_de_pago_view;
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
         LoginView in = new LoginView();
         Seleccion_de_vuelo_usuarioRegistrado_view seR = new  Seleccion_de_vuelo_usuarioRegistrado_view();
         ViewPrincipal_controlador prinC = new ViewPrincipal_controlador(pv,usu,ticket,seR);
         LoginController con = new LoginController(in,pv,usu);
        
        Ticket_dao dao = new Ticket_dao();
         
             in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             in.setVisible(true);
             in.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                
        
        
        
        
    }
    
}
