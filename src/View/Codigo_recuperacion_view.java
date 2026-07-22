/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Nikob
 */

import Controller.Recuperar_contraseña_controller;
import Model.UsuarioDao;
import Model.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Codigo_recuperacion_view extends JFrame {

    Container contenedor;
    JButton b1, btnVolver;
    JPanel mipanel1, mipanel2, mipanel3;
    JLabel logo;
    JLabel titulo;
    JLabel codigo;
    JTextField txCodigo;

    private String correoUsuario;
    private final int MAX_INTENTOS = 3;
    private Recuperar_contraseña_view recuperarView;

    public Codigo_recuperacion_view(String correoUsuario, Recuperar_contraseña_view recuperarView) {

        super("Verificación de Código");
        this.correoUsuario = correoUsuario;
        this.recuperarView = recuperarView;

        contenedor = getContentPane();

        mipanel1 = new JPanel(new BorderLayout());
        mipanel1.setBackground(new Color(3, 127, 185));

        mipanel2 = new JPanel();
        mipanel2.setLayout(new BoxLayout(mipanel2, BoxLayout.Y_AXIS));
        mipanel2.setBackground(Color.WHITE);

        mipanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        mipanel3.setBackground(Color.WHITE);
        mipanel3.setMaximumSize(new Dimension(350, 70));

        titulo = new JLabel("Formulario Verificación de Código");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        codigo = new JLabel("Código de verificación*");

        txCodigo = new JTextField();
        txCodigo.setPreferredSize(new Dimension(350, 25));

        b1 = new JButton("VALIDAR CÓDIGO");
        btnVolver = new JButton("VOLVER");

        ImageIcon imagen = new ImageIcon(
                getClass().getResource("/imagenes/Skylinelogo.png"));

        Image img = imagen.getImage();
        Image imgEscalada = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        logo = new JLabel(new ImageIcon(imgEscalada));

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        mipanel3.add(codigo);
        mipanel3.add(txCodigo);

        mipanel2.add(Box.createVerticalStrut(30));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(15));
        mipanel2.add(titulo);
        mipanel2.add(Box.createVerticalStrut(35));
        mipanel2.add(mipanel3);
        mipanel2.add(Box.createVerticalStrut(35));
        mipanel2.add(b1);

        b1.setBackground(new Color(3, 127, 185));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setMaximumSize(new Dimension(350, 50));

        btnVolver.setBackground(Color.WHITE);
        btnVolver.setForeground(new Color(3, 127, 185));
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
        btnVolver.setPreferredSize(new Dimension(130, 45));

        mipanel2.setPreferredSize(new Dimension(500, 600));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 100));
        panelCentro.setBackground(new Color(3, 127, 185));
        panelCentro.add(mipanel2);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        panelInferior.setBackground(new Color(3, 127, 185));
        panelInferior.add(btnVolver);

        mipanel1.add(panelCentro, BorderLayout.CENTER);
        mipanel1.add(panelInferior, BorderLayout.SOUTH);

        contenedor.add(mipanel1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTextField getTxCodigo() {
        return txCodigo;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public Recuperar_contraseña_view getRecuperarView() {
        return recuperarView;
    }
}