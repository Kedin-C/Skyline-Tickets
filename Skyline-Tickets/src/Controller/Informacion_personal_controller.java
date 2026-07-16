/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
 
/**
 *
 * @author Nikob
 */

import javax.swing.JOptionPane;
import Model.Sesion_usuario;
import Model.Usuario;
import Model.UsuarioDao;
import View.Informacion_personal_view;
import View.Inicio_usuario_view;
import View.Nueva_contraseña_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Informacion_personal_controller implements ActionListener{
    Informacion_personal_view vista;
    Inicio_usuario_view usuario_view;
    Usuario usuarioActual;
    UsuarioDao usuarioDao;
    Sesion_usuario sesion_usuario;
    

    public Informacion_personal_controller(Informacion_personal_view view_p,Inicio_usuario_view usuario_view,Sesion_usuario sesion_usuario) {
        vista = view_p;
        this.usuario_view = usuario_view;
        this.sesion_usuario = sesion_usuario;
        
        usuarioDao = new UsuarioDao();
        
        this.vista.btnVolver.addActionListener(this);
        
        
    }



    
    public void cargarDatosEnVista() {
        usuarioActual = this.sesion_usuario.getUsuario();
        vista.getTxtCorreo().setText(usuarioActual.getCorreo());
        vista.getTxtNombre().setText(usuarioActual.getNombre());
        vista.getTxtApellido().setText(usuarioActual.getApellido());
    }

    
    public void agregarEventos() {

        vista.getBtnAceptar().addActionListener(e -> actualizarCorreo());

        vista.getBtnVolver().addActionListener(e -> {
        vista.dispose();

        
       
        usuario_view.setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnVolver){
            
            vista.setVisible(false);
            
            usuario_view.setVisible(true);
            usuario_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
    

        
      
    
}
