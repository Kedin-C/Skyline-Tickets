/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Apartado_reportes_menu_view;
import View.Pagina_principal_administrador_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juans
 */
public class Pagina_principal_administrador_controller implements ActionListener{
    
    public Pagina_principal_administrador_view vista;
    public Apartado_reportes_menu_view vistaRM;

    public Pagina_principal_administrador_controller(Pagina_principal_administrador_view vista, Apartado_reportes_menu_view vistaRM) {
        this.vista = vista;
        this.vistaRM=vistaRM;
        this.vista.reportes.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.reportes){
            vista.setVisible(false);
            vistaRM.setVisible(true);
            vistaRM.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
    
    
    
}
