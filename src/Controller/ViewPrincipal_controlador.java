/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import Model.UsuarioDao;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ViewPrincipal_controlador implements ActionListener{
    ViewPrincipal vista;
    Usuario usuario;
    Ticket ticket;
    Seleccion_de_vuelo_usuarioRegistrado_view s;
    UsuarioDao usuD = new UsuarioDao();
    Ticket_dao tdao = new Ticket_dao();
    
    public ViewPrincipal_controlador(ViewPrincipal vista,Usuario usuario, Ticket ticket, Seleccion_de_vuelo_usuarioRegistrado_view s){
    this.vista = vista;
    this.ticket = ticket;
    this.usuario = usuario;
    this.s = s;
    
    vista.clase.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.clase){
            
            
            setTickets();
            
            
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             s.setVisible(true);
                s.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
            
        
        }
    }
    
    public void setTickets(){
    
        int tickets = tdao.getTotalVuelos(usuario);
            
            
            
    List<Ticket> tick = tdao.getTotalVuelosList(tickets, usuario);  

    s.setTicketInfo(tick);
    s.SetVuelos(tickets);
    
    ;
            
    }
 }
