/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Nikob
 */
public class Codigo_descuento {
    private int idCodigo;
    private String codigo;
    private int porcentajeDescuento;
    private boolean usado;

    public int getIdCodigo() { return idCodigo; }
    public void setIdCodigo(int idCodigo) { this.idCodigo = idCodigo; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(int porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }

    public boolean isUsado() { return usado; }
    public void setUsado(boolean usado) { this.usado = usado; }
}