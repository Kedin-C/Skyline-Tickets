/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controller;
/**
 *
 * @author Nikob
 */
import Model.UsuarioDao;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import View.Nueva_contraseña_view;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Nueva_contraseña_controller {
    private Nueva_contraseña_view view;
    private UsuarioDao usuarioDao;
    private String correo;
    private JFrame vistaDestino;

    
    public Nueva_contraseña_controller(Nueva_contraseña_view view, String correo, JFrame vistaDestino) {
        this.view = view;
        this.correo = correo;
        this.vistaDestino = vistaDestino;
        usuarioDao = new UsuarioDao();
        iniciarEventos();
    }

    private void iniciarEventos() {
        view.getB1().addActionListener(e -> confirmarCambio());
        view.getB2().addActionListener(e -> {
            view.dispose();
            volverAVistaDestino();
        });

        configurarToggle(view.getTxNuevaContraseña(), view.getBtnVerNueva());
        configurarToggle(view.getTxConfirmarContraseña(), view.getBtnVerConfirmar());
    }

    private void confirmarCambio() {
        String nueva = view.getTxNuevaContraseña().getText().trim();
        String confirmar = view.getTxConfirmarContraseña().getText().trim();
        if (nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }
        if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return;
        }
        if (nueva.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres");
            return;
        }

        String hash = hashearContraseña(nueva);
        boolean actualizado = usuarioDao.actualizarContraseña(correo, hash);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
            view.dispose();
            volverAVistaDestino();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña");
        }
    }

    private void volverAVistaDestino() {
        vistaDestino.setLocationRelativeTo(null);
        vistaDestino.setVisible(true);
        vistaDestino.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private String hashearContraseña(String contraseña) {
        return BCrypt.withDefaults().hashToString(12, contraseña.toCharArray());
    }

    
    private void configurarToggle(JPasswordField campo, JButton boton) {
        final char echoOriginal = campo.getEchoChar();
        boton.addActionListener(e -> {
            if (campo.getEchoChar() == 0) {
                campo.setEchoChar(echoOriginal);
                boton.setText("Ver");
            } else {
                campo.setEchoChar((char) 0);
                boton.setText("Ocultar");
            }
        });
    }
}