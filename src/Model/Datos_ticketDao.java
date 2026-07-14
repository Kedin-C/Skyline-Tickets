/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class Datos_ticketDao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

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
    
}
