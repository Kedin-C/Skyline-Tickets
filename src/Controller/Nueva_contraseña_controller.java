package Controller;
/**
 *
 * @author Nikob
 */
import Model.UsuarioDao;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import View.Nueva_contraseña_view;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Nueva_contraseña_controller {
    private Nueva_contraseña_view view;
    private UsuarioDao usuarioDao;
    private String correo;
    private JFrame vistaDestino;

    /**
     * @param view Vista de "nueva contraseña"
     * @param correo Correo del usuario al que se le cambia la contraseña
     * @param vistaDestino Vista a la que se debe volver al terminar (Login_view si viene de
     *                     "olvidé mi contraseña", o Inicio_usuario_view si viene del perfil
     *                     estando ya logueado)
     */
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
}