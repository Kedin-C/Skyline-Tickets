/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Reservas {
    
    private int id, codigo_vuelo;
    String codigo_asiento;
    
    public Reservas(){
    
    }
    
    public Reservas(int id, String codigo_asiento, int codigo_vuelo){
        
        this.id = id;
        this.codigo_asiento = codigo_asiento;
        this.codigo_vuelo = codigo_vuelo;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo_asiento(String codigo_asiento) {
        this.codigo_asiento = codigo_asiento;
    }

    public void setCodigo_vuelo(int codigo_vuelo) {
        this.codigo_vuelo = codigo_vuelo;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public String getCodigo_asiento() {
        return codigo_asiento;
    }

    public int getCodigo_vuelo() {
        return codigo_vuelo;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id=" + id + ", codigo_asiento=" + codigo_asiento + ", codigo_vuelo=" + codigo_vuelo + '}';
    }
    
    
    
}
