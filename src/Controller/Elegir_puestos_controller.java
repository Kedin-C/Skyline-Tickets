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
import Model.Datos;
import Model.Reservas;
import Model.ReservasDao;
import Model.Usuario;
import View.Datos_y_pago_view;
import View.Elegir_puestos_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.ViewPrincipal;
import javax.swing.JOptionPane;

public class Elegir_puestos_controller implements ActionListener{
    
    Reservas reserva = new Reservas();
    ReservasDao reservadao = new ReservasDao();
    Elegir_puestos_view vista = new Elegir_puestos_view();
    Datos datos = new Datos();
    Datos_y_pago_view vistaDatosyPago = new Datos_y_pago_view();
    private Usuario usuario;
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    
    int filas = 0;
    int columnas = 0;
    
    int totalFilas = vista.torre1.length;
    int totalColumnas = vista.torre1[0].length;
    
    ArrayList<String> codigoAsiento = new ArrayList<>();
    ArrayList<String> ocupados = new ArrayList<>();
    ArrayList<String> claseActual = new ArrayList<>();
        
    public Elegir_puestos_controller(Elegir_puestos_view vista, Datos datos, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario){
        
        this.vista = vista;
        this.datos = datos;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        
        this.vista.aleatorio.addActionListener(this);
        this.vista.siguiente.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        this.vistaDatosyPago.volver.addActionListener(this);

        
        for (int f = 0; f < vista.torre1.length; f++) {
            filas++;
            for (int c = 0; c < vista.torre1[f].length; c++) {
                columnas++;
                if (vista.torre1[f][c] != null) {
                    vista.torre1[f][c].addActionListener(this);
                    vista.torre1[f][c].setEnabled(true);
                    vista.torre1[f][c].setBackground(null);
                }
                
            }
        }
        
        for (int f = 0; f < vista.torre2.length; f++) {
            for (int c = 0; c < vista.torre2[f].length; c++) {
                
                if (vista.torre2[f][c] != null) {
                    vista.torre2[f][c].addActionListener(this);
                    vista.torre2[f][c].setEnabled(true);
                    vista.torre2[f][c].setBackground(null);
                }
                
            }
        }
        
        //Para traer los puestos ocupados
        String puestoActual1 = "";
        String puestoActual2 = "";
        reserva.setCodigo_vuelo(this.datos.getCodigoVuelo());
        ocupados = reservadao.asientoReservados(reserva);
        
        if(ocupados.size() > 0){
            for (int i = 0; i < ocupados.size(); i++) {
                for (int f = 0; f < totalFilas; f++) {
                    for (int c = 0; c < totalColumnas; c++) {
                        
                        puestoActual1 = this.vista.torre1[f][c].getText();
                        puestoActual2 = this.vista.torre2[f][c].getText();
                        
                        if (ocupados.get(i).equals(puestoActual1)) {
                            this.vista.torre1[f][c].setEnabled(false);
                            
                            JButton botonPresionado = this.vista.torre1[f][c];

                            //Cambiar el color del botón seleccionado
                            botonPresionado.setBackground(Color.red);
                        }
                        
                        if (ocupados.get(i).equals(puestoActual2)) {
                            this.vista.torre2[f][c].setEnabled(false);

                            JButton botonPresionado = this.vista.torre2[f][c];

                            //Cambiar el color del botón seleccionado
                            botonPresionado.setBackground(Color.red);
                        
                        }
                    }
                }
            }
        }
        
        
        claseActual = reservadao.claseActual(this.datos.getClaseVuelo());
        for (int i = 0; i < claseActual.size(); i++) {
            for (int f = 0; f < totalFilas; f++) {
                for (int c = 0; c < totalColumnas; c++) {

                    puestoActual1 = this.vista.torre1[f][c].getText();
                    puestoActual2 = this.vista.torre2[f][c].getText();

                    if (claseActual.get(i).equals(puestoActual1)) {
                        this.vista.torre1[f][c].setEnabled(false);
                    }

                    if (claseActual.get(i).equals(puestoActual2)) {
                        this.vista.torre2[f][c].setEnabled(false);
                    }
                }
            }
        }
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        
        for (int f = 0; f < totalFilas; f++) {
            for (int c = 0; c < totalColumnas; c++) {

                if (e.getSource() == vista.torre1[f][c]) {
                    if(datos.elegidos <= datos.getNumeroTickets()){
                        vista.torre1[f][c].setEnabled(false);

                        JButton botonPresionado = vista.torre1[f][c];

                        //Cambiar el color del botón seleccionado
                        botonPresionado.setBackground(Color.decode("#037FB9"));
                        
                        String nombrebtn = botonPresionado.getText();
                        
                        codigoAsiento.add(nombrebtn);
                        
                        if(datos.getClaseVuelo() == 1){
                            datos.setTotalPagar(datos.getTotalPagar()+30000);
                        }else if(datos.getClaseVuelo() == 2){
                            datos.setTotalPagar(datos.getTotalPagar()+50000);
                        }else{
                            datos.setTotalPagar(datos.getTotalPagar()+80000);
                        }
                        
                        datos.elegidos++;
                    }else{
                       return; 
                    }
                }
            }
        }

        for (int f = 0; f < vista.torre2.length; f++) {
            for (int c = 0; c < vista.torre2[f].length; c++) {

                if (e.getSource() == vista.torre2[f][c]) {
                    if(datos.elegidos <= datos.getNumeroTickets()){
                        vista.torre2[f][c].setEnabled(false);
                        
                        JButton botonPresionado = vista.torre2[f][c];

                        //Cambiar el color del botón seleccionado
                        botonPresionado.setBackground(Color.decode("#037FB9"));
                        
                        String nombrebtn = botonPresionado.getText();
                        
                        codigoAsiento.add(nombrebtn);
                        if(datos.getClaseVuelo() == 1){
                            datos.setTotalPagar(datos.getTotalPagar()+30000);
                        }else if(datos.getClaseVuelo() == 2){
                            datos.setTotalPagar(datos.getTotalPagar()+50000);
                        }else{
                            datos.setTotalPagar(datos.getTotalPagar()+80000);
                        }
                        datos.elegidos++;
                    }else{
                        return;
                    }
                }
            }
        }
        
        
        
        if(e.getSource() == vista.siguiente){
            
            if(codigoAsiento.size() == datos.getNumeroTickets()){
                datos.setCodigoAsiento(codigoAsiento);
                
                vista.setVisible(false);
                vistaDatosyPago.setVisible(true);
                Datos_y_pago_controller controllerDatosPago = new Datos_y_pago_controller(vistaDatosyPago, datos, usuario, vistaPrincipal, viewAdmin, viewUsuario);

                JOptionPane.showMessageDialog(vista, "Los puestos elegidos son: " + datos.getCodigoAsiento());
                
                if(datos.getNumeroTickets() > 1)
                JOptionPane.showMessageDialog(vista, "Llena los datos de los " + datos.getNumeroTickets() + " tickets");
                
                
            }else{
                JOptionPane.showMessageDialog(vista,
                                "Debes elegir los puestos de los tickets que compraras", "Elegir puestos", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource() == vista.aleatorio){
            
            while(datos.elegidos <= datos.getNumeroTickets()){
                
                int fila = (int)(Math.random() * totalFilas);
                int columna = (int)(Math.random() * totalColumnas);
                int torreAleatoria = (int)(Math.random() * 2);
                
                
                    
            
                if(torreAleatoria == 0){

                    if(vista.torre1[fila][columna].isEnabled()){
                        vista.torre1[fila][columna].doClick();
                        if(datos.getClaseVuelo() == 1){
                            datos.setTotalPagar(datos.getTotalPagar()-30000);
                        }else if(datos.getClaseVuelo() == 2){
                            datos.setTotalPagar(datos.getTotalPagar()-50000);
                        }else{
                            datos.setTotalPagar(datos.getTotalPagar()-80000);
                        }
                    }else {
                        continue;
                    }
                }
                
                if(torreAleatoria == 1){
                    if(vista.torre2[fila][columna].isEnabled()){
                        vista.torre2[fila][columna].doClick();
                        if(datos.getClaseVuelo() == 1){
                            datos.setTotalPagar(datos.getTotalPagar()-30000);
                        }else if(datos.getClaseVuelo() == 2){
                            datos.setTotalPagar(datos.getTotalPagar()-50000);
                        }else{
                            datos.setTotalPagar(datos.getTotalPagar()-80000);
                        }
                    }else {
                        continue;
                    }
                }  
            }
            
            vista.siguiente.doClick();
        }
        
        if(e.getSource() == vistaDatosyPago.volver){
            vista.setVisible(true);
            vistaDatosyPago.setVisible(false);
        }
    }
    
}
    

