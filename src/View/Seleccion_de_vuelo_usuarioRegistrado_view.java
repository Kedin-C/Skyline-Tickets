/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Ticket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author david
 */
public class Seleccion_de_vuelo_usuarioRegistrado_view extends Interfaz_vista_abtractas{
private Container contenedor;
private JPanel panel,panel2,panelP,panelPC;
private JPanel panel2_dist1, panel2_dist2;
private JPanel panel2_dist1_1,panel2_dist1_2,panel2_dist1_3,panel2_dist1_4,panel2_dist1_5;
private JPanel dist1_cont, dist2_cont, dist3_cont,dist4_cont,dist5_cont;
public JButton volver;
private int pagina_anterior;


//ticket 1
private JPanel img_panel,tipo_panel,text1_panel,text2_panel,boton_panel;
private JLabel imagen,tipo,vuelo_ida,vuelo_vuelta;
public JButton select1;

//ticket 2
private JPanel img_panel2,tipo_panel2,text1_panel2,text2_panel2,boton_panel2;
private JLabel imagen2,tipo2,vuelo_ida2,vuelo_vuelta2;
public JButton select2;

//ticket 3
private JPanel img_panel3,tipo_panel3,text1_panel3,text2_panel3,boton_panel3;
private JLabel imagen3,tipo3,vuelo_ida3,vuelo_vuelta3;
public JButton select3;

//ticket 4
private JPanel img_panel4,tipo_panel4,text1_panel4,text2_panel4,boton_panel4;
private JLabel imagen4,tipo4,vuelo_ida4,vuelo_vuelta4;
public JButton select4;

//ticket 5
private JPanel img_panel5,tipo_panel5,text1_panel5,text2_panel5,boton_panel5;
private JLabel imagen5,tipo5,vuelo_ida5,vuelo_vuelta5;
public JButton select5;


//ticket 1
private String tipo_vuelo_ticket1;

private String origen_ida_ticket1;
private String destino_ida_ticket1;

private String origen_vuelta_ticket1;
private String destino_vuelta_ticket1;

//ticket 2
private String tipo_vuelo_ticket2;

private String origen_ida_ticket2;
private String destino_ida_ticket2;

private String origen_vuelta_ticket2;
private String destino_vuelta_ticket2;

//ticket 3
private String tipo_vuelo_ticket3;

private String origen_ida_ticket3;
private String destino_ida_ticket3;

private String origen_vuelta_ticket3;
private String destino_vuelta_ticket3;

//ticket 4
private String tipo_vuelo_ticket4;

private String origen_ida_ticket4;
private String destino_ida_ticket4;

private String origen_vuelta_ticket4;
private String destino_vuelta_ticket4;

//ticket 5
private String tipo_vuelo_ticket5;

private String origen_ida_ticket5;
private String destino_ida_ticket5;

private String origen_vuelta_ticket5;
private String destino_vuelta_ticket5;


//ticket 1
private String text_ticket1_1;
private String text_ticket1_2;

//ticket 2
private String text_ticket2_1;
private String text_ticket2_2;

//ticket 3
private String text_ticket3_1;
private String text_ticket3_2;

//ticket 4
private String text_ticket4_1;
private String text_ticket4_2;

//ticket 5
private String text_ticket5_1;
private String text_ticket5_2;


    public Seleccion_de_vuelo_usuarioRegistrado_view(){

    String nombre = "Seleccion de vuelo modificar usuarioRegistrado";
    super(nombre);
    this.contenedor = super.getContenedor();
    panel1 = super.getPanel1();
    panel2 = super.getPanel2();
    panel2.setLayout(new BorderLayout());
    panelP =  new JPanel();
    panelPC = new JPanel(new BorderLayout());

     
    panel2_dist1 = new JPanel(new GridLayout(1,5,40,40));
    panel2_dist2 = new JPanel();
    
    panel2_dist1_1 = new JPanel();
    panel2_dist1_2 = new JPanel();
    panel2_dist1_3 = new JPanel();
    panel2_dist1_4 = new JPanel();
    panel2_dist1_5 = new JPanel();
    
    dist1_cont = new JPanel(new GridLayout(5,1,0,0));
    dist2_cont = new JPanel(new GridLayout(5,1,0,0));
    dist3_cont = new JPanel(new GridLayout(5,1,0,0));
    dist4_cont = new JPanel(new GridLayout(5,1,0,0));
    dist5_cont = new JPanel(new GridLayout(5,1,0,0));
    
    
    //ticket 1
    img_panel = new JPanel();
    tipo_panel = new JPanel();
    text1_panel = new JPanel();
    text2_panel = new JPanel();
    boton_panel = new JPanel();
    
    //ticket 2
    img_panel2 = new JPanel();
    tipo_panel2 = new JPanel();
    text1_panel2 = new JPanel();
    text2_panel2 = new JPanel();
    boton_panel2= new JPanel();
    
    
    //ticket 3
    img_panel3 = new JPanel();
    tipo_panel3 = new JPanel();
    text1_panel3 = new JPanel();
    text2_panel3 = new JPanel();
    boton_panel3 = new JPanel();
    
    
    //ticket 4
    img_panel4 = new JPanel();
    tipo_panel4 = new JPanel();
    text1_panel4 = new JPanel();
    text2_panel4 = new JPanel();
    boton_panel4 = new JPanel();
    
    
    //ticket 5
    img_panel5 = new JPanel();
    tipo_panel5 = new JPanel();
    text1_panel5 = new JPanel();
    text2_panel5 = new JPanel();
    boton_panel5 = new JPanel();
    
    
    //imagen
    imagen =  new JLabel(new ImageIcon("src/Imagenes/avion.png"));
    img_panel.setPreferredSize(new Dimension(200,65));
    
    imagen2 =  new JLabel(new ImageIcon("src/Imagenes/avion.png"));
    img_panel2.setPreferredSize(new Dimension(200,65));
    
    imagen3 =  new JLabel(new ImageIcon("src/Imagenes/avion.png"));
    img_panel3.setPreferredSize(new Dimension(200,65));
    
    imagen4 =  new JLabel(new ImageIcon("src/Imagenes/avion.png"));
    img_panel4.setPreferredSize(new Dimension(200,65));
    
    imagen5 =  new JLabel(new ImageIcon("src/Imagenes/avion.png"));
    img_panel5.setPreferredSize(new Dimension(200,65));
    
    
    //ticket 1 textos
    tipo = new JLabel();
    vuelo_ida = new JLabel();
    vuelo_vuelta = new JLabel();
    select1 = new JButton("Modificar");
    
    //ticket 2 textos
    tipo2 = new JLabel();
    vuelo_ida2 = new JLabel();
    vuelo_vuelta2 = new JLabel();
    select2 = new JButton("Modificar");
    
    
    //ticket 3 textos
    tipo3 = new JLabel();
    vuelo_ida3 = new JLabel();
    vuelo_vuelta3 = new JLabel();
    select3 = new JButton("Modificar");
    
    
    //ticket 4 textos 
    tipo4 = new JLabel();
    vuelo_ida4 = new JLabel();
    vuelo_vuelta4 = new JLabel();
    select4 = new JButton("Modificar");
    
    
    //tickets 5 textos
    tipo5 = new JLabel();
    vuelo_ida5 = new JLabel();
    vuelo_vuelta5 = new JLabel();
    select5 = new JButton("Modificar");
    
    
    
    //ticket 1 modificaciones
    vuelo_ida.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_ida.setForeground(Color.WHITE);
    vuelo_vuelta.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_vuelta.setForeground(Color.WHITE);
    tipo.setBorder(new EmptyBorder(20,1,1,1));
    tipo.setFont(new Font("Arial",Font.BOLD,18));
    tipo.setForeground(Color.WHITE);
    
    select1.setPreferredSize(new Dimension(200,30));
    select1.setBackground(Color.WHITE);
    
    // ticket 2 modificaciones
    vuelo_ida2.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_ida2.setForeground(Color.WHITE);
    vuelo_vuelta2.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_vuelta2.setForeground(Color.WHITE);
    tipo2.setBorder(new EmptyBorder(20,1,1,1));
    tipo2.setFont(new Font("Arial",Font.BOLD,18));
    tipo2.setForeground(Color.WHITE);
    
    select2.setPreferredSize(new Dimension(200,30));
    select2.setBackground(Color.WHITE);
    
    //ticket 3 modificaciones
    vuelo_ida3.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_ida3.setForeground(Color.WHITE);
    vuelo_vuelta3.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_vuelta3.setForeground(Color.WHITE);
    tipo3.setBorder(new EmptyBorder(20,1,1,1));
    tipo3.setFont(new Font("Arial",Font.BOLD,18));
    tipo3.setForeground(Color.WHITE);
    
    select3.setPreferredSize(new Dimension(200,30));
    select3.setBackground(Color.WHITE);
    
    //ticket 4 modificaciones
    vuelo_ida4.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_ida4.setForeground(Color.WHITE);
    vuelo_vuelta4.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_vuelta4.setForeground(Color.WHITE);
    tipo4.setBorder(new EmptyBorder(20,1,1,1));
    tipo4.setFont(new Font("Arial",Font.BOLD,18));
    tipo4.setForeground(Color.WHITE);
    
    select4.setPreferredSize(new Dimension(200,30));
    select4.setBackground(Color.WHITE);
    
    
    vuelo_ida5.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_ida5.setForeground(Color.WHITE);
    vuelo_vuelta5.setFont(new Font("Arial",Font.BOLD,15));
    vuelo_vuelta5.setForeground(Color.WHITE);
    tipo5.setBorder(new EmptyBorder(20,1,1,1));
    tipo5.setFont(new Font("Arial",Font.BOLD,18));
    tipo5.setForeground(Color.WHITE);
    
    select5.setPreferredSize(new Dimension(200,30));
    select5.setBackground(Color.WHITE);
    
    
    
    
    
    
    
    panel2_dist1.setBorder(new EmptyBorder(100,1,1,1));
    panel2_dist2.setBorder(new EmptyBorder(1,1,20,20));

    
    
    
    volver = super.volver;
  
    
    img_panel.add(imagen);
    tipo_panel.add(tipo);
    text1_panel.add(vuelo_ida);
    text2_panel.add(vuelo_vuelta);
    boton_panel.add(select1);
    
    img_panel2.add(imagen2);
    tipo_panel2.add(tipo2);
    text1_panel2.add(vuelo_ida2);
    text2_panel2.add(vuelo_vuelta2);
    boton_panel2.add(select2);
    
    img_panel3.add(imagen3);
    tipo_panel3.add(tipo3);
    text1_panel3.add(vuelo_ida3);
    text2_panel3.add(vuelo_vuelta3);
    boton_panel3.add(select3);
    
    img_panel4.add(imagen4);
    tipo_panel4.add(tipo4);
    text1_panel4.add(vuelo_ida4);
    text2_panel4.add(vuelo_vuelta4);
    boton_panel4.add(select4);
    
    img_panel5.add(imagen5);
    tipo_panel5.add(tipo5);
    text1_panel5.add(vuelo_ida5);
    text2_panel5.add(vuelo_vuelta5);
    boton_panel5.add(select5);
    
    
    dist1_cont.add(img_panel);
    dist1_cont.add(tipo_panel);
    dist1_cont.add(text1_panel);
    dist1_cont.add(text2_panel);
    dist1_cont.add(boton_panel);
    
    dist2_cont.add(img_panel2);
    dist2_cont.add(tipo_panel2);
    dist2_cont.add(text1_panel2);
    dist2_cont.add(text2_panel2);
    dist2_cont.add(boton_panel2);
    
     dist3_cont.add(img_panel3);
    dist3_cont.add(tipo_panel3);
    dist3_cont.add(text1_panel3);
    dist3_cont.add(text2_panel3);
    dist3_cont.add(boton_panel3);
    
     dist4_cont.add(img_panel4);
    dist4_cont.add(tipo_panel4);
    dist4_cont.add(text1_panel4);
    dist4_cont.add(text2_panel4);
    dist4_cont.add(boton_panel4);
    
     dist5_cont.add(img_panel5);
    dist5_cont.add(tipo_panel5);
    dist5_cont.add(text1_panel5);
    dist5_cont.add(text2_panel5);
    dist5_cont.add(boton_panel5);
    

    
    img_panel.setBackground(Color.decode("#037FB9"));
    tipo_panel.setBackground(Color.decode("#037FB9"));
    text1_panel.setBackground(Color.decode("#037FB9"));
    text2_panel.setBackground(Color.decode("#037FB9"));
    boton_panel.setBackground(Color.decode("#037FB9"));
    
    
    
    img_panel2.setBackground(Color.decode("#037FB9"));
    tipo_panel2.setBackground(Color.decode("#037FB9"));
    text1_panel2.setBackground(Color.decode("#037FB9"));
    text2_panel2.setBackground(Color.decode("#037FB9"));
    boton_panel2.setBackground(Color.decode("#037FB9"));
    
    
    img_panel3.setBackground(Color.decode("#037FB9"));
    tipo_panel3.setBackground(Color.decode("#037FB9"));
    text1_panel3.setBackground(Color.decode("#037FB9"));
    text2_panel3.setBackground(Color.decode("#037FB9"));
    boton_panel3.setBackground(Color.decode("#037FB9"));
    
    
    
    img_panel4.setBackground(Color.decode("#037FB9"));
    tipo_panel4.setBackground(Color.decode("#037FB9"));
    text1_panel4.setBackground(Color.decode("#037FB9"));
    text2_panel4.setBackground(Color.decode("#037FB9"));
    boton_panel4.setBackground(Color.decode("#037FB9"));
   
    
    img_panel5.setBackground(Color.decode("#037FB9"));
    tipo_panel5.setBackground(Color.decode("#037FB9"));
    text1_panel5.setBackground(Color.decode("#037FB9"));
    text2_panel5.setBackground(Color.decode("#037FB9"));
    boton_panel5.setBackground(Color.decode("#037FB9"));
    
    
    

    
    panel2_dist1_1.add(dist1_cont);
    panel2_dist1_2.add(dist2_cont);
    panel2_dist1_3.add(dist3_cont);
    panel2_dist1_4.add(dist4_cont);
    panel2_dist1_5.add(dist5_cont);
    
 
    
    panel2_dist2.add(volver);
    panelPC.add(panel2_dist2,BorderLayout.EAST);
    
    
    
    
    

    
    panelP.add(panel2_dist1);
    
    
    panel2.add(panelP);
    panel2.add(panelPC,BorderLayout.SOUTH);
    
    
    
}
    
    public void SetVuelos(int v){
        
        switch(v){
            case 1:{panel2_dist1.add(panel2_dist1_1);
            }break;
            case 2:{panel2_dist1.add(panel2_dist1_1);
                    panel2_dist1.add(panel2_dist1_2);
            }break;
            case 3:{panel2_dist1.add(panel2_dist1_1);
                    panel2_dist1.add(panel2_dist1_2);
                    panel2_dist1.add(panel2_dist1_3);
            }break;
            case 4:{panel2_dist1.add(panel2_dist1_1);
                    panel2_dist1.add(panel2_dist1_2);
                    panel2_dist1.add(panel2_dist1_3);
                    panel2_dist1.add(panel2_dist1_4);
            }break;
            case 5:{    
                    panel2_dist1.add(panel2_dist1_1);
                    panel2_dist1.add(panel2_dist1_2);
                    panel2_dist1.add(panel2_dist1_3);
                    panel2_dist1.add(panel2_dist1_4);
                    panel2_dist1.add(panel2_dist1_5);
            }break;
            default:{}break;
        }
        
    }
    
    
    public void setTicketInfo(List<Ticket> ticket){
    
        
        for (int i = 0; i < ticket.size(); i++) {
            

            if(i == 0){
            tipo_vuelo_ticket1 = ticket.get(i).getTipo_vuelo();
            origen_ida_ticket1 = ticket.get(i).getOrigen();
            destino_ida_ticket1 = ticket.get(i).getDestino();
            origen_vuelta_ticket1 = ticket.get(i).getDestino();
            destino_vuelta_ticket1 = ticket.get(i).getOrigen();
            }else if(i == 1){
            tipo_vuelo_ticket2 = ticket.get(i).getTipo_vuelo();
            origen_ida_ticket2 = ticket.get(i).getOrigen();
            destino_ida_ticket2 = ticket.get(i).getDestino();
            origen_vuelta_ticket2 = ticket.get(i).getDestino();
            destino_vuelta_ticket2 = ticket.get(i).getOrigen();
            }
            else if(i == 2){
            tipo_vuelo_ticket3 = ticket.get(i).getTipo_vuelo();
            origen_ida_ticket3 = ticket.get(i).getOrigen();
            destino_ida_ticket3 = ticket.get(i).getDestino();
            origen_vuelta_ticket3 = ticket.get(i).getDestino();
            destino_vuelta_ticket3 = ticket.get(i).getOrigen();
            }else if(i == 3){
            tipo_vuelo_ticket4 = ticket.get(i).getTipo_vuelo();
            origen_ida_ticket4 = ticket.get(i).getOrigen();
            destino_ida_ticket4 = ticket.get(i).getDestino();
            origen_vuelta_ticket4 = ticket.get(i).getDestino();
            destino_vuelta_ticket4 = ticket.get(i).getOrigen();
            }else if(i == 4){
            tipo_vuelo_ticket5 = ticket.get(i).getTipo_vuelo();
            origen_ida_ticket5 = ticket.get(i).getOrigen();
            destino_ida_ticket5 = ticket.get(i).getDestino();
            origen_vuelta_ticket5 = ticket.get(i).getDestino();
            destino_vuelta_ticket5 = ticket.get(i).getOrigen();
            }
            
            
text_ticket1_1 = "Ida: "+origen_ida_ticket1+" → "+destino_ida_ticket1;
text_ticket1_2 = "Vuelta: "+origen_vuelta_ticket1+" → "+destino_vuelta_ticket1;

//ticket 2
text_ticket2_1 = "Ida: "+origen_ida_ticket2+" → "+destino_ida_ticket2;
text_ticket2_2 = "Vuelta: "+origen_vuelta_ticket2+" → "+destino_vuelta_ticket2;

//ticket 3
text_ticket3_1 = "Ida: "+origen_ida_ticket3+" → "+destino_ida_ticket3;
text_ticket3_2 = "Vuelta: "+origen_vuelta_ticket3+" → "+destino_vuelta_ticket3;

//ticket 4
text_ticket4_1 = "Ida: "+origen_ida_ticket4+" → "+destino_ida_ticket4;
text_ticket4_2 = "Vuelta: "+origen_vuelta_ticket4+" → "+destino_vuelta_ticket4;

//ticket 5
text_ticket5_1 = "Ida: "+origen_ida_ticket5+" → "+destino_ida_ticket5;
text_ticket5_2 = "Vuelta: "+origen_vuelta_ticket5+" → "+destino_vuelta_ticket5;
            

if("IDA".equals(tipo_vuelo_ticket1)){
    tipo.setText(tipo_vuelo_ticket1);
    vuelo_ida.setText(text_ticket1_1);
    vuelo_vuelta.setText(" ");
    
}else{
    tipo.setText(tipo_vuelo_ticket1);
    vuelo_ida.setText(text_ticket1_1);
    vuelo_vuelta.setText(text_ticket1_2);
}

if("IDA".equals(tipo_vuelo_ticket2)){
    tipo2.setText(tipo_vuelo_ticket2);
    vuelo_ida2.setText(text_ticket2_1);
    vuelo_vuelta2.setText(" ");
    
}else{
    tipo2.setText(tipo_vuelo_ticket2);
    vuelo_ida2.setText(text_ticket2_1);
    vuelo_vuelta2.setText(text_ticket2_2);
}

if("IDA".equals(tipo_vuelo_ticket3)){
    tipo3.setText(tipo_vuelo_ticket3);
    vuelo_ida3.setText(text_ticket3_1);
    vuelo_vuelta3.setText(" ");
    
}else{
    tipo3.setText(tipo_vuelo_ticket3);
    vuelo_ida3.setText(text_ticket3_1);
    vuelo_vuelta3.setText(text_ticket3_2);
}

if("IDA".equals(tipo_vuelo_ticket4)){
    tipo4.setText(tipo_vuelo_ticket4);
    vuelo_ida4.setText(text_ticket4_1);
    vuelo_vuelta4.setText(" ");
    
}else{
    tipo4.setText(tipo_vuelo_ticket4);
    vuelo_ida4.setText(text_ticket4_1);
    vuelo_vuelta4.setText(text_ticket4_2);
}

if("IDA".equals(tipo_vuelo_ticket5)){
    tipo5.setText(tipo_vuelo_ticket5);
    vuelo_ida5.setText(text_ticket5_1);
    vuelo_vuelta5.setText(" ");
    
}else{
    tipo5.setText(tipo_vuelo_ticket5);
    vuelo_ida5.setText(text_ticket5_1);
    vuelo_vuelta5.setText(text_ticket5_2);
}
            
        }


    
    }
 
    public void Limpiar_Vuelos() {
        panel2_dist1.removeAll();
        panel2_dist2.removeAll();
        panel2_dist1.removeAll();
        panel2_dist1.removeAll();
        panel2_dist1.removeAll();

    }
    
        public int getPagina_anterior() {
        return pagina_anterior;
    }

    public void setPagina_anterior(int pagina_anterior) {
        this.pagina_anterior = pagina_anterior;
    }


}
