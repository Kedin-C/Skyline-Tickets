/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;


import Controller.Reportes_operativos_controller;
import Controller.Apartado_menu_reportes_Controller;
import Controller.Pagina_principal_administrador_controller_2;
import Controller.Reportes_financieros_controller;
import Model.Reportes_financieros_dao;
import Model.Reportes_operativos_dao;
import View.Apartado_reportes_operacionales_view;
import View.Apartado_reportes_financieros_view;
import View.Apartado_reportes_menu_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Buscar_vuelos_view;
import View.ViewPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class SkylineTickets_rama_salcedo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Apartado_reportes_operacionales_view vistaReportesO = new Apartado_reportes_operacionales_view();
//        Apartado_reportes_financieros_view vistaReportesF = new Apartado_reportes_financieros_view();
//        Seleccion_de_vuelo_usuarioRegistrado_view vistaCL = new Seleccion_de_vuelo_usuarioRegistrado_view();
//        Buscar_vuelos_view vistaCV = new Buscar_vuelos_view();
//        Apartado_reportes_menu_view vistaMenu = new Apartado_reportes_menu_view();
//        Reportes_operativos_dao reportesO = new Reportes_operativos_dao();
//        Reportes_financieros_dao reportesF = new Reportes_financieros_dao();
//        Pagina_principal_administrador_view vistaP = new Pagina_principal_administrador_view();
//        Pagina_principal_administrador_controller_2 controllerP = new Pagina_principal_administrador_controller_2(vistaP,vistaMenu,vistaCL,vistaCV);
//        Apartado_menu_reportes_Controller controlador = new Apartado_menu_reportes_Controller(vistaMenu, vistaReportesO,vistaReportesF,vistaP);
//        Reportes_operativos_controller controler_reportesO = new Reportes_operativos_controller(vistaReportesO,reportesO,vistaMenu);
//        Reportes_financieros_controller controler_reportesF = new Reportes_financieros_controller(vistaReportesF,reportesF,vistaMenu);
//        vistaP.setVisible(true);     
//        vistaP.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        ViewPrincipal v = new ViewPrincipal();
        
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
        v.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
    }
    
}
