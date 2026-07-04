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
import Model.Sesion_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.Inicio_usuario_view;
import View.Login_view;
import View.Menu_principal_view;
//import view.Pagina_principal_administrador_view;
import View.Recuperar_contraseña_view;
import View.ViewPrincipal;


public class Login_controller implements ActionListener {
    private Login_view vista;
    private UsuarioDao dao;
    private ViewPrincipal prin;
    Usuario usu;
    
    public Login_controller(Login_view vista,ViewPrincipal principal,Usuario usuario) {
        this.vista = vista;
        this.dao = new UsuarioDao();
        this.prin = principal;
        this.usu = usuario;
        vista.getB1().addActionListener(this);
        vista.getB2().addActionListener(this);
        vista.getBtnVolver().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getB1()) {
            String correo = vista.getTxCorreo().getText();
            String contraseña = vista.getTxContraseña().getText();
            Usuario usuario = dao.iniciarSesion(
                    correo,
                    contraseña);
            if(usuario != null) {

                
                Sesion_usuario.setUsuario(usuario);

                JOptionPane.showMessageDialog(
                        null,
                        "Bienvenido " + usuario.getNombre());
                if(usuario.getRol().equals("ADMINISTRADOR")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como administrador");
                    // Abrir MenuAdministradorView
                    
//                     Pagina_principal_administrador_view vistaInicioad = new Pagina_principal_administrador_view();
//                     vistaInicioad.setLocationRelativeTo(null);
//                     vistaInicioad.setVisible(true);
                     vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como usuario");
                     Inicio_usuario_view vistaInicio = new Inicio_usuario_view();
                     vistaInicio.setLocationRelativeTo(null);
                     vistaInicio.setVisible(true);
                     vista.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Correo o contraseña incorrectos");
            }
        }
    
        if(e.getSource() == vista.getB2()) {
            
        Recuperar_contraseña_view recuperarView = new Recuperar_contraseña_view();
        new Recuperar_contraseña_controller(recuperarView);
        recuperarView.setLocationRelativeTo(null);
        recuperarView.setVisible(true);
        vista.dispose();
        }
        
        
        if(e.getSource() == vista.getBtnVolver()) {
        ViewPrincipal vp = new ViewPrincipal();
        Menu_principal_view MenuView = new Menu_principal_view(vp);
        MenuView.setLocationRelativeTo(null);
        
        vista.dispose();
        }
        }
    }

