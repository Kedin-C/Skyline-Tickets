/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.And_puestos;
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
import View.Seleccion_forma_de_pago_view;
import View.Transferencia_view;
import View.ViewPrincipal;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Transferencia_controller implements ActionListener{
    
    private Transferencia_view vista;
    private Datos datos;
    private Seleccion_forma_de_pago_view vista_atras;
    private Ticket_dao ticketdao = new Ticket_dao();;
    private Usuario usuario;
    private DatosPago datosPagar = new DatosPago();
    private ViewPrincipal vistaPrincipal;
    private Pagina_principal_administrador_view viewAdmin;
    private Inicio_usuario_view viewUsuario;
    private CreadorPDFTickets creador = new CreadorPDFTickets();
    private Correo_controller correo = new Correo_controller();
    private DatosPagoDao datosPagarDao = new DatosPagoDao();
    private ReservasDao reservas_dao = new ReservasDao();
    private And_puestos pv;
    private Ticket ticket;
    
    public Transferencia_controller(Transferencia_view vista, Datos datos,Seleccion_forma_de_pago_view vista_atras, Usuario usuario, ViewPrincipal vistaPrincipal, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsuario, Ticket ticket,And_puestos pv){
        this.vista = vista;
        this.datos = datos;
        this.vista_atras = vista_atras;
        this.usuario = usuario;
        this.vistaPrincipal = vistaPrincipal;
        this.viewAdmin = viewAdmin;
        this.viewUsuario = viewUsuario;
        this.pv = pv;
        this.ticket = ticket;
        
        this.vista.volver.addActionListener(this);
        this.vista.bancolombia.addActionListener(this);
        this.vista.nequi.addActionListener(this);
        this.vista.paypal.addActionListener(this);
        
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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                }
        } else if (e.getSource() == vista.nequi) {

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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                }
        } else if (e.getSource() == vista.paypal) {

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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO AGREGAR EQUIPAJE EXTRA EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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

                    viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE");
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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblMensaje.setText("SE HA REALIZADO CON EXITO LA MODIFICACIÓN DE LA CLASE EN AMBOS VUELOS");
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

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
                    mostrarClaseEquipajeCosto(viewPago, id_pasajero);

                    if ("IDA_VUELTA".equals(ticketdao.obtenerTipoVuelo(id_pasajero))) {
                        viewPago.lblFlechaVuelta.setVisible(true);
                        viewPago.lblFechaVuelta.setVisible(true);
                        String fechaida = ticketdao.obtenerFechaVuelo(id_pasajero);
                        viewPago.lblFechaIda.setText("FECHA IDA: " + fechaida);
                        String fechavuelta = ticketdao.obtenerFechaRegreso(id_pasajero);
                        viewPago.lblFechaVuelta.setText("FECHA REGRESO: " + fechavuelta);
                    }

                    vista.setVisible(false);
                    viewPago.setVisible(true);
                    viewPago.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    envio_Ticket(listaPasajeros,id_pasajero);

                }
        }

    }

    private void mostrarClaseEquipajeCosto(Confirmar_pago_view viewPago, int id_pasajero) {
        int clase = ticketdao.obtenerClase(id_pasajero);
        int equipaje = ticketdao.obtenerEquiExtra(id_pasajero);
        double costo = ticketdao.obtenerCosto(id_pasajero);

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

        double costoFinal = costoClase + (equipaje * 10000) + costo;
        viewPago.lblCostoTotal.setText("COSTO FINAL: $" + String.format("%,.0f", costoFinal) + " COP");
    }

    private void envio_Ticket(ArrayList<Integer> listaPasajeros,int idPasajero1) {
        
        new Thread(() -> {
            try {

                Thread.sleep(4000);
                String tipoVuelo = ticketdao.obtenerTipoVuelo(idPasajero1);
                System.out.println(listaPasajeros);
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
                        double costo = ticketdao.obtenerCosto(idPasajero);
                        String codigoReserva = ticketdao.obtenerCodigoReserva(idPasajero);
                        String correoDestino = ticketdao.obtenerCorreoPasajero(idPasajero);
                        int ticket = ticketdao.obtenerCodTicket(idPasajero);
                        int clase = ticketdao.obtenerClase(idPasajero);
                        int equipaje = ticketdao.obtenerEquiExtra(idPasajero);
                        String fechaRegreso = ticketdao.obtenerFechaRegreso(idPasajero1);

                        // Generar PDF de ida y de vuelta
                        File pdf1 = creador.generarTicket(
                                nombre, documento, vuelo, origen, destino,
                                fechat, asiento, costo, codigoReserva, ticket,
                                clase, equipaje
                        );

                        File pdf2 = creador.generarTicket(
                                nombre, documento, vuelo, destino, origen,
                                fechaRegreso, asiento, costo, codigoReserva, ticket,
                                clase, equipaje
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
                        double costo = ticketdao.obtenerCosto(idPasajero);
                        String codigoReserva = ticketdao.obtenerCodigoReserva(idPasajero);
                        String correoDestino = ticketdao.obtenerCorreoPasajero(idPasajero);
                        int ticket = ticketdao.obtenerCodTicket(idPasajero);
                        int clase = ticketdao.obtenerClase(idPasajero);
                        int equipaje = ticketdao.obtenerEquiExtra(idPasajero);

                        // Generar PDF para este pasajero
                        File pdf = creador.generarTicket(
                                nombre, documento, vuelo, origen, destino,
                                fechat, asiento, costo, codigoReserva, ticket,
                                clase, equipaje
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