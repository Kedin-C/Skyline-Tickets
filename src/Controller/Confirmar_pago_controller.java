/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import Model.Usuario;
import View.Vistas_globales;
import View.Confirmar_pago_view;
import View.Inicio_usuario_view;
import View.Pagina_principal_administrador_view;
import View.ViewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author juans
 */
public class Confirmar_pago_controller implements ActionListener{
    
    public Confirmar_pago_view view;
    public ViewPrincipal viewPrin;
    public Pagina_principal_administrador_view viewAdmin;
    public Inicio_usuario_view viewUsu;
    public Usuario usu;

    public Confirmar_pago_controller(Confirmar_pago_view view, ViewPrincipal viewPrin, Pagina_principal_administrador_view viewAdmin, Inicio_usuario_view viewUsu,Usuario usu) {
        this.view = view;
        this.viewPrin = viewPrin;
        this.viewAdmin = viewAdmin;
        this.viewUsu = viewUsu;
        this.usu = usu;
        this.view.volver.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.volver){

            // Reiniciar todo el estado del proceso de compra
            Datos.getInstance().reset();

            // Limpiar el formulario de búsqueda de vuelos
            if (Vistas_globales.buscarVuelos != null) {
                Vistas_globales.buscarVuelos.listar_origen.setSelectedIndex(0);
                Vistas_globales.buscarVuelos.listar_destino.setSelectedIndex(0);
                Vistas_globales.buscarVuelos.listar_horario.setSelectedIndex(0);
                Vistas_globales.buscarVuelos.elegir_fecha_ida.setDate(null);
                Vistas_globales.buscarVuelos.elegir_fecha_regreso.setDate(null);
                Vistas_globales.buscarVuelos.modelo.setRowCount(0);
            }

            // Limpiar la pantalla de elegir clase de vuelo
            if (Vistas_globales.elegirClase != null) {
                Vistas_globales.elegirClase.economica.setSelected(false);
                Vistas_globales.elegirClase.ejecutiva.setSelected(false);
                Vistas_globales.elegirClase.primera.setSelected(false);
                Vistas_globales.elegirClase.listarNumeros.setSelectedIndex(0);
                Vistas_globales.elegirClase.listarEquipaje.setSelectedIndex(0);
            }

            // Limpiar la selección de asientos de la compra anterior
            if (Vistas_globales.elegirPuestosController != null) {
                Vistas_globales.elegirPuestosController.setAsientos();
            }

            // Limpiar los datos personales y de pago ingresados
            if (Vistas_globales.datosYPago != null) {
                Vistas_globales.datosYPago.nombrecampo.setText("");
                Vistas_globales.datosYPago.apellidocampo.setText("");
                Vistas_globales.datosYPago.numero_documento.setText("");
                Vistas_globales.datosYPago.numeroTel.setText("");
                Vistas_globales.datosYPago.correo.setText("");
                Vistas_globales.datosYPago.precioTotal.setText("");
                Vistas_globales.datosYPago.elegir_fecha.setDate(null);
                Vistas_globales.datosYPago.listar_documento.setSelectedIndex(0);
                Vistas_globales.datosYPago.listar_sexo.setSelectedIndex(0);
                Vistas_globales.datosYPago.listar_nacionalidad.setSelectedIndex(0);
            }

            // Limpiar los campos de la tarjeta de crédito
            if (Vistas_globales.tarjetaCredito != null) {
                Vistas_globales.tarjetaCredito.num_tarjeta.setText("");
                Vistas_globales.tarjetaCredito.cvv.setText("");
                Vistas_globales.tarjetaCredito.nombre_titular.setText("");
                Vistas_globales.tarjetaCredito.codigoDescuento.setText("");
                Vistas_globales.tarjetaCredito.fecha_ven.setDate(null);
            }

            // Limpiar los campos de la tarjeta de débito
            if (Vistas_globales.tarjetaDebito != null) {
                Vistas_globales.tarjetaDebito.num_tarjeta.setText("");
                Vistas_globales.tarjetaDebito.cvv.setText("");
                Vistas_globales.tarjetaDebito.nombre_titular.setText("");
                Vistas_globales.tarjetaDebito.codigoDescuento.setText("");
                Vistas_globales.tarjetaDebito.fecha_ven.setDate(null);
            }

//            view.setVisible(false);
//            viewPrin.setVisible(true);
//            viewPrin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            if(usu.getRol() == 1){
                view.setVisible(false);
                viewAdmin.setVisible(true);
                viewAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else if(usu.getRol() == 2){
                view.setVisible(false);
                viewUsu.setVisible(true);
                viewUsu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else{
                view.setVisible(false);
                viewPrin.setVisible(true);
                viewPrin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }

    
}
