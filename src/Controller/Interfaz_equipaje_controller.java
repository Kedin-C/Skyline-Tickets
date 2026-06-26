/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Seleccion_equipaje_extra_dao;
import Model.Ticket;
import View.Agregar_equipaje_extra_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class Interfaz_equipaje_controller implements ActionListener{
    
    private Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_equipaje;
    private Agregar_equipaje_extra_view vista_agg_equipaje;
    private Seleccion_equipaje_extra_dao dao;
    private Ticket ticket;
    
    
    
   
    public Interfaz_equipaje_controller(Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_equipaje,Agregar_equipaje_extra_view vista_agg_equipaje,Seleccion_equipaje_extra_dao dao, Ticket ticket){
    this.vista_seleccion_clase_equipaje = vista_seleccion_clase_equipaje;
    this.vista_agg_equipaje = vista_agg_equipaje;
    this.dao = dao;
    this.ticket = ticket;

    vista_agg_equipaje.volver.addActionListener(this);
    vista_agg_equipaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    vista_agg_equipaje.agregar.addActionListener(this);
    vista_agg_equipaje.quitar.addActionListener(this);
    vista_agg_equipaje.actual.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        


        if(e.getSource() == vista_agg_equipaje.volver){
            vista_agg_equipaje.setVisible(false);

            vista_seleccion_clase_equipaje.setVisible(true);
            vista_seleccion_clase_equipaje.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
        
        if(e.getSource() == vista_agg_equipaje.agregar){
            if(vista_agg_equipaje.getEquipaje_estado() < 5)
            vista_agg_equipaje.setEquipaje_agregar();
            else
             JOptionPane.showMessageDialog(vista_agg_equipaje, "ya llegaste al limite de equipaje de bodega que se puede agregar");
        }
        
        if(e.getSource() == vista_agg_equipaje.quitar){
            
            if(vista_agg_equipaje.getEquipaje_estado() >0)
            vista_agg_equipaje.setEquipaje_quitar();
            else
             JOptionPane.showMessageDialog(vista_agg_equipaje, "no puedes llevar equipaje negativo");

        }
        
        if(e.getSource() == vista_agg_equipaje.actual){
        
            if(this.dao.ClaseDeVueloActual(ticket.getTicket()) == 1){
            JOptionPane.showMessageDialog(vista_seleccion_clase_equipaje, "Clase Económica\n" +
"\n" +
"Viaja con comodidad y al mejor precio. Incluye equipaje de mano, asiento estándar, entretenimiento a bordo y acceso a los servicios esenciales durante el vuelo.");
        
        }else if(this.dao.ClaseDeVueloActual(ticket.getTicket()) == 2){
        JOptionPane.showMessageDialog(vista_seleccion_clase_equipaje, "Clase Ejecutiva\n" +
"\n" +
"Disfruta de una experiencia superior con mayor espacio, embarque prioritario, acceso a salas VIP, equipaje adicional y servicio premium a bordo.");
        }else if(this.dao.ClaseDeVueloActual(ticket.getTicket()) == 3){
        JOptionPane.showMessageDialog(vista_seleccion_clase_equipaje,"Primera Clase\n" +
"\n" +
"Accede al máximo nivel de exclusividad y confort con asientos tipo cama, atención personalizada, salas VIP exclusivas, gastronomía premium y beneficios prioritarios en todo tu viaje.");
        }
        }
        
        }
        
        
    
}
