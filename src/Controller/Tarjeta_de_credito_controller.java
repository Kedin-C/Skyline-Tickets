/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Datos;
import Model.DatosPago;
import Model.DatosPagoDao;
import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Buscar_vuelos_view;
import View.Confirmar_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
import View.ViewPrincipal;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private Ticket_dao ticketdao = new Ticket_dao();
    private CreadorPDFTickets creador = new CreadorPDFTickets();
    private Correo_controller correo = new Correo_controller();
    private Ticket ticket;
    private Usuario usuario;
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    

    
    public Tarjeta_de_credito_controller(Tarjeta_de_credito_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras, Ticket ticket, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario){
        
        this.vista_atras = vista_atras;
        this.vista = vista;
        this.datos = datos;
        this.ticket=ticket;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        
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
                
                datosPagar.setNumero_tarjeta(vista.num_tarjeta.getText());
                
                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fecha = formateadorRegreso.format(vista.fecha_ven.getDate());
                
                datosPagar.setFecha_vencimiento(fecha);
                
                datosPagar.setCvv(Integer.parseInt(vista.cvv.getText()));
                
                datosPagar.setNombre_titular(vista.nombre_titular.getText());
                
                datosPagar.setTotal(datos.getTotalPagar());
                
                datos.setDatosPago(datosPagar);
                
                if(datos.vista_pago == 1){
                    
                    datosPagarDao.enviarDatos(datosPagar);
                    ticketdao.modificarEquipaje(ticket.getId(), datos.getEquipajeExtra());
                    
                }else if(datos.vista_pago == 2){
                    
                    datosPagarDao.enviarDatos(datosPagar);
                    
                }else{
                    datos.subirDatos();
                    datos.ids();
                    datos.subirTicket();
                }
                
                Confirmar_pago_view viewPago = new Confirmar_pago_view();
                Confirmar_pago_controller pago_cont = new Confirmar_pago_controller(viewPago, vistaPrincipal, viewAdmin, viewUsuario, usuario);
                
                ArrayList<Integer> lista = datos.id_pasajero;
                int id_pasajero = lista.get(0);
        
                int ticketp = ticketdao.obtenerCodTicket(id_pasajero);
                viewPago.lblNumeroTicket.setText("NUMERO DE TICKET: " + ticketp);
                String nombrep = ticketdao.obtenerNombrePasajero(id_pasajero);
                viewPago.lblNombrePasajero.setText("NOMBRE DEL PASAJERO: "+nombrep);
                String codVuelo = ticketdao.obtenerCodigoVuelo(id_pasajero);
                viewPago.lblReferenciaPago.setText("CÓDIGO DE VUELO: "+codVuelo);
                String origenp = ticketdao.obtenerOrigen(id_pasajero);
                viewPago.lblOrigen.setText(origenp);
                String destinop = ticketdao.obtenerDestino(id_pasajero);
                viewPago.lblDestino.setText(destinop);
                String fechap = ticketdao.obtenerFechaVuelo(id_pasajero);
                viewPago.lblFechaIda.setText("FECHA: "+fechap);
        
                if(datos.getFechaRegreso() != null){
                    viewPago.lblFlechaVuelta.setVisible(true);
                    viewPago.lblFechaVuelta.setVisible(true);
                    String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                    viewPago.lblFechaIda.setText("FECHA IDA: "+fechaida);
                    String fechavuelta = datos.getFechaRegreso();
                    viewPago.lblFechaVuelta.setText("FECHA REGRESO: "+fechavuelta);
                }

                vista.setVisible(false);
                viewPago.setVisible(true);
                viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                new Thread(() -> {
                    try {
                        Thread.sleep(4000);
                        
                        
                        ArrayList<Integer> listaPasajeros = datos.id_pasajero;
                        
                        for (int idPasajero : listaPasajeros) {
                            // Obtener datos desde el DAO
                            String nombre = ticketdao.obtenerNombrePasajero(idPasajero);
                            String documento = ticketdao.obtenerDocumento(idPasajero);
                            String vuelo = ticketdao.obtenerCodigoVuelo(idPasajero);
                            String origen = ticketdao.obtenerOrigen(idPasajero);
                            String destino = ticketdao.obtenerDestino(idPasajero);
                           String fechat = ticketdao.obtenerFechaVuelo(idPasajero);
                           String asiento = ticketdao.obtenerAsiento(idPasajero);
                           double costo = ticketdao.obtenerCosto(idPasajero);
                           String codigoReserva = ticketdao.obtenerCodigoReserva(idPasajero);
                           String correoDestino = ticketdao.obtenerCorreoPasajero(idPasajero);
                           int ticket = ticketdao.obtenerCodTicket(idPasajero);
                           
                          // Generar PDF para este pasajero
                            File pdf = creador.generarTicket(
                               nombre, documento, vuelo, origen, destino,
                               fechat, asiento, costo, codigoReserva, ticket
                           );

                           // Enviar correo con el PDF adjunto
                         correo.enviarCorreoConAdjunto(correoDestino, pdf);
                         
                         JOptionPane.showMessageDialog(null, "Se te envio a tu correo electronico el PDF de tu ticket");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, e.toString(),
                        "Error al generar y/o enviar pdf: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    }
                }).start();
                
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
        String cvv = vista.cvv.getText();
        
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
        
        if(cvv.length() == 3){
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
