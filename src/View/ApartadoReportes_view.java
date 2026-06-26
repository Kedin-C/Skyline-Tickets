/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets.view;

import View.Interfaz_vista_abtractas;
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
public class ApartadoReportes_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelbotones,panelcentro;
    public JButton Rfinanciero,Roperacional,Rvuelos;
    
    public ApartadoReportes_view(){
        String nombre = "Pagina Principal";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
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
        
        //Boton vuelos
        Rvuelos = new JButton("Reportes Vuelos");
        Rvuelos.setFont(new Font("Arial", Font.BOLD, 20));
        Rvuelos.setBackground(Color.decode("#037FB9"));
        Rvuelos.setForeground(Color.white);
        Rvuelos.setPreferredSize(new Dimension(300, 150));
        
        //Panel de botones
        panelbotones = new JPanel(new GridLayout(1,3,100,100));
        panelbotones.setBackground(Color.white);
        
        //Panel centrado
        panelcentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelcentro.setBackground(Color.WHITE);
        panelcentro.add(panelbotones);
        
        //Agregar componentes
        panelbotones.add(Rfinanciero);
        panelbotones.add(Roperacional);
        panelbotones.add(Rvuelos);
        panel2.add(panelcentro);
        
    }
    
}
