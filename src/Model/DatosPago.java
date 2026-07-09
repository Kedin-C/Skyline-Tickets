/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class DatosPago {
    private int id, cvv;
    private String numero_tarjeta, nombre_titular, fecha_vencimiento;
    
    public DatosPago(){
    
    }
    
    public DatosPago(int id, int cvv, String numeto_tarjeta, String nombre_titular, String fecha_vencimiento){
        this.id = id;
        this.cvv = cvv;
        this.numero_tarjeta = numeto_tarjeta;
        this.nombre_titular = nombre_titular;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId() {
        return id;
    }

    public int getCvv() {
        return cvv;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    
    
    @Override
    public String toString() {
        return "DatosPago{" + "id=" + id + ", cvv=" + cvv + ", numeto_tarjeta=" + numero_tarjeta + ", nombre_titular=" + nombre_titular + ", fecha_vencimiento=" + fecha_vencimiento + '}';
    }
    
    

}
