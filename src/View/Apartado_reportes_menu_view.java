/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juans
 */
public class Apartado_reportes_menu_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelbotones,panelcentro,panelInferior;
    public JButton Rfinanciero,Roperacional,volver;
    
    public Apartado_reportes_menu_view(){
        String nombre = "Pagina Principal";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        volver = super.getVolver();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createVerticalGlue());
        
        //Boton Financiero
        Rfinanciero = new JButton("Reportes Financieros");
        Rfinanciero.setFont(new Font("Arial", Font.BOLD, 20));
        Rfinanciero.setBackground(Color.decode("#037FB9"));
        Rfinanciero.setForeground(Color.white);
        Rfinanciero.setPreferredSize(new Dimension(300, 150));
        
        //Boton operacional
        Roperacional = new JButton("Reportes Operacionales");
        Roperacional.setFont(new Font("Arial", Font.BOLD, 20));
        Roperacional.setBackground(Color.decode("#037FB9"));
        Roperacional.setForeground(Color.white);
        Roperacional.setPreferredSize(new Dimension(300, 150));
        
        //Panel de botones
        panelbotones = new JPanel(new GridLayout(1,3,100,100));
        panelbotones.setBackground(Color.white);
        
        //Panel centrado
        panelcentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelcentro.setBackground(Color.WHITE);
        panelcentro.add(panelbotones);
        
        //Panel centrado
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        panelInferior.setBackground(Color.white);
        panelInferior.add(volver);
        
        //Agregar componentes
        panelbotones.add(Rfinanciero);
        panelbotones.add(Roperacional);
        panel2.add(panelcentro);
        panel2.add(panelInferior);
        
    }
    
}
