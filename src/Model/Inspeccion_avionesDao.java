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
public class Inspeccion_avionesDao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarAviones() {
        List listarA = new ArrayList();
        String sql = "SELECT * FROM aviones";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Object[] fila = new Object[5];
                fila[0] = rs.getString("matricula");
                fila[1] = rs.getString("marca");
                fila[2] = rs.getString("modelo");
                fila[3] = rs.getString("capacidad");
                fila[4] = rs.getString("estado");

                listarA.add(fila);
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
        return listarA;
    }
    
    public void cambioEstado(String matricula){
        String sql = "UPDATE aviones SET estado = 'Activo' WHERE matricula = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se cambio de estado a Activo el avion.");
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
    }
    
}
