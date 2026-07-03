/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;

import Controller.Buscar_vuelos_controller;
import Model.Datos;
import View.Buscar_vuelos_view;

public class SkylineTickets {

    public static void main(String[] args) {
        
        Datos datos = new Datos();
        
        Buscar_vuelos_view vistaBuscarVuelos = new Buscar_vuelos_view();
        Buscar_vuelos_controller controllerBuscarVuelos = new Buscar_vuelos_controller(vistaBuscarVuelos, datos);
        
    }
    
}
