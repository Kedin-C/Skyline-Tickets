/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


/**
 *
 * @author juans
 */
public class Apartado_reportes_operacionales_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelBotones,panelReportes,panelInferior,panelGraficos,panelCentral,paneltiempo1,paneltiempo2,
            panelbotonfiltro,panelModal,panelComboxDestino,panelComboxTipo,panelBotonDestino,panelModalDestino,panelModalTipo,
            panelBotonTipo;
    public JLabel titulo;
    public JButton btnFecha,btnDestino,btnTipo,btnExportar,volver,btnAplicarFecha,btnAplicarDestino,btnAplicarTipo,btnQuitarFiltros;
    public JTextArea areaReportes;
    public JScrollPane scrollReportes;
    public DefaultTableModel modelo;
    public JTable tabla;
    private String tituloReportes;
    public JFreeChart chartTiempo,chartDestinos,charTipo;
    public ChartPanel panelTiempo,panelDestinos,panelTipo;
    public JDialog modalFecha,modalDestino,modalTipo;
    public JDateChooser fechaInicio,fechaFin;
    public JComboBox ComboxTipo;
    public String listaTipo[] = {"","Nacional","Internacional"};
    
    public Apartado_reportes_operacionales_view(){
        
        super("REPORTES OPERACIONALES");
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();

        //Titulo
        JLabel titulo = new JLabel("Reportes Operacionales", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(titulo, BorderLayout.CENTER);
        
        //Panel de botones
        panelBotones = new JPanel(new BorderLayout());

        // Panel con los botones de filtros hacia la izquierda
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        btnFecha = new JButton("Filtro por Fecha");
        btnDestino = new JButton("Filtro por Destino");
        btnTipo = new JButton("Filtro por Tipo de Vuelo");
        btnQuitarFiltros = new JButton("Quitar Filtros");
        btnFecha.setBackground(Color.decode("#037FB9"));
        btnFecha.setForeground(Color.white);
        btnDestino.setBackground(Color.decode("#037FB9"));
        btnDestino.setForeground(Color.white);
        btnTipo.setBackground(Color.decode("#037FB9"));
        btnTipo.setForeground(Color.white);
        btnQuitarFiltros.setBackground(Color.decode("#037FB9"));
        btnQuitarFiltros.setForeground(Color.white);
        panelFiltros.add(btnFecha);
        panelFiltros.add(btnDestino);
        panelFiltros.add(btnTipo);
        panelFiltros.add(btnQuitarFiltros);

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
        modelo.addColumn("NUMERO VUELO  ");
        modelo.addColumn("FECHA ");
        modelo.addColumn("ORIGEN ");
        modelo.addColumn("DESTINO ");
        modelo.addColumn("TIPO VUELO ");
        modelo.addColumn("CLASE ");
        modelo.addColumn("CANTIDAD PASAJEROS ");
        modelo.addColumn("ESTADO ");
        
        
        // Gráfico de barras Tiempo
        panelTiempo = new ChartPanel(chartTiempo);
        panelTiempo.setPreferredSize(new Dimension(400, 300));
        
        // Gráfico de barras Destinos
        panelDestinos = new ChartPanel(chartDestinos);
        panelDestinos.setPreferredSize(new Dimension(400, 300));

        // Gráfico de pastel tipo
        panelTipo = new ChartPanel(charTipo);
        panelTipo.setPreferredSize(new Dimension(400, 300));
        
        panelGraficos= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelGraficos.setPreferredSize(new Dimension(220, 340));
        panelGraficos.add(panelTiempo);
        panelGraficos.add(panelDestinos);
        panelGraficos.add(panelTipo);
        
        
        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        scrollReportes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelReportes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scrollReportes.setPreferredSize(new Dimension(1600, 500)); 
        panelReportes.add(scrollReportes);
        
        //Panel central con los graficos y los reportes
        panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelGraficos, BorderLayout.NORTH);
        panelCentral.add(panelReportes, BorderLayout.CENTER);
        
        
        //Panel inferior con botón Volver
        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 60, 10));
        volver = super.getVolver();
        panelInferior.add(volver);

        panel2.setLayout(new BorderLayout());
        panel2.add(panelBotones, BorderLayout.NORTH);
        panel2.add(panelCentral, BorderLayout.CENTER);
        panel2.add(panelInferior, BorderLayout.SOUTH);
        
        
        // Agregamos el modal del filtro rango de fechas
        modalFecha = new JDialog(this, "Seleccionar rango de fechas", true);
        panelModal = new JPanel();
        fechaInicio = new JDateChooser();
        fechaFin = new JDateChooser();
        Date hoy = new Date();
        fechaInicio.setMaxSelectableDate(hoy);
        fechaFin.setMaxSelectableDate(hoy);
        btnAplicarFecha = new JButton("Aplicar Filtro");
        
        panelModal.setLayout(new FlowLayout(FlowLayout.CENTER));

        paneltiempo1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paneltiempo1.add(new JLabel("Fecha inicio:"));
        paneltiempo1.add(fechaInicio);

        paneltiempo2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paneltiempo2.add(new JLabel("Fecha fin:"));
        paneltiempo2.add(fechaFin);
        
        panelbotonfiltro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelbotonfiltro.add(btnAplicarFecha);
        
        ((JTextField) fechaInicio.getDateEditor().getUiComponent()).setEditable(false);
        ((JTextField) fechaFin.getDateEditor().getUiComponent()).setEditable(false);

        panelModal.add(paneltiempo1);
        panelModal.add(paneltiempo2);
        panelModal.add(panelbotonfiltro);
        modalFecha.add(panelModal);
        
        
        // Agregamos el modal del filtro Destinos
        modalDestino = new JDialog(this, "Seleccionar Destino", true);
        modalDestino.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelModalDestino = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelModalDestino.setPreferredSize(new Dimension(150, 150));
        
        panelComboxDestino = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        panelBotonDestino = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAplicarDestino = new JButton("Aplicar Filtro");
        panelBotonDestino.add(btnAplicarDestino);
        
        panelModalDestino.add(panelComboxDestino);
        panelModalDestino.add(panelBotonDestino);
        modalDestino.add(panelModalDestino);
        
        
        // Agregamos el modal del filtro Destinos
        modalTipo = new JDialog(this, "Seleccionar Tipo", true);
        modalTipo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelModalTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelModalTipo.setPreferredSize(new Dimension(150, 150));
        
        panelComboxTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ComboxTipo = new JComboBox(listaTipo);
        panelComboxTipo.add(ComboxTipo);
        
        panelBotonTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAplicarTipo = new JButton("Aplicar Filtro");
        panelBotonTipo.add(btnAplicarTipo);
        
        panelModalTipo.add(panelComboxTipo);
        panelModalTipo.add(panelBotonTipo);
        modalTipo.add(panelModalTipo);

    }
    
    
    
    public void mostrarModalFecha() {
        modalFecha.setSize(200, 200);
        modalFecha.setLocationRelativeTo(this);
        modalFecha.setVisible(true);
    }
    
    public void mostrarModalDestino() {
        modalDestino.setSize(200, 200);
        modalDestino.setLocationRelativeTo(this);
        modalDestino.setVisible(true);
    }
    
    public void mostrarModalTipo() {
        modalTipo.setSize(200, 200);
        modalTipo.setLocationRelativeTo(this);
        modalTipo.setVisible(true);
    }
    

        
       
        
    
    
    
}
