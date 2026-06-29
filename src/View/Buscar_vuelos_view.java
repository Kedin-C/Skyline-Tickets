/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets.view;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import skyline_tickets.controller.Buscar_vuelos_controller;

public class Buscar_vuelos_view extends Interfaz_vista_abtractas{
    // Declaracion de objetos y variables
    private JLabel lugar_origen,lugar_destino,fecha_ida,fecha_regreso,horario;
            private String lista_origen[]={"",
                "Ciudad de México", "Guadalajara", "Monterrey",
                "Cancún", "Tijuana", "Mérida",
                "Puerto Vallarta", "Bogotá", "Medellín",
                "Cali", "Cartagena", "Barranquilla",
                "Santa Marta", "Pereira", "Bucaramanga",
                "Quito", "Guayaquil", "Cuenca",
                "Lima", "Cusco", "Arequipa",
                "Trujillo", "Santiago", "Antofagasta",
                "Concepción", "Puerto Montt", "Buenos Aires",
                "Córdoba", "Rosario", "Mendoza",
                "Bariloche", "São Paulo", "Rio de Janeiro",
                "Brasilia", "Salvador", "Recife",
                "Fortaleza", "Curitiba", "Belo Horizonte",
                "Montevideo", "Punta del Este", "Asunción",
                "Ciudad del Este", "La Paz", "Santa Cruz de la Sierra",
                "Cochabamba", "Caracas", "Maracaibo",
                "Valencia", "Barquisimeto", "Ciudad de Panamá",
                "David", "San José", "Liberia",
                "Guatemala City", "Flores", "San Salvador",
                "Tegucigalpa", "San Pedro Sula", "Managua",
                "Santo Domingo", "Punta Cana", "Santiago de los Caballeros",
                "San Juan", "Kingston", "Belice"},
            lista_destino[] = {"",
                "Ciudad de México", "Guadalajara", "Monterrey",
                "Cancún", "Tijuana", "Mérida",
                "Puerto Vallarta", "Bogotá", "Medellín",
                "Cali", "Cartagena", "Barranquilla",
                "Santa Marta", "Pereira", "Bucaramanga",
                "Quito", "Guayaquil", "Cuenca",
                "Lima", "Cusco", "Arequipa",
                "Trujillo", "Santiago", "Antofagasta",
                "Concepción", "Puerto Montt", "Buenos Aires",
                "Córdoba", "Rosario", "Mendoza",
                "Bariloche", "São Paulo", "Rio de Janeiro",
                "Brasilia", "Salvador", "Recife",
                "Fortaleza", "Curitiba", "Belo Horizonte",
                "Montevideo", "Punta del Este", "Asunción",
                "Ciudad del Este", "La Paz", "Santa Cruz de la Sierra",
                "Cochabamba", "Caracas", "Maracaibo",
                "Valencia", "Barquisimeto", "Ciudad de Panamá",
                "David", "San José", "Liberia",
                "Guatemala City", "Flores", "San Salvador",
                "Tegucigalpa", "San Pedro Sula", "Managua",
                "Santo Domingo", "Punta Cana", "Santiago de los Caballeros",
                "San Juan", "Kingston", "Belice"},
            
            lista_horario[]={"", 
                "00:00:00 - 03:00:00", "03:00:00 - 06:00:00", "06:00:00 - 09:00:00",
                "09:00:00 - 12:00:00", "12:00:00 - 15:00:00", "15:00:00 - 18:00:00",
                "18:00:00 - 21:00:00", "21:00:00 - 00:00:00"};
    private String[] columnas;
    private ArrayList<Object[]> datos;
    public JRadioButton vuelo_ida,vuelo_regreso;
    public JButton buscar_vuelos,volver,siguiente;
    public JComboBox listar_origen,listar_destino,listar_horario;
    public JDateChooser elegir_fecha_ida,elegir_fecha_regreso;
    private SimpleDateFormat formatoFecha;
    private JPanel origen_destino,vueloIda_vueloRegreso,fechas,buscar,contenido,tablero_datos,siguiente_volver,contenedor_principal,contenedor;
    private JScrollPane scroll;
    public JTable tabla;
    public DefaultTableModel modelo;
    
    
    public Buscar_vuelos_view(){
        
        String nombrepagina = "Buscar Vuelos";
        super(nombrepagina);
        contenedor_principal = super.getPanel2();
        contenedor = new JPanel(new BorderLayout(0, 10));
        
        //Crear paneles para agrupar los objetos
        origen_destino = new JPanel();
        vueloIda_vueloRegreso = new JPanel();
        fechas = new JPanel();
        buscar = new JPanel();
        tablero_datos = new JPanel(new GridLayout(2,1));
        tablero_datos.setLayout(new BorderLayout());
        siguiente_volver = new JPanel(new FlowLayout(FlowLayout.RIGHT,15, 10));
        
        
        //Crear textos
        lugar_origen = new JLabel("Lugar de origen*");
        lugar_destino = new JLabel("Lugar de destino*");
        fecha_ida = new JLabel("Fecha de ida*");
        fecha_regreso = new JLabel("Fecha de regreso*");
        horario = new JLabel("Elegir horario");
        
        //Crear botones
        vuelo_ida = new JRadioButton("Vuelo de ida");
        vuelo_regreso = new JRadioButton("Vuelo de ida y vuelta");
        buscar_vuelos = new JButton("Buscar vuelo");
        
        volver = new JButton("Volver");
        siguiente = new JButton("Siguiente");
        
        //Color letras botones
        buscar_vuelos.setForeground(Color.WHITE);
        volver.setForeground(Color.WHITE);
        siguiente.setForeground(Color.WHITE);
        
        //Color botones
        buscar_vuelos.setBackground(Color.decode("#037FB9"));
        volver.setBackground(Color.decode("#037FB9"));
        siguiente.setBackground(Color.decode("#037FB9"));
        
        
        //Organisar los botones en grupos y campos en grupos
        origen_destino.setLayout(new GridLayout(1,4,10,10));
        vueloIda_vueloRegreso.setLayout(new GridLayout(1,2,10,10));
        fechas.setLayout(new GridLayout(1,4,10,10));
        buscar.setLayout(new GridLayout(1,3,10,10));
        
        
        
        //campos desplegables y campos de fechas
        listar_origen = new JComboBox(lista_origen);
        listar_destino = new JComboBox(lista_destino);
        listar_horario = new JComboBox(lista_horario);
        
        elegir_fecha_ida = new JDateChooser();
        elegir_fecha_regreso = new JDateChooser();
        
        elegir_fecha_ida.setDateFormatString("yyyy-MM-dd");
        elegir_fecha_regreso.setDateFormatString("yyyy-MM-dd");
        
        origen_destino.add(lugar_origen);
        origen_destino.add(listar_origen);
        origen_destino.add(lugar_destino);
        origen_destino.add(listar_destino);
        
        vueloIda_vueloRegreso.add(vuelo_ida);
        vueloIda_vueloRegreso.add(vuelo_regreso);
        
        fechas.add(fecha_ida);
        fechas.add(elegir_fecha_ida);
        fechas.add(fecha_regreso);
        fechas.add(elegir_fecha_regreso);
//        
        Component cajaInvisible = Box.createRigidArea(new Dimension(20, 50));
        
        buscar.add(horario);
        buscar.add(listar_horario);
        buscar.add(cajaInvisible);
        buscar.add(buscar_vuelos);
        
        siguiente_volver.add(volver);
        siguiente_volver.add(siguiente);
        
        //Tamaño del contenedor
        siguiente_volver.setPreferredSize(new Dimension(90,40));
        
        //Columnas del buscador
        columnas = new String[7];
        columnas[0] = "ID";
        columnas[1] = "Origen";
        columnas[2] = "Destino";
        columnas[3] = "Fecha";
        columnas[4] = "Hora salida";
        columnas[5] = "Hora llegada";
        columnas[6] = "Precio";
        
        datos = new ArrayList<>();
        
        
        modelo = new DefaultTableModel(columnas, 0) {
            //Metodo para bloquear los campos de la tabla
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tabla = new JTable(modelo);
        scroll = new JScrollPane(tabla);
        
        tablero_datos.add(scroll, BorderLayout.CENTER);
        
        //Organizar los grupos de Paneles
        contenido = new JPanel(new GridLayout(4,1,10,15));
        
        contenido.add(origen_destino);
        contenido.add(vueloIda_vueloRegreso);
        contenido.add(fechas);
        contenido.add(buscar);
        
        //Agregando en el orden correcto
        contenedor.add(contenido, BorderLayout.NORTH);
        contenedor.add(tablero_datos, BorderLayout.CENTER);
        contenedor.add(siguiente_volver, BorderLayout.SOUTH);
        
        //Espacios para los 4 lados
        contenedor.setBorder(BorderFactory.createEmptyBorder(7, 45, 20, 45));
        
        contenedor_principal.setLayout(new BorderLayout());
        contenedor_principal.add(contenedor, BorderLayout.CENTER);
        
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        
    }

}
