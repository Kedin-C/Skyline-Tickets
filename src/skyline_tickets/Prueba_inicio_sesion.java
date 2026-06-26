/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;

import Controller.LoginController;
import View.LoginView;
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
         ViewPrincipal pv = new ViewPrincipal();
         LoginView in = new LoginView();
         LoginController con = new LoginController(in,pv);
         
             in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             in.setVisible(true);
                in.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
