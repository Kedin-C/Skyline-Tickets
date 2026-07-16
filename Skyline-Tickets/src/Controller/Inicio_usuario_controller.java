/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Sesion_usuario;
import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Buscar_vuelos_view;
import View.Informacion_personal_view;
import View.Inicio_usuario_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class Inicio_usuario_controller implements ActionListener {

    public Inicio_usuario_view vista;
    public Seleccion_de_vuelo_usuarioRegistrado_view vistaCL;
    public Buscar_vuelos_view vistaCV;
    public Informacion_personal_view vistaIP;
    private Ticket ticket;
    private Usuario usuario;
    private Ticket_dao tdao = new Ticket_dao();
    private Informacion_personal_controller info_per_cont;
    

    public Inicio_usuario_controller(Inicio_usuario_view vista, Seleccion_de_vuelo_usuarioRegistrado_view vistaCL, Buscar_vuelos_view vistaCV, Informacion_personal_view vistaIP, Ticket ticket, Usuario usu,Informacion_personal_controller info_per_cont,Sesion_usuario sesion_usu) {
        this.vista = vista;
        this.vistaCL = vistaCL;
        this.vistaCV = vistaCV;
        this.vistaIP = vistaIP;
        this.info_per_cont = info_per_cont;
        

        this.ticket = ticket;
        this.usuario = usu;

        this.vista.inicio.addActionListener(this);
        this.vista.comprar.addActionListener(this);
        this.vista.clase.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.inicio) {
            
            
            setTickets();
            vista.setVisible(false);
            info_per_cont.cargarDatosEnVista();
            info_per_cont.agregarEventos();
            vistaIP.setVisible(true);
            vistaIP.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            
        } else if (e.getSource() == vista.comprar) {
            vista.setVisible(false);

            vistaCV.setVisible(true);
            vistaCV.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            vistaCV.setPagina_anterior(2);
        } else if (e.getSource() == vista.clase) {

            if (getCant_t() > 0) {
                setTickets();
                vista.setVisible(false);

                vistaCL.setVisible(true);
                vistaCL.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            } else {
                JOptionPane.showMessageDialog(vista, "No tienes vuelos activos disponibles");
            }

        } 
        
    }

    public void setTickets() {

        int tickets = tdao.getTotalVuelos(usuario);

        List<Ticket> tick = tdao.getTotalVuelosList(usuario);

        vistaCL.setTicketInfo(tick);
        vistaCL.SetVuelos(tickets);

    }

    public int getCant_t() {

        return tdao.getTotalVuelos(usuario);
    }

    public void getTicket_select(int v) {

        int cod = 0;
        int tickets = tdao.getTotalVuelos(usuario);
        List<Ticket> tick = tdao.getTotalVuelosList(usuario);

        if (v <= tickets && v >= 0) {
            ticket.setId(tick.get(v).getId());
            ticket.setDestino(tick.get(v).getDestino());
            ticket.setOrigen(tick.get(v).getOrigen());
            ticket.setTipo_vuelo(tick.get(v).getTipo_vuelo());
        }

    }

}
