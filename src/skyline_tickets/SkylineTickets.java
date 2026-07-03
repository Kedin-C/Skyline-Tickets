/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;

import Controller.Interfaz_cambio_clase_controller;
import Controller.Interfaz_equipaje_controller;
import Controller.Modificacion_clase_equipaje_controller;
import Controller.Seleccion_forma_pago_controller;
import Controller.seleccion_modificacion_usuario_no_registrado_controller;
import Model.Seleccion_equipaje_extra_dao;
import Model.Seleccion_modificacion_clase_de_vuelo_dao;
import Model.Seleccion_vuelo_usuario_no_registrado_dao;
import Model.Ticket;
import View.Agregar_equipaje_extra_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_de_vuelo_usuarioNoregistrado_view;
import View.Seleccion_forma_de_pago_view;
import View.cambio_de_clase_de_vuelo_viiew;

/**
 *
 * @author david
 */
public class SkylineTickets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Seleccion_de_vuelo_usuarioNoregistrado_view buscar_vuelo = new Seleccion_de_vuelo_usuarioNoregistrado_view();
        Seleccion_de_Modificacion_de_vuelo_view modificacion = new Seleccion_de_Modificacion_de_vuelo_view();
        cambio_de_clase_de_vuelo_viiew clase = new cambio_de_clase_de_vuelo_viiew();
        Agregar_equipaje_extra_view bodega = new Agregar_equipaje_extra_view();
        Seleccion_forma_de_pago_view forma_pago_vista = new Seleccion_forma_de_pago_view();
        
        Ticket ticket = new Ticket();
        
        
        Seleccion_vuelo_usuario_no_registrado_dao dao_modificacion_vuelo = new Seleccion_vuelo_usuario_no_registrado_dao();
        Seleccion_modificacion_clase_de_vuelo_dao dao_modificacion_clase_vuelo = new Seleccion_modificacion_clase_de_vuelo_dao();
        Seleccion_equipaje_extra_dao dao_equipaje_extra = new Seleccion_equipaje_extra_dao();
        
        
                
        Interfaz_equipaje_controller interfaz2 = new Interfaz_equipaje_controller(modificacion,bodega,dao_equipaje_extra,ticket,forma_pago_vista);
        Interfaz_cambio_clase_controller interfaz3 = new Interfaz_cambio_clase_controller(modificacion,clase,dao_modificacion_clase_vuelo,ticket,forma_pago_vista);
        Modificacion_clase_equipaje_controller interfaz1 = new Modificacion_clase_equipaje_controller(modificacion,clase,bodega,buscar_vuelo,ticket,interfaz3,dao_equipaje_extra);
        seleccion_modificacion_usuario_no_registrado_controller interfaz = new seleccion_modificacion_usuario_no_registrado_controller(dao_modificacion_vuelo,buscar_vuelo,modificacion,interfaz1,ticket);
        Seleccion_forma_pago_controller forma_pago_controlador = new Seleccion_forma_pago_controller(forma_pago_vista, clase, bodega);        
        
        
    }
    
}
