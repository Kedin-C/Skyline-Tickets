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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class Inspeccion_vuelos_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    private JPanel panel1,panel2,paneltitulo,panelInferior,panelTituloInspe,
            panelAviones,panelInspecion;
    private JLabel titulo,tituloAvi;
    public JButton volver,inspeccionar;
    private JScrollPane scroll;
    public DefaultTableModel modelo;
    public JTable tabla;

    public Inspeccion_vuelos_view() {
        super("INSPECCIÓN VUELOS");
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        titulo = new JLabel("INSPECCIÓN VUELOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(Color.white);
        
        paneltitulo = new JPanel();
        paneltitulo.setBorder(new EmptyBorder(25,0,0,210));
        paneltitulo.setBackground(null);
        paneltitulo.add(titulo);

        panel1.add(paneltitulo);
        
        tituloAvi = new JLabel("Lista Aviones");
        tituloAvi.setFont(new Font("Arial", Font.BOLD, 35));
        tituloAvi.setForeground(Color.black);
        
        panelTituloInspe = new JPanel();
        panelTituloInspe.setBackground(null);
        panelTituloInspe.setBorder(new EmptyBorder(65, 0, 20, 0));
        panelTituloInspe.add(tituloAvi);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("MATRÍCULA ");
        modelo.addColumn("MARCA ");
        modelo.addColumn("MODELO ");
        modelo.addColumn("CAPACIDAD ");
        modelo.addColumn("ESTADO ");

        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 18));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setBackground(Color.decode("#D9D9D9"));
        tabla.setRowSelectionAllowed(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setResizingAllowed(false);

        // Crear un renderer para centrar contenido
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderer a todas las columnas
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
            tabla.getColumnModel().getColumn(i).setCellRenderer(rendererFila);
        }
        
        
        inspeccionar = new JButton("Inspeccionar avión");
        inspeccionar.setPreferredSize(new Dimension(200, 40));
        inspeccionar.setBackground(Color.decode("#037FB9"));
        inspeccionar.setForeground(Color.WHITE);
        
        panelInspecion = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
        panelInspecion.setPreferredSize(new Dimension(1000,300));
        panelInspecion.add(inspeccionar);
        
        scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(1100, 350)); 
        panelAviones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelAviones.add(scroll);
        panelAviones.add(panelInspecion);

        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        panelInferior.setBorder(new EmptyBorder(0, 0, 20, 0));
        volver = super.getVolver();
        panelInferior.add(volver);

        panel2.setLayout(new BorderLayout());
        panel2.add(panelTituloInspe, BorderLayout.NORTH);
        panel2.add(panelAviones, BorderLayout.CENTER);
        panel2.add(panelInferior, BorderLayout.SOUTH);
    }

    DefaultTableCellRenderer rendererFila = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            setHorizontalAlignment(SwingConstants.CENTER);

            Object estado = table.getValueAt(row, 4);

            if ("Activo".equals(estado)) {
                c.setBackground(new Color(144, 238, 144));
            }else if("Inactivo".equals(estado)){
                c.setBackground(new Color(255, 0, 0, 60)); 
            }else{
                c.setBackground(new Color(220, 220, 220)); 
            }

            return c;
        }
    };

}
