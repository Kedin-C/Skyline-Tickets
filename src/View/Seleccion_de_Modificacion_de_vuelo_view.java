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
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class Seleccion_de_Modificacion_de_vuelo_view extends Interfaz_vista_abtractas  {
    
    private final Container contenedor;
    private final JPanel panel1,panel2;
    private final JPanel panel_contenedor_distribucion;
    private final JPanel Cont_text1,Cont_text2,Cont_text3,Contenedor_de_Cont_text;
    private final JPanel Cont_contenedor_boton_clase_vuelo,Cont_contenedor_boton_equipaje,Cont_contenedor_boton_volver;
    private final JPanel Content_Boton_Clase_vuelo,Content_Boton_Equipaje,Content_Boton_volver;
    public JButton Clase_vuelo,Equipaje,Volver;
    private final JLabel Message_text1,Message_text2,Message_text3;
    
    public Seleccion_de_Modificacion_de_vuelo_view(){
        
        String nombre = "Seleccion_de_Modificacion_de_clase_de_vuelo_o_agregacion_de_equipjae";
        super(nombre);
        contenedor =  super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        panel2.setLayout(new BorderLayout());
        
        panel_contenedor_distribucion = new JPanel(new GridLayout(3,0));
        
        Cont_text1 = new JPanel();
        Cont_text2 = new JPanel();
        Cont_text3 = new JPanel(); 
        Contenedor_de_Cont_text = new JPanel(new GridLayout(3,1));
        
        Cont_contenedor_boton_clase_vuelo = new JPanel(new BorderLayout());
        Cont_contenedor_boton_equipaje = new JPanel(new BorderLayout());
        Cont_contenedor_boton_volver = new JPanel(new BorderLayout());
         
        Content_Boton_Clase_vuelo = new JPanel();
        Content_Boton_Equipaje = new JPanel();
        Content_Boton_volver = new JPanel();
        
        ImageIcon imagen_clase = new ImageIcon("src/Imagenes/clase_vuelo.png");       
        Image Imagen_clase_ajustada = imagen_clase.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);        
        ImageIcon nueva_imagen_clase = new ImageIcon(Imagen_clase_ajustada);
        
        ImageIcon imagen_equipaje = new ImageIcon("src/Imagenes/equipaje.png");       
        Image Imagen_equipaje_ajustada = imagen_equipaje.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);        
        ImageIcon nueva_imagen_equipaje = new ImageIcon(Imagen_equipaje_ajustada);
        
        
        
        Clase_vuelo = new JButton("  CLASE DE VUELO     ",nueva_imagen_clase);
        Equipaje = new JButton("  EQUIPAJE          ",nueva_imagen_equipaje);
        Volver = super.volver;
        
        Message_text1 = new JLabel("Bienvenido, aquí podrás cambiarte a una");
        Message_text2 = new JLabel("clase de vuelo mejor y agregar equipaje de");
        Message_text3 = new JLabel("bodega extra para tu vuelo.");
        
        Cont_text1.add(Message_text1);
        Cont_text2.add(Message_text2);
        Cont_text3.add(Message_text3);
        
        Contenedor_de_Cont_text.add(Cont_text1);
        Contenedor_de_Cont_text.add(Cont_text2);
        Contenedor_de_Cont_text.add(Cont_text3);
        
        Cont_text1.setPreferredSize(new Dimension(700,50));
        Message_text1.setFont(new Font("Arial",Font.BOLD,30));
        
        
        Cont_text2.setPreferredSize(new Dimension(700,50));
        Message_text2.setFont(new Font("Arial",Font.BOLD,30));
        
        
        Cont_text3.setPreferredSize(new Dimension(700,50));
        Message_text3.setFont(new Font("Arial",Font.BOLD,30));
        
        panel_contenedor_distribucion.setBorder(new EmptyBorder(90,1,1,1));
        Cont_contenedor_boton_clase_vuelo.setBorder(new EmptyBorder(300,1,0,1));
        Cont_contenedor_boton_equipaje.setBorder(new EmptyBorder(1,1,0,1));
        Content_Boton_volver.setBorder(new EmptyBorder(1,1,0,20));

        
        Cont_contenedor_boton_volver.setPreferredSize(new Dimension(100,60));
        
        Equipaje.setPreferredSize(new Dimension(250,40));
    
        Equipaje.setBackground(Color.decode("#037FB9"));
        Equipaje.setForeground(Color.WHITE);
        
        Clase_vuelo.setPreferredSize(new Dimension(250,40));
    
        Clase_vuelo.setBackground(Color.decode("#037FB9"));
        Clase_vuelo.setForeground(Color.WHITE);
        
        
    
        
        
       
        
        Content_Boton_Clase_vuelo.add(Clase_vuelo);
        Content_Boton_Equipaje.add(Equipaje);
        Content_Boton_volver.add(Volver);
        
        Cont_contenedor_boton_clase_vuelo.add(Content_Boton_Clase_vuelo,BorderLayout.SOUTH);
        Cont_contenedor_boton_equipaje.add(Content_Boton_Equipaje,BorderLayout.NORTH);
        Cont_contenedor_boton_volver.add(Content_Boton_volver,BorderLayout.AFTER_LINE_ENDS);
        
        panel_contenedor_distribucion.add(Contenedor_de_Cont_text);
        panel_contenedor_distribucion.add(Cont_contenedor_boton_clase_vuelo);
        panel_contenedor_distribucion.add(Cont_contenedor_boton_equipaje);
 

        
        panel2.add(panel_contenedor_distribucion);
        panel2.add(Cont_contenedor_boton_volver,BorderLayout.SOUTH);
    }
    
}
