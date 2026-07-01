/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class cambio_de_clase_de_vuelo_viiew extends Interfaz_vista_abtractas {

    private final Container contenedor;
    private final JPanel panel1, panel2;
    // distribucon de 3 tarjetas
    private final JPanel contenedor_distribucion;
    //3 paneles que se distribuiran en 3 tarjetas
    private final JPanel p1, p2, p3;
    //3 paneles que no le afecta la distribucion
    private final JPanel panel_clase_economica, panel_clase_ejecutiva, panel_primera_clase;
    // 3 paneles dentro de los paneles que no le afectara la distribucion
    private final JPanel distribucion1, distribucion2, distribucion3;
    // contenedor de las tarjetas
    private final JPanel cont_clase_economica, cont_clase_ejecutiva, cont_primera_clase;
    // contenedor de la imagen y el texto de las tarjetas
    private final JPanel imagen, texto, imagen2, texto2, imagen3, texto3;
    //contenedor de los contenedores de las imagenes y textos
    private final JPanel cont_economi_imagen, cont_economi_texto, cont_ejecutiva_imagen2, cont_ejecutiva_texto2, cont_primera_imagen3, cont_primera_texto3;
    // imagen y textos de la clase economica
    private final JLabel imagen_avion, P_texto1, P_texto2, P_texto3, P_texto4, P_texto5, P_texto6, P_texto7;
    // imagen y textos de la clase ejecutiva
    private final JLabel imagen_avion_ejecutiva, P_texto1_ejecutiva, P_texto2_ejecutiva, P_texto3_ejecutiva, P_texto4_ejecutiva, P_texto5_ejecutiva, P_texto6_ejecutiva, P_texto7_ejecutiva;
    //imagen y textos de la primera clase
    private final JLabel imagen_avion_primera, P_texto1_primera, P_texto2_primera, P_texto3_primera, P_texto4_primera, P_texto5_primera, P_texto6_primera, P_texto7_primera;
    //botones de clase actual y seleccionar
    public JButton boton_Actual, boton_Seleccionar_ejecutiva, boton_Seleccionar_primera, boton_volver;
    //contenedor boton volver
    private final JPanel cont_volver;
    
    public int ticket;

    public cambio_de_clase_de_vuelo_viiew() {
        String nombre = "Seleccion cambio de clase de vuelo";
        super(nombre);

        contenedor = super.getContenedor();
        panel1 = super.getPanel1();
        panel2 = super.getPanel2();

        panel2.setOpaque(true);

        //distribucion de los 3 paneles
        contenedor_distribucion = new JPanel(new GridLayout(1, 3));

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        distribucion1 = new JPanel(new BorderLayout());
        distribucion2 = new JPanel(new BorderLayout());
        distribucion3 = new JPanel(new BorderLayout());

        panel_clase_economica = new JPanel();
        panel_clase_ejecutiva = new JPanel();
        panel_primera_clase = new JPanel();

        cont_clase_economica = new JPanel(new BorderLayout());
        cont_clase_ejecutiva = new JPanel(new BorderLayout());
        cont_primera_clase = new JPanel(new BorderLayout());
        cont_volver = new JPanel();

        cont_economi_imagen = new JPanel(new BorderLayout());

        cont_economi_texto = new JPanel();

        cont_ejecutiva_imagen2 = new JPanel(new BorderLayout());

        cont_ejecutiva_texto2 = new JPanel();

        cont_primera_imagen3 = new JPanel(new BorderLayout());
        cont_primera_texto3 = new JPanel();

        //imagen y distribucion de los textos
        imagen = new JPanel();
        texto = new JPanel(new GridLayout(7, 1));
        imagen2 = new JPanel();
        texto2 = new JPanel(new GridLayout(7, 1));
        imagen3 = new JPanel();
        texto3 = new JPanel(new GridLayout(7, 1));

//    ----------------------------------------------------------------------------------------------------------
        
          
        //tamaño del contenedor con la distribucion
        contenedor_distribucion.setPreferredSize(new Dimension(1400, 630));
      
        //margen del contenedor con la distribucion
        contenedor_distribucion.setBorder(new EmptyBorder(80, 1, 1, 1));
        
        
// clase economica
// imagen
        ImageIcon imagen_icono = new ImageIcon("src/Imagenes/clase_economica.png");
        Image Imagen_ajustada = imagen_icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon imagen_new = new ImageIcon(Imagen_ajustada);

        imagen.setBorder(new EmptyBorder(50, 1, 1, 1));
        imagen.setBackground(Color.decode("#037FB9"));
        imagen_avion = new JLabel(imagen_new);
        
        //tamaño del contenedor de la imagen
        cont_economi_imagen.setPreferredSize(new Dimension(1, 200));

        //color del contenedor de los textos
        texto.setBackground(Color.decode("#037FB9"));

// color del contenedor
        cont_economi_texto.setBackground(Color.decode("#037FB9"));

        //texto de la clase economica
        P_texto1 = new JLabel("          ECONÓMICA");
        P_texto2 = new JLabel("1 artículo personal incluido.");
        P_texto3 = new JLabel("Equipaje de mano hasta 10 kg.");
        P_texto4 = new JLabel("Selección de asiento estándar.");
        P_texto5 = new JLabel("Comidas y bebidas según la ruta.");
        P_texto6 = new JLabel("Entretenimiento a bordo.");
        P_texto7 = new JLabel("Embarque general.");
        
        P_texto1.setBorder(new EmptyBorder(1, 0, 10, 0));
        
        //tipo de letra y tamaño de la letra

        P_texto1.setFont(new Font("Arial", Font.BOLD, 20));
        P_texto2.setFont(new Font("Arial", Font.BOLD, 15)); 
        P_texto3.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto4.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto5.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto6.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto7.setFont(new Font("Arial", Font.BOLD, 15));

        //color de la letra
        P_texto1.setForeground(Color.WHITE);
        P_texto2.setForeground(Color.WHITE);
        P_texto3.setForeground(Color.WHITE);
        P_texto4.setForeground(Color.WHITE);
        P_texto5.setForeground(Color.WHITE);
        P_texto6.setForeground(Color.WHITE);
        P_texto7.setForeground(Color.WHITE);
        
        //configuracion boton actual

        boton_Actual = new JButton("ACTUAL");
        boton_Actual.setBackground(Color.WHITE);
        boton_Actual.setPreferredSize(new Dimension(20, 30));

        boton_Actual.setBorderPainted(false);

        
        // color del contenedor que contiene la imagen y el texto
        panel_clase_economica.setBackground(Color.decode("#037FB9"));
        // contenedor que contiene al contenedor del texto
        cont_economi_texto.setBackground(Color.decode("#037FB9"));

        // clase ejecutiva
        
        //imagen
        ImageIcon imagen_icono2 = new ImageIcon("src/Imagenes/clase_ejecutiva.png");
        Image Imagen_ajustada2 = imagen_icono2.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon imagen_new2 = new ImageIcon(Imagen_ajustada2);

        imagen_avion_ejecutiva = new JLabel(imagen_new2);

        imagen2.setBorder(new EmptyBorder(50, 1, 50, 1));
        imagen2.setBackground(Color.decode("#037FB9"));
        //tamaño de la imagen
        cont_ejecutiva_imagen2.setPreferredSize(new Dimension(200, 200));
        
        
        //color del contenedor del texto
        texto2.setBackground(Color.decode("#037FB9"));
        

        
        //text
        
        
        P_texto1_ejecutiva = new JLabel("              EJECUTIVA ");
        P_texto2_ejecutiva = new JLabel("2 artículos personales incluidos.");
        P_texto3_ejecutiva = new JLabel("Equipaje de mano hasta 16 kg.");
        P_texto4_ejecutiva = new JLabel("2 maletas en bodega hasta 23 kg c/u.");
        P_texto5_ejecutiva = new JLabel("Asientos más amplios y reclinables.");
        P_texto6_ejecutiva = new JLabel("Acceso a salas VIP.");
        P_texto7_ejecutiva = new JLabel("Entretenimiento mejorado.");

        //tipo de letra y tamaño de la letra
        P_texto1_ejecutiva.setFont(new Font("Arial", Font.BOLD, 20));
        P_texto2_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto3_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto4_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto5_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto6_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto7_ejecutiva.setFont(new Font("Arial", Font.BOLD, 15));

        //color de la letra
        P_texto1_ejecutiva.setForeground(Color.WHITE);
        P_texto2_ejecutiva.setForeground(Color.WHITE);
        P_texto3_ejecutiva.setForeground(Color.WHITE);
        P_texto4_ejecutiva.setForeground(Color.WHITE);
        P_texto5_ejecutiva.setForeground(Color.WHITE);
        P_texto6_ejecutiva.setForeground(Color.WHITE);
        P_texto7_ejecutiva.setForeground(Color.WHITE);

        //configuracion boton Seleccionar clase ejecutiva
        boton_Seleccionar_ejecutiva = new JButton("SELECCIONAR");
        boton_Seleccionar_ejecutiva.setBackground(Color.WHITE);
        boton_Seleccionar_ejecutiva.setPreferredSize(new Dimension(20, 30));
        boton_Seleccionar_ejecutiva.setBorderPainted(false);
        
        //margen del texto
        P_texto1_ejecutiva.setBorder(new EmptyBorder(1, 0, 10, 0));
             
        
        // color del contenedor que contiene la imagen y el texto
        panel_clase_ejecutiva.setBackground(Color.decode("#037FB9"));


        // contenedor que contiene al contenedor del texto
        cont_ejecutiva_texto2.setBackground(Color.decode("#037FB9"));

        // primera clase
        
        
        //imagen
        ImageIcon imagen_icono3 = new ImageIcon("src/Imagenes/primera_clase.png");
        Image Imagen_ajustada3 = imagen_icono3.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon imagen_new3 = new ImageIcon(Imagen_ajustada3);

        imagen_avion_primera = new JLabel(imagen_new3);
        imagen3.setBorder(new EmptyBorder(50, 1, 1, 1));
        imagen3.setBackground(Color.decode("#037FB9"));
        
        //color del contenedor del texto
        texto3.setBackground(Color.decode("#037FB9"));

        //texto
        P_texto1_primera = new JLabel("           PRIMERA CLASE ");
        P_texto2_primera = new JLabel("2 artículos personales incluidos.");
        P_texto3_primera = new JLabel("Equipaje de mano hasta 18 kg.");
        P_texto4_primera = new JLabel("3 maletas en bodega hasta 32 kg c/u.");
        P_texto5_primera = new JLabel("Asientos cama totalmente reclinables.");
        P_texto6_primera = new JLabel("Acceso a salas VIP exclusivas.");
        P_texto7_primera = new JLabel("Check-in y embarque prioritario.");
        //tipo de letra y tamaño de la letra
        P_texto1_primera.setFont(new Font("Arial", Font.BOLD, 20));
        P_texto2_primera.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto3_primera.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto4_primera.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto5_primera.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto6_primera.setFont(new Font("Arial", Font.BOLD, 15));
        P_texto7_primera.setFont(new Font("Arial", Font.BOLD, 15));
        //color de la letra
        P_texto1_primera.setForeground(Color.WHITE);
        P_texto2_primera.setForeground(Color.WHITE);
        P_texto3_primera.setForeground(Color.WHITE);
        P_texto4_primera.setForeground(Color.WHITE);
        P_texto5_primera.setForeground(Color.WHITE);
        P_texto6_primera.setForeground(Color.WHITE);
        P_texto7_primera.setForeground(Color.WHITE);
        //margen del texto
        P_texto1_primera.setBorder(new EmptyBorder(1, 0, 10, 0));
        //tamaño del contenedor que contiene al contenedor de la imagen
        cont_primera_imagen3.setPreferredSize(new Dimension(200, 200));
        //color del contenedor de la imagen y el texto
        panel_primera_clase.setBackground(Color.decode("#037FB9"));
        //color del contenedor del contenedor del texto
        cont_primera_texto3.setBackground(Color.decode("#037FB9"));
        
        //boton seleccionar primera clase
        boton_Seleccionar_primera = new JButton("SELECCIONAR");
        boton_Seleccionar_primera.setBackground(Color.WHITE);
        boton_Seleccionar_primera.setPreferredSize(new Dimension(20, 30));

        boton_Seleccionar_primera.setBorderPainted(false);


        
        // boton volver
        
        boton_volver = super.volver;
        
        cont_volver.add(boton_volver);

        cont_volver.setBorder(new EmptyBorder(1,1300,0,0));

//    ----------------------------------------------------------------------------------------------------------------------------
        imagen.add(imagen_avion);
        texto.add(P_texto1);
        texto.add(P_texto2);
        texto.add(P_texto3);
        texto.add(P_texto4);
        texto.add(P_texto5);
        texto.add(P_texto6);
        texto.add(P_texto7);

        imagen2.add(imagen_avion_ejecutiva);
        texto2.add(P_texto1_ejecutiva);
        texto2.add(P_texto2_ejecutiva);
        texto2.add(P_texto3_ejecutiva);
        texto2.add(P_texto4_ejecutiva);
        texto2.add(P_texto5_ejecutiva);
        texto2.add(P_texto6_ejecutiva);
        texto2.add(P_texto7_ejecutiva);

        imagen3.add(imagen_avion_primera);
        texto3.add(P_texto1_primera);
        texto3.add(P_texto2_primera);
        texto3.add(P_texto3_primera);
        texto3.add(P_texto4_primera);
        texto3.add(P_texto5_primera);
        texto3.add(P_texto6_primera);
        texto3.add(P_texto7_primera);

        cont_economi_imagen.add(imagen);
        cont_economi_texto.add(texto);

        cont_ejecutiva_imagen2.add(imagen2);
        cont_ejecutiva_texto2.add(texto2);

        cont_primera_imagen3.add(imagen3);
        cont_primera_texto3.add(texto3);

        
        

        
        

        
        

        panel_clase_economica.add(cont_clase_economica);
        panel_clase_ejecutiva.add(cont_clase_ejecutiva);
        panel_primera_clase.add(cont_primera_clase);


        p1.add(distribucion1);
        p2.add(distribucion2);
        p3.add(distribucion3);

        contenedor_distribucion.add(p1);
        contenedor_distribucion.add(p2);
        contenedor_distribucion.add(p3);

        panel2.add(contenedor_distribucion);
        panel2.add(cont_volver,BorderLayout.WEST);

    }
    
    public JPanel getClases(int id){
        
        JPanel panel;
        
        switch (id) {

            case 1: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
                cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                panel = this.panel_clase_economica;
                break;
            }

            case 2: {
                cont_clase_ejecutiva.add(cont_ejecutiva_imagen2, BorderLayout.NORTH);
                cont_clase_ejecutiva.add(cont_ejecutiva_texto2);
                cont_clase_ejecutiva.add(boton_Actual, BorderLayout.SOUTH);
                panel = this.panel_clase_ejecutiva;
                break;
            }

            case 3: {
                cont_primera_clase.add(cont_primera_imagen3, BorderLayout.NORTH);
                cont_primera_clase.add(cont_primera_texto3);
                cont_primera_clase.add(boton_Actual, BorderLayout.SOUTH);
                panel = this.panel_primera_clase;
                break;
            }

            default: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
                cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                panel = this.panel_clase_economica;
                break;
            }
            
            

        }

        return panel;
    
    }

    public void setClase_disponible2(int id) {
        
        

        switch (id) {

            case 1: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
        cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion3.add(panel_clase_economica);
                break;
            }

            case 2: {
                cont_clase_ejecutiva.add(cont_ejecutiva_imagen2, BorderLayout.NORTH);
                cont_clase_ejecutiva.add(cont_ejecutiva_texto2);
                cont_clase_ejecutiva.add(boton_Seleccionar_ejecutiva, BorderLayout.SOUTH);
                this.distribucion3.add(panel_clase_ejecutiva);
                break;
            }

            case 3: {
                cont_primera_clase.add(cont_primera_imagen3, BorderLayout.NORTH);
                cont_primera_clase.add(cont_primera_texto3);
                cont_primera_clase.add(boton_Seleccionar_primera, BorderLayout.SOUTH);
                this.distribucion3.add(panel_primera_clase);
                break;
            }

            default: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
        cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion3.add(panel_clase_economica);
                break;
            }

        }
    }

    public void setClase_disponible(int id) {
        
       

        switch (id) {

            case 1: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
        cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion2.add(panel_clase_economica);
                break;
            }

            case 2: {
                cont_clase_ejecutiva.add(cont_ejecutiva_imagen2, BorderLayout.NORTH);
                cont_clase_ejecutiva.add(cont_ejecutiva_texto2);
                cont_clase_ejecutiva.add(boton_Seleccionar_ejecutiva, BorderLayout.SOUTH);
                this.distribucion2.add(panel_clase_ejecutiva);
                break;
            }

            case 3: {
                cont_primera_clase.add(cont_primera_imagen3, BorderLayout.NORTH);
                cont_primera_clase.add(cont_primera_texto3);
                cont_primera_clase.add(boton_Seleccionar_primera, BorderLayout.SOUTH);
                this.distribucion2.add(panel_primera_clase);
                break;
            }

            default: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
        cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion2.add(panel_clase_economica);
                break;
            }

        }
    }

    public void setClase_actual(int id) {

        
        
        switch (id) {

            case 1: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
                cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion1.add(panel_clase_economica);
                break;
            }

            case 2: {
                cont_clase_ejecutiva.add(cont_ejecutiva_imagen2, BorderLayout.NORTH);
                cont_clase_ejecutiva.add(cont_ejecutiva_texto2);
                cont_clase_ejecutiva.add(boton_Actual, BorderLayout.SOUTH); 
                this.distribucion1.add(panel_clase_ejecutiva);
                break;
            }

            case 3: {
                cont_primera_clase.add(cont_primera_imagen3, BorderLayout.NORTH);
                cont_primera_clase.add(cont_primera_texto3);
                cont_primera_clase.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion1.add(panel_primera_clase);
                break;
            }

            default: {
                cont_clase_economica.add(cont_economi_imagen, BorderLayout.NORTH);
                cont_clase_economica.add(cont_economi_texto);
                cont_clase_economica.add(boton_Actual, BorderLayout.SOUTH);
                this.distribucion1.add(panel_clase_economica);
                break;
            }
            
            

        }

    }
    
    public void remove(){
    this.distribucion3.removeAll();
     this.distribucion2.removeAll();
     this.distribucion1.removeAll();
    }
    
    public void removeBotones(){
        cont_clase_economica.removeAll();
        cont_clase_ejecutiva.removeAll();
        cont_primera_clase.removeAll();
                    

    }
    
    
}
