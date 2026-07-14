/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import Model.CrearPdfTicket;
import Model.Datos;
import Model.DatosPago;
import Model.DatosPagoDao;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
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

public class Tarjeta_de_credito_controller implements ActionListener{
    
    private Tarjeta_de_credito_view vista;
    private Seleccion_forma_de_pago_view vista_atras;
    private Datos datos;
    private DatosPago datosPagar = new DatosPago();
    private DatosPagoDao datosPagarDao = new DatosPagoDao();
    
//    private CrearPdfTicket crearPdf;
    
    public Tarjeta_de_credito_controller(Tarjeta_de_credito_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras){
        
        this.vista_atras = vista_atras;
        this.vista = vista;
        this.datos = datos;
        
        this.vista.pagar.addActionListener(this);
        this.vista.volver.addActionListener(this);
        
        Calendar cal = Calendar.getInstance(); //Toma la fecha y hora actual
        cal.add(Calendar.DAY_OF_YEAR, 1);
        
        this.vista.fecha_ven.setMinSelectableDate(cal.getTime());
        
        
        
        //Condicones para que los campos solo permitan siertos caracteres
        this.vista.num_tarjeta.addKeyListener(new KeyAdapter() {
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
                
                JOptionPane.showMessageDialog(vista, vista.num_tarjeta.getText());
                
                datosPagar.setNumero_tarjeta(vista.num_tarjeta.getText());
                
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fecha = formateadorRegreso.format(vista.fecha_ven.getDate());
                
                datosPagar.setFecha_vencimiento(fecha);
                
                datosPagar.setCvv(Integer.parseInt(vista.cvv.getText()));
                
                datosPagar.setNombre_titular(vista.nombre_titular.getText());
                
                datos.setDatosPago(datosPagar);
                if(datos.vista_pago == 1){
                    
                    datosPagarDao.enviarDatos(datosPagar.getNumero_tarjeta(),
                            datosPagar.getCvv(),
                            datosPagar.getNombre_titular(),
                            datosPagar.getFecha_vencimiento(),
                            datos.getTotalPagar());
                    
                }else{
                    datos.subirDatos();
                }
                
//                crearPdf = new CrearPdfTicket();
                
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
            if(datosCorrectos()){
                return true;
            }else{
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Debes llenar todos los datos de la tarjeta de credito", "Llenar datos tarjeta credito", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
    private boolean datosCorrectos(){
        String num_tarjeta = quitarEspacios(vista.num_tarjeta.getText());
        int cvv = Integer.parseInt(vista.cvv.getText());
        
        int puntos = 0;
        if(num_tarjeta.length() <= 19){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu numero de tarjeta supero el limite de digitos (19)", "Numero de tarjeta", JOptionPane.WARNING_MESSAGE);
        }
        
        if(num_tarjeta.length() >= 13){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu numero de tarjeta no llega al minimo de digitos (13)", "Numero de tarjeta", JOptionPane.WARNING_MESSAGE);
        }
        
        if(cvv <= 999 && cvv > 99){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu CVV debe tener 3 digitos", "CVV", JOptionPane.WARNING_MESSAGE);
        }
        
        if(puntos == 3){
            return true;
        }else{
            return false;
        }
    }
    
    
    private String quitarEspacios(String texto){
        String resultado="";
        for(int i = 0; i < texto.length(); i++){
            char numero = texto.charAt(i);
            if(numero == ' '){
                continue;
            }else{
                resultado = resultado+numero;
            }
        }
        return resultado;
    }
}
