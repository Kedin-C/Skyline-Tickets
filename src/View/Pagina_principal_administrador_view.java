/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author juans
 */
public class Pagina_principal_administrador_view extends Interfaz_vista_abtractas{
    
            
    public Container contenedor;
    public JPanel panel1,panelboton,panelboton2,panelboton3,paneltitulo,panelbotones;
    public Panel_con_fondo_view panel2;
    public JButton comprar,clase,reportes;
    public JLabel titulo;
    public FlowLayout miflow;
    
    public Pagina_principal_administrador_view(){
        String nombre = "Pagina Principal";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        
        // Crear panel contenedor para los dos botones
        panelbotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        panelbotones.setOpaque(false);

        // Configurar botones
        reportes = new JButton("Reportes");
        reportes.setBackground(Color.white);
        reportes.setPreferredSize(new Dimension(200, 40));
        reportes.setFont(new Font("Arial", Font.BOLD, 20));
        reportes.setBorderPainted(false);

//        rol = new JButton("Asignar Rol");
//        rol.setBackground(Color.white);
//        rol.setPreferredSize(new Dimension(200, 40));
//        rol.setFont(new Font("Arial", Font.BOLD, 20));
//        rol.setBorderPainted(false);

        // Agregar ambos al mismo panel
        panelbotones.add(reportes);
//        panelbotones.add(rol);

        // Añadir el panel completo al lado derecho del panel1
        panel1.add(panelbotones, BorderLayout.LINE_END);
        
        // Panel principal con fondo
        panel2 = new Panel_con_fondo_view("src/Imagenes/fondo_principal.png");
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        // Título de bienvenida
        titulo = new JLabel("Bienvenidos");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel auxiliar para el título
        miflow = new FlowLayout();
        paneltitulo = new JPanel(miflow);
        paneltitulo.add(titulo);

       // Botones principales
        comprar = new JButton("Comprar Vuelo");
        clase = new JButton("Modificar Clase de Vuelo y Equipaje");

        // Panel para el botón "Comprar Vuelo"
        panelboton = new JPanel();
        panelboton.add(comprar);
        panelboton.setBorder(new EmptyBorder(50,1,50,1));
        panelboton.setOpaque(false);

        // Agregar componentes al panel con fondo
        panel2.add(Box.createVerticalGlue());   
        panel2.add(titulo);                     
        panel2.add(clase);                      
        panel2.add(panelboton);                 

       // Configuración del botón "Comprar Vuelo"
        comprar.setAlignmentX(Component.CENTER_ALIGNMENT);
        comprar.setBackground(Color.white);
        comprar.setPreferredSize(new Dimension(300, 60));
        comprar.setFont(new Font("Arial", Font.BOLD, 24));
        comprar.setBorderPainted(false);

        // Configuración del botón "Modificar Clase de Vuelo y Equipaje"
        clase.setAlignmentX(Component.CENTER_ALIGNMENT);
        clase.setBackground(Color.white);
        clase.setPreferredSize(new Dimension(450, 60));
        clase.setFont(new Font("Arial", Font.BOLD, 24));
        clase.setBorderPainted(false);

        // Agregar panel2 al contenedor principal
        contenedor.add(panel2, BorderLayout.CENTER);         
        

    }

    
    
}
