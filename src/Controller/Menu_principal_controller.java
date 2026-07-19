/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Login_view;
import View.Menu_principal_view;
import View.Registro_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juans
 */
public class Menu_principal_controller implements ActionListener{
    
    private ViewPrincipal vistaP;
    private Login_view login;
    private Registro_view registro;
    private Menu_principal_view vista;

    public Menu_principal_controller(ViewPrincipal vistaP, Login_view login, Registro_view registro,Menu_principal_view vista) {
        this.vistaP = vistaP;
        this.login = login;
        this.registro = registro;
        this.vista = vista;
        vista.b1.addActionListener(this);
        vista.b2.addActionListener(this);
        vista.btnVolver.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.b1) {
            vista.dispose();
            login.txContraseña.setText("");
            login.txCorreo.setText("");
            login.setVisible(true);
            login.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
        if (e.getSource() == vista.b2) {
            vista.dispose();
            registro.txNombre.setText("");
            registro.txApellido.setText("");
            registro.txCorreo.setText("");
            registro.txContraseña.setText("");
            registro.txConfirmar.setText("");
            registro.setVisible(true);
            registro.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
        if (e.getSource() == vista.btnVolver) {
            vista.dispose();
            vistaP.setVisible(true);
            registro.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
    
    
    
}
