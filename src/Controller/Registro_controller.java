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
import Model.Codigo_descuento;
import Controller.Codigo_descuento_controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Login_view;
import View.Menu_principal_view;
import View.Registro_view;

public class Registro_controller implements ActionListener {

    private Registro_view vista;
    private UsuarioDao dao;
    private Codigo_descuento_controller codigoController;

    public Registro_controller(Registro_view vista) {
        this.vista = vista;
        this.dao = new UsuarioDao();
        this.codigoController = new Codigo_descuento_controller();
        vista.getB1().addActionListener(this);
        vista.getBtnVolver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.getBtnVolver()) {
            
        Menu_principal_view MenuView = new Menu_principal_view();
        MenuView.setLocationRelativeTo(null);
        
        vista.dispose();
        }
        
        if (e.getSource() == vista.getB1()) {

            String nombre = vista.getTxNombre().getText();
            String apellido = vista.getTxApellido().getText();
            String correo = vista.getTxCorreo().getText();
            String contraseña = vista.getTxContraseña().getText();
            String confirmar = vista.getTxConfirmar().getText();
            
            
            if (dao.existeCorreo(correo)) {
                JOptionPane.showMessageDialog(
                null,
                "Este correo ya se encuentra registrado.");
                return;
            }       
            
            
            
            if (!validarNombreApellido(nombre)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El nombre solo puede contener letras.");
                return;
            }

            
            if (!validarNombreApellido(apellido)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El apellido solo puede contener letras.");
                return;
            }

            
            if (!validarContraseña(contraseña)) {
                JOptionPane.showMessageDialog(
                        null,
                        "La contraseña debe cumplir los siguientes requisitos:\n"
                        + "- Mínimo 8 caracteres.\n"
                        + "- No contener espacios.\n"
                        + "- Tener al menos 2 números.");
                return;
            }

            if (!contraseña.equals(confirmar)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Las contraseñas no coinciden");
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setContraseña(contraseña);
            usuario.setRol("USUARIO");

            if (dao.registrarUsuario(usuario)) {

                Codigo_descuento codigo = codigoController.generarYGuardarCodigo();

                if (codigo != null) {

                    Correo_controller correoController = new Correo_controller();

                    correoController.enviarCodigoDescuento(
                            correo,
                            codigo.getCodigo(),
                            codigo.getPorcentajeDescuento());

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario registrado correctamente.");
                }

                vista.dispose();

                Login_view login = new Login_view();
                new Login_controller(login);
                login.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al registrar usuario");
            }
        }
    }

    

    
    private boolean validarNombreApellido(String texto) {
        return texto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$");
    }

    
    private boolean validarContraseña(String contraseña) {

        
        if (contraseña.contains(" ")) {
            return false;
        }

        
        if (contraseña.length() < 8) {
            return false;
        }

        
        int cantidadNumeros = 0;

        for (char c : contraseña.toCharArray()) {
            if (Character.isDigit(c)) {
                cantidadNumeros++;
            }
        }

        return cantidadNumeros >= 2;
    }
}