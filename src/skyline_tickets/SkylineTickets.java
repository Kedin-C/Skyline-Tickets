/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;


import Controller.Reportes_operativos_controller;
import Controller.Apartado_menu_reportes_Controller;
import Controller.Reportes_financieros_controller;
import Model.Reportes_financieros_dao;
import Model.Reportes_operativos_dao;
import View.Apartado_reportes_operacionales_view;
import View.Apartado_reportes_financieros_view;
import View.Apartado_reportes_menu_view;

/**
 *
 * @author david
 */
public class SkylineTickets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Apartado_reportes_operacionales_view vistaReportesO = new Apartado_reportes_operacionales_view();
        Apartado_reportes_financieros_view vistaReportesF = new Apartado_reportes_financieros_view();
        Apartado_reportes_menu_view vistaMenu = new Apartado_reportes_menu_view();
        Reportes_operativos_dao reportesO = new Reportes_operativos_dao();
        Reportes_financieros_dao reportesF = new Reportes_financieros_dao();
        Apartado_menu_reportes_Controller controlador = new Apartado_menu_reportes_Controller(vistaMenu, vistaReportesO,vistaReportesF);
        Reportes_operativos_controller controler_reportesO = new Reportes_operativos_controller(vistaReportesO,reportesO,vistaMenu);
        Reportes_financieros_controller controler_reportesF = new Reportes_financieros_controller(vistaReportesF,reportesF,vistaMenu);
        vistaMenu.setVisible(true);     
        vistaMenu.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
    }
    
}
