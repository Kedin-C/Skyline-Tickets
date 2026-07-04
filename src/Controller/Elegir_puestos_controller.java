/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Model.Datos;
import Model.Reservas;
import Model.ReservasDao;
import View.Datos_y_pago_view;
import View.Elegir_puestos_view;
import View.Tarjeta_de_credito_view;

public class Elegir_puestos_controller implements ActionListener{
    
    Reservas reserva = new Reservas();
    ReservasDao reservadao = new ReservasDao();
    Elegir_puestos_view vista = new Elegir_puestos_view();
    Datos datos = new Datos();
    
    int filas = 0;
    int columnas = 0;
    int elegidos = 1;
    
    ArrayList<String> codigoAsiento = new ArrayList<>();
        
    public Elegir_puestos_controller(Elegir_puestos_view vista, Datos datos){
        
        this.vista = vista;
        this.datos = datos;
        
        this.vista.aleatorio.addActionListener(this);
        this.vista.siguiente.addActionListener(this);
        this.vista.volver.addActionListener(this);

        
        for (int f = 0; f < vista.torre1.length; f++) {
            filas++;
            for (int c = 0; c < vista.torre1[f].length; c++) {
                columnas++;
                if (vista.torre1[f][c] != null) {
                    vista.torre1[f][c].addActionListener(this);
                }
                
            }
        }
        
        for (int f = 0; f < vista.torre2.length; f++) {
            for (int c = 0; c < vista.torre2[f].length; c++) {
                
                if (vista.torre2[f][c] != null) {
                    vista.torre2[f][c].addActionListener(this);
                }
                
            }
        }
        
    }

    
    int totalFilas = vista.torre1.length;
    int totalColumnas = vista.torre1[0].length;
    
    @Override
    public void actionPerformed(ActionEvent e) {

        
        for (int f = 0; f < totalFilas; f++) {
            for (int c = 0; c < totalColumnas; c++) {

                if (e.getSource() == vista.torre1[f][c]) {
                    if(elegidos <= datos.getNumeroTickets()){
                        vista.torre1[f][c].setEnabled(false);

                        JButton botonPresionado = vista.torre1[f][c];

                        //Cambiar el color del botón seleccionado
                        botonPresionado.setBackground(Color.decode("#037FB9"));
                        
                        String nombrebtn = botonPresionado.getText();
                        
                        codigoAsiento.add(nombrebtn);

                        elegidos++;
                    }else{
                       return; 
                    }
                }
            }
        }

        for (int f = 0; f < vista.torre2.length; f++) {
            for (int c = 0; c < vista.torre2[f].length; c++) {

                if (e.getSource() == vista.torre2[f][c]) {
                    if(elegidos <= datos.getNumeroTickets()){
                        vista.torre2[f][c].setEnabled(false);
                        
                        JButton botonPresionado = vista.torre2[f][c];

                        //Cambiar el color del botón seleccionado
                        botonPresionado.setBackground(Color.decode("#037FB9"));
                        
                        String nombrebtn = botonPresionado.getText();
                        
                        codigoAsiento.add(nombrebtn);
                        

                        elegidos++;
                    }else{
                        return;
                    }
                }
            }
        }
        
        
        
        if(e.getSource() == vista.siguiente){
            
            if(codigoAsiento.size() == datos.getNumeroTickets()){
                datos.setCodigoAsiento(codigoAsiento);
                
                Datos_y_pago_view viewDatosyPago = new Datos_y_pago_view();
                vista.setVisible(false);
                viewDatosyPago.setVisible(true);
                Datos_y_pago_controller controllerDatosPago = new Datos_y_pago_controller(viewDatosyPago, datos);

                JOptionPane.showMessageDialog(vista, "Elegiste los puestos: " + datos.getCodigoAsiento());
                
                if(datos.getNumeroTickets() > 1)
                JOptionPane.showMessageDialog(vista, "Llena los datos de los " + datos.getNumeroTickets() + " tickets");
            }else{
                JOptionPane.showMessageDialog(vista,
                                "Debes elegir los puestos de los tickets que compraras", "Elegir puestos", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource() == vista.aleatorio){
            
            while(elegidos <= datos.getNumeroTickets()){
                
                int fila = (int)(Math.random() * totalFilas);
                int columna = (int)(Math.random() * totalColumnas);
                int torreAleatoria = (int)(Math.random() * 2);
                
                
                    
            
                if(torreAleatoria == 0){

                    if(vista.torre1[fila][columna].isEnabled()){
                        vista.torre1[fila][columna].doClick();
                    }else {
                        continue;
                    }
                }
                
                if(torreAleatoria == 1){
                    if(vista.torre2[fila][columna].isEnabled()){
                        vista.torre2[fila][columna].doClick();
                    }else {
                        continue;
                    }
                }  
            }
            
            vista.siguiente.doClick();
        }
    }
    
}
    

