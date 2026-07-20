/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Elegir_puestos_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, puestos, puestosTorre1, puestosTorre2, siguiente_volver; 
    public JButton torre1[][], torre2[][], siguiente, volver, aleatorio;
    private FondoPanel avion;
    private JScrollPane scrol;
    
    public Elegir_puestos_view() {
        
        
        super("Elegir Puestos");
        contenedor_principal = super.getPanel2();
        
        //Agregando la imagen de fondo
        avion = new FondoPanel("src/Imagenes/avion_fondo.png");
        avion.setLayout(null);
        avion.setOpaque(false);
        
        //Definiendo las filas y columnas
        int fila1 = 30, fila2 = 30, columna1 = 3, columna2 = 3;
        
        //Creando las matricez de botones
        torre1 = new JButton[fila1][columna1];
        torre2 = new JButton[fila2][columna2];
        
        //Creando los paneles
        puestos = new JPanel(new FlowLayout());
        puestosTorre1 = new JPanel(new GridLayout(fila1,columna1));
        puestosTorre2 = new JPanel(new GridLayout(fila2,columna2));
        siguiente_volver = new JPanel(new FlowLayout(FlowLayout.RIGHT,15, 10));
        
        //Creando los botones de las 2 matricez de botones
        for(int f=0; f<fila1; f++){
            for(int c=0; c<columna1; c++){
                
                char letra=(char)('A' + c);
                String nombreBoton = "" + letra + (f + 1);
                
                torre1[f][c] = new JButton(nombreBoton);
                
                torre1[f][c].setPreferredSize(new Dimension(49,25));
                torre1[f][c].setFont(new Font("Arial", Font.BOLD, 8));
                
                puestosTorre1.add(torre1[f][c]);
            }
        }
        
        for(int f=0; f<fila2; f++){
            for(int c=0; c<columna2; c++){
                
                char letra=(char)('D' + c);
                String nombreBoton = "" + letra + (f + 1);
                
                torre2[f][c] = new JButton(nombreBoton);
                
                torre2[f][c].setPreferredSize(new Dimension(49,25));
                torre2[f][c].setFont(new Font("Arial",Font.BOLD, 8));
                
                puestosTorre2.add(torre2[f][c]);
            }
        }
        
        //Para que no tenga fondo
        puestos.setOpaque(false);
        
        
        //Agregando los 2 paneles con la las 2 matricez de botones
        puestos.add(puestosTorre1);
        puestos.add(puestosTorre2);
        
        
        //Scroll para navegar entre los botones
        scrol = new JScrollPane(puestos);
        
        scrol.setOpaque(false);
        
        scrol.getViewport().setOpaque(false);
        
        scrol.setBorder(null);
        
        scrol.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrol.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Tamaño y posiscion de donde estan los botones
        scrol.setBounds(610, 115, 330, 400);
        
        //Agregando la matriz de botones para que quede encima de la imagen
        avion.add(scrol);
        
        //Creando y decorando los botones
        siguiente = new JButton("Siguiente");
        volver = new JButton("Volver");
        aleatorio = new JButton("Aleatorio");
        
        siguiente.setForeground(Color.WHITE);
        volver.setForeground(Color.WHITE);
        aleatorio.setForeground(Color.WHITE);
        
        siguiente.setBackground(Color.decode("#037FB9"));
        volver.setBackground(Color.decode("#037FB9"));
        aleatorio.setBackground(Color.decode("#037FB9"));
        
        //Agregando los botones al panel
        siguiente_volver.add(volver);
        siguiente_volver.add(siguiente);
        siguiente_volver.add(aleatorio);
        siguiente_volver.setPreferredSize(new Dimension(50,60));
        
        //Agregando los componentes al contenedor principal
        contenedor_principal.setLayout(new BorderLayout());
        contenedor_principal.add(avion, BorderLayout.CENTER);
        contenedor_principal.add(siguiente_volver, BorderLayout.SOUTH);
        
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}

//El avion de fondo 
class FondoPanel extends JPanel {
    private Image imagen;

    public FondoPanel(String ruta) {
        this.imagen = new ImageIcon(ruta).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}