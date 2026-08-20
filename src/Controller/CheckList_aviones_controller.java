/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inspeccion_avionesDao;
import Model.Usuario;
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
public class CheckList_aviones_controller implements ActionListener {

    private CheckList_aviones_view view;
    private Inspeccion_vuelos_view inspec;
    private Inspeccion_avionesDao dao;
    private Inspeccion_vuelos_controller inspec_cont;
    private Usuario usu;

    public CheckList_aviones_controller(CheckList_aviones_view view, Inspeccion_vuelos_view inspec, Inspeccion_vuelos_controller inspec_cont, Inspeccion_avionesDao dao, Usuario usu) {
        this.view = view;
        this.inspec = inspec;
        this.dao = dao;
        this.inspec_cont = inspec_cont;
        this.usu = usu;
        this.view.btnRegistrarInspeccion.addActionListener(this);
        this.view.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnVolver) {
            view.setVisible(false);
            inspec.setVisible(true);
            inspec.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else if (e.getSource() == view.btnRegistrarInspeccion) {
            validarCheck();
        }
    }

    private void validarCheck() {
        if (!view.rbAleronesAplica.isSelected() && !view.rbAleronesNoAplica.isSelected()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, seleccione Aplica o No aplica en los alerones.",
                    "Opción no seleccionada",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        } else {
            if (!view.rbAspasTurbinaAplica.isSelected() && !view.rbAspasTurbinaNoAplica.isSelected()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, seleccione Aplica o No aplica en las aspas de turbina.",
                        "Opción no seleccionada",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } else {
                if (!view.rbCabinaAseguradaAplica.isSelected() && !view.rbCabinaAseguradaNoAplica.isSelected()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, seleccione Aplica o No aplica en la cabina asegurada.",
                            "Opción no seleccionada",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                } else {
                    if (!view.rbCargaAseguradaAplica.isSelected() && !view.rbCargaAseguradaNoAplica.isSelected()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Por favor, seleccione Aplica o No aplica en la carga asegurada.",
                                "Opción no seleccionada",
                                JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    } else {
                        if (!view.rbEquipoEmergenciaAplica.isSelected() && !view.rbEquipoEmergenciaNoAplica.isSelected()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Por favor, seleccione Aplica o No aplica en el equipo de emergencia.",
                                    "Opción no seleccionada",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            return;
                        } else {
                            if (!view.rbFuselajeAplica.isSelected() && !view.rbFuselajeNoAplica.isSelected()) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Por favor, seleccione Aplica o No aplica en el fuselaje.",
                                        "Opción no seleccionada",
                                        JOptionPane.WARNING_MESSAGE
                                );
                                return;
                            } else {
                                if (!view.rbLlantasAplica.isSelected() && !view.rbLlantasNoAplica.isSelected()) {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Por favor, seleccione Aplica o No aplica en las llantas.",
                                            "Opción no seleccionada",
                                            JOptionPane.WARNING_MESSAGE
                                    );
                                    return;
                                } else {
                                    if (!view.rbMotoresFugasAplica.isSelected() && !view.rbMotoresFugasNoAplica.isSelected()) {
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "Por favor, seleccione Aplica o No aplica en las fugas del motor.",
                                                "Opción no seleccionada",
                                                JOptionPane.WARNING_MESSAGE
                                        );
                                        return;
                                    } else {
                                        if (!view.rbNivelCombustibleAplica.isSelected() && !view.rbNivelCombustibleNoAplica.isSelected()) {
                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "Por favor, seleccione Aplica o No aplica en el combustible.",
                                                    "Opción no seleccionada",
                                                    JOptionPane.WARNING_MESSAGE
                                            );
                                            return;
                                        } else {
                                            if (!view.rbTrenAterrizajeAplica.isSelected() && !view.rbTrenAterrizajeNoAplica.isSelected()) {
                                                JOptionPane.showMessageDialog(
                                                        null,
                                                        "Por favor, seleccione Aplica o No aplica en el tren de aterrizaje.",
                                                        "Opción no seleccionada",
                                                        JOptionPane.WARNING_MESSAGE
                                                );
                                                return;
                                            } else {
                                                if (view.txtFirmaTecnico.getText().isBlank() && view.txtFirmaTecnico.getText().isEmpty()) {
                                                    JOptionPane.showMessageDialog(
                                                            null,
                                                            "Por favor, Ingrese el nombre del tecnico que hace el check al avion.",
                                                            "Nombre del Tecnico en Blanco",
                                                            JOptionPane.WARNING_MESSAGE
                                                    );
                                                    return;
                                                } else {
                                                    if (!usu.getNombre().equals(view.txtFirmaTecnico.getText())) {
                                                        JOptionPane.showMessageDialog(
                                                                null,
                                                                "Se tiene que realizar la firma ingresando el mismo nombre del tecnico de esta cuenta.",
                                                                "Firma del Tecnico",
                                                                JOptionPane.WARNING_MESSAGE
                                                        );
                                                        return;
                                                    } else {
                                                        boolean tieneNoAplica = view.rbAleronesNoAplica.isSelected()
                                                                || view.rbAspasTurbinaNoAplica.isSelected()
                                                                || view.rbCabinaAseguradaNoAplica.isSelected()
                                                                || view.rbCargaAseguradaNoAplica.isSelected()
                                                                || view.rbEquipoEmergenciaNoAplica.isSelected()
                                                                || view.rbFuselajeNoAplica.isSelected()
                                                                || view.rbLlantasNoAplica.isSelected()
                                                                || view.rbMotoresFugasNoAplica.isSelected()
                                                                || view.rbNivelCombustibleNoAplica.isSelected()
                                                                || view.rbTrenAterrizajeNoAplica.isSelected();

                                                        String estado = tieneNoAplica ? "Inactivo" : "Activo";

                                                        dao.cambioEstado(view.txtMatricula.getText(), estado);
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

}
