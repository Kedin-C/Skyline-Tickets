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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


/**
 *
 * @author juans
 */
public class Apartado_reportes_financieros_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelBotones,panelReportes,panelInferior,panelGraficos,panelCentral,paneltiempo1,paneltiempo2,
            panelbotonfiltro,panelModal,panelComboxTipo,panelModalTipo,
            panelBotonTipo;
    public JLabel titulo;
    public JButton btnFecha,btnTipo,btnExportar,volver,btnAplicarFecha,btnAplicarTipo;
    public JTextArea areaReportes;
    public JScrollPane scrollReportes;
    public DefaultTableModel modelo;
    public JTable tabla;
    private String tituloReportes;
    public JFreeChart chartIngresos,chartGastos,charTipo;
    public ChartPanel panelIngresos,panelGastos,panelTipo;
    public JDialog modalFecha,modalTipo;
    public JDateChooser fechaInicio,fechaFin;
    public JComboBox ComboxTipo;
    public String listaTipo[] = {"","Ventas","Ingresos","Gastos","Ganancias"};
    
    public Apartado_reportes_financieros_view(){
        String nombre = "REPORTES FINANCIEROS";
        super(nombre);
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();

        //Titulo
        JLabel titulo = new JLabel("Reportes Financieros", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(titulo, BorderLayout.CENTER);
        
        //Panel de botones
        panelBotones = new JPanel(new BorderLayout());

        // Panel con los botones de filtros hacia la izquierda
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        btnFecha = new JButton("Filtro por Fecha");
        btnTipo = new JButton("Filtro por Tipo de Reporte");
        btnFecha.setBackground(Color.decode("#037FB9"));
        btnFecha.setForeground(Color.white);
        btnTipo.setBackground(Color.decode("#037FB9"));
        btnTipo.setForeground(Color.white);
        panelFiltros.add(btnFecha);
        panelFiltros.add(btnTipo);

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
        modelo.addColumn("TIPO ");
        modelo.addColumn("DESCRIPCION ");
        modelo.addColumn("MONTO ");
        modelo.addColumn("FECHA ");
        modelo.addColumn("REFERENCIA ");
        
        
        // Gráfico de barras Ingresos
        panelIngresos = new ChartPanel(chartIngresos);
        panelIngresos.setPreferredSize(new Dimension(400, 300));
        
        // Gráfico de barras Gastos
        panelGastos = new ChartPanel(chartGastos);
        panelGastos.setPreferredSize(new Dimension(400, 300));

        // Gráfico de pastel gastos/ganancias
        panelTipo = new ChartPanel(charTipo);
        panelTipo.setPreferredSize(new Dimension(400, 300));
        
        panelGraficos= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelGraficos.setPreferredSize(new Dimension(220, 340));
        panelGraficos.add(panelIngresos);
        panelGraficos.add(panelGastos);
        panelGraficos.add(panelTipo);
        
        
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
        volver = super.volver;
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

        panelModal.add(paneltiempo1);
        panelModal.add(paneltiempo2);
        panelModal.add(panelbotonfiltro);
        modalFecha.add(panelModal);
        
        
        // Agregamos el modal del filtro Tipo de Reporte
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
    
    public void mostrarModalTipo() {
        modalTipo.setSize(200, 200);
        modalTipo.setLocationRelativeTo(this);
        modalTipo.setVisible(true);
    }
    

        
       
        
    
    
    
}
