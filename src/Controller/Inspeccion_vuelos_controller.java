/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inspeccion_avionesDao;
import Model.Usuario;
import View.CheckList_aviones_view;
import View.Inspeccion_vuelos_view;
import View.Pagina_principal_tecnico_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class Inspeccion_vuelos_controller implements ActionListener{
    
    private Pagina_principal_tecnico_view tecni;
    private Inspeccion_vuelos_view view;
    private Inspeccion_avionesDao dao;
    private CheckList_aviones_view check;

    public Inspeccion_vuelos_controller(Pagina_principal_tecnico_view tecni, Inspeccion_vuelos_view view, Inspeccion_avionesDao dao,CheckList_aviones_view check) {
        this.tecni = tecni;
        this.view = view;
        this.dao = new Inspeccion_avionesDao();
        this.check = check;
        this.view.volver.addActionListener(this);
        this.view.inspeccionar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == view.volver){
            view.setVisible(false);
            tecni.setVisible(true);
            tecni.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == view.inspeccionar){
            int fila = view.tabla.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, seleccione un avion de la tabla para continuar.",
                        "Avion no seleccionado",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }else{
                String estado = view.tabla.getValueAt(fila, 4).toString();
                if(estado.equals("Activo")){
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, seleccione un avion de la tabla que este por revisar.",
                            "Avion Activo",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }else if(estado.equals("Inactivo")){
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, seleccione un avion de la tabla que este por revisar.",
                            "Avion Inactivo",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                } else {
                    view.setVisible(false);
                    String matricula = view.tabla.getValueAt(fila, 0).toString();
                    check.txtMatricula.setText(matricula);
                    String marca = view.tabla.getValueAt(fila, 1).toString();
                    check.txtMarca.setText(marca);
                    String modelo = view.tabla.getValueAt(fila, 2).toString();
                    check.txtModelo.setText(modelo);
                    check.setVisible(true);
                    check.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        }
    }
    
    public void cargarTabla(){
        List datos = dao.listarAviones();
        DefaultTableModel modelo = (DefaultTableModel) view.tabla.getModel();
        modelo.setRowCount(0);

        for (Object obj : datos) {
            Object[] fila = (Object[]) obj;
            modelo.addRow(fila);
        }
    }
    
}
