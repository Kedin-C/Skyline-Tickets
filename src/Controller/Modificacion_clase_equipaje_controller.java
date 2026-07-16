/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Seleccion_equipaje_extra_dao;
import Model.Ticket;
import View.Agregar_equipaje_extra_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_de_vuelo_usuarioNoregistrado_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.cambio_de_clase_de_vuelo_viiew;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author david
 */
public class Modificacion_clase_equipaje_controller implements ActionListener {
    private final Seleccion_de_Modificacion_de_vuelo_view vista;
    private final cambio_de_clase_de_vuelo_viiew vista_seleccion_clase;
    private final Agregar_equipaje_extra_view vista_agg_equipaje;
    private final Seleccion_de_vuelo_usuarioNoregistrado_view vista_noregistrado;
    private Seleccion_de_vuelo_usuarioRegistrado_view vista_registrado;
    private Interfaz_cambio_clase_controller clase_cont;
    private Seleccion_equipaje_extra_dao dao_agg;
    private Ticket ticket;
    

    
    
    
    public Modificacion_clase_equipaje_controller(Seleccion_de_Modificacion_de_vuelo_view vista_seleccion_clase_equipaje,cambio_de_clase_de_vuelo_viiew vista_seleccion_clase,Agregar_equipaje_extra_view vista_agg_equipaje,Seleccion_de_vuelo_usuarioNoregistrado_view vista_atras,Ticket ticket,Interfaz_cambio_clase_controller clase_cont, Seleccion_equipaje_extra_dao dao_agg,Seleccion_de_vuelo_usuarioRegistrado_view vista_registrado){
    this.vista = vista_seleccion_clase_equipaje;
    this.vista_seleccion_clase = vista_seleccion_clase;
    this.vista_agg_equipaje = vista_agg_equipaje;
    this.vista_noregistrado = vista_atras;
    this.clase_cont = clase_cont;
    this.ticket = ticket;
    this.dao_agg = dao_agg;
    this.vista_registrado = vista_registrado;
    
    vista_seleccion_clase_equipaje.Clase_vuelo.addActionListener(this);
    vista_seleccion_clase_equipaje.Equipaje.addActionListener(this);
    vista_seleccion_clase_equipaje.Volver.addActionListener(this);
    
    this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.Clase_vuelo){
            vista.setVisible(false);
            

            clase_cont.ClasesDeVueloDisponibles(ticket.getId());
            vista_seleccion_clase.setVisible(true);
            vista_seleccion_clase.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
        
        if(e.getSource() == vista.Equipaje){
            vista.setVisible(false);
            
            vista_agg_equipaje.Vaciar_clase();
            vista_agg_equipaje.setClaseActual(dao_agg.ClaseDeVueloActual(ticket.getId()));
            vista_agg_equipaje.setVisible(true);
            vista_agg_equipaje.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
        
        if(e.getSource() == vista.Volver){
            if(vista.getVista_anterior() == 1){
            vista.setVisible(false);
            vista_noregistrado.setVisible(true);
            vista_noregistrado.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(vista.getVista_anterior() == 2){
            vista.setVisible(false);
            vista_registrado.setVisible(true);
            vista_registrado.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            

        }
        
    }
    

    
    

}
