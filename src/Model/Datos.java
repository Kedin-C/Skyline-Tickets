/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public class Datos {
    
    private int codigoVuelo, numeroTickets, equipajeExtra, claseVuelo;
    private double totalPagar;
    private String tipoVuelo, fechaRegreso;
    private ArrayList<String> codigoAsiento;
    private ArrayList<DatosPersonales> datosPersonales;
    private DatosPago datosPago;
    
    private DatosPersonalesDao datosPersonalesDao = new DatosPersonalesDao();
    
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
            
            String numero_documento = this.datosPersonales.get(i).getNumero_documento();
            String nombre = this.datosPersonales.get(i).getNombre();
            String apellido = this.datosPersonales.get(i).getApellido();
            int codigo_tipo_documento = this.datosPersonales.get(i).getCodigo_tipo_documento();
            String sexo = this.datosPersonales.get(i).getSexo();
            String numero_telefono = this.datosPersonales.get(i).getNumero_telefono();
            String correo = this.datosPersonales.get(i).getCorreo();
            String fecha_nacimiento = this.datosPersonales.get(i).getFecha_nacimiento();
            String nacionalidad = this.datosPersonales.get(i).getNationalidad();
                    
            datosPersonalesDao.enviarDatos(numero_documento, nombre, apellido, codigo_tipo_documento, sexo, numero_telefono, correo, fecha_nacimiento, nacionalidad);
        }
        
        
    }
    
}
