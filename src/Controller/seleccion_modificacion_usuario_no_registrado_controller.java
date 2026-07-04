/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Seleccion_vuelo_usuario_no_registrado_dao;
import Model.Ticket;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_de_vuelo_usuarioNoregistrado_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class seleccion_modificacion_usuario_no_registrado_controller implements ActionListener {
    private ViewPrincipal vista_principal;
    private Seleccion_de_vuelo_usuarioNoregistrado_view vista;
    private Seleccion_de_Modificacion_de_vuelo_view vista2;
    private Seleccion_vuelo_usuario_no_registrado_dao dao;
    private Ticket ticket;


    public seleccion_modificacion_usuario_no_registrado_controller(Seleccion_vuelo_usuario_no_registrado_dao dao, Seleccion_de_vuelo_usuarioNoregistrado_view vista, Seleccion_de_Modificacion_de_vuelo_view vista2, Modificacion_clase_equipaje_controller controlador_equipaje,Ticket ticket,ViewPrincipal principal) {
        this.vista = vista;
        this.vista2 = vista2;
        this.dao = dao;
        this.ticket = ticket;
        this.vista_principal = principal;
        vista.continuar.addActionListener(this);
        vista.volver.addActionListener(this);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {
            vista.setVisible(false);
            
           vista_principal.setVisible(true);
           vista_principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        if (e.getSource() == vista.continuar) {

            String verify_correo = ".+@gmail\\.com$";

            if (!vista.Codigo_ticket.getText().isEmpty() || !vista.Nombre_usuario.getText().isEmpty() || !vista.Numero_documento.getText().isEmpty() || !vista.Correo_electronico.getText().isEmpty()) {

                if (!vista.Codigo_ticket.getText().isEmpty()) {

                    if (vista.Codigo_ticket.getText().matches("\\d+")) {

                        if (!vista.Nombre_usuario.getText().isEmpty()) {

                            if (!vista.Numero_documento.getText().isEmpty()) {
                                if (vista.Numero_documento.getText().matches("^.{3,10}$")) {

                                    if (!vista.Correo_electronico.getText().isEmpty()) {
                                        if (vista.Correo_electronico.getText().matches(verify_correo)) {

                                            confirmacion();

                                        } else {
                                            JOptionPane.showMessageDialog(vista, "El campo de correo electronico debe teneder @gmail.com al final, y texto al principio");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(vista, "El campo de correo electronico no puede estar vacio");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(vista, "El campo de documento debe tener minimo 3 caracteres y maximo 10");
                                }
                            } else {
                                JOptionPane.showMessageDialog(vista, "El campo de documento no puede estar vacio");
                            }

                        } else {
                            JOptionPane.showMessageDialog(vista, "El campo de nombre no puede estar vacio");
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "El campo del codigo de ticket solo puede contener numeros");
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "El campo del ticket no puede estar vacio");
                }

            } else {
                JOptionPane.showMessageDialog(vista, "Los campos obligatorios no pueden estar vacios");
            }

        }

    }

    public void confirmacion() {
        int ticket = Integer.parseInt(vista.Codigo_ticket.getText());
        String nombre = vista.Nombre_usuario.getText();
        String documento = vista.Numero_documento.getText();
        String correo = vista.Correo_electronico.getText();

        try {

            int uno = dao.confir_ticket(ticket);
            int dos = dao.confir_nombre(nombre);
            int tres = dao.confir_documento(documento);
            int cuatro = dao.confir_correo(correo);
            int definitivo = dao.confir_ejecucion(ticket, nombre, documento, correo);

            if (uno != 1) {

                JOptionPane.showMessageDialog(vista, "El codigo de ticket no esta registrado en el sistema");
            }

            if (dos != 1) {
                JOptionPane.showMessageDialog(vista, "El nombre no esta registrado en el sistema");
            }

            if (tres != 1) {
                JOptionPane.showMessageDialog(vista, "El documento no esta registrado en el sistema");
            }

            if (cuatro != 1) {
                JOptionPane.showMessageDialog(vista, "el correo electronico no esta registrado en el sistema");
            }
            if (definitivo == 1) {
                this.ticket.setId(ticket);
                vista.setVisible(false);
                vista2.setVisible(true);
                vista2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                JOptionPane.showMessageDialog(vista, "Los datos ingresados no coinciden");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, ex.toString());
        } catch (Exception ex) {
            System.getLogger(seleccion_modificacion_usuario_no_registrado_controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    

    


}
