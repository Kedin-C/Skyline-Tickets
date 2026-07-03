/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Nikob
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nueva_contraseña_view extends JFrame {

    Container contenedor;
    JButton b1, b2;
    JPanel mipanel1, mipanel2, mipanel3;
    JLabel logo, lblTitulo, lblNueva, lblConfirmar;
    JTextField txNuevaContraseña, txConfirmarContraseña;

    public Nueva_contraseña_view() {
        super("Cambio de contraseña");
        contenedor = getContentPane();

        
        mipanel1 = new JPanel();
        mipanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        mipanel1.setBackground(new Color(3, 127, 185));

     
        mipanel2 = new JPanel();
        mipanel2.setLayout(new BoxLayout(mipanel2, BoxLayout.Y_AXIS));
        mipanel2.setBackground(Color.WHITE);
        mipanel2.setPreferredSize(new Dimension(500, 580));

        
        mipanel3 = new JPanel();
        mipanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        mipanel3.setBackground(Color.WHITE);
        mipanel3.setMaximumSize(new Dimension(350, 130));

        
        ImageIcon imagen = new ImageIcon(getClass()
                .getResource("/imagenes/Skylinelogo.png"));
        Image img = imagen.getImage();
        Image imgEscalada = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logo = new JLabel(new ImageIcon(imgEscalada));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        lblTitulo = new JLabel("Cambio de contraseña:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        lblNueva = new JLabel("Nueva contraseña*");
        lblNueva.setFont(new Font("Arial", Font.BOLD, 14));

        lblConfirmar = new JLabel("Confirmar contraseña*");
        lblConfirmar.setFont(new Font("Arial", Font.BOLD, 14));

        
        txNuevaContraseña = new JTextField();
        txNuevaContraseña.setPreferredSize(new Dimension(350, 30));

        txConfirmarContraseña = new JTextField();
        txConfirmarContraseña.setPreferredSize(new Dimension(350, 30));

        
        b1 = new JButton("Confirmar");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setMaximumSize(new Dimension(350, 50));
        b1.setBackground(new Color(3, 127, 185));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setFont(new Font("Arial", Font.BOLD, 16));

        b2 = new JButton("Volver");
        b2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        b2.setMaximumSize(new Dimension(120, 40));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setFocusPainted(false);
        b2.setFont(new Font("Arial", Font.BOLD, 14));

        
        mipanel3.add(lblNueva);
        mipanel3.add(txNuevaContraseña);
        mipanel3.add(Box.createVerticalStrut(8));
        mipanel3.add(lblConfirmar);
        mipanel3.add(txConfirmarContraseña);

        
        mipanel2.add(Box.createVerticalStrut(30));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(10));
        mipanel2.add(lblTitulo);
        mipanel2.add(Box.createVerticalStrut(25));
        mipanel2.add(mipanel3);
        mipanel2.add(Box.createVerticalStrut(30));
        mipanel2.add(b1);
        mipanel2.add(Box.createVerticalStrut(15));
        mipanel2.add(b2);

        mipanel1.add(mipanel2);
        contenedor.add(mipanel1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

     
    
    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JTextField getTxNuevaContraseña() {
        return txNuevaContraseña;
    }

    public JTextField getTxConfirmarContraseña() {
        return txConfirmarContraseña;
    }
}