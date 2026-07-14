
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DatosPersonalesDao {
    
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void enviarDatos(String numero_documento, String nombre, String apellido, int codigo_tipo_documento, String sexo, String numero_telefono, String correo, String fecha_nacimiento, String nacionalidad){
        String sql = "INSERT INTO datos_pasajero (numero_documento, nombre, apellido, codigo_tipo_documento, sexo, numero_telefono, correo, fecha_nacimiento, nacionalidad) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, numero_documento);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setInt(4, codigo_tipo_documento);
            ps.setString(5, sexo);
            ps.setString(6, numero_telefono);
            ps.setString(7, correo);
            ps.setString(8, fecha_nacimiento);
            ps.setString(9, nacionalidad);
        
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
    
    public int idPasajero(String numero_documento, String nombre, String apellido, int codigo_tipo_documento, String sexo, String numero_telefono, String correo, String fecha_nacimiento, String nacionalidad){
        int id=-1;
        String sql = "SELECT id FROM datos_pasajero WHERE numero_documento = ? AND nombre = ? AND apellido = ? AND codigo_tipo_documento = ? AND sexo = ? AND numero_telefono = ? AND correo = ? AND fecha_nacimiento = ? AND nacionalidad = ?";
        
        try{
            con = Conexion.getObject().getConection();
            ps=con.prepareStatement(sql);
        
            ps.setString(1, numero_documento);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setInt(4, codigo_tipo_documento);
            ps.setString(5, sexo);
            ps.setString(6, numero_telefono);
            ps.setString(7, correo);
            ps.setString(8, fecha_nacimiento);
            ps.setString(9, nacionalidad);
            
            rs=ps.executeQuery();
            
            if (rs.next()) {
                id=rs.getInt("id");
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
       
       return id; 
    }
}
