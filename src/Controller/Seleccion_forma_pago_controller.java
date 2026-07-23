/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import View.Agregar_equipaje_extra_view;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;
import View.Transferencia_view;
import View.Cambio_de_clase_de_vuelo_viiew;
import View.Elegir_clase_view;
import View.Elegir_puestos_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class Seleccion_forma_pago_controller implements ActionListener{
    private Seleccion_forma_de_pago_view vista;
    private Cambio_de_clase_de_vuelo_viiew clase;
    private Agregar_equipaje_extra_view equipaje;
    private Tarjeta_de_credito_view credito;
    private Tarjeta_de_debito_view debito;
    private Transferencia_view transferencia;
    private Datos datos;
    private Elegir_puestos_view puestos;
    private Elegir_clase_view clase_view;
    
    
    
    public Seleccion_forma_pago_controller(Seleccion_forma_de_pago_view vista, Cambio_de_clase_de_vuelo_viiew clase, Agregar_equipaje_extra_view equipaje,Tarjeta_de_credito_view credito,Tarjeta_de_debito_view debito,Transferencia_view transferencia,Datos datos,Elegir_puestos_view puestos,Elegir_clase_view clase_view){
        this.clase = clase;
        this.equipaje = equipaje;
        this.vista = vista;
        this.credito = credito;
        this.debito = debito;
        this.transferencia = transferencia;
        this.puestos = puestos;
        this.clase_view = clase_view;
        this.datos = datos;
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.volver.addActionListener(this);
        vista.forma1.addActionListener(this);
        vista.forma2.addActionListener(this);
        vista.forma3.addActionListener(this);
       
        this.datos.setEquipajeExtra(this.equipaje.getEquipaje_estado());
        
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
            }else if(vista.getVista_anterior() == 3){
                vista.setVisible(false);
                
                if(clase.getClase_seleccionada() == 1){
                clase_view.ejecutiva.setSelected(true);
                clase_view.siguiente.doClick();
                clase_view.setVista_anterior(2);
                
                datos.setClaseVuelo(2);
                datos.setNumeroTickets(1);
                
                clase_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }else if(clase.getClase_seleccionada() == 2){
                clase_view.primera.setSelected(true);
                clase_view.siguiente.doClick();
                clase_view.setVista_anterior(2);
                
                datos.setClaseVuelo(2);
                datos.setNumeroTickets(1);
                
                clase_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        }
        
        if(e.getSource() == vista.forma1){
            
            vista.setVisible(false);
            
            credito.setVisible(true);
            credito.setExtendedState(JFrame.MAXIMIZED_BOTH);
            credito.setCod_anterior_view(1);
            //datos.vista_pago = 1;
            
        
        }
        
        if(e.getSource() == vista.forma2){
            
            vista.setVisible(false);
            
            debito.setVisible(true);
            debito.setExtendedState(JFrame.MAXIMIZED_BOTH);
            debito.setCod_anterior_view(1);
            //datos.vista_pago = 1;
        
        }
        
        if(e.getSource() == vista.forma3){
            
            vista.setVisible(false);
            
            transferencia.setVisible(true);
            transferencia.setExtendedState(JFrame.MAXIMIZED_BOTH);
            transferencia.setCod_anterior_view(1);
        
        }
        
        
    }
    
    
   
    
}
