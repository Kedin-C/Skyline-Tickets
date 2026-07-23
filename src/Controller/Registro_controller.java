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
import View.ViewPrincipal;
import javax.swing.JFrame;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Registro_controller implements ActionListener {

    private Registro_view vista;
    private UsuarioDao dao;
    private Codigo_descuento_controller codigoController;
    private Menu_principal_view menu;
    private Login_view login;

    public Registro_controller(Registro_view vista,Menu_principal_view menu,Login_view login) {
        this.vista = vista;
        this.dao = new UsuarioDao();
        this.login = login;        
        this.codigoController = new Codigo_descuento_controller();
        this.menu = menu;
        vista.getB1().addActionListener(this);
        vista.getBtnVolver().addActionListener(this);
        
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.getBtnVolver()) {
        menu.setVisible(true);
        vista.dispose();
        }
        
        if (e.getSource() == vista.getB1()) {

            String nombre = vista.getTxNombre().getText();
            String apellido = vista.getTxApellido().getText();
            String correo = vista.getTxCorreo().getText();
            String documento = vista.getNdocumento().getText();
            String contraseña = vista.getTxContraseña().getText();
            String confirmar = vista.getTxConfirmar().getText();
            
            
            if (!validarCorreo(correo)) {
                JOptionPane.showMessageDialog(
                null,
                "El correo no puede estar vacío, no debe contener espacios y debe tener un formato válido (ejemplo@dominio.com).");
                return;
            }
            
            if (dao.existeCorreo(correo)) {
                JOptionPane.showMessageDialog(
                null,
                "Este correo ya se encuentra registrado.");
                return;
            }       
            
            if (!validarDocumento(documento)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El número de documento debe contener solo números y tener entre 8 y 17 dígitos.");
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
            
            String hash = ContraseñaHash(contraseña);

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setDocumento(documento);
            usuario.setContraseña(hash);
            usuario.setRol(2);

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

                
                login.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
    
    private String ContraseñaHash(String contraseña){
        return BCrypt.withDefaults().hashToString(12, contraseña.toCharArray());
    }
}