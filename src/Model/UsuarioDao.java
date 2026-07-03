/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author Nikob
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.Conexion;
import Model.Usuario;
import java.sql.ResultSet;

public class UsuarioDao {

    Conexion conexionBD = new Conexion();
    Connection con;

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre_usuario, apellido_usuario, correo_usuario, password_usuario, rol) VALUES(?,?,?,?,?)";
        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getRol());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Usuario iniciarSesion(String correo, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE correo_usuario = ? AND password_usuario = ?";
        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre_usuario"));
                usuario.setApellido(rs.getString("apellido_usuario"));
                usuario.setCorreo(rs.getString("correo_usuario"));
                usuario.setContraseña(rs.getString("password_usuario"));
                usuario.setRol(rs.getString("rol"));
                return usuario;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM usuario WHERE correo_usuario = ?";
        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre_usuario"));
                usuario.setApellido(rs.getString("apellido_usuario"));
                usuario.setCorreo(rs.getString("correo_usuario"));
                usuario.setContraseña(rs.getString("password_usuario"));
                usuario.setRol(rs.getString("rol"));
                return usuario;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean actualizarContraseña(String correo, String nuevaContraseña) {
        String sql = "UPDATE usuario SET password_usuario = ? WHERE correo_usuario = ?";
        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevaContraseña);
            ps.setString(2, correo);

            System.out.println("SQL: " + sql);
            System.out.println("Nueva contraseña: " + nuevaContraseña);
            System.out.println("Correo: " + correo);
            int filas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
            return filas > 0;
        } catch (Exception e) {

            System.out.println("ERROR en actualizarContraseña: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCorreo(int idUsuario, String nuevoCorreo) {
        String sql = "UPDATE usuario SET correo_usuario = ? WHERE id_usuario = ?";
        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoCorreo);
            ps.setInt(2, idUsuario);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            System.out.println("ERROR en actualizarCorreo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeCorreo(String correo) {

        String sql = "SELECT COUNT(*) FROM usuario WHERE correo_usuario = ?";

        try {
            con = conexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
