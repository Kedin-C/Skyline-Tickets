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
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class Seleccion_de_vuelo_usuarioNoregistrado_view extends Interfaz_vista_abtractas{
    
    private final Container contenedor;
    //distribucion de la interfaz
    private final JPanel panel1,panel2,panel3,panel4;
    //Contenedores del titulo y el campo a llenar de cada opcion
    private final JPanel Codigo_t_panel,Nombre_usu_panel,Numero_do_panel,Correo_panel;
    //Contenedores de los titulos
    private final JPanel Codigo_t_text,Nombre_usu_text,Numero_do_text,Correo_text;
    // Contenedores de los JTextField que reciben la informacion
    private final JPanel Cont_inf_1,Cont_inf_2,Cont_inf_3,Cont_inf_4;   
    //Titulos de los campos a llenar
    private final JLabel codig_titulo,nomb_titulo,nume_titulo,corr_titulo;
    //Texto de explicacion principal
    private final JLabel text_explication,text_explication2;
    //Contenedor del texto de explicacion y el boton de continuar, contenedor del contenedor del texto de explicacion
    private final JPanel contenedor_textExp,contenedor_explication;
    //Boton de continuar, Boton de volver
    public JButton continuar,volver;
    //Contenedor de boton volver, contenedor de boton continuar, contenedor del contenedor del boton volver
    private final JPanel contenedor_volver,contenedor_continuar,contenedor_cont_volver;
    //Campos para ingresar los datos
    public JTextField Codigo_ticket,Nombre_usuario,Numero_documento,Correo_electronico;
    
    
    public Seleccion_de_vuelo_usuarioNoregistrado_view(){
    //Titulo de la interfaz
     String nombre = "Seleccion de vuelo modificar usuario no registrado";
    super(nombre);
        
    contenedor = super.getContenedor();
    
    
    //Cabeza de la interfaz
    panel1 = super.getPanel1();
    //Cuerpo de la interfaz
    panel2 =  super.getPanel2();
    //distribucion de cuerpo de la interfaz
    
    panel2.setLayout(new GridLayout(0,2));
    //Inicializacion y distribuciones de contenedores de los campos a llenar
    Cont_inf_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Cont_inf_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Cont_inf_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Cont_inf_4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //Inicializacion y distribuciones de los contenedores de los campos y los titulos a llenar
    Codigo_t_panel= new JPanel(new BorderLayout());
    Nombre_usu_panel= new JPanel(new BorderLayout());
    Numero_do_panel= new JPanel(new BorderLayout());
    Correo_panel= new JPanel(new BorderLayout());

    
    Codigo_t_text= new JPanel(new FlowLayout(FlowLayout.CENTER));
    Nombre_usu_text= new JPanel(new FlowLayout(FlowLayout.CENTER));
    Numero_do_text= new JPanel(new FlowLayout(FlowLayout.CENTER));
    Correo_text= new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    contenedor_explication = new JPanel(new BorderLayout());
    contenedor_textExp = new JPanel();
    contenedor_volver = new JPanel();
    contenedor_continuar = new JPanel();
    contenedor_cont_volver = new JPanel(new BorderLayout());
    
    
    codig_titulo = new JLabel("CODIGO DE TICKET *");
    nomb_titulo = new JLabel("NOMBRE COMPLETO *");
    nume_titulo = new JLabel("NUMERO DE DOCUMENTO *");
    corr_titulo = new JLabel("CORREO ELECTRONICO *");
    
    panel3 = new JPanel(new GridLayout(4,0,0,0));
    
    panel4 = new JPanel(new GridLayout(2,0,0,0));
    
    
    
    
    
    Codigo_ticket = new JTextField("");
    Nombre_usuario = new JTextField("");
    Numero_documento = new JTextField("");
    Correo_electronico = new JTextField("");
    

    
    Codigo_ticket.setPreferredSize(new Dimension(300,50));
    Codigo_ticket.setFont(new Font("Arial",Font.BOLD,20));
    
    Nombre_usuario.setPreferredSize(new Dimension(300,50));
    Nombre_usuario.setFont(new Font("Arial",Font.BOLD,20));
    
    Numero_documento.setPreferredSize(new Dimension(300,50));
    Numero_documento.setFont(new Font("Arial",Font.BOLD,20));
    
    Correo_electronico.setPreferredSize(new Dimension(300,50));
    Correo_electronico.setFont(new Font("Arial",Font.BOLD,20));
    
    text_explication = new JLabel("Puedes editar tu clase de vuelo o agregar equipaje");
    text_explication2 = new JLabel("de bodega Ingresando la informacion solicitada.");
    
    text_explication.setPreferredSize(new Dimension(600,30));
    text_explication.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    text_explication.setOpaque(true);
    
    text_explication2.setPreferredSize(new Dimension(600,20));
    text_explication2.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
    text_explication2.setOpaque(true);
    
    contenedor_textExp.setBorder(new EmptyBorder(140,0,0,0));
   


    continuar = super.continuar;
    volver = super.volver;
    
    contenedor_continuar.setBorder(new EmptyBorder(100,0,0,120));
    
    contenedor_volver.setPreferredSize(new Dimension(100,80));
    
    contenedor_volver.setBorder(new EmptyBorder(20,500,20,20));
    

    
    panel3.setBorder(new EmptyBorder(90,20,20,20));
    
    contenedor_explication.setOpaque(true);
    contenedor_explication.setBackground(Color.gray);
    
    
    contenedor_textExp.add(text_explication);
    contenedor_textExp.add(text_explication2);
    contenedor_continuar.add(continuar);
    contenedor_textExp.add(contenedor_continuar,BorderLayout.SOUTH);
    contenedor_explication.add(contenedor_textExp,BorderLayout.CENTER);
    
    contenedor_volver.add(volver,BorderLayout.SOUTH);
    contenedor_cont_volver.add(contenedor_volver,BorderLayout.SOUTH);
    
    
    Codigo_t_text.add(codig_titulo);
    Nombre_usu_text.add(nomb_titulo);
    Numero_do_text.add(nume_titulo);
    Correo_text.add(corr_titulo);
    
    Cont_inf_1.add(Codigo_ticket);
    Cont_inf_2.add(Nombre_usuario);
    Cont_inf_3.add(Numero_documento);
    Cont_inf_4.add(Correo_electronico);
    
    Codigo_t_panel.add(Codigo_t_text,BorderLayout.NORTH);
    Codigo_t_panel.add(Cont_inf_1);
    Nombre_usu_panel.add(Nombre_usu_text,BorderLayout.NORTH);
    Nombre_usu_panel.add(Cont_inf_2);
    Numero_do_panel.add(Numero_do_text,BorderLayout.NORTH);
    Numero_do_panel.add(Cont_inf_3);
    Correo_panel.add(Correo_text,BorderLayout.NORTH);
    Correo_panel.add(Cont_inf_4);
    
    panel4.add(contenedor_explication,BorderLayout.CENTER);
    panel4.add(contenedor_cont_volver);
    
    panel3.add(Codigo_t_panel);
    panel3.add(Nombre_usu_panel);
    panel3.add(Numero_do_panel);
    panel3.add(Correo_panel);
    
    panel2.add(panel3);
    panel2.add(panel4);
    
    }
    
    
}
