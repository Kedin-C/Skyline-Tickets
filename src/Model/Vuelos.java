/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Vuelos {
    
    private int codigo_vuelo;
    private String origen, destino, hora_salida, hora_llegada;
    private Date fecha;
    private Double precio;      
            
    public Vuelos(){
        
    }
    
    public Vuelos(int codigo_vuelo, String origen, String destino, Date fecha, String hora_salida, String hora_llegada, Double precio){
    
        this.codigo_vuelo = codigo_vuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.precio = precio;
    }

    public int getCodigo_vuelo() {
        return codigo_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCodigo_vuelo(int codigo_vuelo) {
        this.codigo_vuelo = codigo_vuelo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vuelos{" + "codigo_vuelo=" + codigo_vuelo + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", hora_salida=" + hora_salida + ", hora_llegada=" + hora_llegada + ", precio=" + precio + '}';
    }
    
    
    
}
