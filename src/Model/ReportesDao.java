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
 * @author juans
 */
public class ReportesDao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
    List listarP = new ArrayList();
    String sql = "SELECT id_reporte, tipo, categoria, descripcion, monto, fecha, referencia FROM financieros";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            
            Object[] fila = new Object[7]; 
            fila[0] = rs.getInt("id_reporte");
            fila[1] = rs.getString("tipo");
            fila[2] = rs.getString("categoria"); 
            fila[3] = rs.getString("descripcion"); 
            fila[4] = rs.getDouble("monto"); 
            fila[5] = rs.getTimestamp("fecha"); 
            fila[6] = rs.getString("referencia"); 

            listarP.add(fila);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Error de consulta" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
    } finally {
        if (con != null) {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    return listarP;
}
    
}
