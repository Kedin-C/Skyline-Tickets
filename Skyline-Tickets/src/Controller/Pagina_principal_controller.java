/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Buscar_vuelos_view;
import View.Menu_principal_view;
import View.Seleccion_de_vuelo_usuarioNoregistrado_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author juans
 */
public class Pagina_principal_controller implements ActionListener{
    
    
    public Seleccion_de_vuelo_usuarioNoregistrado_view vistaCL;
    public Buscar_vuelos_view vistaCV;
    public Menu_principal_view vistaIN;
    public ViewPrincipal vista;

    public Pagina_principal_controller(ViewPrincipal vista, Seleccion_de_vuelo_usuarioNoregistrado_view vistaCL, Buscar_vuelos_view vistaCV, Menu_principal_view vistaIN) {
        this.vista = vista;
        this.vistaCL=vistaCL;
        this.vistaCV=vistaCV;
        this.vistaIN=vistaIN;
        
        this.vista.comprar.addActionListener(this);
        this.vista.clase.addActionListener(this);
        this.vista.inicio.addActionListener(this);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.comprar){
            vista.setVisible(false);
            vistaCV.setVisible(true);
            vistaCV.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            vistaCV.setPagina_anterior(1);
        }else if(e.getSource() == vista.clase){
            
            vista.setVisible(false);
            vistaCL.setVisible(true);
            vistaCL.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.inicio){
            vista.setVisible(false);
            vistaIN.setVisible(true);
            vistaIN.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
}
