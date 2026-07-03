/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Apartado_reportes_menu_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Buscar_vuelos_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juans
 */
public class Pagina_principal_administrador_controller implements ActionListener{
    
    public Pagina_principal_administrador_view vista;
    public Apartado_reportes_menu_view vistaRM;
    public Seleccion_de_vuelo_usuarioRegistrado_view vistaCL;
    public Buscar_vuelos_view vistaCV;

    public Pagina_principal_administrador_controller(Pagina_principal_administrador_view vista, Apartado_reportes_menu_view vistaRM, Pagina_principal_administrador_view vistaCL,Buscar_vuelos_view vistaCV) {
        this.vista = vista;
        this.vistaRM=vistaRM;
        this.vistaCL=vistaCL;
        this.vistaCV=vistaCV;
        this.vista.reportes.addActionListener(this);
        this.vista.comprar.addActionListener(this);
        this.vista.clase.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.reportes){
            vista.setVisible(false);
            vistaRM.setVisible(true);
            vistaRM.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.comprar){
            vista.setVisible(false);
            vistaCV.setVisible(true);
            vistaCV.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.clase){
            vista.setVisible(false);
            vistaCL.setVisible(true);
            vistaCL.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
    
    
    
}
