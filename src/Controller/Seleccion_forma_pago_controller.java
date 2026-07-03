/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Agregar_equipaje_extra_view;
import View.Seleccion_forma_de_pago_view;
import View.cambio_de_clase_de_vuelo_viiew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class Seleccion_forma_pago_controller implements ActionListener{
    private Seleccion_forma_de_pago_view vista;
    private cambio_de_clase_de_vuelo_viiew clase;
    private Agregar_equipaje_extra_view equipaje;
    
    
    
    public Seleccion_forma_pago_controller(Seleccion_forma_de_pago_view vista, cambio_de_clase_de_vuelo_viiew clase, Agregar_equipaje_extra_view equipaje){
        this.clase = clase;
        this.equipaje = equipaje;
        this.vista = vista;
        
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.volver.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.volver){
            if(vista.getVista_anterior() == 1){
                
                vista.setVisible(false);
                
                clase.setVisible(true);
                clase.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            }else if(vista.getVista_anterior() == 2){
                vista.setVisible(false);
                
                equipaje.setVisible(true);
                equipaje.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
        
        
    }
    
    
   
    
}
