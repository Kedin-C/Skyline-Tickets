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
import Model.Reportes_financieros_dao;
import View.Apartado_reportes_menu_view;
import View.Apartado_reportes_financieros_view;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author juans
 */
public class Reportes_financieros_controller implements ActionListener{
    
    public Reportes_financieros_dao reportes = new Reportes_financieros_dao();
    public Apartado_reportes_financieros_view vista = new Apartado_reportes_financieros_view();
    public Apartado_reportes_menu_view vistaM = new Apartado_reportes_menu_view();
    DefaultTableModel modelo = new DefaultTableModel();
    Reportes_creadorPdf CrearPdf;
    JFreeChart chartIngresos,chartGastos,chartTipo;
    
    public Reportes_financieros_controller(Apartado_reportes_financieros_view vista, Reportes_financieros_dao reportes, Apartado_reportes_menu_view vistaM) {
        this.vista = vista;
        this.reportes = reportes;
        this.vistaM = vistaM;
        this.CrearPdf = new Reportes_creadorPdf();
        this.vista.btnExportar.addActionListener(this);
        this.vista.btnFecha.addActionListener(this);
        this.vista.btnAplicarFecha.addActionListener(this);
        this.vista.btnTipo.addActionListener(this);
        this.vista.btnAplicarTipo.addActionListener(this);
        this.vista.volver.addActionListener(this);
        this.vista.btnQuitarFiltro.addActionListener(this);
        cargarTabla();
        
        cargarGraficoIngresosFecha("2026-03-01", "2026-06-30");
        cargarGraficoGastosFecha("2026-03-01", "2026-06-30");
        cargarGraficoDistribucionFecha("2026-03-01", "2026-06-30");
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.btnExportar){
            System.out.println("hola");
            CrearPdf.setCrearPdf(vista.tabla,chartIngresos,chartGastos,chartTipo);
        }else if(e.getSource() == vista.btnFecha){
            vista.mostrarModalFecha();
        }else if(e.getSource() == vista.btnAplicarFecha){
            Date inicio = vista.fechaInicio.getDate();
            Date fin = vista.fechaFin.getDate();
            if(inicio != null && fin != null && inicio.before(fin)) {
                String f1 = new SimpleDateFormat("yyyy-MM-dd").format(inicio);
                String f2 = new SimpleDateFormat("yyyy-MM-dd").format(fin);
                cargarTablaPorFecha(f1,f2);
                cargarGraficoIngresosFecha(f1,f2);
                cargarGraficoGastosFecha(f1,f2);
                cargarGraficoDistribucionFecha(f1,f2);
                vista.modalFecha.dispose();
            }
        }else if(e.getSource() == vista.btnTipo){
            vista.mostrarModalTipo();
        }else if(e.getSource() == vista.btnAplicarTipo){
            String tipo = (String)vista.ComboxTipo.getSelectedItem();
            if(tipo != "") {
                cargarTablaPorTipo(tipo);
                cargarGraficoIngresosTipo(tipo);
                cargarGraficoGastosTipo(tipo);
                cargarGraficoDistribucionTipo(tipo);
                vista.modalTipo.dispose();
            }
        }else if(e.getSource() == vista.volver){
            vista.setVisible(false);
            vistaM.setVisible(true);
        }else if(e.getSource() == vista.btnQuitarFiltro){
            cargarTabla();
        
            cargarGraficoIngresosFecha("2026-03-01", "2026-06-30");
            cargarGraficoGastosFecha("2026-03-01", "2026-06-30");
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
    
    // Gráfico ingresos fechas
    public void cargarGraficoIngresosFecha(String fechaInicio, String fechaFin) {
        DefaultCategoryDataset dataset = reportes.obtenerIngresosDatasetT(fechaInicio, fechaFin);
        chartIngresos = ChartFactory.createBarChart(
            "Ingresos (" + fechaInicio + " a " + fechaFin + ")",
            "Mes",
            "Monto",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartIngresos);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelIngresos.removeAll();
        vista.panelIngresos.add(panel);
        vista.panelIngresos.validate();
    }

    // Gráfico gastos fechas
    public void cargarGraficoGastosFecha(String fechaInicio, String fechaFin) {
        DefaultCategoryDataset dataset = reportes.obtenerGastosDatasetT(fechaInicio, fechaFin);
        chartGastos = ChartFactory.createBarChart(
            "Gastos por Mes (" + fechaInicio + " a " + fechaFin + ")",
            "Mes",
            "Monto",
            dataset
        );
        ChartPanel panel = new ChartPanel(chartGastos);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelGastos.removeAll();
        vista.panelGastos.add(panel);
        vista.panelGastos.validate();
    }

    // Gráfico distribución gastos/ganancias fechas
    public void cargarGraficoDistribucionFecha(String fechaInicio, String fechaFin) {
        DefaultPieDataset dataset = reportes.obtenerDistribucionGastosGananciasDatasetT(fechaInicio, fechaFin);
        chartTipo = ChartFactory.createPieChart(
            "Distribución Gastos vs Ganancias (" + fechaInicio + " a " + fechaFin + ")",
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
    
    //Cargar los datos de la tabla por tipo
    private void cargarTablaPorTipo(String tipo) {
        List datos = reportes.listarPorTipo(tipo);
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
    // Gráfico ingresos tipo
    public void cargarGraficoIngresosTipo(String tipo) {
        DefaultCategoryDataset dataset = reportes.obtenerIngresosDatasetTP(tipo);
        chartIngresos = ChartFactory.createBarChart(tipo + " por mes", "Mes", "Monto",dataset);
        ChartPanel panel = new ChartPanel(chartIngresos);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelIngresos.removeAll();
        vista.panelIngresos.add(panel);
        vista.panelIngresos.validate();
    }

    // Gráfico gastos tipo
    public void cargarGraficoGastosTipo(String tipo) {
        DefaultCategoryDataset dataset = reportes.obtenerGastosDatasetTP(tipo);
        chartGastos = ChartFactory.createBarChart( tipo + " últimos 3 meses","Mes", "Monto",dataset);
        ChartPanel panel = new ChartPanel(chartGastos);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelGastos.removeAll();
        vista.panelGastos.add(panel);
        vista.panelGastos.validate();
    }

    // Gráfico distribución gastos/ganancias tipo
    public void cargarGraficoDistribucionTipo(String tipo) {
        DefaultPieDataset dataset = reportes.obtenerDistribucionGastosGananciasDatasetTP(tipo);
        chartTipo = ChartFactory.createPieChart("Distribución de " + tipo,dataset,true, true, false
        );
        ChartPanel panel = new ChartPanel(chartTipo);
        panel.setPreferredSize(new Dimension(400, 300));
        vista.panelTipo.removeAll();
        vista.panelTipo.add(panel);
        vista.panelTipo.validate();
    }   
    
}
