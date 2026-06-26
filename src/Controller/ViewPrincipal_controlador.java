/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david
 */
public class ViewPrincipal_controlador implements ActionListener{
    ViewPrincipal vista;
    
    public ViewPrincipal_controlador(ViewPrincipal vista){
    this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.panelboton){
        
            
        
        }
    }
}
