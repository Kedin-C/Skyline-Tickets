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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class Agregar_equipaje_extra_view extends Interfaz_vista_abtractas{
    
    private final Container contenedor;
    private  JPanel panel1,panel2,clase = null;
    public JButton actual;
    private final JPanel cont_distribucion;
    private final JPanel dist1,dist2;
    private final JPanel dist1_panel1, dist1_panel2;
    private final JPanel dist2_panel1, dist2_panel2, dist2_panel3, dist2_panel4;
    public JButton agregar,quitar,confirmar,volver;
    JLabel contador,text_actual,text_cont;
    private int contador_num = 0;
    private final JPanel cont_contador,cont_boton_confirmar,cont_boton_quitar,cont_boton_agregar,cont_boton_volver;
    
    
    cambio_de_clase_de_vuelo_viiew in = new cambio_de_clase_de_vuelo_viiew();
    

    public Agregar_equipaje_extra_view() {
        
        super("Agregar equipaje de bodega extra");
        
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        
       
        
        actual = in.boton_Actual;
        
        cont_distribucion = new JPanel(new GridLayout(1,2));
        
        dist1 = new JPanel(new BorderLayout());
        dist2 = new JPanel(new GridLayout(4,1));
         
        dist1_panel1 = new JPanel();
        dist1_panel2 = new JPanel();
        
        
        dist2_panel1 = new JPanel();
        dist2_panel2 = new JPanel(new GridLayout(1,3));
        dist2_panel3 = new JPanel();
        dist2_panel4 = new JPanel(new BorderLayout());
        
        ImageIcon imagen_ag = new ImageIcon("src/Imagenes/agregar.png");
        Image imagen_ag_ajustada = imagen_ag.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imagen_new_agregar = new ImageIcon(imagen_ag_ajustada);
        
        agregar = new JButton("AGREGAR",imagen_new_agregar);
        
        ImageIcon imagen_qui = new ImageIcon("src/Imagenes/quitar.png");
        Image imagen_qui_ajustada = imagen_qui.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imagen_new_quitar = new ImageIcon(imagen_qui_ajustada);
        
        quitar = new JButton("QUITAR",imagen_new_quitar);
        confirmar = new JButton("CONTINUAR");

        volver = super.getVolver();
         
        cont_contador = new JPanel();
        cont_boton_confirmar = new JPanel();
        cont_boton_quitar = new JPanel();
        cont_boton_agregar = new JPanel();
        cont_boton_volver = new JPanel();
        
        contador = new JLabel(Integer.toString(contador_num));
        text_actual = new JLabel("CLASE DE VUELO ACTUAL");
        text_cont = new JLabel("NUMERO DE EQUIPAJE DE BODEGA SELECCIONADO");
        
        
        dist1_panel1.setBorder(new EmptyBorder(60,20,10,400));
        dist1_panel2.setBorder(new EmptyBorder(20,20,200,400));
        
        
        text_actual.setFont(new Font("Arial",Font.BOLD,20));
        
        contador.setFont(new Font("Arial",Font.BOLD,20));
        
        text_cont.setFont(new Font("Arial",Font.BOLD,20));
        dist2_panel1.setBorder(new EmptyBorder(120,0,10,20));
        dist2_panel2.setBorder(new EmptyBorder(150,0,10,0));

        cont_boton_volver.setBorder(new EmptyBorder(10,1,1,1));
        
        
        volver = super.volver;
        
        confirmar = super.continuar;
        
        quitar.setPreferredSize(new Dimension(170,40));    
        quitar.setBackground(Color.decode("#037FB9"));
        quitar.setForeground(Color.WHITE);
        
        agregar.setPreferredSize(new Dimension(170,40));    
        agregar.setBackground(Color.decode("#037FB9"));
        agregar.setForeground(Color.WHITE);
        
        cont_contador.add(contador);
        cont_boton_confirmar.add(confirmar);
        cont_boton_quitar.add(quitar);
        cont_boton_agregar.add(agregar);
        cont_boton_volver.add(volver);
        
        
        
        
        dist2_panel1.add(text_cont);
        dist2_panel2.add(cont_boton_agregar);
        dist2_panel2.add(cont_contador);
        dist2_panel2.add(cont_boton_quitar);
        dist2_panel3.add(cont_boton_confirmar);
        dist2_panel4.add(cont_boton_volver,BorderLayout.AFTER_LINE_ENDS);
        
        
        dist1_panel1.add(text_actual,BorderLayout.CENTER);
        
        
        
        
        dist2.add(dist2_panel1);
        dist2.add(dist2_panel2);
        dist2.add(dist2_panel3);
        dist2.add(dist2_panel4);
        
        dist1.add(dist1_panel1,BorderLayout.NORTH);
        dist1.add(dist1_panel2,BorderLayout.SOUTH);
        
        
        cont_distribucion.add(dist1);
        cont_distribucion.add(dist2);
        
        panel2.add(cont_distribucion);
        
        
        
        
        

        
     
    }
    
    
    public void setEquipaje_agregar(){
    
        this.contador_num+=1;
        contador.setText(Integer.toString(this.contador_num));
        
    }
    
     public void setEquipaje_quitar(){
    
        this.contador_num-=1;
        contador.setText(Integer.toString(this.contador_num));
    }
     
      public int getEquipaje_estado(){
    
        return this.contador_num;
    }
      
      public void setClaseActual(int var){
          
          clase = in.getClases(var);
          dist1_panel2.add(clase);
          
      }
      
      public void Vaciar_clase(){
          dist1_panel2.removeAll();
      }
     


  

        
        
        

    
    
    
}
