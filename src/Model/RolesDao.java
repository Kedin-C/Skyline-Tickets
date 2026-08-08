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
public class RolesDao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listarUsuarios(String correo) {
        List listarU = new ArrayList();
        String sql = "SELECT nombre_usuario, apellido_usuario, correo_usuario, id_rol FROM usuario WHERE correo_usuario NOT LIKE ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            while (rs.next()) {

                Object[] fila = new Object[4];
                fila[0] = rs.getString("nombre_usuario");
                fila[1] = rs.getString("apellido_usuario");
                fila[2] = rs.getString("correo_usuario");

                int rol = rs.getInt("id_rol");
                if (rol == 1) {
                    fila[3] = "Administrador";
                } else if (rol == 2) {
                    fila[3] = "Usuario";
                } else {
                    fila[3] = "Tecnico";
                }

                listarU.add(fila);
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
        return listarU;
    }

    public void AsignarRol(String rol, String correo) {
        String sql = "UPDATE usuario SET id_rol = ? WHERE correo_usuario = ?";
        try {
            con = conectar.getConection();
            ps = con.prepareStatement(sql);
            
            int id_rol = 0;
            if(rol.equals("Administrador")){
                id_rol = 1;
            }else if(rol.equals("Usuario")){
                id_rol = 2;
            }else{
                id_rol = 3;
            }
            
            ps.setInt(1, id_rol);
            ps.setString(2, correo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se reasigno correctamente el rol al usuario seleccionado.");
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
