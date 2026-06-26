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
 * @author david
 */
public class Seleccion_equipaje_extra_dao {
    Conexion conectar = Conexion.getObject();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;
    
    
    public int ClaseDeVueloActual(int var) {
        int r = 0;

        String sql = "SELECT a.codigo_clase FROM Tickets t JOIN Reservas r ON t.id_reserva = r.id JOIN Asientos a ON r.id_asiento = a.id WHERE t.codigo_ticket = ?";
        try {
            

            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, var);
            rs = ps.executeQuery();
            
            
            
            if(rs.next())
            r = rs.getInt(1);
            

           return r;
            

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "error en la confirmacion del ticket", e.toString(), JOptionPane.ERROR_MESSAGE);
            return 0;
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
    }
}
