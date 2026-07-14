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
import javax.swing.JOptionPane;

public class UsuarioDao {

    Conexion conexionBD = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre_usuario, apellido_usuario, correo_usuario, password_usuario, rol) VALUES(?,?,?,?,?)";
        try {
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
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
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            
            rs = ps.executeQuery();

            
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre_usuario"));
                usuario.setApellido(rs.getString("apellido_usuario"));
                usuario.setCorreo(rs.getString("correo_usuario"));
                usuario.setContraseña(rs.getString("password_usuario"));     
                usuario.setDocumento(rs.getString("numero_documento"));
                usuario.setCodigo_tipo_documento(rs.getInt("codigo_tipo_documento"));
                usuario.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setNationalidad(rs.getString("nacionalidad"));
                usuario.setNumero_telefono(rs.getString("numero_telefono"));
                if(rs.getString("id_rol").equals(1)){
                    usuario.setRol("ADMINISTRADOR");
                }else{
                                    usuario.setRol("USUARIO");
}
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
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
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
            con = conexionBD.getConection();
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
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
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
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);

            ps.setString(1, correo);

           rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public int getId (Usuario usuario){

    String sql = "SELECT id_usuario FROM usuarios WHERE usuarios.correo_usuario = ? AND usuarios.password_usuario = ?";
    int id = 0;

    try{

        con = conexionBD.getConection();

        ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getCorreo());
        ps.setString(2, usuario.getContraseña());

        rs = ps.executeQuery();

        if(rs.next()){
            
            id = rs.getInt(1);
            
            
        }
        
        return id;

    }catch(Exception e){

        System.out.println(e.getMessage());

    }

    return id;
    }
}
