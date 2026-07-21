
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;

public class DatosPersonalesDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void enviarDatos(DatosPersonales pasajero){
        String sql = "INSERT INTO datos_pasajero (numero_documento, nombre, apellido, codigo_tipo_documento, sexo, numero_telefono, correo, fecha_nacimiento, nacionalidad) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, pasajero.getNumero_documento());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getApellido());
            ps.setInt(4, pasajero.getCodigo_tipo_documento());
            ps.setString(5, pasajero.getSexo());
            ps.setString(6, pasajero.getNumero_telefono());
            ps.setString(7, pasajero.getCorreo());
            ps.setDate(8, Date.valueOf(pasajero.getFecha_nacimiento()));
            ps.setString(9, pasajero.getNacionalidad());
        
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
    
    public int idPasajero(DatosPersonales pasajero){
        
        int id=-1;
        String sql = "SELECT id FROM datos_pasajero WHERE numero_documento = ? ORDER BY id DESC LIMIT 1";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, pasajero.getNumero_documento());
            
            rs=ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
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
       JOptionPane.showMessageDialog(null, "id_pasajero: "+id);
       return id; 
    }
}
