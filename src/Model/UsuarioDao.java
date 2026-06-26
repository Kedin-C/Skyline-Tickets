package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;



/**
 *
 * @author david
 */
public class UsuarioDao {

/**
 *
 * @author Nikob
 */

    Conexion conectar = Conexion.getObject();
    Connection con;
    
    public boolean registrarUsuario(Usuario usuario){

    String sql = "INSERT INTO usuario(nombre_usuario, apellido_usuario, correo_usuario, password_usuario, rol) VALUES(?,?,?,?,?)";

    try{

        con = conectar.getConection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getApellido());
        ps.setString(3, usuario.getCorreo());
        ps.setString(4, usuario.getContraseña());
        ps.setString(5, usuario.getRol());

        ps.executeUpdate();

        return true;

    }catch(Exception e){

        System.out.println(e.getMessage());

        return false;
    }
    }
    
    public Usuario iniciarSesion(String correo, String contraseña){

    String sql = "select id_usuario, nombre, apellido,correo,contrasena,rol from usuarios WHERE usuarios.correo = ? AND usuarios.contrasena= ?";

    try{

        con = conectar.getConection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, correo);
        ps.setString(2, contraseña);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            Usuario usuario = new Usuario();

            usuario.setIdUsuario(rs.getInt("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setContraseña(rs.getString("contrasena"));
            usuario.setRol(rs.getString("rol"));
            
            
            return usuario;
        }

    }catch(Exception e){

        System.out.println(e.getMessage());

    }

    return null;
    }
    
    
    public Usuario buscarPorCorreo(String correo){
    
    String sql =
    "SELECT * FROM usuarios WHERE correo = ?";

    try{

        con = conectar.getConection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, correo);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            Usuario usuario = new Usuario();

            usuario.setIdUsuario(
                    rs.getInt("id_usuario"));

            usuario.setNombre(
                    rs.getString("nombre"));

            usuario.setApellido(
                    rs.getString("apellido"));

            usuario.setCorreo(
                    rs.getString("correo"));

            usuario.setContraseña(
                    rs.getString("contrasena"));

            usuario.setRol(
                    rs.getString("rol"));

            return usuario;
        }

    }catch(Exception e){

        System.out.println(e.getMessage());
    }

    return null;
}
    
    public int getId (Usuario usuario){

    String sql = "SELECT id_usuario FROM usuarios WHERE usuarios.correo = ? AND usuarios.contrasena = ?";
    int id = 0;

    try{

        con = conectar.getConection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getCorreo());
        ps.setString(2, usuario.getContraseña());

        ResultSet rs = ps.executeQuery();

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
    
