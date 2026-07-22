/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author juans
 */
public class Confirmar_pago_view extends Interfaz_vista_abtractas{
    
    public Container contenedor;
    public JPanel panel1,panel2,panelFlechas,panelMensaje,panelVuelo,panelOrigen,panelDestino,
            panelDatoslblNumeroTicket,panelCentro,panelWrapperCentro,panelInferior,panelDatos;
    public JLabel lblMensaje,lblOrigen,lblDestino,lblNombrePasajero,lblReferenciaPago,lblFlechaIda,
            lblFlechaVuelta,lblNumeroTicket;

    public Confirmar_pago_view() {
        super("MENSAJE PAGO EXITOSO");

        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();

        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new EmptyBorder(30, 40, 30, 40));

        // Mensaje de exito arriba
        panelMensaje = new JPanel(new BorderLayout());
        panelMensaje.setBackground(new Color(30, 115, 190));
        panelMensaje.setBorder(new EmptyBorder(15, 20, 15, 20));

        lblMensaje = new JLabel("SE HA REALIZADO CON EXITO EL PAGO DEL VUELO", SwingConstants.CENTER);
        lblMensaje.setForeground(Color.WHITE);
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
        panelMensaje.add(lblMensaje, BorderLayout.CENTER);

        // Cajas de origen y destino
        panelVuelo = new JPanel(new GridBagLayout());
        panelVuelo.setBackground(Color.WHITE);

        panelOrigen = new JPanel(new GridBagLayout());
        panelOrigen.setBackground(new Color(217, 217, 217));
        panelOrigen.setPreferredSize(new Dimension(180, 60));
        lblOrigen = new JLabel("BOGOTA");
        lblOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
        panelOrigen.add(lblOrigen);

        panelDestino = new JPanel(new GridBagLayout());
        panelDestino.setBackground(new Color(217, 217, 217));
        panelDestino.setPreferredSize(new Dimension(180, 60));
        lblDestino = new JLabel("MEDELLIN");
        lblDestino.setFont(new Font("Arial", Font.PLAIN, 14));
        panelDestino.add(lblDestino);

        panelFlechas = new JPanel();
        panelFlechas.setLayout(new BoxLayout(panelFlechas, BoxLayout.Y_AXIS));
        panelFlechas.setBackground(Color.WHITE);
        panelFlechas.setBorder(new EmptyBorder(0, 25, 0, 25));

        lblFlechaIda = new JLabel("\u2192");
        lblFlechaIda.setFont(new Font("Arial", Font.BOLD, 18));
        lblFlechaIda.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblFlechaVuelta = new JLabel("\u2190");
        lblFlechaVuelta.setFont(new Font("Arial", Font.BOLD, 18));
        lblFlechaVuelta.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFlechaVuelta.setVisible(false);

        panelFlechas.add(lblFlechaIda);
        panelFlechas.add(lblFlechaVuelta);

        GridBagConstraints gbcVuelo = new GridBagConstraints();
        gbcVuelo.gridy = 0;
        gbcVuelo.gridx = 0;
        panelVuelo.add(panelOrigen, gbcVuelo);
        gbcVuelo.gridx = 1;
        panelVuelo.add(panelFlechas, gbcVuelo);
        gbcVuelo.gridx = 2;
        panelVuelo.add(panelDestino, gbcVuelo);

        // Datos del ticket
        panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBackground(Color.WHITE);

        lblNumeroTicket = new JLabel("NUMERO DE TICKET: XXXXXXXXXX", SwingConstants.CENTER);
        lblNumeroTicket.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNumeroTicket.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblNombrePasajero = new JLabel("NOMBRE DEL PASAJERO: @NOMBRE USUARIO", SwingConstants.CENTER);
        lblNombrePasajero.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNombrePasajero.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblReferenciaPago = new JLabel("REFERENCIA DE PAGO: XXXXXXXXXXXXX", SwingConstants.CENTER);
        lblReferenciaPago.setFont(new Font("Arial", Font.PLAIN, 14));
        lblReferenciaPago.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDatos.add(lblNumeroTicket);
        panelDatos.add(Box.createVerticalStrut(10));
        panelDatos.add(lblNombrePasajero);
        panelDatos.add(Box.createVerticalStrut(10));
        panelDatos.add(lblReferenciaPago);

        // Junta vuelo y datos en un solo bloque
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(Color.WHITE);
        panelVuelo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(panelVuelo);
        panelCentro.add(Box.createVerticalStrut(20));
        panelCentro.add(panelDatos);

        // Centra el bloque sin que se estire
        panelWrapperCentro = new JPanel(new GridBagLayout());
        panelWrapperCentro.setBackground(Color.WHITE);
        panelWrapperCentro.add(panelCentro, new GridBagConstraints());

        panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.setBackground(Color.WHITE);
//        panelInferior.add(btnVolver);

        // Se agrega todo a panel2
        panel2.add(panelMensaje, BorderLayout.NORTH);
        panel2.add(panelWrapperCentro, BorderLayout.CENTER);
        panel2.add(panelInferior, BorderLayout.SOUTH);
    }
    
}
