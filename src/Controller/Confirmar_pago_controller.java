/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import View.Confirmar_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author juans
 */
public class Confirmar_pago_controller implements ActionListener{
    
    public Confirmar_pago_view view;
    public ViewPrincipal viewPrin;
    public Pagina_principal_administrador_view viewAdmin;
    public Inicio_usuario_view viewUsu;
    public Usuario usu;

    public Confirmar_pago_controller(Confirmar_pago_view view, ViewPrincipal viewPrin, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsu,Usuario usu) {
        this.view = view;
        this.viewPrin = viewPrin;
        this.viewAdmin = viewAdmin;
        this.viewUsu = viewUsu;
        this.usu = usu;
        this.view.volver.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.volver){
            
//            view.setVisible(false);
//            viewPrin.setVisible(true);
//            viewPrin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            if(usu.getRol() == 1){
                view.setVisible(false);
                viewAdmin.setVisible(true);
                viewAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(usu.getRol() == 2){
                view.setVisible(false);
                viewUsu.setVisible(true);
                viewUsu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else{
                view.setVisible(false);
                viewPrin.setVisible(true);
                viewPrin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }

    
}
