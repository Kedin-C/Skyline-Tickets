/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inspeccion_avionesDao;
import View.CheckList_aviones_view;
import View.Inspeccion_vuelos_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class CheckList_aviones_controller implements ActionListener{
    
    private CheckList_aviones_view view;
    private Inspeccion_vuelos_view inspec;
    private Inspeccion_avionesDao dao;
    private Inspeccion_vuelos_controller inspec_cont;

    public CheckList_aviones_controller(CheckList_aviones_view view, Inspeccion_vuelos_view inspec,Inspeccion_vuelos_controller inspec_cont,Inspeccion_avionesDao dao) {
        this.view = view;
        this.inspec = inspec;
        this.dao = dao;
        this.inspec_cont = inspec_cont;
        this.view.btnRegistrarInspeccion.addActionListener(this);
        this.view.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnVolver){
            view.setVisible(false);
            inspec.setVisible(true);
            inspec.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == view.btnRegistrarInspeccion){
            validarCheck();
        }
    }
    
    private void validarCheck() {
        if (!view.chkAlerones.isSelected()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, seleccione el check de los alerones.",
                    "Check no seleccionado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        } else {
            if (!view.chkAspasTurbina.isSelected()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, seleccione el check de las aspas de turbina.",
                        "Check no seleccionado",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } else {
                if (!view.chkCabinaAsegurada.isSelected()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, seleccione el check de la cabina asegurada.",
                            "Check no seleccionado",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                } else {
                    if (!view.chkCargaAsegurada.isSelected()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor, seleccione el check de la carga asegurada.",
                                "Check no seleccionado",
                                JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    } else {
                        if (!view.chkEquipoEmergencia.isSelected()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, seleccione el check del equipo de emergencia.",
                                    "Check no seleccionado",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            return;
                        } else {
                            if (!view.chkFuselaje.isSelected()) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Por favor, seleccione el check del fuselaje.",
                                        "Check no seleccionado",
                                        JOptionPane.WARNING_MESSAGE
                                );
                                return;
                            } else {
                                if (!view.chkLlantas.isSelected()) {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Por favor, seleccione el check de las llantas.",
                                            "Check no seleccionado",
                                            JOptionPane.WARNING_MESSAGE
                                    );
                                    return;
                                } else {
                                    if (!view.chkMotoresFugas.isSelected()) {
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "Por favor, seleccione el check de las fugas del motor.",
                                                "Check no seleccionado",
                                                JOptionPane.WARNING_MESSAGE
                                        );
                                        return;
                                    } else {
                                        if (!view.chkNivelCombustible.isSelected()) {
                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "Por favor, seleccione el check del combustible.",
                                                    "Check no seleccionado",
                                                    JOptionPane.WARNING_MESSAGE
                                            );
                                            return;
                                        } else {
                                            if (!view.chkTrenAterrizaje.isSelected()) {
                                                JOptionPane.showMessageDialog(
                                                        null,
                                                        "Por favor, seleccione el check del tren de aterrizaje.",
                                                        "Check no seleccionado",
                                                        JOptionPane.WARNING_MESSAGE
                                                );
                                                return;
                                            } else {
                                                if (view.txtNombreTecnico.getText().isBlank() && view.txtNombreTecnico.getText().isEmpty()) {
                                                    JOptionPane.showMessageDialog(
                                                            null,
                                                            "Por favor, Ingrese el nombre del tecnico que hace el check al avion.",
                                                            "Nombre del Tecnico en Blanco",
                                                            JOptionPane.WARNING_MESSAGE
                                                    );
                                                    return;
                                                }else{
                                                    dao.cambioEstado(view.txtMatricula.getText());
                                                    inspec_cont.cargarTabla();
                                                    view.setVisible(false);
                                                    inspec.setVisible(true);
                                                    inspec.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
