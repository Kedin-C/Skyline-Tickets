/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class Tarjeta_de_credito_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, datos_tarjeta, imagen, formulario, volver_pagar;
    public JButton volver,pagar;
    private JLabel numeroTarjeta, fechaVen, cv, nombreTitular, descuento;
    private TitledBorder titulo;
    public JDateChooser fecha_ven;
    private SimpleDateFormat formatoFecha;
    public JTextField num_tarjeta, cvv, nombre_titular, codigoDescuento;
    private int cod_anterior_view;
    
    
    public Tarjeta_de_credito_view() {
        
        super("Tarjeta de credito");
        
        contenedor_principal = super.getPanel2();
        contenedor_principal.setLayout(new BorderLayout());
        
        //Creando los contenedores 
        datos_tarjeta = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        formulario = new JPanel(new GridLayout(5,2,40,15));
        volver_pagar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        
        
        //Creando el contenedor con la imagen de la tarjeta
        imagen = new FondoPanel("src/Imagenes/Tarjeta_credito.PNG");
        
        //Tamaños de la imagen y de el formulario
        Dimension tamanoFormulario = new Dimension(750, 350);
        
        formulario.setPreferredSize(tamanoFormulario);
        formulario.setMinimumSize(tamanoFormulario);
        formulario.setMaximumSize(tamanoFormulario);        
        
        Dimension tamanoImagen = new Dimension(550, 320);
        
        imagen.setPreferredSize(tamanoImagen);
        imagen.setMinimumSize(tamanoImagen);
        imagen.setMaximumSize(tamanoImagen); 
        
        //Titulo del borde
        Font fuenteGrande = new Font("Arial", Font.BOLD, 17);
        titulo = new TitledBorder("Tarjeta de credito");
        titulo.setTitleFont(fuenteGrande);
        
        formulario.setBorder(titulo);
        
        
        //Creando los textos de los campos
        numeroTarjeta = new JLabel("Numero de tarjeta*");
        fechaVen = new JLabel("Fecha de vencimiento*");
        cv = new JLabel("CVV*");
        nombreTitular = new JLabel("Nombre titular*");
        descuento = new JLabel("Codigo de descuento (opcional)");
        
        
        //Creando los campos para ingresar la informacion
        num_tarjeta = new JTextField(12);
        cvv = new JTextField(12);
        nombre_titular = new JTextField(12);
        codigoDescuento = new JTextField(12);
        
        num_tarjeta.setFont(fuenteGrande);
        cvv.setFont(fuenteGrande);
        nombre_titular.setFont(fuenteGrande);
        codigoDescuento.setFont(fuenteGrande);
        
        fecha_ven = new JDateChooser();
        
        fecha_ven.setFont(fuenteGrande);
        
        //Agregando los componentes al formulario
        formulario.add(numeroTarjeta);
        formulario.add(num_tarjeta);
        formulario.add(fechaVen);
        formulario.add(fecha_ven);
        formulario.add(cv);
        formulario.add(cvv);
        formulario.add(nombreTitular);
        formulario.add(nombre_titular);
        formulario.add(descuento);
        formulario.add(codigoDescuento);
        
        //Agregando al contenedor para unirlo a la imagen
        datos_tarjeta.add(formulario, FlowLayout.LEFT);
        datos_tarjeta.add(imagen, FlowLayout.CENTER);
        
        
        //Creando botones
        volver = super.volver_2;
        pagar = new JButton("Realizar pago");
        
        pagar.setForeground(Color.WHITE);
        
        pagar.setBackground(Color.decode("#037FB9"));
        
        pagar.setPreferredSize(new Dimension(120,30)); 
        
        volver_pagar.add(volver);
        volver_pagar.add(pagar);
        
        volver_pagar.setPreferredSize(new Dimension(100,80));
        
        
        contenedor_principal.add(datos_tarjeta, BorderLayout.CENTER);
        contenedor_principal.add(volver_pagar, BorderLayout.SOUTH);
        
        numeroTarjeta.setFont(fuenteGrande);
        fechaVen.setFont(fuenteGrande);
        cv.setFont(fuenteGrande);
        nombreTitular.setFont(fuenteGrande);
        descuento.setFont(fuenteGrande);
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    


public int getCod_anterior_view() {
        return cod_anterior_view;
    }

    public void setCod_anterior_view(int cod_anterior_view) {
        this.cod_anterior_view = cod_anterior_view;
    }



//La imagen de la tarjeta
class FondoPanel extends JPanel {
    private Image imagen;

    public FondoPanel(String ruta) {
        this.imagen = new ImageIcon(ruta).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
}