/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import Model.Datos;
import View.And_puestos;
import View.Cambio_de_clase_de_vuelo_viiew;
import View.Elegir_clase_view;
import View.Elegir_puestos_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_forma_de_pago_view;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Elegir_clase_controller implements ActionListener{
    
    Elegir_clase_view vista = new Elegir_clase_view();
    Datos datos = new Datos();
    Elegir_puestos_view vistaElegirPuestos = new Elegir_puestos_view();
    private Cambio_de_clase_de_vuelo_viiew cam_clas_view ;
    private And_puestos pva;
    private Seleccion_forma_de_pago_view modi_ticket_view ;
    private Cambio_de_clase_de_vuelo_viiew elegir_clase_vista;

    
    public Elegir_clase_controller(Elegir_clase_view vista, Datos datos,Cambio_de_clase_de_vuelo_viiew cam_view,And_puestos pva,Seleccion_forma_de_pago_view modi_ticket_view){
        this.modi_ticket_view = modi_ticket_view;
        this.elegir_clase_vista = cam_view;
        this.pva =pva;
        this.vista=vista;
        this.datos=datos;
        this.cam_clas_view = cam_view;
        
        this.vista.siguiente.addActionListener( this);
        this.vista.volver.addActionListener(this);
        
        this.vistaElegirPuestos.volver.addActionListener(this);
        
        //Se encarga de evitar que elija los 3 botones de tipo de viaje
        ButtonGroup grupoViaje = new ButtonGroup();
        grupoViaje.add(vista.economica);
        grupoViaje.add(vista.ejecutiva);
        grupoViaje.add(vista.primera);
        
        this.vista.economica.addActionListener(this);
        this.vista.ejecutiva.addActionListener(this);
        this.vista.primera.addActionListener(this);
        
        this.vista.economica.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.siguiente){

            if(vista.economica.isSelected()){
                datos.setClaseVuelo(1);
                datos.setTotalPagar(datos.getTotalPagar()+180000);
            }else if(vista.ejecutiva.isSelected()){
                datos.setClaseVuelo(2);
                datos.setTotalPagar(datos.getTotalPagar()+450000);
            }else{
                datos.setClaseVuelo(3);
                datos.setTotalPagar(datos.getTotalPagar()+850000);
            }
            
            datos.setNumeroTickets(Integer.parseInt(vista.listarNumeros.getSelectedItem().toString()));
            datos.elegidos = 1;
            
            if(vista.listarEquipaje.getSelectedIndex() > 0){
                String tickets = vista.listarEquipaje.getSelectedItem().toString();
                datos.setEquipajeExtra(Integer.parseInt(tickets.substring(0, 2)));
                if(vista.listarEquipaje.getSelectedIndex() == 1){
                    datos.setTotalPagar(datos.getTotalPagar()+60000);
                }
                if(vista.listarEquipaje.getSelectedIndex() == 2){
                    datos.setTotalPagar(datos.getTotalPagar()+80000);
                }else{
                    datos.setTotalPagar(datos.getTotalPagar()+100000);
                }
            }
            
            double preciosTickets = datos.getTotalPagar()*datos.getNumeroTickets();
            datos.setTotalPagar(preciosTickets);
            
            vista.setVisible(false);
            vistaElegirPuestos.setVisible(true);
            
            
            Elegir_puestos_controller controllerElegirPuestos = new Elegir_puestos_controller(vistaElegirPuestos, datos,pva,modi_ticket_view);
            
        }
        
        if(e.getSource() == vistaElegirPuestos.volver){
            if(pva.getNumero() == 1){
            vista.setVisible(true);
            vistaElegirPuestos.setVisible(false);
            }else if(pva.getNumero() == 2){
            
                vistaElegirPuestos.setVisible(false);
                
                cam_clas_view.setVisible(true);
                cam_clas_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
            }
        }
        
    }
}
