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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    private JPanel pnlFuselaje, pnlAlerones, pnlTrenAterrizaje, pnlLlantas;
    private JPanel pnlMotoresFugas, pnlNivelCombustible, pnlAspasTurbina;
    private JPanel pnlEquipoEmergencia, pnlCabinaAsegurada, pnlCargaAsegurada;
    private JLabel lblTitulo,lblMatricula,lblMarca,lblModelo,blTecnico, lblFecha;
    private JLabel lblFuselaje, lblAlerones, lblTrenAterrizaje, lblLlantas;
    private JLabel lblMotoresFugas, lblNivelCombustible, lblAspasTurbina;
    private JLabel lblEquipoEmergencia, lblCabinaAsegurada, lblCargaAsegurada;
    public JTextField txtMatricula, txtMarca, txtModelo, txtFirmaTecnico;
    private JDateChooser dcFecha;
    public JRadioButton rbFuselajeAplica, rbFuselajeNoAplica;
    public JRadioButton rbAleronesAplica, rbAleronesNoAplica;
    public JRadioButton rbTrenAterrizajeAplica, rbTrenAterrizajeNoAplica;
    public JRadioButton rbLlantasAplica, rbLlantasNoAplica;
    public JRadioButton rbMotoresFugasAplica, rbMotoresFugasNoAplica;
    public JRadioButton rbNivelCombustibleAplica, rbNivelCombustibleNoAplica;
    public JRadioButton rbAspasTurbinaAplica, rbAspasTurbinaNoAplica;
    public JRadioButton rbEquipoEmergenciaAplica, rbEquipoEmergenciaNoAplica;
    public JRadioButton rbCabinaAseguradaAplica, rbCabinaAseguradaNoAplica;
    public JRadioButton rbCargaAseguradaAplica, rbCargaAseguradaNoAplica;
    private ButtonGroup grupoFuselaje, grupoAlerones, grupoTrenAterrizaje, grupoLlantas;
    private ButtonGroup grupoMotoresFugas, grupoNivelCombustible, grupoAspasTurbina;
    private ButtonGroup grupoEquipoEmergencia, grupoCabinaAsegurada, grupoCargaAsegurada;
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
        
        pnlRevisionExterior = new JPanel(new GridLayout(2, 2, 10, 5)); // Rejilla para las filas
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
        
        pnlFuselaje = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlFuselaje.setBackground(Color.WHITE);
        pnlFuselaje.setOpaque(false);
        
        lblFuselaje = new JLabel("Fuselaje sin abolladuras ni corrosión");
        lblFuselaje.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlFuselaje.add(lblFuselaje);
        
        rbFuselajeAplica = new JRadioButton("Aplica");
        rbFuselajeAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbFuselajeAplica.setBackground(Color.WHITE);
        rbFuselajeAplica.setOpaque(false);
        rbFuselajeAplica.setFocusPainted(false);
        pnlFuselaje.add(rbFuselajeAplica);
        
        rbFuselajeNoAplica = new JRadioButton("No aplica");
        rbFuselajeNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbFuselajeNoAplica.setBackground(Color.WHITE);
        rbFuselajeNoAplica.setOpaque(false);
        rbFuselajeNoAplica.setFocusPainted(false);
        pnlFuselaje.add(rbFuselajeNoAplica);
        
        grupoFuselaje = new ButtonGroup();
        grupoFuselaje.add(rbFuselajeAplica);
        grupoFuselaje.add(rbFuselajeNoAplica);
        
        pnlRevisionExterior.add(pnlFuselaje);

        pnlAlerones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlAlerones.setBackground(Color.WHITE);
        pnlAlerones.setOpaque(false);
        
        lblAlerones = new JLabel("Alerones y superficies de control funcionales");
        lblAlerones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlAlerones.add(lblAlerones);
        
        rbAleronesAplica = new JRadioButton("Aplica");
        rbAleronesAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbAleronesAplica.setBackground(Color.WHITE);
        rbAleronesAplica.setOpaque(false);
        rbAleronesAplica.setFocusPainted(false);
        pnlAlerones.add(rbAleronesAplica);
        
        rbAleronesNoAplica = new JRadioButton("No aplica");
        rbAleronesNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbAleronesNoAplica.setBackground(Color.WHITE);
        rbAleronesNoAplica.setOpaque(false);
        rbAleronesNoAplica.setFocusPainted(false);
        pnlAlerones.add(rbAleronesNoAplica);
        
        grupoAlerones = new ButtonGroup();
        grupoAlerones.add(rbAleronesAplica);
        grupoAlerones.add(rbAleronesNoAplica);
        
        pnlRevisionExterior.add(pnlAlerones);

        pnlTrenAterrizaje = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlTrenAterrizaje.setBackground(Color.WHITE);
        pnlTrenAterrizaje.setOpaque(false);
        
        lblTrenAterrizaje = new JLabel("Tren de aterrizaje sin daños");
        lblTrenAterrizaje.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlTrenAterrizaje.add(lblTrenAterrizaje);
        
        rbTrenAterrizajeAplica = new JRadioButton("Aplica");
        rbTrenAterrizajeAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbTrenAterrizajeAplica.setBackground(Color.WHITE);
        rbTrenAterrizajeAplica.setOpaque(false);
        rbTrenAterrizajeAplica.setFocusPainted(false);
        pnlTrenAterrizaje.add(rbTrenAterrizajeAplica);
        
        rbTrenAterrizajeNoAplica = new JRadioButton("No aplica");
        rbTrenAterrizajeNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbTrenAterrizajeNoAplica.setBackground(Color.WHITE);
        rbTrenAterrizajeNoAplica.setOpaque(false);
        rbTrenAterrizajeNoAplica.setFocusPainted(false);
        pnlTrenAterrizaje.add(rbTrenAterrizajeNoAplica);
        
        grupoTrenAterrizaje = new ButtonGroup();
        grupoTrenAterrizaje.add(rbTrenAterrizajeAplica);
        grupoTrenAterrizaje.add(rbTrenAterrizajeNoAplica);
        
        pnlRevisionExterior.add(pnlTrenAterrizaje);

        pnlLlantas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlLlantas.setBackground(Color.WHITE);
        pnlLlantas.setOpaque(false);
        
        lblLlantas = new JLabel("Llantas con presión y desgaste correctos");
        lblLlantas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlLlantas.add(lblLlantas);
        
        rbLlantasAplica = new JRadioButton("Aplica");
        rbLlantasAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbLlantasAplica.setBackground(Color.WHITE);
        rbLlantasAplica.setOpaque(false);
        rbLlantasAplica.setFocusPainted(false);
        pnlLlantas.add(rbLlantasAplica);
        
        rbLlantasNoAplica = new JRadioButton("No aplica");
        rbLlantasNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbLlantasNoAplica.setBackground(Color.WHITE);
        rbLlantasNoAplica.setOpaque(false);
        rbLlantasNoAplica.setFocusPainted(false);
        pnlLlantas.add(rbLlantasNoAplica);
        
        grupoLlantas = new ButtonGroup();
        grupoLlantas.add(rbLlantasAplica);
        grupoLlantas.add(rbLlantasNoAplica);
        
        pnlRevisionExterior.add(pnlLlantas);

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
        
        pnlMotoresFugas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlMotoresFugas.setBackground(Color.WHITE);
        pnlMotoresFugas.setOpaque(false);
        
        lblMotoresFugas = new JLabel("Motores sin fugas de aceite");
        lblMotoresFugas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlMotoresFugas.add(lblMotoresFugas);
        
        rbMotoresFugasAplica = new JRadioButton("Aplica");
        rbMotoresFugasAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbMotoresFugasAplica.setBackground(Color.WHITE);
        rbMotoresFugasAplica.setOpaque(false);
        rbMotoresFugasAplica.setFocusPainted(false);
        pnlMotoresFugas.add(rbMotoresFugasAplica);
        
        rbMotoresFugasNoAplica = new JRadioButton("No aplica");
        rbMotoresFugasNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbMotoresFugasNoAplica.setBackground(Color.WHITE);
        rbMotoresFugasNoAplica.setOpaque(false);
        rbMotoresFugasNoAplica.setFocusPainted(false);
        pnlMotoresFugas.add(rbMotoresFugasNoAplica);
        
        grupoMotoresFugas = new ButtonGroup();
        grupoMotoresFugas.add(rbMotoresFugasAplica);
        grupoMotoresFugas.add(rbMotoresFugasNoAplica);
        
        pnlSistemasPropulsion.add(pnlMotoresFugas);

        pnlNivelCombustible = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlNivelCombustible.setBackground(Color.WHITE);
        pnlNivelCombustible.setOpaque(false);
        
        lblNivelCombustible = new JLabel("Nivel de combustible verificado y tanqueado");
        lblNivelCombustible.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlNivelCombustible.add(lblNivelCombustible);
        
        rbNivelCombustibleAplica = new JRadioButton("Aplica");
        rbNivelCombustibleAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbNivelCombustibleAplica.setBackground(Color.WHITE);
        rbNivelCombustibleAplica.setOpaque(false);
        rbNivelCombustibleAplica.setFocusPainted(false);
        pnlNivelCombustible.add(rbNivelCombustibleAplica);
        
        rbNivelCombustibleNoAplica = new JRadioButton("No aplica");
        rbNivelCombustibleNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbNivelCombustibleNoAplica.setBackground(Color.WHITE);
        rbNivelCombustibleNoAplica.setOpaque(false);
        rbNivelCombustibleNoAplica.setFocusPainted(false);
        pnlNivelCombustible.add(rbNivelCombustibleNoAplica);
        
        grupoNivelCombustible = new ButtonGroup();
        grupoNivelCombustible.add(rbNivelCombustibleAplica);
        grupoNivelCombustible.add(rbNivelCombustibleNoAplica);
        
        pnlSistemasPropulsion.add(pnlNivelCombustible);

        pnlAspasTurbina = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlAspasTurbina.setBackground(Color.WHITE);
        pnlAspasTurbina.setOpaque(false);
        
        lblAspasTurbina = new JLabel("Aspas de turbina sin daños visuales");
        lblAspasTurbina.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlAspasTurbina.add(lblAspasTurbina);
        
        rbAspasTurbinaAplica = new JRadioButton("Aplica");
        rbAspasTurbinaAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbAspasTurbinaAplica.setBackground(Color.WHITE);
        rbAspasTurbinaAplica.setOpaque(false);
        rbAspasTurbinaAplica.setFocusPainted(false);
        pnlAspasTurbina.add(rbAspasTurbinaAplica);
        
        rbAspasTurbinaNoAplica = new JRadioButton("No aplica");
        rbAspasTurbinaNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbAspasTurbinaNoAplica.setBackground(Color.WHITE);
        rbAspasTurbinaNoAplica.setOpaque(false);
        rbAspasTurbinaNoAplica.setFocusPainted(false);
        pnlAspasTurbina.add(rbAspasTurbinaNoAplica);
        
        grupoAspasTurbina = new ButtonGroup();
        grupoAspasTurbina.add(rbAspasTurbinaAplica);
        grupoAspasTurbina.add(rbAspasTurbinaNoAplica);
        
        pnlSistemasPropulsion.add(pnlAspasTurbina);
        
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
        
        pnlEquipoEmergencia = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlEquipoEmergencia.setBackground(Color.WHITE);
        pnlEquipoEmergencia.setOpaque(false);
        
        lblEquipoEmergencia = new JLabel("Equipo de emergencia a bordo (balsas, chalecos)");
        lblEquipoEmergencia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlEquipoEmergencia.add(lblEquipoEmergencia);
        
        rbEquipoEmergenciaAplica = new JRadioButton("Aplica");
        rbEquipoEmergenciaAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbEquipoEmergenciaAplica.setBackground(Color.WHITE);
        rbEquipoEmergenciaAplica.setOpaque(false);
        rbEquipoEmergenciaAplica.setFocusPainted(false);
        pnlEquipoEmergencia.add(rbEquipoEmergenciaAplica);
        
        rbEquipoEmergenciaNoAplica = new JRadioButton("No aplica");
        rbEquipoEmergenciaNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbEquipoEmergenciaNoAplica.setBackground(Color.WHITE);
        rbEquipoEmergenciaNoAplica.setOpaque(false);
        rbEquipoEmergenciaNoAplica.setFocusPainted(false);
        pnlEquipoEmergencia.add(rbEquipoEmergenciaNoAplica);
        
        grupoEquipoEmergencia = new ButtonGroup();
        grupoEquipoEmergencia.add(rbEquipoEmergenciaAplica);
        grupoEquipoEmergencia.add(rbEquipoEmergenciaNoAplica);
        
        pnlInterioresSeguridad.add(pnlEquipoEmergencia);

        pnlCabinaAsegurada = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlCabinaAsegurada.setBackground(Color.WHITE);
        pnlCabinaAsegurada.setOpaque(false);
        
        lblCabinaAsegurada = new JLabel("Cabina de pasajeros asegurada");
        lblCabinaAsegurada.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlCabinaAsegurada.add(lblCabinaAsegurada);
        
        rbCabinaAseguradaAplica = new JRadioButton("Aplica");
        rbCabinaAseguradaAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbCabinaAseguradaAplica.setBackground(Color.WHITE);
        rbCabinaAseguradaAplica.setOpaque(false);
        rbCabinaAseguradaAplica.setFocusPainted(false);
        pnlCabinaAsegurada.add(rbCabinaAseguradaAplica);
        
        rbCabinaAseguradaNoAplica = new JRadioButton("No aplica");
        rbCabinaAseguradaNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbCabinaAseguradaNoAplica.setBackground(Color.WHITE);
        rbCabinaAseguradaNoAplica.setOpaque(false);
        rbCabinaAseguradaNoAplica.setFocusPainted(false);
        pnlCabinaAsegurada.add(rbCabinaAseguradaNoAplica);
        
        grupoCabinaAsegurada = new ButtonGroup();
        grupoCabinaAsegurada.add(rbCabinaAseguradaAplica);
        grupoCabinaAsegurada.add(rbCabinaAseguradaNoAplica);
        
        pnlInterioresSeguridad.add(pnlCabinaAsegurada);

        pnlCargaAsegurada = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlCargaAsegurada.setBackground(Color.WHITE);
        pnlCargaAsegurada.setOpaque(false);
        
        lblCargaAsegurada = new JLabel("Carga asegurada correctamente");
        lblCargaAsegurada.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlCargaAsegurada.add(lblCargaAsegurada);
        
        rbCargaAseguradaAplica = new JRadioButton("Aplica");
        rbCargaAseguradaAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbCargaAseguradaAplica.setBackground(Color.WHITE);
        rbCargaAseguradaAplica.setOpaque(false);
        rbCargaAseguradaAplica.setFocusPainted(false);
        pnlCargaAsegurada.add(rbCargaAseguradaAplica);
        
        rbCargaAseguradaNoAplica = new JRadioButton("No aplica");
        rbCargaAseguradaNoAplica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbCargaAseguradaNoAplica.setBackground(Color.WHITE);
        rbCargaAseguradaNoAplica.setOpaque(false);
        rbCargaAseguradaNoAplica.setFocusPainted(false);
        pnlCargaAsegurada.add(rbCargaAseguradaNoAplica);
        
        grupoCargaAsegurada = new ButtonGroup();
        grupoCargaAsegurada.add(rbCargaAseguradaAplica);
        grupoCargaAsegurada.add(rbCargaAseguradaNoAplica);
        
        pnlInterioresSeguridad.add(pnlCargaAsegurada);
        
        pnlInterioresSeguridad.add(new JLabel(""));

        panel2.add(pnlInterioresSeguridad);
        panel2.add(Box.createVerticalStrut(20));
        
        pnlDatosFinales = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        pnlDatosFinales.setBackground(Color.WHITE);
        pnlDatosFinales.setOpaque(false);

        // Nombre del Inspector
        blTecnico = new JLabel("Firma del Tecnico:");
        blTecnico.setFont(new Font("Segoe UI", Font.BOLD, 16));
        pnlDatosFinales.add(blTecnico);

        txtFirmaTecnico = new JTextField(20);
        txtFirmaTecnico.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtFirmaTecnico.setPreferredSize(new Dimension(txtFirmaTecnico.getPreferredSize().width, 25));
        txtFirmaTecnico.setEditable(true);
        txtFirmaTecnico.setBackground(Color.WHITE);
        pnlDatosFinales.add(txtFirmaTecnico);
        
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
