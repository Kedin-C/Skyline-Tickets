/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Nikob
 */
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

public class Registro_view extends JFrame {

    Container contenedor;
    JButton b1, btnVolver;
    JPanel mipanel1, mipanel2, mipanel3;
    JLabel logo;
    JLabel jnombre, japellido, jcorreo, jcontraseña, jconfirmar;
    JTextField txNombre, txApellido, txCorreo, txContraseña, txConfirmar;

    public Registro_view() {

        super("Registro");

        contenedor = getContentPane();

        mipanel1 = new JPanel(new BorderLayout());
        mipanel1.setBackground(new Color(3, 127, 185));

        mipanel2 = new JPanel();
        mipanel2.setLayout(new BoxLayout(mipanel2, BoxLayout.Y_AXIS));
        mipanel2.setBackground(Color.WHITE);

        mipanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        mipanel3.setBackground(Color.WHITE);
        mipanel3.setMaximumSize(new Dimension(350, 260));

        jnombre = new JLabel("Nombre*");
        japellido = new JLabel("Apellido*");
        jcorreo = new JLabel("Correo*");
        jcontraseña = new JLabel("Contraseña*");
        jconfirmar = new JLabel("Confirmar contraseña*");

        txNombre = new JTextField();
        txApellido = new JTextField();
        txCorreo = new JTextField();
        txContraseña = new JTextField();
        txConfirmar = new JTextField();

        txNombre.setPreferredSize(new Dimension(350, 25));
        txApellido.setPreferredSize(new Dimension(350, 25));
        txCorreo.setPreferredSize(new Dimension(350, 25));
        txContraseña.setPreferredSize(new Dimension(350, 25));
        txConfirmar.setPreferredSize(new Dimension(350, 25));

        b1 = new JButton("REGISTRARSE");
        btnVolver = new JButton("VOLVER");

        ImageIcon imagen = new ImageIcon(
                getClass().getResource("/imagenes/Skylinelogo.png"));

        Image img = imagen.getImage();
        Image imgEscalada = img.getScaledInstance(220, 220, Image.SCALE_SMOOTH);

        logo = new JLabel(new ImageIcon(imgEscalada));

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        mipanel3.add(jnombre);
        mipanel3.add(txNombre);

        mipanel3.add(japellido);
        mipanel3.add(txApellido);

        mipanel3.add(jcorreo);
        mipanel3.add(txCorreo);

        mipanel3.add(jcontraseña);
        mipanel3.add(txContraseña);

        mipanel3.add(jconfirmar);
        mipanel3.add(txConfirmar);

        mipanel2.add(Box.createVerticalStrut(25));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(10));
        mipanel2.add(mipanel3);
        mipanel2.add(Box.createVerticalStrut(15));
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

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        panelInferior.setBackground(new Color(3, 127, 185));
        panelInferior.add(btnVolver);

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 70));
        panelCentro.setBackground(new Color(3, 127, 185));
        panelCentro.add(mipanel2);

        mipanel2.setPreferredSize(new Dimension(500, 600));

        mipanel1.add(panelCentro, BorderLayout.CENTER);
        mipanel1.add(panelInferior, BorderLayout.SOUTH);

        contenedor.add(mipanel1);

       
        
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTextField getTxNombre() {
        return txNombre;
    }

    public JTextField getTxApellido() {
        return txApellido;
    }

    public JTextField getTxCorreo() {
        return txCorreo;
    }

    public JTextField getTxContraseña() {
        return txContraseña;
    }

    public JTextField getTxConfirmar() {
        return txConfirmar;
    }
}