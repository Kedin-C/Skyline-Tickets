/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

//(Data Transfer Object)
public class Datos {
    
    private int codigoVuelo, numeroTickets, equipajeExtra, claseVuelo, totalPagar;
    private String tipoVuelo, datosPago, fechaRegreso;
    private ArrayList<String> codigoAsiento, datosPersonales;
    
    public Datos(){
        
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setCodigoAsiento(ArrayList<String> codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
    }

    public void setDatosPersonales(ArrayList<String> datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public void setDatosPago(String datosPago) {
        this.datosPago = datosPago;
    }
    
    public void setFechaRegreso(String fechaRegreso){
        this.fechaRegreso = fechaRegreso;
    }

    public void setClaseVuelo(int claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public void setNumeroTickets(int numeroTickets) {
        this.numeroTickets = numeroTickets;
    }

    public void setEquipajeExtra(int equipajeExtra) {
        this.equipajeExtra = equipajeExtra;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
    
    
    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public ArrayList<String> getCodigoAsiento() {
        return codigoAsiento;
    }

    public ArrayList<String> getDatosPersonales() {
        return datosPersonales;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public String getDatosPago() {
        return datosPago;
    }
    
    public String getFechaRegreso(){
        return fechaRegreso;
    }

    public int getClaseVuelo() {
        return claseVuelo;
    }

    public int getNumeroTickets() {
        return numeroTickets;
    }

    public int getEquipajeExtra() {
        return equipajeExtra;
    }

    public int getTotalPagar() {
        return totalPagar;
    }
    
}
