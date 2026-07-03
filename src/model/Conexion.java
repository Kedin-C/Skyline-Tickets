/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Nikob
 */
public class Conexion {
    Connection con;
    
    String url="jdbc:mysql://localhost:3306/skyLine";
    String user="root";
    String pass="";
    
    public Connection getConnection(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con= DriverManager.getConnection(url, user, pass);
           JOptionPane.showMessageDialog(null,"Conexion Exitosa");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.toString(),"Base de Datos Apagada"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
       }
       return con;
   }
}
