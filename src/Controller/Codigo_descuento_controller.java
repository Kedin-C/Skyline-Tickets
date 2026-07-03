/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Codigo_descuento;
import Model.Codigo_descuentoDao;
/**
 *
 * @author Nikob
 */
public class Codigo_descuento_controller {
    private Codigo_descuentoDao dao;

    public Codigo_descuento_controller() {
        this.dao = new Codigo_descuentoDao();
    }

    public Codigo_descuento generarYGuardarCodigo() {
        Codigo_descuento codigo = dao.generarCodigo();
        boolean guardado = dao.guardarCodigo(codigo);
        if (guardado) {
            return codigo;
        }
        return null;
    }
}

