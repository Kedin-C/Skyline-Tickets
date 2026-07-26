/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import Model.Ticket_dao;
import Model.Usuario;
import View.Confirmar_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_forma_de_pago_view;
import View.Transferencia_view;
import View.ViewPrincipal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Transferencia_controller implements ActionListener{
    
    private Transferencia_view vista;
    private Datos datos;
    private Seleccion_forma_de_pago_view vista_atras;
    private Ticket_dao ticketdao = new Ticket_dao();;
    private Usuario usuario;
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    private CreadorPDFTickets creador = new CreadorPDFTickets();
    private Correo_controller correo = new Correo_controller();
    
    public Transferencia_controller(Transferencia_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario){
        this.vista = vista;
        this.datos = datos;
        this.vista_atras = vista_atras;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        
        this.vista.volver.addActionListener(this);
        this.vista.bancolombia.addActionListener(this);
        this.vista.nequi.addActionListener(this);
        this.vista.paypal.addActionListener(this);
        
//        //Para que los botones enviean a la pagina
////        vista.bancolombia.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent evt) {
////                try {
////                    // Definir la dirección de la página web
////                    String url = "https://svpersonas.apps.bancolombia.com/autenticacion";
////
////                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
////                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
////                        // Abrir la URL en el navegador predeterminado
////                        Desktop.getDesktop().browse(new URI(url));
////                    } else {
////                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
////                    }
////                } catch (Exception e) {
////                    // Por si ocurre un error con la URL o el navegador
////                    e.printStackTrace();
////                }
////            }
////        });
//        
//        vista.paypal.addActionListener(new ActionListener() {
//            @Override
////            public void actionPerformed(ActionEvent evt) {
////                try {
////                    // Definir la dirección de la página web
////                    String url = "https://www.paypal.com/signin?locale.x=es_ES";
////
////                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
////                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
////                        // Abrir la URL en el navegador predeterminado
////                        Desktop.getDesktop().browse(new URI(url));
////                    } else {
////                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
////                    }
////                } catch (Exception e) {
////                    // Por si ocurre un error con la URL o el navegador
////                    e.printStackTrace();
////                }
////            }
//        });
//        
//        vista.nequi.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
////                try {
////                    // Definir la dirección de la página web
////                    String url = "https://transacciones.nequi.com/bdigital/login.jsp";
////
////                    // Verificar si el sistema operativo soporta la acción de abrir el navegador
////                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
////                        // Abrir la URL en el navegador predeterminado
////                        Desktop.getDesktop().browse(new URI(url));
////                    } else {
////                        JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
////                    }
////                } catch (Exception e) {
////                    // Por si ocurre un error con la URL o el navegador
////                    e.printStackTrace();
////                }
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {

            if (vista.getCod_anterior_view() == 1) {

                vista.setVisible(false);
                vista_atras.setVisible(true);
                vista_atras.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        } else if (e.getSource() == vista.bancolombia) {
            try {
                String url = "https://svpersonas.apps.bancolombia.com/autenticacion";

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                } else {
                    JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            datos.subirDatosT();
            datos.idsT();
            datos.subirTicketT();
            
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
        } else if (e.getSource() == vista.nequi) {
            try {
                String url = "https://transacciones.nequi.com/bdigital/login.jsp";

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                } else {
                    JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            datos.subirDatosT();
            datos.idsT();
            datos.subirTicketT();
            
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
        } else if (e.getSource() == vista.paypal) {
            try {
                String url = "https://www.paypal.com/signin?locale.x=es_ES";

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                } else {
                    JOptionPane.showInputDialog("No puedes haceder a este medio de pago");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            datos.subirDatosT();
            datos.idsT();
            datos.subirTicketT();
            
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
    
    

}
