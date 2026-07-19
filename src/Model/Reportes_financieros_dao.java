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
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author juans
 */
public class Reportes_financieros_dao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
    List listarP = new ArrayList();
    String sql = "SELECT tipo, descripcion, monto, fecha, referencia FROM reportes_financieros";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            
            Object[] fila = new Object[5];
            fila[0] = rs.getString("tipo"); 
            fila[1] = rs.getString("descripcion"); 
            fila[2] = rs.getDouble("monto"); 
            fila[3] = rs.getDate("fecha"); 
            fila[4] = rs.getString("referencia"); 

            listarP.add(fila);
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
    return listarP;
}


public DefaultCategoryDataset obtenerIngresosDatasetT(String fechaInicio, String fechaFin) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, SUM(monto) AS total_ingresos " +
                 "FROM reportes_financieros " +
                 "WHERE tipo = 'Ingresos' AND fecha BETWEEN ? AND ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getDouble("total_ingresos"), "Ingresos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta ingresos: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {}
}
    return dataset;
}

public DefaultCategoryDataset obtenerGastosDatasetT(String fechaInicio, String fechaFin) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, SUM(monto) AS total_gastos " +
                 "FROM reportes_financieros " +
                 "WHERE tipo = 'Gastos' AND fecha BETWEEN ? AND ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getDouble("total_gastos"), "Gastos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta gastos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


public DefaultPieDataset obtenerDistribucionGastosGananciasDatasetT(String fechaInicio, String fechaFin) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String sql = "SELECT tipo, SUM(monto) AS total_monto " +
                 "FROM reportes_financieros " +
                 "WHERE tipo IN ('Gastos','Ingresos') AND fecha BETWEEN ? AND ? " +
                 "GROUP BY tipo";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.setValue(rs.getString("tipo"), rs.getDouble("total_monto"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta distribución: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public List listarPorFecha(String fechaInicio, String fechaFin) {
    List listarP = new ArrayList();
    String sql = "SELECT id_financiero, tipo, descripcion, monto, fecha, referencia " +
                 "FROM reportes_financieros WHERE fecha BETWEEN ? AND ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[5];
            fila[0] = rs.getString("tipo");
            fila[1] = rs.getString("descripcion");
            fila[2] = rs.getDouble("monto");
            fila[3] = rs.getDate("fecha");
            fila[4] = rs.getString("referencia");

            listarP.add(fila);
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
    return listarP;
}


public List listarPorTipo(String tipo) {
    List listarP = new ArrayList();
    String sql = "SELECT id_financiero, tipo, descripcion, monto, fecha, referencia " +
                 "FROM reportes_financieros WHERE tipo = ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[5];
            fila[0] = rs.getString("tipo");
            fila[1] = rs.getString("descripcion");
            fila[2] = rs.getDouble("monto");
            fila[3] = rs.getDate("fecha");
            fila[4] = rs.getString("referencia");

            listarP.add(fila);
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
    return listarP;
}


public DefaultCategoryDataset obtenerIngresosDatasetTP(String tipo) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, SUM(monto) AS total_ingresos " +
                 "FROM reportes_financieros " +
                 "WHERE tipo = ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getDouble("total_ingresos"), "Ingresos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta ingresos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public DefaultCategoryDataset obtenerGastosDatasetTP(String tipo) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, SUM(monto) AS total_gastos " +
                 "FROM reportes_financieros " +
                 "WHERE tipo = ? AND fecha >= CURDATE() - INTERVAL 3 MONTH " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getDouble("total_gastos"), "Gastos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta gastos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


public DefaultPieDataset obtenerDistribucionGastosGananciasDatasetTP(String tipo) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String sql = "SELECT tipo, SUM(monto) AS total_monto " +
                 "FROM reportes_financieros " +
                 "WHERE tipo = ? " +
                 "GROUP BY tipo";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.setValue(rs.getString("tipo"), rs.getDouble("total_monto"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta distribución: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


}
