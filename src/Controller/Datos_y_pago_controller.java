/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Datos;
import View.Datos_y_pago_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;
import View.Transferencia_view;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Datos_y_pago_controller implements ActionListener{
    
    Datos_y_pago_view vista = new Datos_y_pago_view();
    Datos datos = new Datos();
    
    Tarjeta_de_credito_view viewTarjetaCredito = new Tarjeta_de_credito_view();
    Tarjeta_de_debito_view viewTerjetaDebito = new Tarjeta_de_debito_view();
    Transferencia_view viewTransferencia = new Transferencia_view();
    
    int n;
    
    ArrayList<String> datosPasajeros = new ArrayList<>();
    
    public Datos_y_pago_controller(Datos_y_pago_view vista, Datos datos){
        
        this.datos=datos;
        this.vista=vista;
        
        //this.viewTarjetaCredito = viewTarjetaCredito;
        this.n=1;
        
        this.vista.siguiente.addActionListener(this);
        this.vista.credito.addActionListener(this);
        this.vista.debito.addActionListener(this);
        this.vista.pse.addActionListener(this);
        
        this.viewTarjetaCredito.volver.addActionListener(this);
        this.viewTerjetaDebito.volver.addActionListener(this);
        this.viewTransferencia.volver.addActionListener(this);
        
        if (this.datos.getNumeroTickets() == 1) {
            vista.siguiente.setEnabled(false);
            vista.credito.setEnabled(true);
            vista.debito.setEnabled(true);
            vista.pse.setEnabled(true);
        }
        
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.siguiente){
            
            if(validarDatos()){
                n++;
                if (n >= datos.getNumeroTickets()) {
                    vista.siguiente.setEnabled(false);
                    vista.credito.setEnabled(true);
                    vista.debito.setEnabled(true);
                    vista.pse.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(vista, "Llena los datos del ticket numero: " + n);
                }
            }
        }
        
        if (e.getSource() == vista.credito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTarjetaCredito.setVisible(true);
                Tarjeta_de_credito_controller controllerTarjetaCredito = new Tarjeta_de_credito_controller(viewTarjetaCredito, datos);
                
                datos.setDatosPersonales(datosPasajeros);
                int pago = Integer.parseInt(vista.precioTotal.getText());
                datos.setTotalPagar(pago);
            }
        }
        if (e.getSource() == vista.debito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTerjetaDebito.setVisible(true);
                Tarjeta_de_debito_controller controllerTerjetaDebito = new Tarjeta_de_debito_controller(viewTerjetaDebito, datos);
                
                datos.setDatosPersonales(datosPasajeros);
                int pago = Integer.parseInt(vista.precioTotal.getText());
                datos.setTotalPagar(pago);
            
            }
        }
        if (e.getSource() == vista.pse) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTransferencia.setVisible(true);
                Transferencia_controller controllerTransferencia = new Transferencia_controller(viewTransferencia, datos);
                
                datos.setDatosPersonales(datosPasajeros);
                int pago = Integer.parseInt(vista.precioTotal.getText());
                datos.setTotalPagar(pago);
                
            }
        }
        
        if(e.getSource() == this.viewTarjetaCredito.volver){
            vista.setVisible(true);
            viewTarjetaCredito.setVisible(false);
        }
        
        
    }
    
    public boolean validarDatos(){
        if(vista.nombrecampo != null 
            && vista.apellidocampo != null 
            && vista.numero_documento != null 
            && vista.numeroTel != null 
            && vista.correo != null 
            && vista.listar_documento.getSelectedIndex() > 0
            && vista.listar_sexo.getSelectedIndex() > 0 
            && vista.listar_nacionalidad.getSelectedIndex() > 0
            && vista.elegir_fecha.getDate() != null){
            
            String nombre, apellido, numDocumento, numTel, corre, sexo, nacionalidad, fechaNacimiento;
            int tipoDocumento;
            
            nombre = vista.nombrecampo.getText();
            apellido = vista.apellidocampo.getText();
            numDocumento = vista.numero_documento.getText();
            numTel = vista.numeroTel.getText();
            corre = vista.correo.getText();
            tipoDocumento = vista.listar_documento.getSelectedIndex();
            sexo = vista.listar_sexo.getSelectedItem().toString();
            nacionalidad = vista.listar_nacionalidad.getSelectedItem().toString();
            
            
            SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
            //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
            fechaNacimiento = formateadorRegreso.format(vista.elegir_fecha);
                    
            
            datosPasajeros.add(numDocumento+", "+nombre+", "+apellido+", "+tipoDocumento+", "+sexo+", "+numTel+", "+corre+", "+fechaNacimiento+", "+nacionalidad);
            
            return true;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Debes llenar todos los datos", "Llenar datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
