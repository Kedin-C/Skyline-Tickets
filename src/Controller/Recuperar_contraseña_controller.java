/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
/**
 *
 * @author Nikob
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.Codigo_recuperacion_view;
import View.Login_view;
import View.Recuperar_contraseña_view;

public class Recuperar_contraseña_controller {

    private Recuperar_contraseña_view view;
    private Login_view loginView;

    public Recuperar_contraseña_controller(Recuperar_contraseña_view view, Login_view loginView) {
        this.view = view;
        this.loginView = loginView;
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
                loginView.setVisible(true);
                loginView.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
        Codigo_recuperacion_view codigoView = new Codigo_recuperacion_view(correo, view);
        new Codigo_recuperacion_controller(codigoView, codigoGenerado, correo, loginView);
        codigoView.setLocationRelativeTo(null);
        codigoView.setVisible(true);
        view.dispose();
    }
}