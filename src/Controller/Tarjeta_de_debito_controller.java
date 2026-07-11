/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import Model.DatosPago;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_debito_view;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Tarjeta_de_debito_controller implements ActionListener{
    
    private Seleccion_forma_de_pago_view vista_atras;
    private Tarjeta_de_debito_view vista;
    private Datos datos;
    private DatosPago datosPagar;
    
    public Tarjeta_de_debito_controller(Tarjeta_de_debito_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras){
        
        this.vista_atras = vista_atras;
        this.vista = vista;
        this.datos=datos;
        
        
        this.vista.pagar.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        Calendar cal = Calendar.getInstance(); //Toma la fecha y hora actual
        cal.add(Calendar.DAY_OF_YEAR, 1);
        
        this.vista.fecha_ven.setMinSelectableDate(cal.getTime());
        
        
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
        this.vista.num_tarjeta.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        //Para que no pueda ingresar al campo de fecha
        JTextField editorFecha = (JTextField) this.vista.fecha_ven.getDateEditor().getUiComponent();
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
        this.vista.fecha_ven.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        this.vista.cvv.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))//Solo numeros
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.cvv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        this.vista.nombre_titular.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.nombre_titular.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.pagar){
            if(Validar()){
                datosPagar.setNumero_tarjeta(vista.num_tarjeta.getText());
                
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fecha = formateadorRegreso.format(vista.fecha_ven);
                
                datosPagar.setFecha_vencimiento(fecha);
                
                datosPagar.setCvv(Integer.parseInt(vista.cvv.getText()));
                
                datosPagar.setNombre_titular(vista.nombre_titular.getText());
                
                datos.setDatosPago(datosPagar);
                
                datos.subirDatos();
            }
        }
        
        if(e.getSource() == vista.volver){
            
            if(vista.getCod_anterior_view() == 1){
            
                vista.setVisible(false);
                vista_atras.setVisible(true);
                vista_atras.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        
        }
        
    }
    
    private boolean Validar(){
        if(!vista.num_tarjeta.getText().isBlank() &&
                vista.fecha_ven.getDate() != null &&
                !vista.cvv.getText().isBlank() &&
                !vista.nombre_titular.getText().isBlank()){
            
            return true;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Debes llenar todos los datos de la tarjeta de debito", "Llenar datos tarjeta debito", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
//    private boolean datosCorrectos(){
//        
////        if(){
////        }
//    }
}
