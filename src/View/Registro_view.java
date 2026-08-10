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
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registro_view extends JFrame {

    private Container contenedor;
    public JButton b1, btnVolver;
    public JPanel mipanel1, mipanel2, mipanel3;
    public JLabel jnombre, japellido, jcorreo, jcontraseña, jconfirmar,logo, jdocumento, jmicombo;
    public JTextField txNombre, txApellido, txCorreo, ndocumento;
    public JPasswordField txContraseña, txConfirmar;
    public JComboBox micombo;

    private JButton btnVerContraseña, btnVerConfirmar;

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
        mipanel3.setMaximumSize(new Dimension(380, 370));

        jnombre = new JLabel("Nombre*");
        japellido = new JLabel("Apellido*");
        jcorreo = new JLabel("Correo*");
        jmicombo = new JLabel("Tipo Documento*");
        jdocumento = new JLabel("Numero documento*");
        jcontraseña = new JLabel("Contraseña*");
        jconfirmar = new JLabel("Confirmar contraseña*");

        txNombre = new JTextField();
        txApellido = new JTextField();
        txCorreo = new JTextField();
        ndocumento = new JTextField();
        txContraseña = new JPasswordField();
        txConfirmar = new JPasswordField();
        micombo = new JComboBox();
        
        micombo.addItem("Registro Civil de Nacimiento");
        micombo.addItem("Tarjeta de Identidad ");
        micombo.addItem("Cedula de ciudadania");
        micombo.addItem("Cedula de extranjeria");
        micombo.addItem("Pasaporte vigente");
        micombo.addItem("Permiso por proteccion temporal");

        txNombre.setPreferredSize(new Dimension(350, 25));
        txApellido.setPreferredSize(new Dimension(350, 25));
        txCorreo.setPreferredSize(new Dimension(350, 25));
        txContraseña.setPreferredSize(new Dimension(300, 25));
        txConfirmar.setPreferredSize(new Dimension(300, 25));
        ndocumento.setPreferredSize(new Dimension(350, 25));
        micombo.setPreferredSize(new Dimension(350, 25));

        
        btnVerContraseña = new JButton("Ver");
        btnVerContraseña.setPreferredSize(new Dimension(60, 25));
        btnVerContraseña.setMargin(new Insets(0, 0, 0, 0));
        btnVerContraseña.setFocusPainted(false);
        btnVerContraseña.setFont(new Font("Arial", Font.PLAIN, 11));

        btnVerConfirmar = new JButton("Ver");
        btnVerConfirmar.setPreferredSize(new Dimension(60, 25));
        btnVerConfirmar.setMargin(new Insets(0, 0, 0, 0));
        btnVerConfirmar.setFocusPainted(false);
        btnVerConfirmar.setFont(new Font("Arial", Font.PLAIN, 11));

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
        
        mipanel3.add(jmicombo);
        mipanel3.add(micombo);
        
        mipanel3.add(jdocumento);
        mipanel3.add(ndocumento);
        

        mipanel3.add(jcontraseña);
        mipanel3.add(crearPanelConToggle(txContraseña, btnVerContraseña));

        mipanel3.add(jconfirmar);
        mipanel3.add(crearPanelConToggle(txConfirmar, btnVerConfirmar));

        mipanel2.add(Box.createVerticalStrut(10));
        mipanel2.add(logo);
        mipanel2.add(Box.createVerticalStrut(5));
        mipanel2.add(mipanel3);
        mipanel2.add(Box.createVerticalStrut(10));
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

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelCentro.setBackground(new Color(3, 127, 185));
        panelCentro.add(mipanel2);

        mipanel2.setPreferredSize(new Dimension(500, 2000));

        mipanel1.add(panelCentro, BorderLayout.CENTER);
        mipanel1.add(panelInferior, BorderLayout.SOUTH);

        contenedor.add(mipanel1);

       
        
    }

    
    private JPanel crearPanelConToggle(JPasswordField campo, JButton boton) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.setBackground(Color.WHITE);
        panel.add(campo);
        panel.add(boton);
        return panel;
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

    public JPasswordField getTxContraseña() {
        return txContraseña;
    }

    public JPasswordField getTxConfirmar() {
        return txConfirmar;
    }
    
    public JTextField getNdocumento() {
    return ndocumento;
    }

    public JComboBox getMicombo() {
        return micombo;
    }

    public JButton getBtnVerContraseña() {
        return btnVerContraseña;
    }

    public JButton getBtnVerConfirmar() {
        return btnVerConfirmar;
    }

    
    public int getCodigoTipoDocumentoSeleccionado() {
        return micombo.getSelectedIndex() + 1;
    }
}