/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Nikob
 */

import Controller.Login_controller;
import Controller.Registro_controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu_principal_view extends JFrame implements ActionListener {

    Container contenedor;
    JButton b1, b2, btnVolver;
    JPanel mipanel1, mipanel2;
    JLabel logo;

    public Menu_principal_view() {

        super("Menu");

        contenedor = getContentPane();

        
        mipanel1 = new JPanel(new BorderLayout());
        mipanel1.setBackground(new Color(3, 127, 185));

        
        mipanel2 = new JPanel();
        mipanel2.setLayout(new BoxLayout(mipanel2, BoxLayout.Y_AXIS));
        mipanel2.setBackground(Color.WHITE);

        b1 = new JButton("INICIAR SESION");
        b2 = new JButton("REGISTRARSE");
        btnVolver = new JButton("VOLVER");

        ImageIcon imagen = new ImageIcon(
                getClass().getResource("/imagenes/Skylinelogo.png"));

        Image img = imagen.getImage();
        Image imgEscalada = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        logo = new JLabel(new ImageIcon(imgEscalada));

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(this);
        b2.addActionListener(this);
        btnVolver.addActionListener(this);

        mipanel2.add(Box.createVerticalStrut(40));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(50));
        mipanel2.add(b1);
        mipanel2.add(Box.createVerticalStrut(25));
        mipanel2.add(b2);

        b1.setBackground(new Color(3, 127, 185));
        b2.setBackground(new Color(3, 127, 185));

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);

        b1.setFocusPainted(false);
        b2.setFocusPainted(false);

        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setFont(new Font("Arial", Font.BOLD, 16));

        btnVolver.setBackground(Color.WHITE);
        btnVolver.setForeground(new Color(3, 127, 185));
        btnVolver.setFocusPainted(false);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
        btnVolver.setPreferredSize(new Dimension(130, 45));

        mipanel2.setPreferredSize(new Dimension(500, 600));

        b1.setMaximumSize(new Dimension(350, 50));
        b2.setMaximumSize(new Dimension(350, 50));

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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            dispose();

            Login_view login = new Login_view();
            new Login_controller(login);
        }

        if (e.getSource() == b2) {
            dispose();

            Registro_view registro = new Registro_view();
            new Registro_controller(registro);
        }

        if (e.getSource() == btnVolver) {
            dispose();
            ViewPrincipal principal = new ViewPrincipal();
            
        }
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}