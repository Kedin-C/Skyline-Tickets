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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;

public class Informacion_personal_controller implements ActionListener {

    Informacion_personal_view vista;
    Inicio_usuario_view usuario_view;
    Usuario usuarioActual;
    UsuarioDao usuarioDao;
    Sesion_usuario sesion_usuario;

    public Informacion_personal_controller(Informacion_personal_view view_p, Inicio_usuario_view usuario_view, Sesion_usuario sesion_usuario) {
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

        vista.getTxtDocumento().setText(
                usuarioActual.getDocumento() != null ? usuarioActual.getDocumento() : "");

        vista.getTxtTelefono().setText(
                usuarioActual.getNumero_telefono() != null ? usuarioActual.getNumero_telefono() : "");

        String sexo = usuarioActual.getSexo();
        if (sexo != null && !sexo.isEmpty()) {
            vista.getCbSexo().setSelectedItem(sexo);
        } else {
            vista.getCbSexo().setSelectedIndex(0); 
        }

        String nacionalidad = usuarioActual.getNationalidad();
        if (nacionalidad != null && !nacionalidad.isEmpty()) {
            vista.getCbNacionalidad().setSelectedItem(nacionalidad);
        } else {
            vista.getCbNacionalidad().setSelectedIndex(0);
        }

        String fechaNacimiento = usuarioActual.getFecha_nacimiento();
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                vista.getDcFechaNacimiento().setDate(sdf.parse(fechaNacimiento));
            } catch (ParseException ex) {
                vista.getDcFechaNacimiento().setDate(null);
            }
        } else {
            vista.getDcFechaNacimiento().setDate(null);
        }
    }

    public void agregarEventos() {
        vista.getBtnAceptar().addActionListener(e -> guardarInformacion());

        vista.getBtnVolver().addActionListener(e -> {
            vista.dispose();
            usuario_view.setVisible(true);
        });

        vista.getBtnCambiarContrasena().addActionListener(e -> {
            Nueva_contraseña_view nuevaView = new Nueva_contraseña_view();
            new Nueva_contraseña_controller(nuevaView, usuarioActual.getCorreo(), usuario_view);
            nuevaView.setLocationRelativeTo(null);
            nuevaView.setVisible(true);
            vista.dispose();
        });
    }

    private void guardarInformacion() {
        String nuevoCorreo = vista.getTxtCorreo().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();
        String sexoSeleccionado = (String) vista.getCbSexo().getSelectedItem();
        String nacionalidadSeleccionada = (String) vista.getCbNacionalidad().getSelectedItem();
        Date fechaNacimientoSeleccionada = vista.getDcFechaNacimiento().getDate();

        if (!nuevoCorreo.isEmpty() && !validarCorreo(nuevoCorreo)) {
            JOptionPane.showMessageDialog(vista, "Ingresa un correo válido.");
            return;
        }

        if (!telefono.isEmpty() && !esTelefonoValido(telefono)) {
            JOptionPane.showMessageDialog(
                    vista,
                    "El número de teléfono debe tener 10 dígitos, no debe iniciar en 0 y no debe contener espacios.");
            return;
        }

        if (!validarEdad(fechaNacimientoSeleccionada)) {
            JOptionPane.showMessageDialog(
                    vista,
                    "La fecha de nacimiento debe corresponder a una edad entre 16 y 117 años.");
            return;
        }

        
        String sexo = "Seleccionar".equals(sexoSeleccionado) ? "" : sexoSeleccionado;
        String nacionalidad = "Seleccionar".equals(nacionalidadSeleccionada) ? "" : nacionalidadSeleccionada;

        
        String correoFinal = nuevoCorreo.isEmpty() ? usuarioActual.getCorreo() : nuevoCorreo;

        
        String documentoFinal = usuarioActual.getDocumento() != null ? usuarioActual.getDocumento() : "";

        String fechaNacimientoFinal = fechaNacimientoSeleccionada != null
                ? new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimientoSeleccionada)
                : "";

        boolean actualizado = usuarioDao.actualizarInformacionPersonal(
                usuarioActual.getIdUsuario(), correoFinal, documentoFinal, sexo, telefono,
                fechaNacimientoFinal, nacionalidad);

        if (actualizado) {
            usuarioActual.setCorreo(correoFinal);
            usuarioActual.setDocumento(documentoFinal);
            usuarioActual.setSexo(sexo);
            usuarioActual.setNumero_telefono(telefono);
            usuarioActual.setFecha_nacimiento(fechaNacimientoFinal);
            usuarioActual.setNationalidad(nacionalidad);
            JOptionPane.showMessageDialog(vista, "Información actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo actualizar la información.");
        }
    }

    
    private boolean validarEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return true;
        }
        Calendar hoy = Calendar.getInstance();
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);

        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad >= 16 && edad <= 117;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnVolver) {

            vista.setVisible(false);

            usuario_view.setVisible(true);
            usuario_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

    
     
    private boolean esTelefonoValido(String telefono) {
        return telefono.matches("^[1-9][0-9]{9}$");
    }

    private boolean validarCorreo(String correo) {
        if (correo == null || correo.isEmpty()) {
            return false;
        }
        if (correo.contains(" ")) {
            return false;
        }
        return correo.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    private boolean validarDocumento(String documento) {
        if (documento == null || documento.isEmpty()) {
            return false;
        }
        if (!documento.matches("[0-9]+")) {
            return false;
        }
        return documento.length() >= 8 && documento.length() <= 17;
    }

}