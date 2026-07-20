/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

public class Datos_y_pago_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, contenedor, siguiente_volver, datos, datosTorre1, datosTorre2, medio_pago, panel_precio;
    private JLabel nombre, apellido, tipoDocumento, numeroDocumento, numeroTelefono, correoElectronico, nacionalidad, sexo, fechaNacimiento, precio;
    private TitledBorder tituloDatos, tituloPago;
    private String listaDocumento[] = {"","Registro Civil de Nacimiento","Tarjeta de Identidad","Cédula de Ciudadanía",
            "Cédula de Extranjería","Pasaporte Vigente","Permiso por Protección Temporal"},
            listaSexo[] = {"","Masculino","Femenino"}, 
            listaNacionalidad[] = {"","argentino", "boliviano", "brasileño",
                "chileno", "colombiano", "costarricense",
                "cubano", "dominicano", "ecuatoriano",
                "salvadoreño", "guatemalteco", "hondureño",
                "mexicano", "nicaragüense", "panameño",
                "paraguayo", "peruano", "puertorriqueño",
                "uruguayo", "venezolano"};
    public JComboBox listar_documento, listar_sexo, listar_nacionalidad;
    public JButton volver, siguiente, credito, debito, pse;
    public JTextField nombrecampo, apellidocampo, numero_documento, numeroTel, correo, precioTotal;
    public JDateChooser elegir_fecha;
    private SimpleDateFormat formatoFecha;
    
    
    public Datos_y_pago_view() {
        
       
        super("Datos Personales");
        
        contenedor_principal = super.getPanel2();
        
        //Creando paneles
        contenedor = new JPanel(new BorderLayout());
        datos = new JPanel(new GridLayout(1,2,30,0));
        datosTorre1 = new JPanel(new GridLayout(5,2));
        datosTorre2 = new JPanel(new GridLayout(5,2));
        
        
        Dimension tamanoColumna = new Dimension(450, 180);
        
        datosTorre1.setPreferredSize(tamanoColumna);
        datosTorre1.setMinimumSize(tamanoColumna);
        datosTorre1.setMaximumSize(tamanoColumna);
        
        datosTorre2.setPreferredSize(tamanoColumna);
        datosTorre2.setMinimumSize(tamanoColumna);
        datosTorre2.setMaximumSize(tamanoColumna);
        
        
        medio_pago = new JPanel(new FlowLayout(FlowLayout.CENTER,80,40));
        panel_precio = new JPanel();
        siguiente_volver = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,10));
        
        panel_precio.setLayout(new BoxLayout(panel_precio, BoxLayout.Y_AXIS));
        
        //Titulo en el borde del contenedor
        Font fuenteGrande = new Font("Arial", Font.BOLD, 20); //tipo de letra y tamaño
        tituloDatos = new TitledBorder("Datos Personales");
        tituloDatos.setTitleFont(fuenteGrande);
        
        tituloPago = new TitledBorder("Metodo de pago");
        tituloPago.setTitleFont(fuenteGrande);
        
        datos.setBorder(tituloDatos);
        medio_pago.setBorder(tituloPago);
        
        //Textos del formilario de datos
        nombre = new JLabel("Nombre*");//
        apellido = new JLabel("Apellido*");
        tipoDocumento = new JLabel("Tipo Documento*");
        numeroDocumento = new JLabel("Numero Documento*");
        numeroTelefono = new JLabel("Numero de Celular*");
        correoElectronico = new JLabel("Correo Electronico*");
        nacionalidad = new JLabel("Nacionalidad*");
        sexo = new JLabel("Sexo*");
        fechaNacimiento = new JLabel("Fecha Nacimiento*");
        precio = new JLabel("Precio total");
        
        //campos y desplegables del formulario de datos
        nombrecampo = new JTextField(12);
        apellidocampo = new JTextField(12);
        numero_documento = new JTextField(12);
        numeroTel = new JTextField(12);
        correo = new JTextField(12);
        precioTotal = new JTextField(12);
        
        
        elegir_fecha = new JDateChooser();
        
        formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        
        listar_documento = new JComboBox(listaDocumento);
        listar_sexo = new JComboBox(listaSexo);
        listar_nacionalidad = new JComboBox(listaNacionalidad);
        
        
        
        Component cajaInvisible = Box.createRigidArea(new Dimension(20, 50));
        
        //Agregando al formulario de datos
        datosTorre1.add(nombre);
        datosTorre1.add(nombrecampo);
        datosTorre1.add(apellido);
        datosTorre1.add(apellidocampo);
        datosTorre1.add(tipoDocumento);
        datosTorre1.add(listar_documento);
        datosTorre1.add(numeroDocumento);
        datosTorre1.add(numero_documento);
        datosTorre1.add(numeroTelefono);
        datosTorre1.add(numeroTel); 
        
        datosTorre2.add(correoElectronico);
        datosTorre2.add(correo);
        datosTorre2.add(nacionalidad);
        datosTorre2.add(listar_nacionalidad);
        datosTorre2.add(sexo);
        datosTorre2.add(listar_sexo);
        datosTorre2.add(fechaNacimiento);
        datosTorre2.add(elegir_fecha);
        datosTorre2.add(cajaInvisible);
        datosTorre2.add(cajaInvisible);

        
        
        //Agregando al contenedor datos las dos torres de datos para unificarlas
        datos.add(datosTorre1);
        datos.add(datosTorre2);

        //Creando botones de pago
        credito = new JButton("Targeta de credito");
        debito = new JButton("Targeta de debito"); 
        pse = new JButton("Transferencia");
        
        Dimension tamaño = new Dimension(160, 60);
        
        credito.setPreferredSize(tamaño);
        debito.setPreferredSize(tamaño);
        pse.setPreferredSize(tamaño);  
        
        
        precioTotal.setEditable(false);
        precioTotal.setHorizontalAlignment(JTextField.CENTER);
        precioTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        precio.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel_precio.add(precio);
        panel_precio.add(Box.createVerticalStrut(5));
        panel_precio.add(precioTotal);
        
        medio_pago.add(credito);
        medio_pago.add(debito);
        medio_pago.add(pse);
        medio_pago.add(panel_precio);
        
        credito.setEnabled(false);
        debito.setEnabled(false);
        pse.setEnabled(false);
        
        
        volver = super.getVolver2();
        siguiente = new JButton("Siguiente");
        siguiente.setPreferredSize(new Dimension(120,30)); 
        
        //Color letras botones
        credito.setForeground(Color.WHITE);
        debito.setForeground(Color.WHITE); 
        pse.setForeground(Color.WHITE);
        
        siguiente.setForeground(Color.WHITE);
        
        //Color botones
        credito.setBackground(Color.decode("#037FB9"));
        debito.setBackground(Color.decode("#037FB9")); 
        pse.setBackground(Color.decode("#037FB9"));
        
        siguiente.setBackground(Color.decode("#037FB9"));
        
        
        siguiente_volver.add(volver);
        siguiente_volver.add(siguiente);
        
        siguiente_volver.setPreferredSize(new Dimension(90,40));
        
        contenedor.add(datos, BorderLayout.NORTH);
        contenedor.add(medio_pago, BorderLayout.CENTER);
        contenedor.add(siguiente_volver, BorderLayout.SOUTH);
        
        //Para que el contenedor no ocupe el 100% de la pantalla
        contenedor.setBorder(BorderFactory.createEmptyBorder(7, 45, 20, 45));
        
        contenedor_principal.setLayout(new BorderLayout());
        contenedor_principal.add(contenedor);
        
        
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
