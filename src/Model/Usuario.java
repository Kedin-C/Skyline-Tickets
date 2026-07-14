/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nikob
 */
public class Usuario {

   
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String rol;
    private String documento;
    private int codigo_tipo_documento;
    private String numero_telefono;
    private String nationalidad, sexo, fecha_nacimiento;
    

    public Usuario(int idUsuario, String nombre, String apellido, String correo, String contraseña, String rol, String documento, int codigo_tipo_documento, String numero_telefono, String nationalidad, String sexo, String fecha_nacimiento) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.documento = documento;
        this.codigo_tipo_documento = codigo_tipo_documento;
        this.numero_telefono = numero_telefono;
        this.nationalidad = nationalidad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

   
    
    

   
    
    public Usuario(){
    }
    public int getIdUsuario(){
        return idUsuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }
    public String getContraseña(){
        return contraseña;
    }
    public String getRol(){
        return rol;
    }
    
    
    
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario=idUsuario;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    } 
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public void setCorreo(String correo){
        this.correo=correo;
    }
    
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    
    public void setRol(String rol){
        this.rol=rol;
    }
    
     public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getCodigo_tipo_documento() {
        return codigo_tipo_documento;
    }

    public void setCodigo_tipo_documento(int codigo_tipo_documento) {
        this.codigo_tipo_documento = codigo_tipo_documento;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getNationalidad() {
        return nationalidad;
    }

    public void setNationalidad(String nationalidad) {
        this.nationalidad = nationalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
     @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", rol=" + rol + ", documento=" + documento + ", codigo_tipo_documento=" + codigo_tipo_documento + ", numero_telefono=" + numero_telefono + ", nationalidad=" + nationalidad + ", sexo=" + sexo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
}
