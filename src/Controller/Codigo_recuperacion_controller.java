/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author Nikob
 */

import model.UsuarioDao;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Codigo_recuperacion_view;
import view.Nueva_contraseña_view;

public class Codigo_recuperacion_controller {

    private UsuarioDao usuarioDao;
    private String codigoGenerado;
    private String correoRecuperacion;
    private Codigo_recuperacion_view view;

    
    public Codigo_recuperacion_controller() {
        usuarioDao = new UsuarioDao();
    }

    
    public Codigo_recuperacion_controller(Codigo_recuperacion_view view) {
        this.view = view;
        usuarioDao = new UsuarioDao();
        iniciarEventos();
    }

    
    public Codigo_recuperacion_controller(Codigo_recuperacion_view view, String codigoYaGenerado, String correo) {
        this.view = view;
        this.codigoGenerado = codigoYaGenerado;
        this.correoRecuperacion = correo;
        usuarioDao = new UsuarioDao();
        iniciarEventos();
    }

    
    public boolean procesarSolicitudRecuperacion(String correo) {
        Usuario usuario = usuarioDao.buscarPorCorreo(correo);
        if (usuario == null) {
            return false;
        }
        correoRecuperacion = correo;
        generarCodigo();
        return true;
    }

    
    private void generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        this.codigoGenerado = codigo.toString(); 

        Correo_controller correo = new Correo_controller();
        correo.enviarCodigoRecuperacion(
            getCorreoRecuperacion(),
            getCodigoGenerado()
        );
    }

    
    public boolean validarCodigo(String codigoIngresado) {
        if (codigoGenerado == null) return false;
        System.out.println("CODIGO GENERADO: " + codigoGenerado);
        System.out.println("CODIGO INGRESADO: " + codigoIngresado);
        return codigoGenerado.equals(codigoIngresado.trim());
    }

    
    private void iniciarEventos() {
        view.getB1().addActionListener(e -> {
            String codigoIngresado = view.getTxCodigo().getText().trim();
            if (validarCodigo(codigoIngresado)) {
                Nueva_contraseña_view nuevaView = new Nueva_contraseña_view();
                new Nueva_contraseña_controller(nuevaView, correoRecuperacion);
                nuevaView.setLocationRelativeTo(null);
                nuevaView.setVisible(true);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Código incorrecto");
            }
        });
    }

    
    public String getCodigoGenerado() {
        return codigoGenerado;
    }

    public String getCorreoRecuperacion() {
        return correoRecuperacion;
    }
}


    
           
