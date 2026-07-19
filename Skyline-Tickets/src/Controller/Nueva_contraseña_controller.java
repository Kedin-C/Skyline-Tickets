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
import javax.swing.JOptionPane;
import View.Nueva_contraseña_view;
import View.Login_view;

public class Nueva_contraseña_controller {

    private Nueva_contraseña_view view;
    private UsuarioDao usuarioDao;
    private String correo;

        
    public Nueva_contraseña_controller(Nueva_contraseña_view view, String correo) {
        this.view = view;
        this.correo = correo;
        usuarioDao = new UsuarioDao();
        iniciarEventos();
    }

    private void iniciarEventos() {
        
        view.getB1().addActionListener(e -> confirmarCambio());

        
        view.getB2().addActionListener(e -> {
            Login_view loginView = new Login_view();
//            new Login_controller(loginView);
            loginView.setLocationRelativeTo(null);
            loginView.setVisible(true);
            view.dispose();
        });
        
        
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

        
        boolean actualizado = usuarioDao.actualizarContraseña(correo, nueva);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
           
            Login_view loginView = new Login_view();
//            new Login_controller(loginView);
            loginView.setLocationRelativeTo(null);
            loginView.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña");
        }
    }
}
