/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Seleccion_modificacion_clase_de_vuelo_dao;
import Model.Ticket;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.cambio_de_clase_de_vuelo_viiew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class Interfaz_cambio_clase_controller implements ActionListener {
    
    
    private Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_equipaje;
    private cambio_de_clase_de_vuelo_viiew vista_seleccion_clase;
    private Seleccion_modificacion_clase_de_vuelo_dao dao;
    private Ticket ticket = new Ticket();
    
    
    
    public Interfaz_cambio_clase_controller(Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_equipaje,cambio_de_clase_de_vuelo_viiew vista_seleccion_clase, Seleccion_modificacion_clase_de_vuelo_dao dao, Ticket ticket){
    this.vista_seleccion_clase_equipaje = vista_seleccion_clase_equipaje;
    this.vista_seleccion_clase = vista_seleccion_clase;
    this.dao = dao;
    this.ticket = ticket;

    
    
    
    
    

    this.vista_seleccion_clase.boton_volver.addActionListener(this);
    this.vista_seleccion_clase.boton_Actual.addActionListener(this);
    vista_seleccion_clase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        


        if(e.getSource() == vista_seleccion_clase.boton_volver){
            vista_seleccion_clase.setVisible(false);

            vista_seleccion_clase_equipaje.setVisible(true);
            vista_seleccion_clase_equipaje.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
        
        if(e.getSource() == vista_seleccion_clase.boton_Actual){
        if(this.dao.ClaseDeVueloActual(ticket.getId()) == 1){
            JOptionPane.showMessageDialog(vista_seleccion_clase, "Clase Económica\n" +
"\n" +
"Viaja con comodidad y al mejor precio. Incluye equipaje de mano, asiento estándar, entretenimiento a bordo y acceso a los servicios esenciales durante el vuelo.");
        
        }else if(this.dao.ClaseDeVueloActual(ticket.getId()) == 2){
        JOptionPane.showMessageDialog(vista_seleccion_clase, "Clase Ejecutiva\n" +
"\n" +
"Disfruta de una experiencia superior con mayor espacio, embarque prioritario, acceso a salas VIP, equipaje adicional y servicio premium a bordo.");
        }else if(this.dao.ClaseDeVueloActual(ticket.getId()) == 3){
        JOptionPane.showMessageDialog(vista_seleccion_clase,"Primera Clase\n" +
"\n" +
"Accede al máximo nivel de exclusividad y confort con asientos tipo cama, atención personalizada, salas VIP exclusivas, gastronomía premium y beneficios prioritarios en todo tu viaje.");
        }
        
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


