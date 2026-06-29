/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets.view;

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
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

public class Tarjeta_de_debito_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, datos_tarjeta, imagen,formulario, volver_pagar;//contenedor
    private JButton volver,pagar;
    private JLabel numeroTarjeta, fechaVen, cv, nombreTitular;
    private TitledBorder titulo;
    private JDateChooser fecha_ven;
    private SimpleDateFormat formatoFecha;
    private JTextField num_tarjeta, cvv, nombre_titular;
    
    public Tarjeta_de_debito_view(){
        String nombrePagina = "Tarjeta de debito";
        super(nombrePagina);
        
        contenedor_principal = super.getPanel2();
        contenedor_principal.setLayout(new BorderLayout());
        
        //Creando los contenedores 
        datos_tarjeta = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        formulario = new JPanel(new GridLayout(4,2,40,15));
        volver_pagar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        
        
        //Creando el contenedor con la imagen de la tarjeta
        imagen = new FondoPanel("Tarjeta_debito.PNG");
        
        //Tamaños de la imagen y de el formulario
        Dimension tamanoFormulario = new Dimension(450, 220);
        
        formulario.setPreferredSize(tamanoFormulario);
        formulario.setMinimumSize(tamanoFormulario);
        formulario.setMaximumSize(tamanoFormulario);        
        
        Dimension tamanoImagen = new Dimension(550, 350);
        
        imagen.setPreferredSize(tamanoImagen);
        imagen.setMinimumSize(tamanoImagen);
        imagen.setMaximumSize(tamanoImagen); 
        
        //Titulo del borde
        Font fuenteGrande = new Font("Arial", Font.BOLD, 20);
        titulo = new TitledBorder("Tarjeta de debito");
        titulo.setTitleFont(fuenteGrande);
        
        formulario.setBorder(titulo);
        
        
        //Creando los textos de los campos
        numeroTarjeta = new JLabel("Numero de tarjeta*");
        fechaVen = new JLabel("Fecha de vencimiento*");
        cv = new JLabel("CVV*");
        nombreTitular = new JLabel("Nombre tirular*");
        
        
        //Creando los campos para ingresar la informacion
        num_tarjeta = new JTextField(12);
        cvv = new JTextField(12);
        nombre_titular = new JTextField(12);
        
        fecha_ven = new JDateChooser();
        
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");//Formato de la fecha dia/mes/año
        
        //Condicones para que los campos solo permitan siertos caracteres
        num_tarjeta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo numeros y espacios 
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        num_tarjeta.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");

        //Desactivar el clic derecho
        num_tarjeta.setComponentPopupMenu(new JPopupMenu());
        
        //Para que no pueda ingresar al campo de fecha
        JTextField editorFecha = (JTextField) fecha_ven.getDateEditor().getUiComponent();
        editorFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Bloqueamos absolutamente todo: letras, números, Backspace y Suprimir
                e.consume();
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        fecha_ven.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");

        //Desactivar el clic derecho
        fecha_ven.setComponentPopupMenu(new JPopupMenu());
        
        cvv.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))//Solo numeros
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        cvv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");

        //Desactivar el clic derecho
        cvv.setComponentPopupMenu(new JPopupMenu());
        
        nombre_titular.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        nombre_titular.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");

        //Desactivar el clic derecho
        nombre_titular.setComponentPopupMenu(new JPopupMenu());
        
        
        //Agregando los componentes al formulario
        formulario.add(numeroTarjeta);
        formulario.add(num_tarjeta);
        formulario.add(fechaVen);
        formulario.add(fecha_ven);
        formulario.add(cv);
        formulario.add(cvv);
        formulario.add(nombreTitular);
        formulario.add(nombre_titular);
        
        //Agregando al contenedor para unirlo a la imagen
        datos_tarjeta.add(formulario, FlowLayout.LEFT);
        datos_tarjeta.add(imagen, FlowLayout.CENTER);
        
        
        //Creando botones
        volver = new JButton("Volver");
        pagar = new JButton("Realizar pago");
        
        volver.setForeground(Color.WHITE);
        pagar.setForeground(Color.WHITE);
        
        volver.setBackground(Color.decode("#037FB9"));
        pagar.setBackground(Color.decode("#037FB9"));
        
        volver_pagar.add(volver);
        volver_pagar.add(pagar);
        
        volver_pagar.setPreferredSize(new Dimension(100,80));
        
        
        contenedor_principal.add(datos_tarjeta, BorderLayout.CENTER);
        contenedor_principal.add(volver_pagar, BorderLayout.SOUTH);
    }
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