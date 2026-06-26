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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class Apartado_reportes_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelBotones,panelInferior;
    public JLabel titulo;
    public JButton btnFecha,btnDestino,btnClase,btnExportar,btnVolver;
    public JTextArea areaReportes;
    public JScrollPane scrollReportes;
    public DefaultTableModel modelo;
    public JTable tabla;
    private String tituloReportes;
    
    public Apartado_reportes_view(){
        String nombre = "REPORTES FINANCIEROS";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();


        // Título centrado
//        if(TipoReportes.tipo == 1){
//            tituloReportes = "Reportes Financieros";
//        }else if(TipoReportes.tipo == 2){
//            tituloReportes = "Reportes Operacionales";
//        }
        JLabel titulo = new JLabel("Reportes Financieros", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(titulo, BorderLayout.CENTER);
        
        //Panel de botones
        panelBotones = new JPanel(new BorderLayout());

        // Panel con los botones de filtros hacia la izquierda
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        btnFecha = new JButton("Filtro por Fecha");
        btnDestino = new JButton("Filtro por Destino");
        btnClase = new JButton("Filtro por Clase de Vuelo");
        btnFecha.setBackground(Color.decode("#037FB9"));
        btnFecha.setForeground(Color.white);
        btnDestino.setBackground(Color.decode("#037FB9"));
        btnDestino.setForeground(Color.white);
        btnClase.setBackground(Color.decode("#037FB9"));
        btnClase.setForeground(Color.white);
        panelFiltros.add(btnFecha);
        panelFiltros.add(btnDestino);
        panelFiltros.add(btnClase);

        //Panel con el boton exportar hacia la derecha
        JPanel panelExportar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        btnExportar = new JButton("Exportar");
        btnExportar.setBackground(Color.decode("#037FB9"));
        btnExportar.setForeground(Color.white);
        panelExportar.add(btnExportar);

        // Añado ambos paneles al panelBotones
        panelBotones.add(panelFiltros, BorderLayout.WEST);
        panelBotones.add(panelExportar, BorderLayout.EAST);
        
        //creo una tabla con columnas
        modelo = new DefaultTableModel();
        modelo.addColumn("ID_REPORTE ");
        modelo.addColumn("TIPO ");
        modelo.addColumn("CATEGORIA ");
        modelo.addColumn("DESCRIPCION ");
        modelo.addColumn("MONTO ");
        modelo.addColumn("FECHA ");
        modelo.addColumn("REFERENCIA ");
        
        
        tabla = new JTable(modelo);
        tabla.setBackground(Color.decode("#D9D9D9"));
        tabla.setEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setResizingAllowed(false);
        
        // Crear un renderer para centrar contenido
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderer a todas las columnas
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        //Área de reportes
        scrollReportes = new JScrollPane(tabla);
        scrollReportes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollReportes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel panelReportes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scrollReportes.setPreferredSize(new Dimension(1600, 650)); 
        panelReportes.add(scrollReportes);
        
        
        //Panel inferior con botón Volver
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        btnVolver = new JButton("Volver");
        btnVolver.setBackground(Color.decode("#037FB9"));
        btnVolver.setForeground(Color.white);
        panelInferior.add(btnVolver);

        panel2.setLayout(new BorderLayout());
        panel2.add(panelBotones, BorderLayout.NORTH);
        panel2.add(panelReportes, BorderLayout.CENTER);
        panel2.add(panelInferior, BorderLayout.SOUTH);
    }
    
    
    
    
    

        
       
        
    
    
    
}
