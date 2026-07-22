/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Seleccion_forma_de_pago_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Seleccion_modificacion_vuelo_usuario_controlador implements ActionListener {

    Seleccion_de_vuelo_usuarioRegistrado_view vista;
    Pagina_principal_administrador_view admin_view;
    Pagina_principal_administrador_controller_2 admin_view_cont;
    Inicio_usuario_view usuario_view;
    Inicio_usuario_controller usuario_view_cont;
    Seleccion_de_Modificacion_de_vuelo_view select_modificacion;
    Ticket_dao dao = new Ticket_dao();
    Ticket ticket;
    Usuario usua;
    Usuario usu = new Usuario();

    public Seleccion_modificacion_vuelo_usuario_controlador(Seleccion_de_vuelo_usuarioRegistrado_view vista, Usuario usu, Ticket ticket, Pagina_principal_administrador_view admin_view, Pagina_principal_administrador_controller_2 admin_view_cont, Inicio_usuario_view usuario_view, Inicio_usuario_controller usuario_view_cont, Seleccion_de_Modificacion_de_vuelo_view select_modificacion) {
        this.vista = vista;
        this.usua = usu;
        this.ticket = ticket;
        this.admin_view = admin_view;
        this.admin_view_cont = admin_view_cont;
        this.usuario_view = usuario_view;
        this.usuario_view_cont = usuario_view_cont;
        this.select_modificacion = select_modificacion;

        this.vista.SetVuelos(dao.getTotalVuelos(usu));
        this.vista.select1.addActionListener(this);
        this.vista.select2.addActionListener(this);
        this.vista.select3.addActionListener(this);
        this.vista.select4.addActionListener(this);
        this.vista.select5.addActionListener(this);
        this.vista.volver.addActionListener(this);
        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.select1) {
            select_modificacion.setVista_anterior(2);
            if (vista.getPagina_anterior() == 1) {
                usuario_view_cont.getTicket_select(0);
         
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);

            } else {
                admin_view_cont.getTicket_select(0);

                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);

            }
        }

        if (e.getSource() == vista.select2) {
            select_modificacion.setVista_anterior(2);

            if (vista.getPagina_anterior() == 1) {
                usuario_view_cont.getTicket_select(1);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                admin_view_cont.getTicket_select(1);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
        if (e.getSource() == vista.select3) {
            select_modificacion.setVista_anterior(2);

            if (vista.getPagina_anterior() == 1) {
                usuario_view_cont.getTicket_select(2);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                admin_view_cont.getTicket_select(2);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
        if (e.getSource() == vista.select4) {
            select_modificacion.setVista_anterior(2);

            if (vista.getPagina_anterior() == 1) {
                usuario_view_cont.getTicket_select(3);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                admin_view_cont.getTicket_select(3);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
        if (e.getSource() == vista.select5) {
            select_modificacion.setVista_anterior(2);

            if (vista.getPagina_anterior() == 1) {
                usuario_view_cont.getTicket_select(4);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                admin_view_cont.getTicket_select(4);
                vista.setVisible(false);

                select_modificacion.setVisible(true);
                select_modificacion.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }

        if (e.getSource() == vista.volver) {

            if (vista.getPagina_anterior() == 1) {

                vista.setVisible(false);

                admin_view.setVisible(true);
                admin_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                vista.setVisible(false);

                usuario_view.setVisible(true);
                usuario_view.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }

}
