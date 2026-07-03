/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
 
/**
 *
 * @author Nikob
 */

import javax.swing.JOptionPane;
import model.Sesion_usuario;
import model.Usuario;
import model.UsuarioDao;
import view.Informacion_personal_view;
import view.Inicio_usuario_view;
import view.Nueva_contraseña_view;

public class Informacion_personal_controller {
    Informacion_personal_view vista;
    Usuario usuarioActual;
    UsuarioDao usuarioDao;

    public Informacion_personal_controller() {
        vista = new Informacion_personal_view();
        usuarioActual = Sesion_usuario.getUsuario();
        usuarioDao = new UsuarioDao();

        cargarDatosEnVista();
        agregarEventos();
    }

    
    public void mostrar() {
        vista.setVisible(true);
    }

    
    private void cargarDatosEnVista() {
        vista.getTxtCorreo().setText(usuarioActual.getCorreo());
        vista.getTxtNombre().setText(usuarioActual.getNombre());
        vista.getTxtApellido().setText(usuarioActual.getApellido());
    }

    
    private void agregarEventos() {

        vista.getBtnAceptar().addActionListener(e -> actualizarCorreo());

        vista.getBtnVolver().addActionListener(e -> {
        vista.dispose();

        Inicio_usuario_view inicio = new Inicio_usuario_view();
       
        inicio.setVisible(true);
        });

         vista.getBtnCambiarContrasena().addActionListener(e -> {
            Nueva_contraseña_view nuevaView = new Nueva_contraseña_view();
            new Nueva_contraseña_controller(nuevaView, usuarioActual.getCorreo());
            nuevaView.setLocationRelativeTo(null);
            nuevaView.setVisible(true);
            vista.dispose();
        });
    }

    
    private void actualizarCorreo() {
        String nuevoCorreo = vista.getTxtCorreo().getText().trim();

        if (nuevoCorreo.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El correo no puede estar vacío.");
            return;
        }

        if (!nuevoCorreo.contains("@") || !nuevoCorreo.contains(".")) {
            JOptionPane.showMessageDialog(vista, "Ingresa un correo válido.");
            return;
        }

        boolean actualizado = usuarioDao.actualizarCorreo(usuarioActual.getIdUsuario(), nuevoCorreo);

        if (actualizado) {
            usuarioActual.setCorreo(nuevoCorreo);
            JOptionPane.showMessageDialog(vista, "Correo actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo actualizar el correo.");
        }
    }
}
