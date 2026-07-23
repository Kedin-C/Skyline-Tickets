/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import Model.Seleccion_modificacion_clase_de_vuelo_dao;
import Model.Ticket;
import Model.And_puestos;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_forma_de_pago_view;
import View.Cambio_de_clase_de_vuelo_viiew;
import View.Elegir_clase_view;
import View.Elegir_puestos_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class Interfaz_cambio_clase_controller implements ActionListener {
    
    
    private Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_vuelo;
    private Cambio_de_clase_de_vuelo_viiew vista_seleccion_clase;
    private Seleccion_forma_de_pago_view forma_pago;
    private Seleccion_modificacion_clase_de_vuelo_dao dao;
    private Elegir_puestos_view puesto_vista;
    private Ticket ticket;
    private Datos datos;
    private Elegir_clase_view clase_view;
    private And_puestos pva;
    
    
    
    public Interfaz_cambio_clase_controller(Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_vuelo,Cambio_de_clase_de_vuelo_viiew vista_seleccion_clase, Seleccion_modificacion_clase_de_vuelo_dao dao, Ticket ticket,Seleccion_forma_de_pago_view forma_pago,Elegir_puestos_view puesto_vista,Datos datos,Elegir_clase_view clase_view,And_puestos pva){
    this.vista_seleccion_clase_vuelo = vista_seleccion_clase_vuelo;
    this.vista_seleccion_clase = vista_seleccion_clase;
    this.forma_pago = forma_pago;
    this.puesto_vista = puesto_vista;
    this.clase_view = clase_view;
    this.dao = dao;
    this.ticket = ticket;
    this.datos = datos;
    this.pva = pva;

    
    
    
    
    

    this.vista_seleccion_clase.boton_volver.addActionListener(this);
    this.vista_seleccion_clase.boton_Actual.addActionListener(this);
    this.vista_seleccion_clase.boton_Seleccionar_ejecutiva.addActionListener(this);
    this.vista_seleccion_clase.boton_Seleccionar_primera.addActionListener(this);
    vista_seleccion_clase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        


        if(e.getSource() == vista_seleccion_clase.boton_volver){
            vista_seleccion_clase.setVisible(false);

            vista_seleccion_clase_vuelo.setVisible(true);
            vista_seleccion_clase_vuelo.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            

        }
        
        if(e.getSource() == vista_seleccion_clase.boton_Actual){
        if(this.dao.ClaseDeVueloActual(ticket.getId()) == 1){
            JOptionPane.showMessageDialog(vista_seleccion_clase, "Clase Económica Viaja con comodidad y al mejor precio. Incluye equipaje de mano, asiento estándar, entretenimiento a bordo y acceso a los servicios esenciales durante el vuelo.");
        }else if(this.dao.ClaseDeVueloActual(ticket.getId()) == 2){
            JOptionPane.showMessageDialog(vista_seleccion_clase, "Clase Ejecutiva Disfruta de una experiencia superior con mayor espacio, embarque prioritario, acceso a salas VIP, equipaje adicional y servicio premium a bordo.");
        }else if(this.dao.ClaseDeVueloActual(ticket.getId()) == 3){
            JOptionPane.showMessageDialog(vista_seleccion_clase,"Primera Clase Accede al máximo nivel de exclusividad y confort con asientos tipo cama, atención personalizada, salas VIP exclusivas, gastronomía premium y beneficios prioritarios en todo tu viaje.");
        }
        
        }
        
        if(e.getSource() == vista_seleccion_clase.boton_Seleccionar_ejecutiva){
            vista_seleccion_clase.setVisible(false);
            
            clase_view.ejecutiva.setSelected(true);
            clase_view.siguiente.doClick();
            clase_view.setVista_anterior(2);
            pva.setNumero(2);
            datos.setClaseVuelo(2);
            datos.setNumeroTickets(1);

            vista_seleccion_clase.setClase_seleccionada(1);
        
        }
        
        if(e.getSource() == vista_seleccion_clase.boton_Seleccionar_primera){
            vista_seleccion_clase.setVisible(false);
            clase_view.primera.setSelected(true);
            pva.setNumero(2);
            clase_view.siguiente.doClick();
            
            clase_view.setVista_anterior(2);
            datos.setClaseVuelo(2);
            datos.setNumeroTickets(1);
            
            vista_seleccion_clase.setClase_seleccionada(2);

        }
        
        
    }
    
    
    public void ClasesDeVueloDisponibles(int var){
    
        
     int id = dao.ClaseDeVueloActual(var);
    

//    JOptionPane.showMessageDialog(null, clase_ingreso.getTicket());
    vista_seleccion_clase.remove();
    vista_seleccion_clase.removeBotones();
    
    if (id == 1){
    this.vista_seleccion_clase.setClase_actual(1);
    this.vista_seleccion_clase.setClase_disponible(2);
    this.vista_seleccion_clase.setClase_disponible2(3);
    }else if (id == 2){
    this.vista_seleccion_clase.setClase_actual(2);
    this.vista_seleccion_clase.setClase_disponible(3);
    }else if (id == 3){
    this.vista_seleccion_clase.setClase_actual(3);
    }
    
    
    }
}


