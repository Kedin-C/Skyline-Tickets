/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import View.Tarjeta_de_credito_view;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Tarjeta_de_credito_controller implements ActionListener{
    
    private Tarjeta_de_credito_view vista;
    private Datos datos;
    
    public Tarjeta_de_credito_controller(Tarjeta_de_credito_view vista, Datos datos){
    
        this.vista = vista;
        this.datos = datos;
        
        this.vista.pagar.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        
        
        //Condicones para que los campos solo permitan siertos caracteres
        vista.num_tarjeta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo numeros y espacios 
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.num_tarjeta.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        //Para que no pueda ingresar al campo de fecha
        JTextField editorFecha = (JTextField) vista.fecha_ven.getDateEditor().getUiComponent();
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
        vista.fecha_ven.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        vista.cvv.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))//Solo numeros
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.cvv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        vista.nombre_titular.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.nombre_titular.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.pagar){
            if(Validar()){
                String numero_tarjeta = vista.num_tarjeta.getText();
                
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fecha = formateadorRegreso.format(vista.fecha_ven);
                
                String cvv = vista.cvv.getText();
                
                String nombre = vista.nombre_titular.getText();
                
                //datos.setDatosPago(numero_tarjeta+", "+cvv+", "+nombre+", "+fecha+", "+datos.getTotalPagar());
            }
        }
        
    }
    
    public boolean Validar(){
        if(!vista.num_tarjeta.getText().isBlank() &&
                vista.fecha_ven.getDate() != null &&
                !vista.cvv.getText().isBlank() &&
                !vista.nombre_titular.getText().isBlank()){
            
            return true;
        }else{
            return false;
        }
    }
}
