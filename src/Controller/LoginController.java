/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author david
 */


import Model.Usuario;
import Model.UsuarioDao;
import View.LoginView;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class LoginController implements ActionListener {




    private LoginView vista;
    private UsuarioDao dao;
    private ViewPrincipal prin;

    public LoginController(LoginView vista,ViewPrincipal principal) {
        
        this.prin = principal;

        this.vista = vista;
        this.dao = new UsuarioDao();

        vista.getB1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == vista.getB1()) {
            

            String correo = vista.getTxCorreo().getText();
            String contraseña = vista.getTxContraseña().getText();
            Usuario usuario = dao.iniciarSesion(correo, contraseña);

            if(usuario != null) {

                JOptionPane.showMessageDialog(
                        null,
                        "Bienvenido " + usuario.getNombre());
                vista.setVisible(false);
                prin.setVisible(true);
                prin.setExtendedState(JFrame.MAXIMIZED_BOTH);

                if(usuario.getRol().equals("ADMINISTRADOR")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como administrador");

                    // Abrir MenuAdministradorView

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como usuario");

                    // Abrir MenuUsuarioView
                }

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Correo o contraseña incorrectos");
            }
        }
    
        
        }
    
    }

