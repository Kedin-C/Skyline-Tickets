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
    
    int ticket;
    private String tipo_vuelo;

    private String origen_ida;
    private String destino_ida;

    
    public Ticket(){
    
    
    }
    
    public void setTicket(int ticket){
        this.ticket = ticket;
    }
    
    public int getTicket(){
        return this.ticket;
    }
    
    public void setOrigen_ida(String origen_ida){
        this.origen_ida = origen_ida;
    }
    
    public String getOrigen_ida(){
        return this.origen_ida;
    }
    
    public void setTipo_vuelo(String tipo_vuelo){
        this.tipo_vuelo = tipo_vuelo;
    }
    
    public String getTipo_vuelo(){
        return this.tipo_vuelo;
    }
    
    public void setDestino_ida(String destino_ida){
        this.destino_ida = destino_ida;
    }
    
    public String getDestino_ida(){
        return this.destino_ida;
    }

    
}
