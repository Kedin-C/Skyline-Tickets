/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Nikob
 */
import controller.Login_controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Codigo_recuperacion_view;
import view.Login_view;
import view.Recuperar_contraseña_view;

public class Recuperar_contraseña_controller {

    private Recuperar_contraseña_view view;

    public Recuperar_contraseña_controller(Recuperar_contraseña_view view) {
        this.view = view;
        iniciarEventos();
    }

    private void iniciarEventos() {

        view.getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesar();
            }
        });

        view.getBtnVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.dispose();

                Login_view login = new Login_view();
                new Login_controller(login);
            }
        });
    }

    private void procesar() {

        String correo = view.getTxCorreo().getText().trim();

        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo");
            return;
        }

        Codigo_recuperacion_controller generador = new Codigo_recuperacion_controller();
        boolean existe = generador.procesarSolicitudRecuperacion(correo);

        if (!existe) {
            JOptionPane.showMessageDialog(null, "El correo no existe");
            return;
        }

        String codigoGenerado = generador.getCodigoGenerado();

        Codigo_recuperacion_view codigoView = new Codigo_recuperacion_view(correo);
        new Codigo_recuperacion_controller(codigoView, codigoGenerado, correo);
        codigoView.setLocationRelativeTo(null);
        codigoView.setVisible(true);

        view.dispose();
    }
}
