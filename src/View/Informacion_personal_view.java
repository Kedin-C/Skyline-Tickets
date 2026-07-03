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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Informacion_personal_view extends Interfaz_vista_abtractas {

    JTextField txtCorreo;
    JTextField txtNombre;
    JTextField txtApellido;

    JButton btnCambiarContrasena;
    JButton btnAceptar;
    JButton btnVolver;

    public Informacion_personal_view() {

        super("Cambiar información personal:");

        JLabel titulo = new JLabel("Cambiar información personal:", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 24));
        titulo.setForeground(Color.WHITE);
        getPanel1().add(titulo, BorderLayout.CENTER);

        JPanel panel2 = getPanel2();
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        panelForm.setBackground(Color.WHITE);
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        JLabel labelCorreo = new JLabel("Correo", SwingConstants.CENTER);
        labelCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelCorreo.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        txtCorreo = new JTextField();
        txtCorreo.setBackground(Color.decode("#D9D9D9"));
        txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtCorreo.setHorizontalAlignment(JTextField.CENTER);
        txtCorreo.setMaximumSize(new Dimension(500, 50));
        txtCorreo.setPreferredSize(new Dimension(500, 50));
        txtCorreo.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        panelForm.add(labelCorreo);
        panelForm.add(txtCorreo);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));

        JLabel labelNombre = new JLabel("Nombre", SwingConstants.CENTER);
        labelNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelNombre.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        txtNombre = new JTextField();
        txtNombre.setBackground(Color.decode("#D9D9D9"));
        txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setMaximumSize(new Dimension(500, 50));
        txtNombre.setPreferredSize(new Dimension(500, 50));
        txtNombre.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        txtNombre.setEditable(false);

        panelForm.add(labelNombre);
        panelForm.add(txtNombre);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));

        JLabel labelApellido = new JLabel("Apellido", SwingConstants.CENTER);
        labelApellido.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelApellido.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        txtApellido = new JTextField();
        txtApellido.setBackground(Color.decode("#D9D9D9"));
        txtApellido.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtApellido.setHorizontalAlignment(JTextField.CENTER);
        txtApellido.setMaximumSize(new Dimension(500, 50));
        txtApellido.setPreferredSize(new Dimension(500, 50));
        txtApellido.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        txtApellido.setEditable(false);

        panelForm.add(labelApellido);
        panelForm.add(txtApellido);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));

        btnCambiarContrasena = new JButton("Cambiar contraseña");
        btnCambiarContrasena.setBackground(Color.decode("#037FB9"));
        btnCambiarContrasena.setForeground(Color.WHITE);
        btnCambiarContrasena.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCambiarContrasena.setPreferredSize(new Dimension(300, 50));
        btnCambiarContrasena.setAlignmentX(JButton.CENTER_ALIGNMENT);

        panelForm.add(btnCambiarContrasena);

        JPanel panelCentrado = new JPanel(new GridBagLayout());
        panelCentrado.setBackground(Color.WHITE);
        panelCentrado.add(panelForm);

        panel2.add(panelCentrado, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        panelBotones.setBackground(Color.WHITE);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.decode("#037FB9"));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnAceptar.setPreferredSize(new Dimension(160, 55));

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(Color.decode("#037FB9"));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnVolver.setPreferredSize(new Dimension(160, 55));

        panelBotones.add(btnAceptar);
        panelBotones.add(btnVolver);

        panel2.add(panelBotones, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JButton getBtnCambiarContrasena() {
        return btnCambiarContrasena;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
