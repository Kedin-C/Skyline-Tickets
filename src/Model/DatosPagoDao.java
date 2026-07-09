/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DatosPagoDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void enviarDatos(String numero_tarjeta,int cvv, String nombre_titular, String fecha_vencimiento, double total){
        String sql = "INSERT INTO datos_pago (numero_cuenta, cvv, nombre_titular, fecha_vencimiento, total) "
                + "VALUES (?, ?, ?, ?, ?);";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, numero_tarjeta);
            ps.setInt(2, cvv);
            ps.setString(3, nombre_titular);
            ps.setString(4, fecha_vencimiento);
            ps.setDouble(5, total);
        
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
}
