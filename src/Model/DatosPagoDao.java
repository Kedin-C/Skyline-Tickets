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

public class DatosPagoDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void enviarDatos(DatosPago pago){
        String sql = "INSERT INTO datos_pago (numero_cuenta, cvv, nombre_titular, fecha_vencimiento, total, medio_pago) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, pago.getNumero_tarjeta());
            ps.setInt(2, pago.getCvv());
            ps.setString(3, pago.getNombre_titular());
            ps.setString(4, pago.getFecha_vencimiento());
            ps.setDouble(5, pago.getTotal());
            ps.setString(6, pago.getMedioPago());
        
            ps.executeUpdate();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al guardar los datos del pago "+ex.getMessage(),
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
    
    //WHERE numero_cuenta = ? AND cvv = ? AND nombre_titular = ? AND fecha_vencimiento = ? 
    public int idPago(DatosPago pago){
        
        ArrayList<Integer> ids = new ArrayList();
        int id=-1;
        String sql = "SELECT MAX(id_pago) AS id_pago FROM datos_pago";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id_pago");
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error al traer el id del pago "+ex.getMessage(),
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
