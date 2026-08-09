/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Nikob
 */
public class Codigo_descuentoDao {
    

    Conexion conexionBD = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Codigo_descuento generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        Codigo_descuento codigo = new Codigo_descuento();
        codigo.setCodigo(sb.toString());
        codigo.setPorcentajeDescuento(random.nextInt(6) + 10); // entre 10% y 15%
        return codigo;
    }

    public boolean guardarCodigo(Codigo_descuento codigo) {
        String sql = "INSERT INTO codigo_descuento(codigo, porcentaje_descuento, usado) VALUES(?,?,0)";
        try {
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo.getCodigo());
            ps.setInt(2, codigo.getPorcentajeDescuento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Codigo_descuento aplicarCodigo(String codigo){
        
        Codigo_descuento codigoDes = new Codigo_descuento();
        String sql = "SELECT porcentaje_descuento, usado FROM codigo_descuento WHERE codigo = ?";
        
        try{
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                codigoDes.setPorcentajeDescuento(rs.getInt("porcentaje_descuento"));
                codigoDes.setUsado(rs.getInt("usado")); 
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, 
                    e.toString(),
                    "Error al aplicar el descuento"+e.getMessage(),
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
        
        return codigoDes;
    }
    
    public void codigoUsado(String codigo){
        String sql = "UPDATE codigo_descuento SET usado = ? WHERE codigo = ?";
        
        try{
            con = conexionBD.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, codigo);
            
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, 
                    e.toString(),
                    "Error cambiar el estado de codigo de descuento"+e.getMessage(),
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
}
