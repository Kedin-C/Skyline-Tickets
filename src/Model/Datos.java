/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public class Datos {
    
    private int codigoVuelo, numeroTickets, equipajeExtra, claseVuelo, totalPagar;
    private String tipoVuelo, fechaRegreso;
    private ArrayList<String> codigoAsiento;
    private ArrayList<DatosPersonales> datosPersonales;
    private DatosPago datosPago;
    
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

    public void setTotalPagar(int totalPagar) {
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

    public int getTotalPagar() {
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

    
    
}
