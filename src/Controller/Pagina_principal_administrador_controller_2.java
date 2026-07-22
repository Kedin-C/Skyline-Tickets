/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Apartado_reportes_menu_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Buscar_vuelos_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class Pagina_principal_administrador_controller_2 implements ActionListener{
    
    public Pagina_principal_administrador_view vista;
    public Apartado_reportes_menu_view vistaRM;
    public Seleccion_de_vuelo_usuarioRegistrado_view vistaCL;
    public Buscar_vuelos_view vistaCV;
    public ViewPrincipal vista_prin;
    private Ticket ticket;
    private Usuario usuario;
    private Ticket_dao tdao = new Ticket_dao();

    public Pagina_principal_administrador_controller_2(Pagina_principal_administrador_view vista, Apartado_reportes_menu_view vistaRM, Seleccion_de_vuelo_usuarioRegistrado_view vistaCL,Buscar_vuelos_view vistaCV,Ticket ticket,Usuario usu,ViewPrincipal vista_prin) {
        this.vista = vista;
        this.vistaRM=vistaRM;
        this.vistaCL = vistaCL;
        this.vistaCV=vistaCV;
        this.vista_prin=vista_prin;
        
        
        this.vista.reportes.addActionListener(this);
        this.vista.comprar.addActionListener(this);
        this.vista.clase.addActionListener(this);
        this.vista.cerrarSesion.addActionListener(this);
        
        
        this.ticket = ticket;
        this.usuario = usu;
        
        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.reportes){
            vista.setVisible(false);
            
            vistaRM.setVisible(true);
            vistaRM.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.comprar){
            vista.setVisible(false);
            
            vistaCV.setVisible(true);
            vistaCV.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            vistaCV.setPagina_anterior(3);
        }else if(e.getSource() == vista.clase){
            
            if(getCant_t() > 0){
                setTickets();
                vista.setVisible(false);
            
            vistaCL.setVisible(true);
            vistaCL.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            }else{
                JOptionPane.showMessageDialog(vista,"No tienes vuelos activos disponibles");
            } 
        }else if(e.getSource() == vista.cerrarSesion){
            vista.setVisible(false);
            vista_prin.setVisible(true);
            vista_prin.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
    }
    
    public void setTickets(){
    
    int tickets = tdao.getTotalVuelos(usuario);
              
    List<Ticket> tick = tdao.getTotalVuelosList(usuario);  

    vistaCL.setTicketInfo(tick);
    vistaCL.SetVuelos(tickets);
            
    }
    
    public int getCant_t(){
        
        return tdao.getTotalVuelos(usuario);
    }
    
    public void getTicket_select(int v){
    
         int tickets = tdao.getTotalVuelos(usuario);
         List<Ticket> tick = tdao.getTotalVuelosList(usuario);  
         

         
         if(v <= tickets && v >= 0){
             ticket.setId(tick.get(v).getId());
             ticket.setDestino(tick.get(v).getDestino());
             ticket.setOrigen(tick.get(v).getOrigen());
             ticket.setTipo_vuelo(tick.get(v).getTipo_vuelo());
         }
         
         
         
    }
    
    
    
}
