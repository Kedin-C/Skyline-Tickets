/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Apartado_reportes_operacionales_view;
//import skyline_tickets.view.TipoReportes;
import View.ApartadoReportesMenuView;


/**
 *
 * @author juans
 */
public class Apartado_reportes_Controller implements ActionListener{
    
    public ApartadoReportesMenuView vista;
    public Apartado_reportes_operacionales_view vistaR;
    
    public Apartado_reportes_Controller(ApartadoReportesMenuView vista, Apartado_reportes_operacionales_view vistaR){
        this.vista=vista;
        this.vistaR=vistaR;
        this.vista.Rfinanciero.addActionListener(this);
        this.vista.Roperacional.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.Rfinanciero){
            vista.setVisible(false);
            vistaR.setVisible(true);
            vistaR.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
//            TipoReportes.tipo = 1;
        }else if(e.getSource() == vista.Roperacional){
            vista.setVisible(false);
            vistaR.setVisible(true);
            vistaR.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
//            TipoReportes.tipo = 2;
        }
    }
    
    
    
}
