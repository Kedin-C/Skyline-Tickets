/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class Seleccion_modificacion_vuelo_usuario_controlador implements ActionListener{
    
    Seleccion_de_vuelo_usuarioRegistrado_view vista = new Seleccion_de_vuelo_usuarioRegistrado_view();
    ViewPrincipal_controlador vista_print_cont;
    ViewPrincipal vista_print;
    Ticket_dao dao = new Ticket_dao();
    Ticket ticket;
    Usuario usua;
    Usuario usu = new Usuario();
    
    
    public Seleccion_modificacion_vuelo_usuario_controlador(Seleccion_de_vuelo_usuarioRegistrado_view vista, Usuario usu, Ticket ticket, ViewPrincipal vista_print, ViewPrincipal_controlador vista_print_cont) {
        this.vista = vista;
        this.usua = usu;
        this.ticket = ticket;
        this.vista_print = vista_print;
        this.vista_print_cont = vista_print_cont;
        
    vista.SetVuelos(dao.getTotalVuelos(usu));
    vista.select1.addActionListener(this);
    vista.select2.addActionListener(this);
    vista.select3.addActionListener(this);
    vista.select4.addActionListener(this);
    vista.select5.addActionListener(this);
    vista.volver.addActionListener(this);
    vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.select1){    
           vista_print_cont.getTicket_select(0);
           JOptionPane.showMessageDialog(vista,ticket.toString());
        }
        if(e.getSource() == vista.select2){    
           vista_print_cont.getTicket_select(1);
           JOptionPane.showMessageDialog(vista,ticket.toString());
        }
        if(e.getSource() == vista.select3){    
           vista_print_cont.getTicket_select(2);
           JOptionPane.showMessageDialog(vista,ticket.toString());
        }
        if(e.getSource() == vista.select4){    
           vista_print_cont.getTicket_select(3);
           JOptionPane.showMessageDialog(vista,ticket.toString());
        }
        if(e.getSource() == vista.select5){    
           vista_print_cont.getTicket_select(4);
           JOptionPane.showMessageDialog(vista,ticket.toString());
        }
        
        if(e.getSource() == vista.volver){
            vista.setVisible(false);
            
            vista_print.setVisible(true);
            vista_print.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

}
