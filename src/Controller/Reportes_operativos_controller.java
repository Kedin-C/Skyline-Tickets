/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Reportes_creadorPdf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.Reportes_operativos_dao;
import View.Apartado_reportes_menu_view;
import View.Apartado_reportes_operacionales_view;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author juans
 */
public class Reportes_operativos_controller implements ActionListener{
    
    public Reportes_operativos_dao reportes = new Reportes_operativos_dao();
    public Apartado_reportes_operacionales_view vista = new Apartado_reportes_operacionales_view();
    public Apartado_reportes_menu_view vistaM = new Apartado_reportes_menu_view();
    DefaultTableModel modelo = new DefaultTableModel();
    String[] listaDestinos;
    JComboBox<String> comboDestinos;
    Reportes_creadorPdf CrearPdf;
    JFreeChart chartTiempo,chartDestino,chartTipo;
    
    public Reportes_operativos_controller(Apartado_reportes_operacionales_view vista, Reportes_operativos_dao reportes, Apartado_reportes_menu_view vistaM) {
        this.vista = vista;
        this.reportes = reportes;
        this.vistaM = vistaM;
        this.CrearPdf = new Reportes_creadorPdf();
        this.vista.btnExportar.addActionListener(this);
        this.vista.btnFecha.addActionListener(this);
        this.vista.btnAplicarFecha.addActionListener(this);
        this.vista.btnDestino.addActionListener(this);
        this.vista.btnAplicarDestino.addActionListener(this);
        this.vista.btnTipo.addActionListener(this);
        this.vista.btnAplicarTipo.addActionListener(this);
        this.vista.volver.addActionListener(this);
        this.vista.btnQuitarFiltros.addActionListener(this);
        cargarTabla();
        cargarGraficoTendenciaFecha("2026-03-01", "2026-06-30");
        cargarGraficoDestinosFecha("2026-03-01", "2026-06-30", 5);
        cargarGraficoDistribucionFecha("2026-03-01", "2026-06-30");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.btnExportar){
            CrearPdf.setCrearPdf(vista.tabla,chartTiempo,chartDestino,chartTipo);
        }else if(e.getSource() == vista.btnFecha){
            vista.mostrarModalFecha();
        }else if(e.getSource() == vista.btnAplicarFecha){
            Date inicio = vista.fechaInicio.getDate();
            Date fin = vista.fechaFin.getDate();

            if(inicio == null || fin == null) {
                JOptionPane.showMessageDialog(vista,
                    "Debe seleccionar ambas fechas.",
                    "Error en Filtro",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(inicio.after(fin)) {
                JOptionPane.showMessageDialog(vista,
                    "La fecha de inicio no puede ser posterior a la fecha fin.",
                    "Error en Filtro",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String f1 = new SimpleDateFormat("yyyy-MM-dd").format(inicio);
            String f2 = new SimpleDateFormat("yyyy-MM-dd").format(fin);

            cargarTablaPorFecha(f1, f2);
            cargarGraficoTendenciaFecha(f1, f2);
            cargarGraficoDestinosFecha(f1, f2, 5);
            cargarGraficoDistribucionFecha(f1, f2);
            vista.modalFecha.dispose();
        }else if(e.getSource() == vista.btnDestino){
            cargarListaDestinos();
            vista.mostrarModalDestino();
        }else if(e.getSource() == vista.btnAplicarDestino){
            String destino = (String)comboDestinos.getSelectedItem();
            if(destino != "") {
                cargarTablaPorDestino(destino);
                cargarGraficoTendenciaDestino(destino);
                cargarGraficoDestinosDestino(destino,1);
                cargarGraficoDistribucionDestino(destino);
                vista.modalDestino.dispose();
            }
        }else if(e.getSource() == vista.btnTipo){
            vista.mostrarModalTipo();
        }else if(e.getSource() == vista.btnAplicarTipo){
            String tipo = (String)vista.ComboxTipo.getSelectedItem();
            if(tipo != "") {
                cargarTablaPorTipo(tipo);
                cargarGraficoTendenciaTipo(tipo);
                cargarGraficoDestinosTipo(tipo,5);
                cargarGraficoDistribucionTipo(tipo);
                vista.modalTipo.dispose();
            }
        }else if(e.getSource() == vista.volver){
            vista.setVisible(false);
            vistaM.setVisible(true);
        }else if(e.getSource() == vista.btnQuitarFiltros){
            cargarTabla();
            cargarGraficoTendenciaFecha("2026-03-01", "2026-06-30");
            cargarGraficoDestinosFecha("2026-03-01", "2026-06-30", 5);
            cargarGraficoDistribucionFecha("2026-03-01", "2026-06-30");
        }
    }

    public void cargarTabla(){
        List datos = reportes.listar();
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
    // Gráfico tendencia fechas
    public void cargarGraficoTendenciaFecha(String fechaInicio, String fechaFin) {
        DefaultCategoryDataset dataset = reportes.obtenerTendenciaVuelosDatasetT(fechaInicio, fechaFin);
        chartTiempo = ChartFactory.createBarChart(
            "Tendencia de Vuelos (" + fechaInicio + " a " + fechaFin + ")", 
            "Mes", 
            "Cantidad", 
            dataset
        );
        ChartPanel panel = new ChartPanel(chartTiempo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTiempo.removeAll();
        vista.panelTiempo.add(panel);
        vista.panelTiempo.validate();
    }

    // Gráfico top destinos fechas
    public void cargarGraficoDestinosFecha(String fechaInicio, String fechaFin, int limite) {
        DefaultCategoryDataset dataset = reportes.obtenerTopDestinosDatasetT(fechaInicio, fechaFin, limite);
        chartDestino = ChartFactory.createBarChart(
            "Top Destinos (" + fechaInicio + " a " + fechaFin + ")", 
            "Destino", 
            "Cantidad", 
            dataset
        );
        ChartPanel panel = new ChartPanel(chartDestino);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelDestinos.removeAll();
        vista.panelDestinos.add(panel);
        vista.panelDestinos.validate();
    }   

    // Gráfico distribución nacional/internacional fechas
    public void cargarGraficoDistribucionFecha(String fechaInicio, String fechaFin) {
        DefaultPieDataset dataset = reportes.obtenerDistribucionTipoVueloDatasetT(fechaInicio, fechaFin);
        chartTipo = ChartFactory.createPieChart(
            "Distribución Nacional vs Internacional (" + fechaInicio + " a " + fechaFin + ")", 
            dataset, 
            true, 
            true, 
            false
        );
        ChartPanel panel = new ChartPanel(chartTipo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTipo.removeAll();
        vista.panelTipo.add(panel);
        vista.panelTipo.validate();
    }
    
    //Cargar los datos de la tabla por rango de fechas
    private void cargarTablaPorFecha(String fechaInicio, String fechaFin) {
        List datos = reportes.listarPorFecha(fechaInicio, fechaFin);
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
    private void cargarListaDestinos() {
        List<String> destinos = reportes.listaDestinos();
        listaDestinos = destinos.toArray(new String[0]);
        String[] opcionesConVacio = new String[listaDestinos.length + 1];
        opcionesConVacio[0] = ""; 
        System.arraycopy(listaDestinos, 0, opcionesConVacio, 1, listaDestinos.length);
        comboDestinos = new JComboBox<>(opcionesConVacio);
        vista.panelComboxDestino.add(comboDestinos);
    }
    
    //Cargar los datos de la tabla por destino
    private void cargarTablaPorDestino(String destino) {
        List datos = reportes.listarPorDestino(destino);
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
    
    // Gráfico tendencia destino
    public void cargarGraficoTendenciaDestino(String destino) {
        DefaultCategoryDataset dataset = reportes.obtenerTendenciaVuelosDatasetD(destino);
        chartTiempo = ChartFactory.createBarChart(
            "Tendencia de Vuelos hacia " + destino,
            "Mes",
            "Cantidad",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartTiempo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTiempo.removeAll();
        vista.panelTiempo.add(panel);
        vista.panelTiempo.validate();
    }

    // Gráfico top destinos destino
    public void cargarGraficoDestinosDestino(String destino, int limite) {
        DefaultCategoryDataset dataset = reportes.obtenerTopDestinosDatasetD(destino);
        chartDestino = ChartFactory.createBarChart(
            "Top Destinos desde " + destino,
            "Destino",
            "Cantidad",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartDestino);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelDestinos.removeAll();
        vista.panelDestinos.add(panel);
        vista.panelDestinos.validate();
    }

    // Gráfico distribución nacional/internacional destino
    public void cargarGraficoDistribucionDestino(String destino) {
        DefaultPieDataset dataset = reportes.obtenerDistribucionTipoVueloDatasetD(destino);
        chartTipo = ChartFactory.createPieChart(
            "Distribución Nacional vs Internacional desde " + destino,
            dataset,
            true,
            true,
               false
        );
        ChartPanel panel = new ChartPanel(chartTipo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTipo.removeAll();
        vista.panelTipo.add(panel);
        vista.panelTipo.validate();
    }
    
    //Cargar los datos de la tabla por destino
    private void cargarTablaPorTipo(String tipo) {
        List datos = reportes.listarPorTipo(tipo);
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
    // Gráfico tendencia tipo
    // Gráfico tendencia tipo
    public void cargarGraficoTendenciaTipo(String tipo) {
        DefaultCategoryDataset dataset = reportes.obtenerTendenciaVuelosDatasetTP(tipo);
        chartTiempo = ChartFactory.createBarChart(
            "Tendencia de Vuelos (" + tipo + ")",
            "Mes",
            "Cantidad",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartTiempo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTiempo.removeAll();
        vista.panelTiempo.add(panel);
        vista.panelTiempo.validate();
    }

    // Gráfico top destinos tipo
    public void cargarGraficoDestinosTipo(String tipo, int limite) {
        DefaultCategoryDataset dataset = reportes.obtenerTopDestinosDatasetTP(tipo, limite);
        chartDestino = ChartFactory.createBarChart(
            "Top Destinos (" + tipo + ")",
            "Destino",
            "Cantidad",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartDestino);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelDestinos.removeAll();
        vista.panelDestinos.add(panel);
        vista.panelDestinos.validate();
    }

    // Gráfico distribución nacional/internacional tipo
    public void cargarGraficoDistribucionTipo(String tipo) {
        DefaultPieDataset dataset = reportes.obtenerDistribucionTipoVueloDatasetTP(tipo);
        chartTipo = ChartFactory.createPieChart(
            "Distribución Nacional vs Internacional (" + tipo + ")", 
            dataset,
            true,
            true,
            false
        );
        ChartPanel panel = new ChartPanel(chartTipo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTipo.removeAll();
        vista.panelTipo.add(panel);
        vista.panelTipo.validate();
    }
    
}
