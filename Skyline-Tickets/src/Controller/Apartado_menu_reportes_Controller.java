/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Apartado_reportes_financieros_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Apartado_reportes_operacionales_view;
//import skyline_tickets.view.TipoReportes;
import View.Apartado_reportes_menu_view;
import View.Pagina_principal_administrador_view;


/**
 *
 * @author juans
 */
public class Apartado_menu_reportes_Controller implements ActionListener{
    
    public Apartado_reportes_menu_view vista;
    public Apartado_reportes_operacionales_view vistaRO;
    public Apartado_reportes_financieros_view vistaRF;
    public Pagina_principal_administrador_view vistaP;
    
    public Apartado_menu_reportes_Controller(Apartado_reportes_menu_view vista, Apartado_reportes_operacionales_view vistaRO, Apartado_reportes_financieros_view vistaRF,Pagina_principal_administrador_view vistaP){
        this.vista=vista;
        this.vistaRO=vistaRO;
        this.vistaRF=vistaRF;
        this.vistaP=vistaP;
        this.vista.Rfinanciero.addActionListener(this);
        this.vista.Roperacional.addActionListener(this);
        this.vista.volver.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.Rfinanciero){
            vista.setVisible(false);
            vistaRF.setVisible(true);
            vistaRF.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.Roperacional){
            vista.setVisible(false);
            vistaRO.setVisible(true);
            vistaRO.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.volver){
            vista.setVisible(false);
            vistaP.setVisible(true);
            vistaP.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
    
    
    
}
