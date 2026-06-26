/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Ticket_dao {
    Conexion conectar = Conexion.getObject();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;
    
    public int getTotalVuelos(Usuario usuario){
        int r = 0;
        String sql = "SELECT COUNT(*) AS total_vuelos FROM Tickets JOIN Reservas ON Tickets.id_reserva = Reservas.id JOIN Asientos ON Reservas.id_asiento = Asientos.id WHERE Tickets.id_pasajero = ?";
        try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        
        if(rs.next())
            r = rs.getInt(1);
            

           
                
                 } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "error en la confirmacion del ticket", e.toString(), JOptionPane.ERROR_MESSAGE);
            
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                    rs.close();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
           return r;
    }
    
    
    public List getTotalVuelos(int total,Usuario usuario){
        
        List<Ticket> ticket = new ArrayList<Ticket>();
        
        int cont = 1;
        
        String sql = "SELECT t.codigo_ticket AS id_ticket, v.origen AS origen, v.destino AS destino FROM Tickets t JOIN Reservas r ON t.id_reserva = r.id JOIN Vuelos v ON r.codigo_vuelo = v.codigo_vuelo WHERE t.id_pasajero = ?";
        try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        
        
        Ticket ticket_res = new Ticket();
        while(rs.next()){
            for(int i = 0; i < total; i++){
            ticket_res.setTicket(rs.getInt("id_ticket"));
            ticket_res.setOrigen_ida(rs.getString("origen"));
            ticket_res.setDestino_ida(rs.getString("destino"));
            ticket_res.setTipo_vuelo(rs.getString("tipo_vuelo"));
            ticket.add(ticket_res);
        }
        
            
            
            
        }
                
                 } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "error en la confirmacion del ticket", e.toString(), JOptionPane.ERROR_MESSAGE);
            
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                    rs.close();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
           return ticket;
    }
         
    
    
   
}


