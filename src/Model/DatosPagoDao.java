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
import java.sql.Date;

public class DatosPagoDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void enviarDatos(DatosPago pago){
        String sql = "INSERT INTO datos_pago (numero_cuenta, cvv, nombre_titular, fecha_vencimiento, total) "
                + "VALUES (?, ?, ?, ?, ?);";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, pago.getNumero_tarjeta());
            ps.setInt(2, pago.getCvv());
            ps.setString(3, pago.getNombre_titular());
            ps.setString(4, pago.getFecha_vencimiento());
            ps.setDouble(5, pago.getTotal());
        
            ps.executeUpdate();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pago"+ex.getMessage(),
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
    
    
    public int idPago(DatosPago pago){
        
        ArrayList<Integer> ids = new ArrayList();
        int id=-1;
        String sql = "SELECT id_pago FROM datos_pago WHERE numero_cuenta = ? AND cvv = ? AND nombre_titular = ? AND fecha_vencimiento = ? ORDER BY id_pago DESC LIMIT 1";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, pago.getNumero_tarjeta());
            ps.setInt(2, pago.getCvv());
            ps.setString(3, pago.getNombre_titular());
            ps.setDate(4, Date.valueOf(pago.getFecha_vencimiento()));
            
            rs=ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id_pago");
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
       JOptionPane.showMessageDialog(null, "id_pago: "+id);
       return id; 
    }
    
}
