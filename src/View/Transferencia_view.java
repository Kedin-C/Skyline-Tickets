/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

public class Transferencia_view extends Interfaz_vista_abtractas{
    
    private JPanel contenedor_principal, contenedor, siguiente_volver;
    public JButton bancolombia, paypal, nequi, volver;
    private TitledBorder titulo;
    
    
    public Transferencia_view() {
        
        String nombrePagina = "Transferencia";
        super(nombrePagina);
        contenedor_principal = super.getPanel2();
        contenedor_principal.setLayout(new BorderLayout());
        
        contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER,60,60));
        siguiente_volver = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,10));
        
        //Tipo de letra y tamaño
        Font fuenteGrande = new Font("Arial", Font.BOLD, 22);
        titulo = new TitledBorder("Elegir plataforma de pago");
        titulo.setTitleFont(fuenteGrande);
        
        contenedor.setBorder(titulo);
        
        bancolombia = new JButton("Bancolombia");
        paypal = new JButton("Paypal");
        nequi = new JButton("Nequi");
        
        volver = new JButton("Volver");
        
        //Tamaño botones y color
        Dimension tamanoColumna = new Dimension(140, 70);
        
        bancolombia.setPreferredSize(tamanoColumna);
        bancolombia.setMinimumSize(tamanoColumna);
        bancolombia.setMaximumSize(tamanoColumna);
        
        paypal.setPreferredSize(tamanoColumna);
        paypal.setMinimumSize(tamanoColumna);
        paypal.setMaximumSize(tamanoColumna);
        
        nequi.setPreferredSize(tamanoColumna);
        nequi.setMinimumSize(tamanoColumna);
        nequi.setMaximumSize(tamanoColumna);
        
        bancolombia.setBackground(Color.decode("#037FB9"));
        paypal.setBackground(Color.decode("#037FB9"));
        nequi.setBackground(Color.decode("#037FB9"));
        
        volver.setBackground(Color.decode("#037FB9"));
        
        bancolombia.setForeground(Color.WHITE);
        paypal.setForeground(Color.WHITE);
        nequi.setForeground(Color.WHITE);
        
        volver.setForeground(Color.WHITE);
                
        siguiente_volver.add(volver);
        
        contenedor.add(bancolombia);
        contenedor.add(paypal);
        contenedor.add(nequi);
        
        
        contenedor_principal.add(contenedor);
        contenedor_principal.add(siguiente_volver, BorderLayout.SOUTH);
        
        this.setSize(550, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        //Para que los botones enviean a la pagina
        bancolombia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Definir la dirección de la página web
                    String url = "https://svpersonas.apps.bancolombia.com/autenticacion";

                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        // Abrir la URL en el navegador predeterminado
                        Desktop.getDesktop().browse(new URI(url));
                    } else {
                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                    }
                } catch (Exception e) {
                    // Por si ocurre un error con la URL o el navegador
                    e.printStackTrace();
                }
            }
        });
        
        paypal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Definir la dirección de la página web
                    String url = "https://www.paypal.com/signin?locale.x=es_ES";

                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        // Abrir la URL en el navegador predeterminado
                        Desktop.getDesktop().browse(new URI(url));
                    } else {
                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                    }
                } catch (Exception e) {
                    // Por si ocurre un error con la URL o el navegador
                    e.printStackTrace();
                }
            }
        });
        
        nequi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Definir la dirección de la página web
                    String url = "https://transacciones.nequi.com/bdigital/login.jsp";

                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        // Abrir la URL en el navegador predeterminado
                        Desktop.getDesktop().browse(new URI(url));
                    } else {
                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                    }
                } catch (Exception e) {
                    // Por si ocurre un error con la URL o el navegador
                    e.printStackTrace();
                }
            }
        });
    }
    
}
