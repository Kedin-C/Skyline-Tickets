/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Elegir_clase_view extends Interfaz_vista_abtractas{
    
    private JLabel numeroTickets,aumentaEquipaje,precioEconomica,precioEjecutiva,precioPrimera;
    public JRadioButton economica,ejecutiva,primera;
    public JButton volver,siguiente;
    private JTextArea infoEconomica,infoEjecutiva,infoPrimera;
    private JPanel contenedor_principal,tickets_numero,clases,equipaje,cuadroEconomica,cuadroEjecutiva,cuadroPrimera,siguiente_volver,inferior; 
    private String listaNumeros[] = {"1","2","3","4","5"},
            listaEquipaje[] = {"","15 Kilos $60.000","20 Kilos $80.000","25 Kilos $100.000"};
    public JComboBox listarNumeros,listarEquipaje;
    
    
    
    public Elegir_clase_view() {
        
        
        super("Elegir Clase");
        
        Font fuenteGrande = new Font("Arial", Font.PLAIN, 17);
        
        contenedor_principal = super.getPanel2();
        contenedor_principal.setLayout(new BorderLayout(0,20));
        
        //Campos
        numeroTickets = new JLabel("Numero de tickets");
        aumentaEquipaje = new JLabel("Aumentar equipaje en bodega");
        numeroTickets.setFont(fuenteGrande);
        aumentaEquipaje.setFont(fuenteGrande);
        
        //botones de seleccion
        economica = new JRadioButton("Clase Economica");
        ejecutiva = new JRadioButton("Clase Ejecutiva");
        primera = new JRadioButton("Primera Clase");
        
        //botones normales
        volver = super.volver_2;
        siguiente = super.siguiente;
        
        //Color de las letras
//        volver.setForeground(Color.WHITE);
//        siguiente.setForeground(Color.WHITE);
//        
//        //Color de fondo
//        volver.setBackground(Color.decode("#137FB0"));
//        siguiente.setBackground(Color.decode("#137FB0"));
        
        //informacion de cada clase
        infoEconomica = new JTextArea("\t - Bolso de mano\n"
                + "\t - Asientos cómodos\n"
                + "\t - Sistema de entretenimiento\n");
//                + "\t\t $ 180.000\n");
        infoEjecutiva = new JTextArea("\t - Bolso de mano\n"
                + "\t - Morral\n"
                + "\t - Asientos amplios con mayor espacio\n"
                + "\t - Sistema de entretenimiento\n"
                + "\t - Acceso a salas VIP\n");
//                + "\t\t $ 450.000\n");
        infoPrimera = new JTextArea("\t - Bolso de mano\n"
                + "\t - Morral\n"
                + "\t - Bodega\n"
                + "\t - Asientos completamente convertibles en cama\n"
                + "\t - Sistema de entretenimiento y Wifi\n"
                + "\t - Acceso a salas VIP\n"
                + "\t - Salas VIP premium\n"
                + "\t - Entretenimiento premium y conectividad\n");
//                + "\t\t $ 850.000\n");
        
        economica.setFont(fuenteGrande);
        ejecutiva.setFont(fuenteGrande);
        primera.setFont(fuenteGrande);
        
        //No deja modificar la informacion del JTextArea
        infoEconomica.setEditable(false);
        infoEjecutiva.setEditable(false);
        infoPrimera.setEditable(false);
        
        precioEconomica = new JLabel("$ 180.000", SwingConstants.CENTER);
        precioEjecutiva = new JLabel("$ 450.000", SwingConstants.CENTER);
        precioPrimera = new JLabel("$ 850.000", SwingConstants.CENTER);
        
        Font fuentePrecio = new Font("Arial", Font.BOLD, 20);
        precioEconomica.setFont(fuentePrecio);
        precioEjecutiva.setFont(fuentePrecio);
        precioPrimera.setFont(fuentePrecio);
        
        infoEconomica.setFont(fuenteGrande);
        infoEjecutiva.setFont(fuenteGrande);
        infoPrimera.setFont(fuenteGrande);
        
        //Le da el mismo color del fondo paea que no se vea blanco 
        infoEconomica.setBackground(contenedor_principal.getBackground());
        infoEjecutiva.setBackground(contenedor_principal.getBackground());
        infoPrimera.setBackground(contenedor_principal.getBackground());
        
        //Paneles para agrupar el conenido
        tickets_numero = new JPanel(new FlowLayout(FlowLayout.LEFT,15, 10));
        clases = new JPanel(new GridLayout(1,3,40,40));
        equipaje = new JPanel(new FlowLayout(FlowLayout.LEFT,15, 10));
        inferior = new JPanel(new GridLayout(2,1));
        
        siguiente_volver = new JPanel(new FlowLayout(FlowLayout.RIGHT,15, 10));
        
        //Separacion y ubicacion de los contenedores en la pantalla
        tickets_numero.setBorder(BorderFactory.createEmptyBorder(15, 40, 0, 0));
        equipaje.setBorder(BorderFactory.createEmptyBorder(0, 40, 25, 0));
         
        //Campo desplegable y el tamaño que tendra
        listarNumeros =  new JComboBox(listaNumeros);
        listarNumeros.setPreferredSize(new Dimension(70,30));
        listarEquipaje =  new JComboBox(listaEquipaje);
        listarEquipaje.setPreferredSize(new Dimension(120,30));
        
        //Agregando al panel de elegir numero de tickets
        tickets_numero.add(numeroTickets);
        tickets_numero.add(listarNumeros);
        
        //Cuadrados de info y elegir clases
        cuadroEconomica = new JPanel(new BorderLayout());
        cuadroEjecutiva = new JPanel(new BorderLayout());
        cuadroPrimera = new JPanel(new BorderLayout());
        
        cuadroEconomica.add(precioEconomica, BorderLayout.SOUTH);
        cuadroEjecutiva.add(precioEjecutiva, BorderLayout.SOUTH);
        cuadroPrimera.add(precioPrimera, BorderLayout.SOUTH);
        
        //Agregando los componentes a los 3 cuadros de las clases
        cuadroEconomica.add(economica, BorderLayout.NORTH);
        cuadroEconomica.add(infoEconomica, BorderLayout.CENTER);
        
        cuadroEjecutiva.add(ejecutiva, BorderLayout.NORTH);
        cuadroEjecutiva.add(infoEjecutiva, BorderLayout.CENTER);
        
        cuadroPrimera.add(primera, BorderLayout.NORTH);
        cuadroPrimera.add(infoPrimera, BorderLayout.CENTER);
        
        //centrado los botones
        economica.setHorizontalAlignment(SwingConstants.CENTER);
        ejecutiva.setHorizontalAlignment(SwingConstants.CENTER);
        primera.setHorizontalAlignment(SwingConstants.CENTER);
                
        //Bordes con la linea negra
        Border lineaNegra = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border margenInterno = BorderFactory.createEmptyBorder(15, 15, 30, 15);
        
        Border bordeFinal = BorderFactory.createCompoundBorder(lineaNegra, margenInterno);
        
        cuadroEconomica.setBorder(bordeFinal);
        cuadroEjecutiva.setBorder(bordeFinal);
        cuadroPrimera.setBorder(bordeFinal);
        
        //Agregando los 3 cuadrados a el contenedor de las clases
        clases.add(cuadroEconomica);
        clases.add(cuadroEjecutiva);
        clases.add(cuadroPrimera);
        
        //Agregando los componentes de aumentar equipaje
        equipaje.add(aumentaEquipaje);
        equipaje.add(listarEquipaje);
        
        clases.add(equipaje);

        //Contenedor de los botones volver y siguiente
        siguiente_volver.add(volver);
        siguiente_volver.add(siguiente);
        
        siguiente_volver.setPreferredSize(new Dimension(90,40));
        
        //Uniendo los el contenedor de los botones volver y siguiente y el de aumentar equipaje
        inferior.add(equipaje, new FlowLayout(FlowLayout.LEFT));
        inferior.add(siguiente_volver, new FlowLayout(FlowLayout.RIGHT));
        
        
        //Asignar los componentes de la pagina al para que sean visibles
        contenedor_principal.add(tickets_numero, BorderLayout.NORTH);
        contenedor_principal.add(clases, BorderLayout.CENTER);
        contenedor_principal.add(inferior, BorderLayout.SOUTH);
        
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
}
