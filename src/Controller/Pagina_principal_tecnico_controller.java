/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Buscar_vuelos_view;
import View.Historial_vuelos_view;
import View.Inspeccion_vuelos_view;
import View.Pagina_principal_tecnico_view;
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
public class Pagina_principal_tecnico_controller implements ActionListener{
    
    public Pagina_principal_tecnico_view vista;
    public Seleccion_de_vuelo_usuarioRegistrado_view vistaCL;
    public Buscar_vuelos_view vistaCV;
    public ViewPrincipal vista_prin;
    private Ticket ticket;
    private Usuario usuario;
    private Ticket_dao tdao = new Ticket_dao();
    private Historial_vuelos_view histo_vista;
    private Historial_vuelos_controller histo_cont;
    private Inspeccion_vuelos_view inspec;
    private Inspeccion_vuelos_controller inspec_cont;

    public Pagina_principal_tecnico_controller(Pagina_principal_tecnico_view vista, Seleccion_de_vuelo_usuarioRegistrado_view vistaCL,Buscar_vuelos_view vistaCV,Ticket ticket,Usuario usu,Historial_vuelos_view histo_vista,Historial_vuelos_controller histo_cont,Inspeccion_vuelos_view inspec,Inspeccion_vuelos_controller inspec_cont) {
        this.vista = vista;
        this.vistaCL = vistaCL;
        this.vistaCV=vistaCV;
        this.histo_vista = histo_vista;
        this.histo_cont = histo_cont;
        this.inspec = inspec;
        this.inspec_cont = inspec_cont;
       
        this.vista.comprar.addActionListener(this);
        this.vista.clase.addActionListener(this);
        this.vista.cerrarSesion.addActionListener(this);
        this.vista.historial.addActionListener(this);
        this.vista.inspeccion.addActionListener(this);
        
        this.ticket = ticket;
        this.usuario = usu;
        
//        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.inspeccion){
            vista.setVisible(false);
            inspec_cont.cargarTabla();
            inspec.setVisible(true);
            inspec.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
            usuario.limpiar();
            vista.setVisible(false);
            vista_prin.setVisible(true);
            vista_prin.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else if(e.getSource() == vista.historial){
            histo_cont.ResetRow();
            histo_cont.SetRow();
            
            
            if(getCant_t() > 0){
            vista.setVisible(false);
            histo_vista.setVista_anterior(2);
            histo_vista.setVisible(true);
            histo_vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else{
                JOptionPane.showMessageDialog(vista, "No has comprado ningun vuelo desde que creaste la cuenta");
            }
        }
    }
    
    public void setTickets(){
    
    int tickets = tdao.getTotalVuelos(usuario);
              
    List<Ticket> tick = tdao.getTotalVuelosList(usuario);  

    vistaCL.setTicketInfo(tick);
    vistaCL.Limpiar_Vuelos();
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
             ticket.setId_pasajero(tdao.obtenerIdPasajero(usuario.getDocumento(), tick.get(v).getId()));
         }
         
         
         
    }
    
    
    
}
