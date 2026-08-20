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
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Datos_y_pago_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, contenedor, siguiente_volver, datos, datosTorre1, datosTorre2, medio_pago, panel_precio, panel_desglose;
    private JLabel nombre, apellido, tipoDocumento, numeroDocumento, numeroTelefono, correoElectronico, nacionalidad, sexo, fechaNacimiento, precio,autocompletado ;
    private TitledBorder tituloDatos, tituloPago;
    private String listaDocumento[] = {"","Registro Civil de Nacimiento","Tarjeta de Identidad","Cédula de Ciudadanía",
            "Cédula de Extranjería","Pasaporte Vigente","Permiso por Protección Temporal"},
            listaSexo[] = {"","Masculino","Femenino"}, 
            listaNacionalidad[] = {
                "",
                "Argentino", "Boliviano", "Brasileño",
                "Chileno", "Colombiano", "Costarricense",
                "Cubano", "Dominicano", "Ecuatoriano",
                "Salvadoreño", "Guatemalteco", "Hondureño",
                "Mexicano", "Nicaragüense", "Panameño",
                "Paraguayo", "Peruano", "Puertorriqueño",
                "Uruguayo", "Venezolano"
            };
    public JComboBox listar_documento, listar_sexo, listar_nacionalidad;
    public JButton volver, siguiente, credito, debito, pse,autocompletadobutton;
    public JTextField nombrecampo, apellidocampo, numero_documento, numeroTel, correo, precioTotal;
    public JDateChooser elegir_fecha;
    private SimpleDateFormat formatoFecha;
    
    // Labels del desglose de precio, ubicados justo arriba del total (precioTotal).
    // El controlador (Datos_y_pago_controller) es quien actualiza su texto segun
    // lo que el usuario haya escogido: vuelo, ida/vuelta, clase, equipaje, asientos y tickets.
    public JLabel lblDesglosePrecioVuelo, lblDesgloseMultiplicadorVuelo, lblDesgloseClase,
            lblDesgloseEquipaje, lblDesgloseAsientos, lblDesgloseTickets;
    
    
    public Datos_y_pago_view() {
        
       
        super("Datos Personales");
        
        Font fuenteGrande = new Font("Arial", Font.PLAIN, 18);
        
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
        autocompletado = new JLabel("Auto completar");
        
        //campos y desplegables del formulario de datos
        nombrecampo = new JTextField(12);
        apellidocampo = new JTextField(12);
        numero_documento = new JTextField(12);
        numeroTel = new JTextField(12);
        correo = new JTextField(12);
        precioTotal = new JTextField(12);
        autocompletadobutton = new JButton("Autocompletar");
        
        
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
        

        
        
        //Agregando al contenedor datos las dos torres de datos para unificarlas
        datos.add(datosTorre1);
        datos.add(datosTorre2);

        //Creando botones de pago
        credito = new JButton("Targeta de credito");
        debito = new JButton("Targeta de debito"); 
        pse = new JButton("Transferencia");
        
        
        Dimension tamaño = new Dimension(220, 60);
        
        credito.setPreferredSize(tamaño);
        debito.setPreferredSize(tamaño);
        pse.setPreferredSize(tamaño); 
        
        credito.setFont(fuenteGrande);
        debito.setFont(fuenteGrande);
        pse.setFont(fuenteGrande);
        
        
        precioTotal.setEditable(false);
        precioTotal.setHorizontalAlignment(JTextField.CENTER);
        precioTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        precio.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // --- Panel de desglose del precio, arriba del total ---
        Font fuenteDesglose = new Font("Arial", Font.PLAIN, 13);
        
        panel_desglose = new JPanel();
        panel_desglose.setLayout(new BoxLayout(panel_desglose, BoxLayout.Y_AXIS));
        panel_desglose.setBorder(BorderFactory.createTitledBorder("Desglose del precio"));
        panel_desglose.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblDesglosePrecioVuelo = new JLabel("Precio del vuelo: $0");
        lblDesgloseMultiplicadorVuelo = new JLabel("Ida y vuelta: x2");
        lblDesgloseClase = new JLabel("Clase: -");
        lblDesgloseEquipaje = new JLabel("Equipaje extra: Ninguno");
        lblDesgloseAsientos = new JLabel("Asientos escogidos: Ninguno");
        lblDesgloseTickets = new JLabel("Cantidad de tickets: x1");
        
        JLabel[] labelsDesglose = {lblDesglosePrecioVuelo, lblDesgloseMultiplicadorVuelo, lblDesgloseClase,
            lblDesgloseEquipaje, lblDesgloseAsientos, lblDesgloseTickets};
        
        for (JLabel etiqueta : labelsDesglose) {
            etiqueta.setFont(fuenteDesglose);
            etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel_desglose.add(etiqueta);
        }
        
        panel_precio.add(panel_desglose);
        panel_precio.add(Box.createVerticalStrut(10));
        
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
        
        
        volver = super.volver_2;
        siguiente = super.siguiente;
        
        //Color letras botones
        credito.setForeground(Color.WHITE);
        debito.setForeground(Color.WHITE); 
        pse.setForeground(Color.WHITE);
        
        siguiente.setForeground(Color.WHITE);
        
        //Color botones
        credito.setBackground(Color.decode("#037FB9"));
        debito.setBackground(Color.decode("#037FB9")); 
        pse.setBackground(Color.decode("#037FB9"));
        autocompletadobutton.setBackground(Color.decode("#037FB9"));
        autocompletadobutton.setForeground(Color.white);
        
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
        
        nombre.setFont(fuenteGrande);
        apellido.setFont(fuenteGrande);
        tipoDocumento.setFont(fuenteGrande);
        numeroDocumento.setFont(fuenteGrande);
        numeroTelefono.setFont(fuenteGrande);
        correoElectronico.setFont(fuenteGrande);
        nacionalidad.setFont(fuenteGrande);
        sexo.setFont(fuenteGrande);
        fechaNacimiento.setFont(fuenteGrande);
        precio.setFont(fuenteGrande);
        autocompletado.setFont(fuenteGrande);
        
        nombrecampo.setFont(fuenteGrande);
        apellidocampo.setFont(fuenteGrande);
        numero_documento.setFont(fuenteGrande);
        numeroTel.setFont(fuenteGrande);
        correo.setFont(fuenteGrande);
        precioTotal.setFont(fuenteGrande);
        
        listar_documento.setFont(fuenteGrande);
        listar_sexo.setFont(fuenteGrande);
        listar_nacionalidad.setFont(fuenteGrande);
        elegir_fecha.setFont(fuenteGrande);
        
        
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void setButtonAutoComplete(){
        datosTorre2.add(autocompletado);
        datosTorre2.add(autocompletadobutton);
    }
    
    public void resetButtonAutoComplete(){
        datosTorre2.remove(autocompletado);
        datosTorre2.remove(autocompletadobutton);
    }
    
}
