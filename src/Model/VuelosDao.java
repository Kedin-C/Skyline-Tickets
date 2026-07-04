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

public class VuelosDao {
    Conexion conectar = Conexion.getObject();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void codigoVuelo(){
    
    }
    
    public List<Vuelos> listarIda(String origen, String destino, String fecha){
        
        
        List<Vuelos> listarV = new ArrayList<Vuelos>();
        String sql="SELECT * FROM vuelos";
        JOptionPane.showMessageDialog(null,conectar + " Hola");
        try{
            
            con = conectar.getConection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, fecha);
        
            rs=ps.executeQuery();
            
            while(rs.next()){
                Vuelos v = new Vuelos();
                v.setCodigo_vuelo(rs.getInt(1));
                v.setOrigen(rs.getString(2));
                v.setDestino(rs.getString(3));
                v.setFecha(rs.getDate(4));
                v.setHora_salida(rs.getString(5));
                v.setHora_llegada(rs.getString(6));
                v.setPrecio(rs.getDouble(7));
                
                listarV.add(v);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error la busqueda de vuelos"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            if(con!=null){
                try{
                    con.close();
                    ps.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        return listarV;
    }
    
    public List<Vuelos> listarIdaHorario(String origen, String destino, String fecha, String horario1, String horario2){
        List<Vuelos> listarV = new ArrayList<Vuelos>();
        String sql="SELECT origen, destino, fecha, hora_salida, hora_llegada, precio FROM vuelos WHERE origen=? AND destino=? AND fecha=? AND hora_salida BETWEEN ? AND ?";
        try{
            ps=con.prepareStatement(sql);
            
            ps.setString(1, origen);
            ps.setString(2, destino);
            ps.setString(3, fecha);
            ps.setString(4,horario1);
            ps.setString(5,horario2);
            
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                Vuelos v = new Vuelos();
                v.setCodigo_vuelo(rs.getInt(1));
                v.setOrigen(rs.getString(2));
                v.setDestino(rs.getString(3));
                v.setFecha(rs.getDate(4));
                v.setHora_salida(rs.getString(5));
                v.setHora_llegada(rs.getString(6));
                v.setPrecio(rs.getDouble(7));
                
                listarV.add(v);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString(),
                    "Error la busqueda de vuelos"+ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            if(con!=null){
                try{
                    con.close();
                    ps.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        return listarV;
    }
    
}
