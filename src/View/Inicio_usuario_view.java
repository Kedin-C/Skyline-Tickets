/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Nikob
 */

import Controller.Informacion_personal_controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Inicio_usuario_view extends Interfaz_vista_abtractas  {

    public Container contenedor;
    public JPanel panel1, panelboton, panelboton2;
    public Panel_con_fondo_view panel2;
    public JButton comprar, clase, infoPerso, cerrarSesion;

    public Inicio_usuario_view() {
        super("Pagina Principal");
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();

        // Botón Cerrar Sesión
        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setBackground(Color.white);
        cerrarSesion.setPreferredSize(new Dimension(150, 40));
        cerrarSesion.setFont(new Font("Arial", Font.BOLD, 15));
        cerrarSesion.setBorderPainted(false);

        // Botón Información personal
        infoPerso = new JButton("Información personal");
        infoPerso.setBackground(Color.white);
        infoPerso.setPreferredSize(new Dimension(300, 40));
        infoPerso.setFont(new Font("Arial", Font.BOLD, 15));
        infoPerso.setBorderPainted(false);

        // Panel para los botones superiores
        panelboton2 = new JPanel();
        panelboton2.setOpaque(false);
        panelboton2.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Añadimos los botones
        panelboton2.add(cerrarSesion);
        panelboton2.add(Box.createHorizontalStrut(20));
        panelboton2.add(infoPerso);

        panel1.add(panelboton2, BorderLayout.LINE_END);

        
        panel2 = new Panel_con_fondo_view("/Imagenes/fondo_principal_1.png");
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        comprar = new JButton("Comprar Vuelo");
        clase = new JButton("Modificar Clase de Vuelo y Equipaje");

        panelboton = new JPanel();
        panelboton.add(comprar);
        panelboton.setBorder(new EmptyBorder(50, 1, 50, 1));
        panelboton.setOpaque(false);

        panel2.add(Box.createVerticalGlue());                   
        panel2.add(clase);                      
        panel2.add(panelboton); 

        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
        comprar.setBackground(Color.white);
        comprar.setPreferredSize(new Dimension(300, 60));
        comprar.setFont(new Font("Arial", Font.BOLD, 24));
        comprar.setBorderPainted(false);

        clase.setAlignmentX(Component.CENTER_ALIGNMENT);
        clase.setBackground(Color.white);
        clase.setPreferredSize(new Dimension(450, 60));
        clase.setFont(new Font("Arial", Font.BOLD, 24));
        clase.setBorderPainted(false);

        contenedor.add(panel2, BorderLayout.CENTER);
        

        
    }

    

}
