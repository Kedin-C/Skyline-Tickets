/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.And_puestos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Datos;
import Model.DatosPersonales;
import Model.DatosPersonalesDao;
import Model.Ticket;
import Model.Usuario;
import View.Datos_y_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;
import View.Transferencia_view;
import View.ViewPrincipal;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Datos_y_pago_controller implements ActionListener{
    
    DatosPersonales datosPersonales = new DatosPersonales();
    DatosPersonalesDao datosPersonalesdao = new DatosPersonalesDao();
    Datos_y_pago_view vista = new Datos_y_pago_view();
    Datos datos;
    
    Ticket ticket = new Ticket();
    Tarjeta_de_credito_view viewTarjetaCredito = new Tarjeta_de_credito_view();
    Tarjeta_de_debito_view viewTerjetaDebito = new Tarjeta_de_debito_view();
    Transferencia_view viewTransferencia = new Transferencia_view();
    private Usuario usuario;
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    private And_puestos pv;
    private Seleccion_de_Modificacion_de_vuelo_view modify;
    
    
    int n;
    
    ArrayList<DatosPersonales> datosPasajeros = new ArrayList<>();
    
    public Datos_y_pago_controller(Datos_y_pago_view vista, Datos datos, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario,And_puestos pv,Seleccion_de_Modificacion_de_vuelo_view modify){
        
        this.modify = modify;
        this.datos=datos;
        this.vista=vista;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        
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
            this.vista.siguiente.setEnabled(false);
            this.vista.credito.setEnabled(true);
            this.vista.debito.setEnabled(true);
            this.vista.pse.setEnabled(true);
        }
        
        Calendar cal = Calendar.getInstance(); //Toma la fecha y hora actual
        cal.add(Calendar.DAY_OF_YEAR, -14);//Resta 2 semanas (14 días) hacia el pasado para definir la fecha de nacimiento mínima
        
        this.vista.elegir_fecha.setMaxSelectableDate(cal.getTime());//Para bloquear las fechas de 2 semanas atras al futuro
        this.vista.elegir_fecha.setDate(cal.getTime());//Para que el calendario se habra en la fecha minima
        
        
        //Condicones para que los campos solo permitan siertos caracteres
        this.vista.nombrecampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.nombrecampo.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        this.vista.apellidocampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != ' ')//Solo letras y espacios
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.apellidocampo.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        this.vista.numero_documento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' ' 
                        && e.getKeyChar() != '.' && e.getKeyChar() != '-'
                        && !Character.isLetter(e.getKeyChar()))
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.numero_documento.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        this.vista.numeroTel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ' ')
                {
                    e.consume();
                }
            }
        });
        
        //Desactivar el comando de "Pegar" (Ctrl + V)
        this.vista.numeroTel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
//        this.vista.correo.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '@'){
//                    e.consume();
//                }
//            }
//        });
//        
//        this.vista.correo.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "none");
        
        //Para que no pueda ingresar al campo de fecha
        JTextField editorFecha = (JTextField) this.vista.elegir_fecha.getDateEditor().getUiComponent();
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
        
        
        
        JOptionPane.showMessageDialog(null, "Llena los datos de manera correcta y\n"
                                                        + "que concuerden con los datos reales\n"
                                                        + "del pasajero ya que se validara esta\n"
                                                        + "informacion antes de subir al vuelo");
        
        this.vista.precioTotal.setText(""+this.datos.getTotalPagar());
        
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
                    
                    JOptionPane.showMessageDialog(null, "Llena los datos del ticket numero: " + n);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Llena los datos del ticket numero: " + n);
                    
                }
                vista.nombrecampo.setText("");
                vista.apellidocampo.setText("");
                vista.listar_documento.setSelectedIndex(0);
                vista.numero_documento.setText("");
                vista.numeroTel.setText("");
                vista.correo.setText("");
                vista.listar_sexo.setSelectedIndex(0);
                vista.listar_nacionalidad.setSelectedIndex(0);
            }
        }
        
        if (e.getSource() == vista.credito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTarjetaCredito.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
                Tarjeta_de_credito_controller controllerTarjetaCredito = new Tarjeta_de_credito_controller(viewTarjetaCredito, datos,selec_pago, ticket, usuario, vistaPrincipal, viewAdmin, viewUsuario,pv,modify);
                
                datos.setDatosPersonales(datosPasajeros);
                
            }
        }
        if (e.getSource() == vista.debito) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTerjetaDebito.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
<<<<<<< HEAD
                Tarjeta_de_debito_controller controllerTerjetaDebito = new Tarjeta_de_debito_controller(viewTerjetaDebito, datos,selec_pago, ticket,pv,modify,vistaPrincipal,viewAdmin,viewUsuario,usuario);
=======
                Tarjeta_de_debito_controller controllerTerjetaDebito = new Tarjeta_de_debito_controller(viewTerjetaDebito, datos,selec_pago, ticket, usuario, vistaPrincipal, viewAdmin, viewUsuario);
>>>>>>> 63aca5e69167a43b6826bd3de98f9beb6ea01090
                
                datos.setDatosPersonales(datosPasajeros);
                
            
            }
        }
        if (e.getSource() == vista.pse) {
            if(validarDatos()){
                vista.setVisible(false);
                viewTransferencia.setVisible(true);
                Seleccion_forma_de_pago_view selec_pago = new Seleccion_forma_de_pago_view();
                Transferencia_controller controllerTransferencia = new Transferencia_controller(viewTransferencia, datos,selec_pago, usuario, vistaPrincipal, viewAdmin, viewUsuario);
                datos.setDatosPersonales(datosPasajeros);
                
            }
        }
        
        if(e.getSource() == this.viewTarjetaCredito.volver){
            vista.setVisible(true);
            viewTarjetaCredito.setVisible(false);
        }
        
        if(e.getSource() == this.viewTerjetaDebito.volver){
            vista.setVisible(true);
            viewTerjetaDebito.setVisible(false);
        }
        
        if(e.getSource() == this.viewTransferencia.volver){
            vista.setVisible(true);
            viewTransferencia.setVisible(false);
        }
        
        
    }
    
    public boolean validarDatos(){
        if(!vista.nombrecampo.getText().isBlank() 
            && !vista.apellidocampo.getText().isBlank()
            && !vista.numero_documento.getText().isBlank()
            && !vista.numeroTel.getText().isBlank()
            && !vista.correo.getText().isBlank()
            && vista.listar_documento.getSelectedIndex() > 0
            && vista.listar_sexo.getSelectedIndex() > 0 
            && vista.listar_nacionalidad.getSelectedIndex() > 0
            && vista.elegir_fecha.getDate() != null){
            
            if(datosCorrectos()){
                guardarDatos();
                return true;
            }else{
                return false;
            }
            
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Debes llenar todos los datos", "Llenar datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
    public void guardarDatos(){
        
        String nombre, apellido, numDocumento, numTel, correo, sexo, nacionalidad, fechaNacimiento;
        int tipoDocumento;

        nombre = vista.nombrecampo.getText();
        apellido = vista.apellidocampo.getText();
        numDocumento = vista.numero_documento.getText();
        numTel = vista.numeroTel.getText();
        correo = vista.correo.getText();
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
        datosPersonales.setCorreo(correo);
        datosPersonales.setCodigo_tipo_documento(tipoDocumento);
        datosPersonales.setSexo(sexo);
        datosPersonales.setNacionalidad(nacionalidad);
        datosPersonales.setFecha_nacimiento(fechaNacimiento);

        datosPasajeros.add(datosPersonales);
    
    }
    
    private boolean datosCorrectos(){
        String numDocumento = vista.numero_documento.getText();
        String numTel = quitarEspaciosPuntos(vista.numeroTel.getText());
        String correo = vista.correo.getText();
        int tipo_documento = vista.listar_documento.getSelectedIndex();
                
        int puntos = 0;
        
        if(numDocumento.charAt(0) == '0'){
            puntos--;
            JOptionPane.showMessageDialog(vista,
                                "El numero de documento no puede empesar por 0", "Numero de documento invalido", JOptionPane.WARNING_MESSAGE);
        }
        if (numDocumento.length() <= 17){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu numero de documento pasa el maximo de caracteres para el sistema", "Numero de documento invalido", JOptionPane.WARNING_MESSAGE);
        }
        
        if (numDocumento.length() >= 8){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu numero de documento no alcansa el minimo de caracteres para el sistema", "Numero de documento invalido", JOptionPane.WARNING_MESSAGE);
        }  
        
        if(numTel.charAt(0) == '0'){
            puntos--;
            JOptionPane.showMessageDialog(vista,
                                "El numero de celular no puede empesar por 0", "Numero de documento invalido", JOptionPane.WARNING_MESSAGE);
        }
        
        if (numTel.length() == 10){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Un numero de celular sin codigo de pais Ej:(+57) debe tener 10 digitos", "Numero de telefonos invalido", JOptionPane.WARNING_MESSAGE);
        }
        
        if(correoCorrecto(correo)){
            puntos++;
        }else{
            JOptionPane.showMessageDialog(vista,
                                "Tu correo no es valido revisa que tu correo tenga \n'@' y termine en '.co' o '.com' y tenga el servidor Ej:(@gmail.com)", "Correo", JOptionPane.WARNING_MESSAGE);
        }
        
        if(tipo_documento > 3){
            puntos++;
        }else{
            if(tipo_documento == 1){
                Calendar limite = Calendar.getInstance();
                limite.add(Calendar.YEAR, -6);

                Date fechaNacimiento = vista.elegir_fecha.getDate();
                
                if(fechaNacimiento.after(limite.getTime())){
                    puntos++;
                }else{
                    JOptionPane.showMessageDialog(vista,
                                "El tipo de documento no concuerda con tu edad", "Fecha de nacimiento", JOptionPane.WARNING_MESSAGE);
                }
            }
            
            if(tipo_documento == 2){
                Calendar limite1 = Calendar.getInstance();
                limite1.add(Calendar.YEAR, -7);
                
                Calendar limite2 = Calendar.getInstance();
                limite2.add(Calendar.YEAR, -18);

                Date fechaNacimiento = vista.elegir_fecha.getDate();
                
                if(fechaNacimiento.before(limite1.getTime()) && fechaNacimiento.after(limite2.getTime())){
                    puntos++;
                }else{
                    JOptionPane.showMessageDialog(vista,
                                "El tipo de documento no concuerda con tu edad", "Fecha de nacimiento", JOptionPane.WARNING_MESSAGE);
                }
            }
            
            if(tipo_documento == 3){
                Calendar limite = Calendar.getInstance();
                limite.add(Calendar.YEAR, -17);

                Date fechaNacimiento = vista.elegir_fecha.getDate();
                
                if(fechaNacimiento.before(limite.getTime())){
                    puntos++;
                }else{
                    JOptionPane.showMessageDialog(vista,
                                "El tipo de documento no concuerda con tu edad", "Fecha de nacimiento", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        if(puntos == 5){
            return true;
        }else{
            return false;
        }
    }
    
    private String quitarEspaciosPuntos(String texto){
        String resultado="";
        for(int i = 0; i < texto.length(); i++){
            char numero = texto.charAt(i);
            if(numero == ' ' || numero == '.'){
                continue;
            }else{
                resultado = resultado+numero;
            }
        }
        return resultado;
    }
    
    private boolean correoCorrecto(String texto){
        String dominio="", co="", com="";
        int puntos = 0;
        for(int i = texto.length()-1; i >= 0; i--){
            char letra = texto.charAt(i);
            if(letra == '@'){
                dominio = texto.substring(i, texto.length());
                puntos++;
                
                if (dominio.length() > 5) {
                    co = dominio.substring(dominio.length()-3, dominio.length());
                    if (dominio.length() > 6) {
                        com = dominio.substring(dominio.length()-4, dominio.length());
                    }
                    if (co.equals(".co") || com.equals(".com")) {
                        puntos++;
                    }
                }
            }
        }
        
        if(puntos == 2){
            return true;
        }else{
            return false;
        }
    
    }
    
}
