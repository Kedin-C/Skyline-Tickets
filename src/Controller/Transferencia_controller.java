/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import View.Seleccion_forma_de_pago_view;
import View.Transferencia_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Transferencia_controller implements ActionListener{
    
    private Transferencia_view vista;
    private Datos datos;
    private Seleccion_forma_de_pago_view vista_atras;
    
    public Transferencia_controller(Transferencia_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras){
        this.vista = vista;
        this.datos = datos;
        this.vista_atras = vista_atras;
        
        this.vista.volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.volver){
            
            if(vista.getCod_anterior_view() == 1){
            
               
                vista.setVisible(false);
                vista_atras.setVisible(true);
                vista_atras.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        
        }
    }
}
