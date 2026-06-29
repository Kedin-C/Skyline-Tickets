/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skyline_tickets;


import Model.ReportesDao;
import View.Apartado_reportes_operacionales_view;
import View.ApartadoReportesMenuView;

/**
 *
 * @author david
 */
public class SkylineTickets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Apartado_reportes_operacionales_view vistaReportes = new Apartado_reportes_operacionales_view();
        ApartadoReportesMenuView vistaMenu = new ApartadoReportesMenuView();
        ReportesDao reportes = new ReportesDao();
        Apartado_reportes_Controller controlador = new Apartado_reportes_Controller(vistaMenu, vistaReportes);
        Reportes_controlador controler_reportes = new Reportes_controlador(vistaReportes,reportes);
        vistaMenu.setVisible(true);     
        vistaMenu.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
    }
    
}
