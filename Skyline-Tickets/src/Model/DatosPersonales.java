/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class DatosPersonales {
    
    private int id, codigo_tipo_documento;
    private String numero_documento, nombre, apellido, numero_telefono, correo, nationalidad, sexo, fecha_nacimiento;
    
    public DatosPersonales(){
    
    }
    
    public DatosPersonales(int id, int codigo_tipo_documento, String numero_documento, String nombre, String apellido, String numero_telefono, String correo, String nationalidad, String sexo, String fecha_nacimiento){
        this.id = id;
        this.codigo_tipo_documento = codigo_tipo_documento;
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_telefono = numero_telefono;
        this.correo = correo;
        this.nationalidad = nationalidad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo_tipo_documento(int codigo_tipo_documento) {
        this.codigo_tipo_documento = codigo_tipo_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNationalidad(String nationalidad) {
        this.nationalidad = nationalidad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId() {
        return id;
    }

    public int getCodigo_tipo_documento() {
        return codigo_tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNationalidad() {
        return nationalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "DatosPersonales{" + "id=" + id + ", codigo_tipo_documento=" + codigo_tipo_documento + ", numero_documento=" + numero_documento + ", nombre=" + nombre + ", apellido=" + apellido + ", numero_telefono=" + numero_telefono + ", correo=" + correo + ", nationalidad=" + nationalidad + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
    
    
    
}
