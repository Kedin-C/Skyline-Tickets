/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Skyline_tickets;

import View.Confirmar_pago_view;
import javax.swing.JFrame;

/**
 *
 * @author juans
 */
public class useviewconfirmar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Confirmar_pago_view view = new Confirmar_pago_view();
        
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
}
