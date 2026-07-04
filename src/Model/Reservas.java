/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Reservas {
    
    private int id, id_asiento, codigo_vuelo; 
    
    public Reservas(){
    
    }
    
    public Reservas(int id, int id_asiento, int codigo_vuelo){
        
        this.id = id;
        this.id_asiento = id_asiento;
        this.codigo_vuelo = codigo_vuelo;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public void setCodigo_vuelo(int codigo_vuelo) {
        this.codigo_vuelo = codigo_vuelo;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public int getCodigo_vuelo() {
        return codigo_vuelo;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id=" + id + ", id_asiento=" + id_asiento + ", codigo_vuelo=" + codigo_vuelo + '}';
    }
    
    
    
}
