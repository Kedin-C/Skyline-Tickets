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
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EmptyBorder;

public class Informacion_personal_view extends Interfaz_vista_abtractas {

    private static final String[] NACIONALIDADES = {
        "Seleccionar", "Argentino", "Boliviano", "Brasileño",
        "Chileno", "Colombiano", "Costarricense",
        "Cubano", "Dominicano", "Ecuatoriano",
        "Salvadoreño", "Guatemalteco", "Hondureño",
        "Mexicano", "Nicaragüense", "Panameño",
        "Paraguayo", "Peruano", "Puertorriqueño",
        "Uruguayo", "Venezolano"
    };

    public JTextField txtCorreo, txtApellido, txtNombre, txtDocumento, txtTelefono;
    public JComboBox<String> cbSexo;
    public JComboBox<String> cbNacionalidad;
    public JDateChooser dcFechaNacimiento;
    public JButton btnCambiarContrasena, btnVolver, btnAceptar;

    public Informacion_personal_view() {

        super("Cambiar información personal:");

        JLabel titulo = new JLabel("Cambiar información personal:", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 24));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(new EmptyBorder(0,0,0,180));
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

        
        JLabel labelDocumento = new JLabel("Número de documento", SwingConstants.CENTER);
        labelDocumento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelDocumento.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        txtDocumento = new JTextField();
        txtDocumento.setBackground(Color.decode("#D9D9D9"));
        txtDocumento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtDocumento.setHorizontalAlignment(JTextField.CENTER);
        txtDocumento.setMaximumSize(new Dimension(500, 50));
        txtDocumento.setPreferredSize(new Dimension(500, 50));
        txtDocumento.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        txtDocumento.setEditable(false);

        panelForm.add(labelDocumento);
        panelForm.add(txtDocumento);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));

        
        JLabel labelSexo = new JLabel("Sexo", SwingConstants.CENTER);
        labelSexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelSexo.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        cbSexo = new JComboBox<>(new String[]{"Seleccionar", "Masculino", "Femenino"});
        cbSexo.setBackground(Color.decode("#D9D9D9"));
        cbSexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        cbSexo.setMaximumSize(new Dimension(500, 50));
        cbSexo.setPreferredSize(new Dimension(500, 50));
        cbSexo.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        panelForm.add(labelSexo);
        panelForm.add(cbSexo);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));


        JLabel labelFechaNacimiento = new JLabel("Fecha de nacimiento", SwingConstants.CENTER);
        labelFechaNacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelFechaNacimiento.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        dcFechaNacimiento = new JDateChooser();
        dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        dcFechaNacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        dcFechaNacimiento.setMaximumSize(new Dimension(500, 50));
        dcFechaNacimiento.setPreferredSize(new Dimension(500, 50));
        dcFechaNacimiento.setAlignmentX(JDateChooser.CENTER_ALIGNMENT);

        // Edad permitida: mínimo 16 años, máximo 117 años
        Calendar calFechaMasReciente = Calendar.getInstance();
        calFechaMasReciente.add(Calendar.YEAR, -16);
        Date fechaMasReciente = calFechaMasReciente.getTime();

        Calendar calFechaMasAntigua = Calendar.getInstance();
        calFechaMasAntigua.add(Calendar.YEAR, -117);
        Date fechaMasAntigua = calFechaMasAntigua.getTime();

        dcFechaNacimiento.setMaxSelectableDate(fechaMasReciente);
        dcFechaNacimiento.setMinSelectableDate(fechaMasAntigua);

        panelForm.add(labelFechaNacimiento);
        panelForm.add(dcFechaNacimiento);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));


        JLabel labelNacionalidad = new JLabel("Nacionalidad", SwingConstants.CENTER);
        labelNacionalidad.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelNacionalidad.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        cbNacionalidad = new JComboBox<>(NACIONALIDADES);
        cbNacionalidad.setBackground(Color.decode("#D9D9D9"));
        cbNacionalidad.setFont(new Font("SansSerif", Font.PLAIN, 18));
        cbNacionalidad.setMaximumSize(new Dimension(500, 50));
        cbNacionalidad.setPreferredSize(new Dimension(500, 50));
        cbNacionalidad.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        panelForm.add(labelNacionalidad);
        panelForm.add(cbNacionalidad);
        panelForm.add(javax.swing.Box.createVerticalStrut(25));

        
        JLabel labelTelefono = new JLabel("Número de teléfono", SwingConstants.CENTER);
        labelTelefono.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelTelefono.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        txtTelefono = new JTextField();
        txtTelefono.setBackground(Color.decode("#D9D9D9"));
        txtTelefono.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtTelefono.setHorizontalAlignment(JTextField.CENTER);
        txtTelefono.setMaximumSize(new Dimension(500, 50));
        txtTelefono.setPreferredSize(new Dimension(500, 50));
        txtTelefono.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        panelForm.add(labelTelefono);
        panelForm.add(txtTelefono);
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
        btnAceptar.setPreferredSize(new Dimension(120,30));

        btnVolver = super.volver_2;

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

    public JTextField getTxtDocumento() {
        return txtDocumento;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JComboBox<String> getCbSexo() {
        return cbSexo;
    }

    public JComboBox<String> getCbNacionalidad() {
        return cbNacionalidad;
    }

    public JDateChooser getDcFechaNacimiento() {
        return dcFechaNacimiento;
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