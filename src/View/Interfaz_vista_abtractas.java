/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public abstract class Interfaz_vista_abtractas extends JFrame{
    
    
    Container contenedor;
    //panel1 es la cabeza de la pagina y panel2 es el cuerpo de la pagina osea todo lo de abajo de la cabeza
    JPanel panel1,panel2;
    JLabel portada;
    JButton continuar,volver;
    GridLayout migrid;
    
    
    public Interfaz_vista_abtractas(String nombre_pagina){
        
        super(nombre_pagina);
    
    //contenedor
    contenedor = getContentPane();  

    
    //Jpanel
    panel1 = new JPanel();
    panel2 = new JPanel();
    //Esto es para ponerle margin al panel
    panel1.setBorder(new EmptyBorder(0,20,0,0));
    //Aqui pongo el color del panel
    panel1.setBackground(Color.decode("#037FB9"));
    //aAqui estoy modificando Tamaño del panel ANCHO,LARGO
    panel1.setPreferredSize(new Dimension(0,90));
    //Aqui estoy poniendo un border a el panel para despues poder ubicarlo en direfentes direcciones
    panel1.setLayout(new BorderLayout());
    //Aqui llamando a la imagen que tengo guardada en documentos, y creo una variable para guardarla
    ImageIcon imagen_portada =new ImageIcon("src/Imagenes/portada.png");
    //Aqui convirto a la imagen para usar el metodo de getScaledInstance, el cual me ayuda a dimensionar la imagen
    Image imagen_ajustada = imagen_portada.getImage().getScaledInstance(190, 170, Image.SCALE_SMOOTH);
    //Aqui estoy convirtiendo a la imagen que anteriormente ajuste, a una imageicon denuevo para usarla
    Icon portada_img = new ImageIcon(imagen_ajustada);
    //Aqui estoy declarando el JLabel en donde va a estar la imagen
    portada =  new JLabel(portada_img);
    
    ImageIcon imagen1 = new ImageIcon("src/Imagenes/avion.png");    
    Image imagen1_ajustada =  imagen1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);   
    ImageIcon imagen_ya_ajustada = new ImageIcon(imagen1_ajustada);
    
    continuar = new JButton("Continuar   ",imagen_ya_ajustada);
    continuar.setPreferredSize(new Dimension(180,45));
    continuar.setBackground(Color.decode("#037FB9"));
    continuar.setForeground(Color.WHITE);
    
    ImageIcon imagen_volver = new ImageIcon("src/Imagenes/volver.png");    
    Image Imagen_volver_ajustada = imagen_volver.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);        
    ImageIcon nueva_imagen_volver = new ImageIcon(Imagen_volver_ajustada);
    
    volver = new JButton("  Volver    ",nueva_imagen_volver);
    volver.setPreferredSize(new Dimension(200,40));    
    volver.setBackground(Color.decode("#037FB9"));
    volver.setForeground(Color.WHITE);

    
  
    
    //Aqui estoy agregando el JLabel al JPanel, indico que el JLabel va a estar alineado a al inicio del JPanel
    panel1.add(portada,BorderLayout.LINE_START);
    
    contenedor.add(panel1,BorderLayout.NORTH);
    contenedor.add(panel2);
    
        
};
    

  
    public Container getContenedor(){
     return this.contenedor;
    }
    
    public JPanel getPanel1(){
        return this.panel1;
    }
    
     public JPanel getPanel2(){
        return this.panel2;
    }
     
     public JButton getContinuar(){
         return this.continuar;
     }
     
     public JButton getVolver(){
         return this.volver;
     }
    
}
