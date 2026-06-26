/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.ReportesDao;
import View.Apartado_reportes_view;

/**
 *
 * @author juans
 */
public class Reportes_controlador implements ActionListener{
    
    public ReportesDao persona = new ReportesDao();
    public Apartado_reportes_view vista = new Apartado_reportes_view();
    DefaultTableModel modelo = new DefaultTableModel();
    Reportes_creadorPdf CrearPdf;
    
    public Reportes_controlador(Apartado_reportes_view vista, ReportesDao dao) {
        this.vista = vista;
        this.persona = dao;
        this.CrearPdf = new Reportes_creadorPdf();
        this.vista.btnExportar.addActionListener(this);
        cargarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.btnExportar){
            CrearPdf.setCrearPdf(vista.tabla);
        }
    }

    private void cargarTabla() {
        List datos = persona.listar();
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
}
