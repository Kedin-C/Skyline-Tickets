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
public class ReportesDao {
    
    Conexion conectar = Conexion.getObject();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
    List listarP = new ArrayList();
    String sql = "SELECT numero_vuelo, fecha, origen, destino, tipo_vuelo, clase, cantidad_pasajeros, estado FROM reportes_operacionales";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            
            Object[] fila = new Object[8]; 
            fila[0] = rs.getString("numero_vuelo");
            fila[1] = rs.getDate("fecha"); 
            fila[2] = rs.getString("origen"); 
            fila[3] = rs.getString("destino"); 
            fila[4] = rs.getString("tipo_vuelo"); 
            fila[5] = rs.getString("clase"); 
            fila[6] = rs.getInt("cantidad_pasajeros"); 
            fila[7] = rs.getString("estado"); 

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


public DefaultCategoryDataset obtenerTendenciaVuelosDatasetT(String fechaInicio, String fechaFin) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE fecha BETWEEN ? AND ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta tendencia: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public DefaultCategoryDataset obtenerTopDestinosDatasetT(String fechaInicio, String fechaFin, int limite) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT destino, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE fecha BETWEEN ? AND ? " +
                 "GROUP BY destino ORDER BY total_vuelos DESC LIMIT ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        ps.setInt(3, limite);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("destino"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta destinos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


public DefaultPieDataset obtenerDistribucionTipoVueloDatasetT(String fechaInicio, String fechaFin) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String sql = "SELECT tipo_vuelo, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE fecha BETWEEN ? AND ? " +
                 "GROUP BY tipo_vuelo";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.setValue(rs.getString("tipo_vuelo"), rs.getInt("total_vuelos"));
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
    String sql = "SELECT numero_vuelo, fecha, origen, destino, tipo_vuelo, clase, cantidad_pasajeros, estado " +
                 "FROM reportes_operacionales WHERE fecha BETWEEN ? AND ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);
        rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getString("numero_vuelo");
            fila[1] = rs.getDate("fecha");
            fila[2] = rs.getString("origen");
            fila[3] = rs.getString("destino");
            fila[4] = rs.getString("tipo_vuelo");
            fila[5] = rs.getString("clase");
            fila[6] = rs.getInt("cantidad_pasajeros");
            fila[7] = rs.getString("estado");

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


public List listarPorDestino(String destino) {
    List listarP = new ArrayList();
    String sql = "SELECT numero_vuelo, fecha, origen, destino, tipo_vuelo, clase, cantidad_pasajeros, estado " +
                 "FROM reportes_operacionales WHERE destino = ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, destino);
        rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getString("numero_vuelo");
            fila[1] = rs.getDate("fecha");
            fila[2] = rs.getString("origen");
            fila[3] = rs.getString("destino");
            fila[4] = rs.getString("tipo_vuelo");
            fila[5] = rs.getString("clase");
            fila[6] = rs.getInt("cantidad_pasajeros");
            fila[7] = rs.getString("estado");

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


public List listaDestinos() {
    List listarD = new ArrayList();
    String sql = "SELECT DISTINCT destino FROM reportes_operacionales";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            listarD.add(rs.getString("destino"));
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
    return listarD;
}


public DefaultCategoryDataset obtenerTendenciaVuelosDatasetD(String destino) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE destino = ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, destino);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta tendencia: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public DefaultCategoryDataset obtenerTopDestinosDatasetD(String destino) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT destino, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE destino = ? " +
                 "GROUP BY destino ORDER BY total_vuelos DESC LIMIT 1";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, destino);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("destino"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta destinos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


public DefaultPieDataset obtenerDistribucionTipoVueloDatasetD(String destino) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String sql = "SELECT tipo_vuelo, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE destino = ? " +
                 "GROUP BY tipo_vuelo";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, destino);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.setValue(rs.getString("tipo_vuelo"), rs.getInt("total_vuelos"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta distribución: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public List listarPorTipo(String tipo) {
    List listarP = new ArrayList();
    String sql = "SELECT numero_vuelo, fecha, origen, destino, tipo_vuelo, clase, cantidad_pasajeros, estado " +
                 "FROM reportes_operacionales WHERE tipo_vuelo = ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getString("numero_vuelo");
            fila[1] = rs.getDate("fecha");
            fila[2] = rs.getString("origen");
            fila[3] = rs.getString("destino");
            fila[4] = rs.getString("tipo_vuelo");
            fila[5] = rs.getString("clase");
            fila[6] = rs.getInt("cantidad_pasajeros");
            fila[7] = rs.getString("estado");

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


public DefaultCategoryDataset obtenerTendenciaVuelosDatasetTP(String tipo) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE tipo_vuelo = ? " +
                 "GROUP BY mes ORDER BY mes";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("mes"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta tendencia: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}

public DefaultCategoryDataset obtenerTopDestinosDatasetTP(String tipo, int limite) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String sql = "SELECT destino, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE tipo_vuelo = ? " +
                 "GROUP BY destino ORDER BY total_vuelos DESC LIMIT ?";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        ps.setInt(2, limite);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.addValue(rs.getInt("total_vuelos"), "Vuelos", rs.getString("destino"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta destinos: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


public DefaultPieDataset obtenerDistribucionTipoVueloDatasetTP(String tipo) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String sql = "SELECT tipo_vuelo, COUNT(*) AS total_vuelos " +
                 "FROM reportes_operacionales " +
                 "WHERE tipo_vuelo = ? " +
                 "GROUP BY tipo_vuelo";
    try {
        con = conectar.getConection();
        ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        rs = ps.executeQuery();
        while (rs.next()) {
            dataset.setValue(rs.getString("tipo_vuelo"), rs.getInt("total_vuelos"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error consulta distribución: " + e.getMessage());
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
    return dataset;
}


}
