/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Datos {
    
    private int codigoVuelo, numeroTickets, equipajeExtra, claseVuelo;
    private double totalPagar = 0;
    private String tipoVuelo, fechaRegreso;
    private ArrayList<String> codigoAsiento;
    private ArrayList<DatosPersonales> datosPersonales;
    private DatosPago datosPago;
    
    public int elegidos = 1, vista_pago = 0, id_pago;
    
    private DatosPersonalesDao datosPersonalesDao = new DatosPersonalesDao();
    private DatosPagoDao datosPagoDao = new DatosPagoDao();
    private ReservasDao datosReservaDao = new ReservasDao();
    private Ticket_dao ticket = new Ticket_dao();
    
    
    public ArrayList<Integer> id_pasajero = new ArrayList<>();
    public ArrayList<Integer> id_reserva = new ArrayList<>();
    
    public Datos(){
        
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setNumeroTickets(int numeroTickets) {
        this.numeroTickets = numeroTickets;
    }

    public void setEquipajeExtra(int equipajeExtra) {
        this.equipajeExtra = equipajeExtra;
    }

    public void setClaseVuelo(int claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public void setCodigoAsiento(ArrayList<String> codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
    }

    public void setDatosPersonales(ArrayList<DatosPersonales> datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public void setDatosPago(DatosPago datosPago) {
        this.datosPago = datosPago;
    }

    
    
    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public int getNumeroTickets() {
        return numeroTickets;
    }

    public int getEquipajeExtra() {
        return equipajeExtra;
    }

    public int getClaseVuelo() {
        return claseVuelo;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public ArrayList<String> getCodigoAsiento() {
        return codigoAsiento;
    }

    public ArrayList<DatosPersonales> getDatosPersonales() {
        return datosPersonales;
    }

    public DatosPago getDatosPago() {
        return datosPago;
    }
    
    public void subirDatos(){
        for(int i=0; i < datosPersonales.size(); i++){
                    
            datosPersonalesDao.enviarDatos(datosPersonales.get(i));
        }
        
        if(getDatosPago() != null){
            datosPagoDao.enviarDatos(datosPago);
        }
        
        for(int index = 0; index < codigoAsiento.size(); index++){
            datosReservaDao.enviarDatos(codigoAsiento.get(index), codigoVuelo);
        }
    }
    
    public void ids(){
        for(int i=0; i < datosPersonales.size(); i++){
                    
            id_pasajero.add(datosPersonalesDao.idPasajero(datosPersonales.get(i)));
        }
        
        id_pago = datosPagoDao.idPago(datosPago);
        
        for(int index = 0; index < codigoAsiento.size(); index++){
            id_reserva.add(datosReservaDao.idReservas(codigoAsiento.get(index),codigoVuelo));
        }
        JOptionPane.showMessageDialog(null, "ids    "+id_pago+"  "+id_pasajero+"  "+id_reserva+"  "+equipajeExtra+"  "+tipoVuelo);
    }
    
    public void subirTicket(){
        if(id_pago > 0 && id_pasajero.size() > 0 && id_reserva.size() > 0){ 
            for(int i = 0; i < numeroTickets; i++){
                ticket.enviarDatos(id_pago, id_pasajero.get(i), id_reserva.get(i), equipajeExtra, tipoVuelo);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo envial el ticket a la base de datos");
        }
        
    }
}
