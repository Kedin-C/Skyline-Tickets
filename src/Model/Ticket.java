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
    
    int Id;
    private String tipo_vuelo;
    private String origen;
    private String destino;

    
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
    
    @Override
    public String toString(){
    return this.Id + " " + this.tipo_vuelo + " " + this.destino + " " +this.origen;
    }

    
}
