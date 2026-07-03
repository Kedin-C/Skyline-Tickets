/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import Model.Conexion;
import Model.Codigo_descuento;
/**
 *
 * @author Nikob
 */
public class Codigo_descuentoDao {
    

    Conexion conexionBD = new Conexion();
    Connection con;

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
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo.getCodigo());
            ps.setInt(2, codigo.getPorcentajeDescuento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
