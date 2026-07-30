/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Conexion {
    public static Conexion object;
    Connection con;
    
    String url = "jdbc:mysql://localhost:3306/skyline_tickets_bd";
    String user = "root";
    String pass = "";
    
    private Conexion(){};
    
    public static Conexion getObject(){
    
        if (object == null){
            object = new Conexion();
        }
        return object;
    }
    
    public Connection getConection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"Base de Datos Apagada"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
