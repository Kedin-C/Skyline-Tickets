/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Codigo_descuento;
import Model.Codigo_descuentoDao;
import Model.Datos;
import Model.DatosPago;
import Model.DatosPagoDao;
import Model.ReservasDao;
import Model.Ticket;
import Model.Ticket_dao;
import Model.Usuario;
import View.Confirmar_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
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

public class Tarjeta_de_credito_controller implements ActionListener {

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
    private And_puestos pv;
    private ReservasDao reservas_dao = new ReservasDao();
    private Seleccion_de_Modificacion_de_vuelo_view view_modificar_ticket;
    private Codigo_descuentoDao descuentoDao = new Codigo_descuentoDao();
    private Codigo_descuento codigoDes = new Codigo_descuento();

    public Tarjeta_de_credito_controller(Tarjeta_de_credito_view vista, Datos datos, Seleccion_forma_de_pago_view vista_atras, Ticket ticket, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario, And_puestos pv, Seleccion_de_Modificacion_de_vuelo_view view_modificar_ticket) {

        this.view_modificar_ticket = view_modificar_ticket;
        this.vista_atras = vista_atras;
        this.vista = vista;
        this.datos = datos;
        this.ticket = ticket;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        this.pv = pv;

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
        ((JTextField) this.vista.fecha_ven.getDateEditor().getUiComponent()).setEditable(false);


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

        if (e.getSource() == vista.pagar) {
            if (Validar()) {
                double porcentaje = 0;
                datosPagar.setNumero_tarjeta(vista.num_tarjeta.getText());

                SimpleDateFormat formateadorRegreso = new SimpleDateFormat("yyyy-MM-dd");
                //aplicando el metodo que deja la fecha tal cual en el campo de fecha regreso
                String fecha = formateadorRegreso.format(vista.fecha_ven.getDate());

                datosPagar.setFecha_vencimiento(fecha);

                datosPagar.setCvv(Integer.parseInt(vista.cvv.getText()));

                datosPagar.setNombre_titular(vista.nombre_titular.getText());
                
                if(!vista.codigoDescuento.getText().isBlank()){
                    codigoDes = descuentoDao.aplicarCodigo(vista.codigoDescuento.getText());
                    porcentaje = codigoDes.getPorcentajeDescuento();
                    porcentaje /= 100;
                    descuentoDao.codigoUsado(vista.codigoDescuento.getText());
                    
                    if(!codigoDes.isUsado()){
                        double aplicarDes = datos.getTotalPagar() * porcentaje; 
                        datosPagar.setTotal(datos.getTotalPagar() - aplicarDes);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo aplicar tu codigo de descuento");
                        datosPagar.setTotal(datos.getTotalPagar());
                    }
                    
                }else{
                    datosPagar.setTotal(datos.getTotalPagar());
                }

                datosPagar.setMedioPago("credito");

                datos.setDatosPago(datosPagar);

                if (datos.vista_pago == 1) {

                    datosPagarDao.enviarDatos(datosPagar);
                    ticketdao.modificarEquipaje(ticket.getId(), datos.getEquipajeExtra());
                    Confirmar_pago_view viewPago = new Confirmar_pago_view();
                    Confirmar_pago_controller pago_cont = new Confirmar_pago_controller(viewPago, vistaPrincipal, viewAdmin, viewUsuario, usuario);

                    final ArrayList<Integer> listaPasajeros;

                    if (datos.id_pasajero != null && !datos.id_pasajero.isEmpty()) {
                        // Caso compra: ya hay datos cargados, se usan tal cual
                        listaPasajeros = datos.id_pasajero;
                    } else {
                        listaPasajeros = new ArrayList<>();
                        listaPasajeros.add(ticket.getId_pasajero());
                    }

                    int id_pasajero = listaPasajeros.get(0);

                    mostrarInformacionPago(viewPago, id_pasajero);


                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                } else if (datos.vista_pago == 2) {

                    datosPagarDao.enviarDatos(datosPagar);

                    int id = ticketdao.codigoReserva(ticket.getId());
                    String asiento = pv.getPuesto();

                    reservas_dao.cambiarReserva(id, asiento);

                    vista.setVisible(false);

                    
                    Confirmar_pago_view viewPago = new Confirmar_pago_view();
                    Confirmar_pago_controller pago_cont = new Confirmar_pago_controller(viewPago, vistaPrincipal, viewAdmin, viewUsuario, usuario);

                    final ArrayList<Integer> listaPasajeros;

                    if (datos.id_pasajero != null && !datos.id_pasajero.isEmpty()) {
                        listaPasajeros = datos.id_pasajero;
                    } else {
                        listaPasajeros = new ArrayList<>();
                        listaPasajeros.add(ticket.getId_pasajero());
                    }

                    int id_pasajero = listaPasajeros.get(0);

                    mostrarInformacionPago(viewPago, id_pasajero);


                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                } else {
                    datos.subirDatos();
                    datos.ids();
                    datos.subirTicket();
                    Confirmar_pago_view viewPago = new Confirmar_pago_view();
                    Confirmar_pago_controller pago_cont = new Confirmar_pago_controller(viewPago, vistaPrincipal, viewAdmin, viewUsuario, usuario);

                    final ArrayList<Integer> listaPasajeros;

                    if (datos.id_pasajero != null && !datos.id_pasajero.isEmpty()) {
                        // Caso compra: ya hay datos cargados, se usan tal cual
                        listaPasajeros = datos.id_pasajero;
                    } else {
                        listaPasajeros = new ArrayList<>();
                        listaPasajeros.add(ticket.getId_pasajero());
                    }

                    int id_pasajero = listaPasajeros.get(0);

                    
                    mostrarInformacionPago(viewPago, id_pasajero);

                    

                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                }

            }
        }

        if (e.getSource() == vista.volver) {

            if (vista.getCod_anterior_view() == 1) {

                vista.setVisible(false);
                vista_atras.setVisible(true);
                vista_atras.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

        }

    }

    private boolean Validar() {
        if (!vista.num_tarjeta.getText().isBlank()
                && vista.fecha_ven.getDate() != null
                && !vista.cvv.getText().isBlank()
                && !vista.nombre_titular.getText().isBlank()) {
            if (datosCorrectos()) {
                return true;
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(vista,
                    "Debes llenar todos los datos de la tarjeta de credito", "Llenar datos tarjeta credito", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean datosCorrectos() {
        String num_tarjeta = quitarEspacios(vista.num_tarjeta.getText());
        String cvv = vista.cvv.getText();

        int puntos = 0;

        if (num_tarjeta.length() <= 19) {
            puntos++;
        } else {
            JOptionPane.showMessageDialog(vista,
                    "Tu numero de tarjeta supero el limite de digitos (19)", "Numero de tarjeta", JOptionPane.WARNING_MESSAGE);
        }

        if (num_tarjeta.length() >= 13) {
            puntos++;
        } else {
            JOptionPane.showMessageDialog(vista,
                    "Tu numero de tarjeta no llega al minimo de digitos (13)", "Numero de tarjeta", JOptionPane.WARNING_MESSAGE);
        }

        if (cvv.length() == 3) {
            puntos++;
        } else {
            JOptionPane.showMessageDialog(vista,
                    "Tu CVV debe tener 3 digitos", "CVV", JOptionPane.WARNING_MESSAGE);
        }

        if (puntos == 3) {
            return true;
        } else {
            return false;
        }
    }

    private String quitarEspacios(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char numero = texto.charAt(i);
            if (numero == ' ') {
                continue;
            } else {
                resultado = resultado + numero;
            }
        }
        return resultado;

    }

    private void mostrarInformacionPago(Confirmar_pago_view viewPago, int id_pasajero) {
        int ticketp = ticketdao.obtenerCodTicket(id_pasajero);
        viewPago.lblNumeroTicket.setText("NUMERO DE TICKET: " + ticketp);
        String nombrep = ticketdao.obtenerNombrePasajero(id_pasajero);
        viewPago.lblNombrePasajero.setText("NOMBRE DEL PASAJERO: " + nombrep);
        String codVuelo = ticketdao.obtenerCodigoVuelo(id_pasajero);
        viewPago.lblReferenciaPago.setText("CÓDIGO DE VUELO: " + codVuelo);
        String origenp = ticketdao.obtenerOrigen(id_pasajero);
        viewPago.lblOrigen.setText(origenp);
        String destinop = ticketdao.obtenerDestino(id_pasajero);
        viewPago.lblDestino.setText(destinop);
        String fechap = ticketdao.obtenerFechaVuelo(id_pasajero);
        viewPago.lblFechaIda.setText("FECHA: " + fechap);
        int clase = ticketdao.obtenerClase(id_pasajero);
        int equipaje = ticketdao.obtenerEquiExtra(id_pasajero);
        double total = datos.getDatosPago().getTotal();
        int totalTickets = datos.getNumeroTickets();

        if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
            viewPago.lblFlechaVuelta.setVisible(true);
            viewPago.lblFechaVuelta.setVisible(true);
            String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
            viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
            String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
            viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
        }

        String nombreClase = "";
        double costoClase = 0;
        if (clase == 1) {
            nombreClase = "Clase Economica";
        } else if (clase == 2) {
            nombreClase = "Clase Ejecutiva";
            costoClase = 250000.0;
        } else if (clase == 3) {
            nombreClase = "Primera Clase";
            costoClase = 400000.0;
        }
        viewPago.lblClase.setText("CLASE: " + nombreClase);

        if (equipaje > 0) {
            viewPago.lblEquipaje.setText("EQUIPAJE EXTRA: " + equipaje + " KG");
        } else {
            viewPago.lblEquipaje.setText("EQUIPAJE EXTRA: Ninguno");
        }
        
        double costoAsiento = 0;
        if (datos.getEscogerAsiento() == 0) {
            viewPago.lblAsiento.setText("Escogiste el o los asientos de forma aleatoria es sin costo");
        } else {
            
            if (clase == 1) {
                costoAsiento = 30000.0;
            } else if (clase == 2) {
                costoAsiento = 50000.0;
            } else if (clase == 3) {
                costoAsiento = 80000.0;
            }

            viewPago.lblAsiento.setText("Cobro Asiento: " + String.format("%,.0f", costoAsiento) + " COP");
        }
        
        double costoFinal = 0;
        if(totalTickets > 0){
            costoFinal = total / totalTickets;
            
            viewPago.lblCostoTotal.setText("COSTO FINAL INDIVIDUAL POR PERSONA: $" + String.format("%,.0f", costoFinal) + " COP");
        }else{
            costoFinal = total;
            
            viewPago.lblCostoTotal.setText("COSTO FINAL: $" + String.format("%,.0f", costoFinal) + " COP");
        }

    }

    private void envio_Ticket(ArrayList<Integer> listaPasajeros,int idPasajero1) {
        
        new Thread(() -> {
            try {

                Thread.sleep(4000);
                String tipoVuelo = ticketdao.obtenerTipoVuelo(idPasajero1);
                if (tipoVuelo.equals("IDA_VUELTA")) {
                    for (int idPasajero : listaPasajeros) {
                        // Obtener datos desde el DAOD
                        String nombre = ticketdao.obtenerNombrePasajero(idPasajero);
                        String documento = ticketdao.obtenerDocumento(idPasajero);
                        String vuelo = ticketdao.obtenerCodigoVuelo(idPasajero);
                        String origen = ticketdao.obtenerOrigen(idPasajero);
                        String destino = ticketdao.obtenerDestino(idPasajero);
                        String fechat = ticketdao.obtenerFechaVuelo(idPasajero);
                        String asiento = ticketdao.obtenerAsiento(idPasajero);
                        String codigoReserva = ticketdao.obtenerCodigoReserva(idPasajero);
                        String correoDestino = ticketdao.obtenerCorreoPasajero(idPasajero);
                        int ticket = ticketdao.obtenerCodTicket(idPasajero);
                        int clase = ticketdao.obtenerClase(idPasajero);
                        int equipaje = ticketdao.obtenerEquiExtra(idPasajero);
                        String fechaRegreso = ticketdao.obtenerFechaRegreso(idPasajero1);
                        int escogerAsiento = datos.getEscogerAsiento();
                        double total = datos.getDatosPago().getTotal();
                        int totalTickets = datos.getNumeroTickets();

                        // Generar PDF de ida y de vuelta
                        File pdf1 = creador.generarTicket(
                                nombre, documento, vuelo, origen, destino,
                                fechat, asiento, total, codigoReserva, ticket,
                                clase, equipaje, escogerAsiento, totalTickets
                        );

                        File pdf2 = creador.generarTicket(
                                nombre, documento, vuelo, destino, origen,
                                fechaRegreso, asiento, total, codigoReserva, ticket,
                                clase, equipaje, escogerAsiento, totalTickets
                        );

                        // Enviar correo con los 2 PDF adjuntos
                        correo.enviarCorreoConAdjuntos(correoDestino, pdf1, pdf2);

                        JOptionPane.showMessageDialog(null, "Se te envio a tu correo electronico los PDFs de tus tickets");
                    }
                } else {
                    for (int idPasajero : listaPasajeros) {
                        // Obtener datos desde el DAO
                        String nombre = ticketdao.obtenerNombrePasajero(idPasajero);
                        String documento = ticketdao.obtenerDocumento(idPasajero);
                        String vuelo = ticketdao.obtenerCodigoVuelo(idPasajero);
                        String origen = ticketdao.obtenerOrigen(idPasajero);
                        String destino = ticketdao.obtenerDestino(idPasajero);
                        String fechat = ticketdao.obtenerFechaVuelo(idPasajero);
                        String asiento = ticketdao.obtenerAsiento(idPasajero);
                        String codigoReserva = ticketdao.obtenerCodigoReserva(idPasajero);
                        String correoDestino = ticketdao.obtenerCorreoPasajero(idPasajero);
                        int ticket = ticketdao.obtenerCodTicket(idPasajero);
                        int clase = ticketdao.obtenerClase(idPasajero);
                        int equipaje = ticketdao.obtenerEquiExtra(idPasajero);
                        int escogerAsiento = datos.getEscogerAsiento();
                        double total = datos.getDatosPago().getTotal();
                        int totalTickets = datos.getNumeroTickets();

                        // Generar PDF para este pasajero
                        File pdf = creador.generarTicket(
                                nombre, documento, vuelo, origen, destino,
                                fechat, asiento, total, codigoReserva, ticket,
                                clase, equipaje, escogerAsiento, totalTickets
                        );

                        // Enviar correo con el PDF adjunto
                        correo.enviarCorreoConAdjunto(correoDestino, pdf);

                        JOptionPane.showMessageDialog(null, "Se te envio a tu correo electronico el PDF de tu ticket");

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al generar y/o enviar pdf: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }).start();
    }
}
