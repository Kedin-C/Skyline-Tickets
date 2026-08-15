/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author juans
 */
public class CheckList_aviones_view extends Interfaz_vista_abtractas{
    
    private Container contenedor;
    private JPanel panel1,panel2,
    pnlInfoAvion, pnlRevisionExterior, pnlSistemasPropulsion, pnlInterioresSeguridad
    ,pnlDatosFinales, pnlBotones, pnlBotonVolver;
    private JLabel lblTitulo,lblMatricula,lblMarca,lblModelo,blTecnico, lblFecha;
    public JTextField txtMatricula, txtMarca, txtModelo, txtNombreTecnico;
    private JDateChooser dcFecha;
    public JCheckBox chkFuselaje, chkAlerones, chkTrenAterrizaje, chkLlantas;
    public JCheckBox chkMotoresFugas, chkNivelCombustible, chkAspasTurbina;
    public JCheckBox chkEquipoEmergencia, chkCabinaAsegurada, chkCargaAsegurada;
    public JButton btnRegistrarInspeccion, btnVolver;
    private TitledBorder borderInfo,borderExterior,borderSistemas,borderInteriores;

    public CheckList_aviones_view() {
        super("CHECKLIST AVIONES");
        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createVerticalStrut(40));
        
        lblTitulo = new JLabel("LISTA DE CHEQUEO DE MANTENIMIENTO");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(lblTitulo);
        panel2.add(Box.createVerticalStrut(40));
        
        pnlInfoAvion = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlInfoAvion.setBackground(Color.WHITE);
        pnlInfoAvion.setOpaque(false);
        borderInfo = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                "Información del Avión"
        );
        borderInfo.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlInfoAvion.setBorder(borderInfo);
        
        pnlInfoAvion.setMaximumSize(new Dimension(1100, 180));
        pnlInfoAvion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlInfoAvion.add(lblMatricula);
        
        txtMatricula = new JTextField();
        txtMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtMatricula.setPreferredSize(new Dimension(240,25));
        txtMatricula.setEditable(false);
        txtMatricula.setBackground(new Color(240, 240, 240));
        txtMatricula.setText("");
        pnlInfoAvion.add(txtMatricula);
        
        lblMarca = new JLabel("Marca:");
        lblMarca.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlInfoAvion.add(lblMarca);
        
        txtMarca = new JTextField();
        txtMarca.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtMarca.setPreferredSize(new Dimension(240,25));
        txtMarca.setEditable(false);
        txtMarca.setBackground(new Color(240, 240, 240));
        txtMarca.setText("");
        pnlInfoAvion.add(txtMarca);
        
        lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlInfoAvion.add(lblModelo);
        
        txtModelo = new JTextField();
        txtModelo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtModelo.setPreferredSize(new Dimension(240,25));
        txtModelo.setEditable(false);
        txtModelo.setBackground(new Color(240, 240, 240));
        txtModelo.setText("");
        pnlInfoAvion.add(txtModelo);
        
        panel2.add(pnlInfoAvion);
        panel2.add(Box.createVerticalStrut(20));
        
        pnlRevisionExterior = new JPanel(new GridLayout(2, 2, 10, 5)); // Rejilla para los checks
        pnlRevisionExterior.setBackground(Color.WHITE);
        pnlRevisionExterior.setOpaque(false);
        
        borderExterior = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                "Revisión Exterior"
        );
        borderExterior.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlRevisionExterior.setBorder(borderExterior);

        pnlRevisionExterior.setMaximumSize(new Dimension(1100, 180));
        pnlRevisionExterior.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        chkFuselaje = new JCheckBox("Fuselaje sin abolladuras ni corrosión");
        chkFuselaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkFuselaje.setBackground(Color.WHITE);
        chkFuselaje.setOpaque(false);
        chkFuselaje.setFocusPainted(false);
        pnlRevisionExterior.add(chkFuselaje);

        chkAlerones = new JCheckBox("Alerones y superficies de control funcionales");
        chkAlerones.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkAlerones.setBackground(Color.WHITE);
        chkAlerones.setOpaque(false);
        chkAlerones.setFocusPainted(false);
        pnlRevisionExterior.add(chkAlerones);

        chkTrenAterrizaje = new JCheckBox("Tren de aterrizaje sin daños");
        chkTrenAterrizaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkTrenAterrizaje.setBackground(Color.WHITE);
        chkTrenAterrizaje.setOpaque(false);
        chkTrenAterrizaje.setFocusPainted(false);
        pnlRevisionExterior.add(chkTrenAterrizaje);

        chkLlantas = new JCheckBox("Llantas con presión y desgaste correctos");
        chkLlantas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkLlantas.setBackground(Color.WHITE);
        chkLlantas.setOpaque(false);
        chkLlantas.setFocusPainted(false);
        pnlRevisionExterior.add(chkLlantas);

        panel2.add(pnlRevisionExterior);
        panel2.add(Box.createVerticalStrut(20));
        
        pnlSistemasPropulsion = new JPanel(new GridLayout(2, 2, 10, 5));
        pnlSistemasPropulsion.setBackground(Color.WHITE);
        pnlSistemasPropulsion.setOpaque(false);
        
        borderSistemas = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                "Sistemas de Propulsión"
        );
        borderSistemas.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlSistemasPropulsion.setBorder(borderSistemas);

        pnlSistemasPropulsion.setMaximumSize(new Dimension(1100, 180));
        pnlSistemasPropulsion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        chkMotoresFugas = new JCheckBox("Motores sin fugas de aceite");
        chkMotoresFugas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkMotoresFugas.setBackground(Color.WHITE);
        chkMotoresFugas.setOpaque(false);
        chkMotoresFugas.setFocusPainted(false);
        pnlSistemasPropulsion.add(chkMotoresFugas);

        chkNivelCombustible = new JCheckBox("Nivel de combustible verificado y tanqueado");
        chkNivelCombustible.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkNivelCombustible.setBackground(Color.WHITE);
        chkNivelCombustible.setOpaque(false);
        chkNivelCombustible.setFocusPainted(false);
        pnlSistemasPropulsion.add(chkNivelCombustible);

        chkAspasTurbina = new JCheckBox("Aspas de turbina sin daños visuales");
        chkAspasTurbina.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkAspasTurbina.setBackground(Color.WHITE);
        chkAspasTurbina.setOpaque(false);
        chkAspasTurbina.setFocusPainted(false);
        pnlSistemasPropulsion.add(chkAspasTurbina);
        
        pnlSistemasPropulsion.add(new JLabel(""));

        panel2.add(pnlSistemasPropulsion);
        panel2.add(Box.createVerticalStrut(20));
        
        pnlInterioresSeguridad = new JPanel(new GridLayout(2, 2, 10, 5));
        pnlInterioresSeguridad.setBackground(Color.WHITE);
        pnlInterioresSeguridad.setOpaque(false);
        
        borderInteriores = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                "Interiores y Seguridad"
        );
        borderInteriores.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlInterioresSeguridad.setBorder(borderInteriores);

        pnlInterioresSeguridad.setMaximumSize(new Dimension(1100, 180));
        pnlInterioresSeguridad.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        chkEquipoEmergencia = new JCheckBox("Equipo de emergencia a bordo (balsas, chalecos)");
        chkEquipoEmergencia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkEquipoEmergencia.setBackground(Color.WHITE);
        chkEquipoEmergencia.setOpaque(false);
        chkEquipoEmergencia.setFocusPainted(false);
        pnlInterioresSeguridad.add(chkEquipoEmergencia);

        chkCabinaAsegurada = new JCheckBox("Cabina de pasajeros asegurada");
        chkCabinaAsegurada.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkCabinaAsegurada.setBackground(Color.WHITE);
        chkCabinaAsegurada.setOpaque(false);
        chkCabinaAsegurada.setFocusPainted(false);
        pnlInterioresSeguridad.add(chkCabinaAsegurada);

        chkCargaAsegurada = new JCheckBox("Carga asegurada correctamente");
        chkCargaAsegurada.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkCargaAsegurada.setBackground(Color.WHITE);
        chkCargaAsegurada.setOpaque(false);
        chkCargaAsegurada.setFocusPainted(false);
        pnlInterioresSeguridad.add(chkCargaAsegurada);
        
        pnlInterioresSeguridad.add(new JLabel(""));

        panel2.add(pnlInterioresSeguridad);
        panel2.add(Box.createVerticalStrut(20));
        
        pnlDatosFinales = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        pnlDatosFinales.setBackground(Color.WHITE);
        pnlDatosFinales.setOpaque(false);

        // Nombre del Inspector
        blTecnico = new JLabel("Nombre del Tecnico:");
        blTecnico.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlDatosFinales.add(blTecnico);

        txtNombreTecnico = new JTextField(20);
        txtNombreTecnico.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtNombreTecnico.setPreferredSize(new Dimension(txtNombreTecnico.getPreferredSize().width, 25));
        txtNombreTecnico.setEditable(true);
        txtNombreTecnico.setBackground(Color.WHITE);
        pnlDatosFinales.add(txtNombreTecnico);
        
        lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlDatosFinales.add(lblFecha);

        dcFecha = new JDateChooser();
        dcFecha.setDateFormatString("dd/MM/yyyy");
        
        dcFecha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        dcFecha.setPreferredSize(new Dimension(200, 30));
        dcFecha.setDate(new Date()); 
        JTextField dateEditor = ((JTextField) dcFecha.getDateEditor().getUiComponent());
        dateEditor.setEditable(false);
        Component BotonCalendario = dcFecha.getCalendarButton();
        BotonCalendario.setEnabled(false);
        pnlDatosFinales.add(dcFecha);

        panel2.add(pnlDatosFinales);
        panel2.add(Box.createVerticalStrut(30));
        
        pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        pnlBotones.setBackground(Color.WHITE);
        pnlBotones.setOpaque(false);
        
        btnRegistrarInspeccion = new JButton("Registrar Inspección");
        btnRegistrarInspeccion.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnRegistrarInspeccion.setBackground(new Color(0, 122, 192)); // Azul
        btnRegistrarInspeccion.setForeground(Color.WHITE); // Letra blanca
        btnRegistrarInspeccion.setPreferredSize(new Dimension(300, 30));
        btnRegistrarInspeccion.setFocusPainted(false);
        pnlBotones.add(btnRegistrarInspeccion);

        panel2.add(pnlBotones);
        panel2.add(Box.createVerticalStrut(30));
        
        pnlBotonVolver = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        pnlBotonVolver.setBackground(Color.WHITE);
        pnlBotonVolver.setOpaque(false);
        
        btnVolver = super.getVolver();
        pnlBotonVolver.add(btnVolver);
        
        panel2.add(pnlBotonVolver);
        panel2.add(Box.createVerticalStrut(10));
    }
    
    
}
