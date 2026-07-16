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
import View.Pagina_principal_administrador_view;
//import view.Pagina_principal_administrador_view;
import View.Recuperar_contraseña_view;
import View.Registro_view;
import View.ViewPrincipal;
import javax.swing.JFrame;


public class Login_controller implements ActionListener {
    private Login_view vista;
    private UsuarioDao dao;
    private ViewPrincipal prin;
    private Pagina_principal_administrador_view vista_admin;
    private Inicio_usuario_view vista_usuario;
    private Menu_principal_view menu;
    private Registro_view registro;
    private Usuario usu;
    private Sesion_usuario sesion_usu;
    
    
    public Login_controller(Login_view vista,ViewPrincipal principal,Usuario usuario,Registro_view registro,Pagina_principal_administrador_view vista_admin,Inicio_usuario_view vista_usuario, Sesion_usuario sesion_usu) {
        this.vista = vista;
        this.vista_admin = vista_admin;
        this.vista_usuario = vista_usuario;
        this.dao = new UsuarioDao();
        this.prin = principal;
        this.usu = usuario;
        this.registro = registro;
        this.menu = new Menu_principal_view(this.prin,this.vista,this.registro);
        this.sesion_usu = sesion_usu;
        
        this.vista.getB1().addActionListener(this);
        this.vista.getB2().addActionListener(this);
        this.vista.getBtnVolver().addActionListener(this);
        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.vista.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getB1()) {
            String correo = vista.getTxCorreo().getText();
            String contraseña = vista.getTxContraseña().getText();
            
            Usuario usuario = dao.iniciarSesion(
                    correo,
                    contraseña);
            
            sesion_usu.setUsuario(usuario);
            
            if(usu != null) {
                
                usu.setApellido(usuario.getApellido());
                usu.setContraseña(usuario.getContraseña());
                usu.setCorreo(usuario.getCorreo());
                usu.setIdUsuario(usuario.getIdUsuario());
                usu.setNombre(usuario.getNombre());
                usu.setRol(usuario.getRol());
                usu.setDocumento(usuario.getDocumento());
                usu.setNumero_telefono(usuario.getNumero_telefono());
                usu.setCodigo_tipo_documento(usuario.getCodigo_tipo_documento());
                usu.setFecha_nacimiento(usuario.getFecha_nacimiento());
                usu.setSexo(usuario.getSexo());
                usu.setNationalidad(usuario.getNationalidad());
                usu.setNumero_telefono(usuario.getNumero_telefono());
                
                
                this.sesion_usu.setUsuario(usu);
                
  

                JOptionPane.showMessageDialog(
                        null,
                        "Bienvenido " + usu.getNombre());
                if(usu.getRol().equals("ADMINISTRADOR")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como administrador");
                    // Abrir MenuAdministradorView
                    
                     
                     
                     vista_admin.setVisible(true);
                     vista.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingreso como usuario");
                     
                     
                     vista_usuario.setVisible(true);
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
  
        vista.dispose();
        
        menu.setVisible(true);
        }
        }
    }

