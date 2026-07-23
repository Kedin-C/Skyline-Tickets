package View;


import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import Model.Vuelos;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Historial_vuelos_view extends Interfaz_vista_abtractas{
    
    private Container contenedor;
    private JPanel panel1,panel2;
    private JScrollPane scroll;
    public JTable tabla;
    public DefaultTableModel modelo;
    private String[] columnas;
    private ArrayList<Object[]> datos;
    private JPanel tablero_datos,cont_titulo,cont_total,cont_boton,cont_continuar,cont_volver,cont_all;
    private JLabel titulo;
    public JButton continuar,volver;
    private int vista_anterior;




    public Historial_vuelos_view() {
        super("Historial de vuelos");
        
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        
        cont_total = new JPanel(new BorderLayout());
        cont_all = new JPanel(new BorderLayout());
        
        continuar = super.getContinuar();
        volver = super.getVolver();
        
        cont_continuar = new JPanel();
        cont_volver = new JPanel();
        cont_boton = new JPanel();
        
        tablero_datos = new JPanel(new BorderLayout());
        cont_titulo = new JPanel();
        titulo = new JLabel("HISTORIAL DE VUELOS");
        titulo.setFont(new Font("Arial",Font.BOLD,25));
        titulo.setBorder(new EmptyBorder(20,1,80,1));
        
        
        
        columnas = new String[5];
        columnas[0] = "ID ticket";
        columnas[1] = "Origen";
        columnas[2] = "Destino";
        columnas[3] = "Tipo vuelo";
        columnas[4] = "Fecha vuelo";

        
        
        datos = new ArrayList<>();
        
        
        modelo = new DefaultTableModel(columnas, 0) {
            //Metodo para bloquear los campos de la tabla
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        
        
                
        
        tabla = new JTable(modelo);
        
        
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setResizingAllowed(false);
        
        scroll = new JScrollPane(tabla);

        tabla.setFont(new Font("Arial", Font.PLAIN, 15));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        scroll.setPreferredSize(new Dimension(800, 400));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        cont_boton.setBorder(new EmptyBorder(120,1070,1,1));
        
        cont_continuar.add(continuar);
        cont_volver.add(volver);
        
        cont_boton.add(cont_continuar);
        cont_boton.add(cont_volver);
        
        tablero_datos.add(scroll, BorderLayout.CENTER);
        cont_titulo.add(titulo);
        cont_total.add(cont_titulo, BorderLayout.NORTH);
        cont_total.add(tablero_datos);
        
        cont_all.add(cont_total);
        
        
        
        panel2.add(cont_all);
        panel2.add(cont_boton,BorderLayout.SOUTH);
        
       
        
    }
    
    
    public int getVista_anterior() {
        return vista_anterior;
    }

    public void setVista_anterior(int vista_anterior) {
        this.vista_anterior = vista_anterior;
    }
}
