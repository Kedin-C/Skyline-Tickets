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
        String sql = "SELECT COUNT(*) AS total_vuelos FROM usuario JOIN Datos_pasajero ON usuario.numero_documento = Datos_pasajero.numero_documento JOIN Tickets ON Tickets.id_pasajero = Datos_pasajero.id JOIN Reservas ON Tickets.id_reserva = Reservas.id WHERE usuario.numero_documento = ?";
        try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getDocumento());
        rs = ps.executeQuery();
        
        if(rs.next())
            r = rs.getInt(1);
        
        } 
        catch (Exception e) {
            
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
    
    
    public List getTotalVuelosList(Usuario usuario){
        
        List<Ticket> ticket = new ArrayList<Ticket>();
        
        int cont = 1;
        
        String sql = "SELECT t.codigo_ticket AS id_ticket, t.tipo_vuelo, v.origen AS origen, v.destino AS destino, v.fecha AS fecha_vuelo FROM Tickets t JOIN Reservas r ON t.id_reserva = r.id JOIN Vuelos v ON r.codigo_vuelo = v.codigo_vuelo JOIN Datos_pasajero dp ON t.id_pasajero = dp.id JOIN usuario u ON u.numero_documento = dp.numero_documento WHERE u.id_usuario = ?";
        try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        
        rs = ps.executeQuery();
        
        
        while(rs.next()){
            Ticket ticket_res = new Ticket();
            
            ticket_res.setId(rs.getInt("id_ticket"));
            ticket_res.setOrigen(rs.getString("origen"));
            ticket_res.setDestino(rs.getString("destino"));
            ticket_res.setTipo_vuelo(rs.getString("tipo_vuelo"));
            ticket_res.setFecha(rs.getString("fecha_vuelo"));
            ticket.add(ticket_res);
            
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
    
     public List getVuelosHistorial(Usuario usuario){
        
        List<Ticket> ticket = new ArrayList<Ticket>();
        
        int cont = 1;
        
        String sql = "SELECT t.codigo_ticket AS id_ticket, v.origen AS origen, v.destino AS destino, t.tipo_vuelo FROM Tickets t JOIN Reservas r ON t.id_reserva = r.id JOIN Vuelos v ON r.codigo_vuelo = v.codigo_vuelo JOIN Datos_pasajero dp ON t.id_pasajero = dp.id JOIN usuario u ON u.numero_documento = dp.numero_documento WHERE u.id_usuario = ?";
        try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        
        rs = ps.executeQuery();
        
        
        while(rs.next()){
            Ticket ticket_res = new Ticket();
            
            ticket_res.setId(rs.getInt("id_ticket"));
            ticket_res.setOrigen(rs.getString("origen"));
            ticket_res.setDestino(rs.getString("destino"));
            ticket_res.setTipo_vuelo(rs.getString("tipo_vuelo"));
            ticket.add(ticket_res);
            
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
    
    
    public String obtenerNombrePasajero(int idPasajero) {
        String nombre = null;
        String sql = "SELECT nombre, apellido FROM datos_pasajero WHERE id = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre") + " " + rs.getString("apellido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }
    
    public int obtenerCodTicket(int idPasajero) {
        int ticket = 0;
        String sql = "SELECT codigo_ticket FROM tickets WHERE id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                ticket = rs.getInt("codigo_ticket");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return ticket;
    }


    public String obtenerDocumento(int idPasajero) {
        String documento = null;
        String sql = "SELECT numero_documento FROM datos_pasajero WHERE id = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                documento = rs.getString("numero_documento");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return documento;
    }

    public String obtenerCorreoPasajero(int idPasajero) {
        String correo = null;
        String sql = "SELECT correo FROM datos_pasajero WHERE id = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                correo = rs.getString("correo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return correo;
    }

    public String obtenerCodigoVuelo(int idPasajero) {
        String vuelo = null;
        String sql = "SELECT v.codigo_vuelo " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "JOIN vuelos v ON r.codigo_vuelo = v.codigo_vuelo " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                vuelo = rs.getString("codigo_vuelo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return vuelo;
    }

    public String obtenerOrigen(int idPasajero) {
        String origen = null;
        String sql = "SELECT v.origen " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "JOIN vuelos v ON r.codigo_vuelo = v.codigo_vuelo " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                origen = rs.getString("origen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return origen;
    }

    public String obtenerDestino(int idPasajero) {
        String destino = null;
        String sql = "SELECT v.destino " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "JOIN vuelos v ON r.codigo_vuelo = v.codigo_vuelo " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                destino = rs.getString("destino");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return destino;
    }

    public String obtenerFechaVuelo(int idPasajero) {
        String fecha = null;
        String sql = "SELECT v.fecha " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "JOIN vuelos v ON r.codigo_vuelo = v.codigo_vuelo " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                fecha = rs.getString("fecha");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    public String obtenerAsiento(int idPasajero) {
        String asiento = null;
        String sql = "SELECT r.codigo_asiento " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                asiento = rs.getString("codigo_asiento");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return asiento;
    }

    public double obtenerCosto(int idPasajero) {
        double costo = 0.0;
        String sql = "SELECT v.precio " +
                     "FROM tickets t " +
                     "JOIN reservas r ON t.id_reserva = r.id " +
                     "JOIN vuelos v ON r.codigo_vuelo = v.codigo_vuelo " +
                     "WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                costo = rs.getDouble("precio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return costo;
    }

    public String obtenerCodigoReserva(int idPasajero) {
        String reserva = null;
        String sql = "SELECT t.id_reserva FROM tickets t WHERE t.id_pasajero = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPasajero);
            rs = ps.executeQuery();
            if (rs.next()) {
                reserva = rs.getString("id_reserva");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return reserva;
    }
         
    public void enviarDatos(int id_pago, int id_pasajero, int id_reserva, int equipaje_extra, String tipo_vuelo){
        
        String sql = "INSERT INTO tickets (id_pago, id_pasajero, id_reserva, equipaje_extra, tipo_vuelo)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        try{
            con = Conexion.getObject().getConection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id_pago);
            ps.setInt(2, id_pasajero);
            ps.setInt(3, id_reserva);
            ps.setInt(4, equipaje_extra);
            ps.setString(5, tipo_vuelo);
            
            ps.executeUpdate();
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pasajero"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        
    }
    
    public void enviarDatost(int id_pasajero, int id_reserva, int equipaje_extra, String tipo_vuelo){
        
        String sql = "INSERT INTO tickets (id_pasajero, id_reserva, equipaje_extra, tipo_vuelo)"
                + "VALUES (?, ?, ?, ?)";
        
        try{
            con = Conexion.getObject().getConection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id_pasajero);
            ps.setInt(2, id_reserva);
            ps.setInt(3, equipaje_extra);
            ps.setString(4, tipo_vuelo);
            
            ps.executeUpdate();
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pasajero"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        
    }
    
   private int equipajeExtra(int id){
       
       int equipaje = 0;
       
       String sql = "SELECT equipaje_extra FROM tickets WHERE codigo_ticket = ?";
       
       try{
           con = Conexion.getObject().getConection();
           
           ps = con.prepareStatement(sql);
           
           ps.setInt(1, id);
           
           rs = ps.executeQuery();
           
           if(rs.next()){
               equipaje = rs.getInt("equipaje_extra");
           }
           
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pasajero"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
   
       return equipaje;
       
   }
   
   
   public void modificarEquipaje(int id, int equipaje){
       
       int nuevoEquipaje = equipajeExtra(id) + equipaje;
       
       String sql = "UPDATE tickets SET equipaje_extra = ? WHERE codigo_ticket = ?";
       
       try{
           
           con = Conexion.getObject().getConection();
           
           ps = con.prepareStatement(sql);
           
           ps.setInt(1, nuevoEquipaje);
           ps.setInt(2, id);
           
           ps.executeUpdate();
       
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pasajero"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
   }
   
   public int codigoReserva(int id_ticket){
        int reserva = 0;
        String sql = "SELECT id_reserva FROM tickets WHERE codigo_ticket = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_ticket);
            rs = ps.executeQuery();
            if (rs.next()) {
                reserva = rs.getInt("id_reserva");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                "Error de consulta: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        return reserva;
    }
}


