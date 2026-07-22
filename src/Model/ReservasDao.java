/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReservasDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    public void enviarDatos(String codigo_asiento, int codigo_vuelo){
        String sql = "INSERT INTO reservas (codigo_asiento, codigo_vuelo) "
                + "VALUES (?, ?)";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, codigo_asiento);
            ps.setInt(2, codigo_vuelo);
            
            ps.executeUpdate();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos de lareserva"+ex.getMessage(),
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
    
    public ArrayList<String> asientoReservados(Reservas reserva){
        
        ArrayList<String> puestos = new ArrayList<>();
        String sql = "SELECT codigo_asiento FROM reservas WHERE codigo_vuelo=?";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, reserva.getCodigo_vuelo());
            
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                puestos.add(rs.getString(1));
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al gusrdar los datos de la reserva"+ex.getMessage(),
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
       return puestos;
       
    }
    
    
    public ArrayList<String> claseActual(int codigo_clase){
        
        ArrayList<String> puestos = new ArrayList<>();
        String sql = "SELECT codigo_asiento FROM asientos WHERE codigo_clase != ?";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, codigo_clase);
            
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                puestos.add(rs.getString(1));
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al gusrdar los datos de la reserva"+ex.getMessage(),
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
       return puestos;
       
    }
    
    
    public int idReservas(String codigo_asiento, int codigo_vuelo){
        
        int id=-1;
        String sql = "SELECT id FROM reservas WHERE codigo_asiento = ? AND codigo_vuelo = ?";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, codigo_asiento);
            ps.setInt(2, codigo_vuelo);
            
            rs=ps.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("id");
            } 
            
            JOptionPane.showMessageDialog(null, "id_reserva: "+id);
            
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
       
       return id; 
    }
    
}
