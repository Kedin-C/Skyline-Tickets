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
            
            
            if(getCant_t() > 0){
                setTickets();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                s.setVisible(true);
                s.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else{
                JOptionPane.showMessageDialog(vista,"No tienes vuelos activos disponibles");
            }
            
                
        
            
        
        }
    }
    
    public void setTickets(){
    
        int tickets = tdao.getTotalVuelos(usuario);
            
            
            
    List<Ticket> tick = tdao.getTotalVuelosList(usuario);  

    s.setTicketInfo(tick);
    s.SetVuelos(tickets);
            
    }
    
    public int getCant_t(){
        
        JOptionPane.showMessageDialog(vista,tdao.getTotalVuelos(usuario));
        return tdao.getTotalVuelos(usuario);
    }
    
    public Ticket getTicket_select(int v){
    
         int cod = 0;
         int tickets = tdao.getTotalVuelos(usuario);
         List<Ticket> tick = tdao.getTotalVuelosList(usuario);  
         
         if(v <= tickets && v >= 0){
             ticket.setId(tick.get(v).getId());
             ticket.setDestino(tick.get(v).getDestino());
             ticket.setOrigen(tick.get(v).getOrigen());
             ticket.setTipo_vuelo(tick.get(v).getTipo_vuelo());
         }
         
         return this.ticket;
         
    }
    
    
 }
