/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author david
 */
public class Ticket {
    
    int Id, id_pago, id_reserva, id_pasajero, equipaje_extra;

    private String tipo_vuelo;
    private String origen;
    private String destino;
    private String fecha;

    
    public Ticket(){
    
    
    }
    
    public void setId(int Id){
        this.Id = Id;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    public void setTipo_vuelo(String tipo_vuelo){
        this.tipo_vuelo = tipo_vuelo;
    }
    
    public String getTipo_vuelo(){
        return this.tipo_vuelo;
    }
    
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public String getDestino(){
        return this.destino;
    }
    
    
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getEquipaje_extra() {
        return equipaje_extra;
    }

    public void setEquipaje_extra(int equipaje_extra) {
        this.equipaje_extra = equipaje_extra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ticket{" + "Id=" + Id + ", id_pago=" + id_pago + ", id_reserva=" + id_reserva + ", id_pasajero=" + id_pasajero + ", equipaje_extra=" + equipaje_extra + ", tipo_vuelo=" + tipo_vuelo + ", origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + '}';
    }
    
   

    
}
