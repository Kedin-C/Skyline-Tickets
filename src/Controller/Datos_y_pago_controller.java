/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Datos;
import Model.DatosPersonales;
import Model.DatosPersonalesDao;
import View.Datos_y_pago_view;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;
import View.Transferencia_view;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Datos_y_pago_controller implements ActionListener{
    
    DatosPersonales datosPersonales = new DatosPersonales();
    DatosPersonalesDao datosPersonalesdao = new DatosPersonalesDao();
    Datos_y_pago_view vista = new Datos_y_pago_view();
    Datos datos = new Datos();
    
    Tarjeta_de_credito_view viewTarjetaCredito = new Tarjeta_de_credito_view();
    Tarjeta_de_debito_view viewTerjetaDebito = new Tarjeta_de_debito_view();
    Transferencia_view viewTransferencia = new Transferencia_view();
    
    int n;
    
    ArrayList<DatosPersonales> datosPasajeros = new ArrayList<>();
    
    public Datos_y_pago_controller(Datos_y_pago_view vista, Datos datos){
        
        this.datos=datos;
        this.vista=vista;
        
        //this.viewTarjetaCredito = viewTarjetaCredito;
        this.n=1;
        
        this.vista.siguiente.addActionListener(this);
        this.vista.volver.addActionListener(this);
        this.vista.credito.addActionListener(this);
        this.vista.debito.addActionListener(this);
        this.vista.pse.addActionListener(this);
        
        this.viewTarjetaCredito.volver.addActionListener(this);
        this.viewTerjetaDebito.volver.addActionListener(this);
        this.viewTransferencia.volver.addActionListener(this);
        
        if (this.datos.getNumeroTickets() == 1) {
            vista.siguiente.setEnabled(false);
            vista.credito.setEnabled(true);
            vista.debito.setEnabled(true);
            vista.pse.setEnabled(true);
        }
        
        
        //Condicones para que los campos solo permitan siertos caracteres
        vista.nombrecampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.nombrecampo.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        vista.apellidocampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.apellidocampo.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        vista.numero_documento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.')//Solo numeros y puntos 
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.numero_documento.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        vista.numeroTel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo numeros espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        vista.numeroTel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        
        //Para que no pueda ingresar al campo de fecha
        JTextField editorFecha = (JTextField) vista.elegir_fecha.getDateEditor().getUiComponent();
        editorFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Bloquea y no deja entrar letras, números, Backspace y Suprimir
                e.consume();
            }
        });
        
        vista.precioTotal.setText(""+datos.getTotalPagar());
        
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.siguiente){
            
            if(validarDatos()){
                n++;
                if (n >= datos.getNumeroTickets()) {
                    vista.siguiente.setEnabled(false);
                    vista.credito.setEnabled(true);
                    vista.debito.setEnabled(true);
                    vista.pse.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(vista, "Llena los datos del ticket numero: " + n);
                }
            }
        }
        
        if (e.getSource() == vista.credito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTarjetaCredito.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
                Tarjeta_de_credito_controller controllerTarjetaCredito = new Tarjeta_de_credito_controller(viewTarjetaCredito, datos,selec_pago);
                
                datos.setDatosPersonales(datosPasajeros);
                
                datos.subirDatos();
                //int pago = Integer.parseInt(vista.precioTotal.getText());
                //datos.setTotalPagar(pago);
            }
        }
        if (e.getSource() == vista.debito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTerjetaDebito.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
                Tarjeta_de_debito_controller controllerTerjetaDebito = new Tarjeta_de_debito_controller(viewTerjetaDebito, datos,selec_pago);
                
                datos.setDatosPersonales(datosPasajeros);
                
                datos.subirDatos();
                //int pago = Integer.parseInt(vista.precioTotal.getText());
                //datos.setTotalPagar(pago);
            
            }
        }
        if (e.getSource() == vista.pse) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTransferencia.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
                Transferencia_controller controllerTransferencia = new Transferencia_controller(viewTransferencia, datos,selec_pago);
                
                datos.setDatosPersonales(datosPasajeros);
                
                
                //int pago = Integer.parseInt(vista.precioTotal.getText());
                //datos.setTotalPagar(pago);
                
            }
        }
        
        if(e.getSource() == this.viewTarjetaCredito.volver){
            vista.setVisible(true);
            viewTarjetaCredito.setVisible(false);
        }
        
        if(e.getSource() == this.viewTerjetaDebito.volver){
            vista.setVisible(true);
            viewTarjetaCredito.setVisible(false);
        }
        
        if(e.getSource() == this.viewTransferencia.volver){
            vista.setVisible(true);
            viewTarjetaCredito.setVisible(false);
        }
        
        
    }
    
    public boolean validarDatos(){
        if(vista.nombrecampo != null 
            && vista.apellidocampo != null 
            && vista.numero_documento != null 
            && vista.numeroTel != null 
            && vista.correo != null 
            && vista.listar_documento.getSelectedIndex() > 0
            && vista.listar_sexo.getSelectedIndex() > 0 
            && vista.listar_nacionalidad.getSelectedIndex() > 0
            && vista.elegir_fecha.getDate() != null){
            
            guardarDatos();
            
            return true;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Debes llenar todos los datos", "Llenar datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public void guardarDatos(){
        
        String nombre, apellido, numDocumento, numTel, corre, sexo, nacionalidad, fechaNacimiento;
        int tipoDocumento;

        nombre = vista.nombrecampo.getText();
        apellido = vista.apellidocampo.getText();
        numDocumento = vista.numero_documento.getText();
        numTel = vista.numeroTel.getText();
        corre = vista.correo.getText();
        tipoDocumento = vista.listar_documento.getSelectedIndex();
        sexo = vista.listar_sexo.getSelectedItem().toString();
        nacionalidad = vista.listar_nacionalidad.getSelectedItem().toString();

        SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
        //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
        fechaNacimiento = formateadorRegreso.format(vista.elegir_fecha.getDate());

        datosPersonales.setNombre(nombre);
        datosPersonales.setApellido(apellido);
        datosPersonales.setNumero_documento(numDocumento);
        datosPersonales.setNumero_telefono(numTel);
        datosPersonales.setCorreo(corre);
        datosPersonales.setCodigo_tipo_documento(tipoDocumento);
        datosPersonales.setSexo(sexo);
        datosPersonales.setNationalidad(nacionalidad);
        datosPersonales.setFecha_nacimiento(fechaNacimiento);

        datosPasajeros.add(datosPersonales);
    
    }
}
