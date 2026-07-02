/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class Seleccion_forma_de_pago_view extends Interfaz_vista_abtractas{

    

    private Container contenedor;
    private JPanel panel1,panel2;
    private JPanel panel_cont,panel_dist1,panel_dist2,panel_dist3,panel_boton1,panel_boton2,panel_boton3,panel_dist4,text_cont;
    private JPanel panel_cont2,panel_volver;
    public JButton volver;
    public JButton forma1,forma2,forma3;
    private JLabel text;
    
     public Seleccion_forma_de_pago_view() {
        String nombre = "Seleccion forma de pago view";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2(); 
        panel2.setLayout(new BorderLayout());
        forma1 = new JButton("Targeta de credito");
        forma2 = new JButton("Targeta de débito");
        forma3 = new JButton("Transferencia PSE");
        volver = super.volver;
        
        text = new JLabel("POR FAVOR ESGOJA EL METODO DE PAGO");
        
        text.setFont(new Font("Arial",Font.BOLD,20));
        
        forma1.setPreferredSize(new Dimension(300,80));    
        forma1.setBackground(Color.decode("#037FB9"));
        forma1.setForeground(Color.WHITE);
        forma1.setFont(new Font("Arial",Font.BOLD,15));

        forma2.setPreferredSize(new Dimension(300,80));    
        forma2.setBackground(Color.decode("#037FB9"));
        forma2.setForeground(Color.WHITE);
        forma2.setFont(new Font("Arial",Font.BOLD,15));

        forma3.setPreferredSize(new Dimension(300,80));    
        forma3.setBackground(Color.decode("#037FB9"));
        forma3.setForeground(Color.WHITE);
        forma3.setFont(new Font("Arial",Font.BOLD,15));
        
        
        
        
        panel_cont = new JPanel(new GridLayout(4,1,2,2));
        panel_dist1 = new JPanel();
        panel_dist2 = new JPanel();
        panel_dist3 = new JPanel();
        panel_dist4 = new JPanel();
        
        panel_boton1 = new JPanel();
        panel_boton2 = new JPanel();
        panel_boton3 = new JPanel();
        text_cont = new JPanel();
        
        panel_cont2 = new JPanel(new BorderLayout());
        panel_volver = new JPanel();
        
        
        panel_cont.setBorder(new EmptyBorder(100,1,1,1));
        
        panel_volver.setBorder(new EmptyBorder(1,1,20,20));
        
        
        panel_boton1.add(forma1);
        panel_boton2.add(forma2);
        panel_boton3.add(forma3);
        text_cont.add(text);
        
        
        panel_volver.add(volver);
        
        panel_cont2.add(panel_volver,BorderLayout.EAST);
        
        
        
        panel_dist1.add(panel_boton1);
        panel_dist2.add(panel_boton2);
        panel_dist3.add(panel_boton3);
        panel_dist4.add(text_cont);
        
        panel_cont.add(panel_dist4);
        panel_cont.add(panel_dist1);
        panel_cont.add(panel_dist2);
        panel_cont.add(panel_dist3);
        
        panel2.add(panel_cont);
        panel2.add(panel_cont2,BorderLayout.SOUTH);
    }
    
          
    
}
