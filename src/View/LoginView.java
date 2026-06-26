/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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



public class LoginView extends JFrame {

    Container contenedor;
    JButton b1, b2;
    JPanel mipanel1, mipanel2, mipanel3;
    JLabel logo, contraseña, correo;
    JTextField txContraseña, txCorreo;

    public LoginView() {

        super("Menu");

        contenedor = getContentPane();

        mipanel1 = new JPanel();
        mipanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

        mipanel2 = new JPanel();
        mipanel2.setLayout(new BoxLayout(mipanel2, BoxLayout.Y_AXIS));

       
        mipanel3 = new JPanel();
        mipanel3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        mipanel3.setBackground(Color.WHITE);
        mipanel3.setMaximumSize(new Dimension(350, 110));

        contraseña = new JLabel("Contraseña*");
        correo = new JLabel("Correo*");

        txContraseña = new JTextField();
        txCorreo = new JTextField();

        b1 = new JButton("INICIAR SESION");
        b2 = new JButton("Recuperar contraseña");

        ImageIcon imagen = new ImageIcon("src/Imagenes/Skylinelogo.jpeg");

        Image img = imagen.getImage();
        Image imgEscalada = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

        logo = new JLabel(new ImageIcon(imgEscalada));

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        txCorreo.setPreferredSize(new Dimension(350, 25));
        txContraseña.setPreferredSize(new Dimension(350, 25));

        
        mipanel3.add(correo);
        mipanel3.add(txCorreo);
        mipanel3.add(contraseña);
        mipanel3.add(txContraseña);

        
        mipanel2.add(Box.createVerticalStrut(40));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(25));
        mipanel2.add(mipanel3);
        mipanel2.add(Box.createVerticalStrut(20));
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

        mipanel2.setBackground(Color.WHITE);
        mipanel1.setBackground(new Color(3, 127, 185));

        mipanel1.add(mipanel2);
        contenedor.add(mipanel1);

        mipanel2.setPreferredSize(new Dimension(500, 600));

        b1.setMaximumSize(new Dimension(350, 50));
        b2.setMaximumSize(new Dimension(350, 50));

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

public JTextField getTxCorreo() {
    return txCorreo;
}

public JTextField getTxContraseña() {
    return txContraseña;
}
}

