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
public class Seleccion_vuelo_usuario_no_registrado_dao {

    Conexion conectar = Conexion.getObject();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;

    public int confir_ticket(int var) {
        int r = 0;

        String sql = "select Count(*) from tickets WHERE codigo_ticket = ?";
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

    public int confir_nombre(String nom) {
        int r = 0;
        String sql = " select Count(*) from datos_pasajero WHERE nombre = ? ";
        try {
            

            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1,nom );
            rs = ps.executeQuery();

            if(rs.next())
            r = rs.getInt(1);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la validacion del nombre", e.toString(), JOptionPane.ERROR_MESSAGE);
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        return r;
    }
    }

    public int confir_documento(String var){
        int r = 0;
        String sql = "select Count(*) from datos_pasajero WHERE numero_documento = ?";
        try {
            

            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, var);
            rs = ps.executeQuery();

           if(rs.next())
            r = rs.getInt(1);
           
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la validacion de los documento", e.toString(), JOptionPane.ERROR_MESSAGE);
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
        return r;
    }
    }

    public int confir_correo(String var){
        int r = 0;
        String sql = "select Count(*) from datos_pasajero WHERE correo = ?";
        try {
            

            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, var);
            rs = ps.executeQuery();

            if(rs.next())
            r = rs.getInt(1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la validacion del correo", e.toString(), JOptionPane.ERROR_MESSAGE);
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        return r;
    }
    }

    public int confir_ejecucion(int ticket, String nom, String doc, String corr) {
        int r = 0;
        try {
            String sql = "SELECT COUNT(*) FROM datos_pasajero INNER JOIN Tickets ON datos_pasajero.id = Tickets.id_pasajero WHERE datos_pasajero.nombre = ? AND datos_pasajero.numero_documento = ? AND datos_pasajero.correo = ? AND Tickets.codigo_ticket = ?";

            con = conectar.getConection();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, nom);
            ps.setString(2, doc);
            ps.setString(3, corr);
            ps.setInt(4, ticket);
            rs = ps.executeQuery();
            
            if(rs.next())
                r = rs.getInt(1);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en la validacion de los datos", e.toString(), JOptionPane.ERROR_MESSAGE);
        }finally {
            if (con != null) {
                try {
                    con.close();
                    ps.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        return r;
    }
}
}
