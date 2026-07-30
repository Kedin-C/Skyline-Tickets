package View;

import Controller.Elegir_puestos_controller;
import View.Buscar_vuelos_view;
import View.Datos_y_pago_view;
import View.Elegir_clase_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;

/**
 * Registro estático con referencias a las vistas/controladores que se crean
 * UNA sola vez al iniciar la app (patrón usado en todo el proyecto) y que
 * necesitan "limpiarse" cuando el usuario vuelve a la página principal
 * después de completar una compra.
 *
 * Se llenan una única vez desde donde se crea cada vista (main() o el
 * controlador correspondiente), y desde cualquier otro punto de la app
 * se puede acceder a ellas sin tener que pasarlas por constructor.
 */
public class Vistas_globales {

    public static Buscar_vuelos_view buscarVuelos;
    public static Elegir_clase_view elegirClase;
    public static Datos_y_pago_view datosYPago;
    public static Elegir_puestos_controller elegirPuestosController;
    public static Tarjeta_de_credito_view tarjetaCredito;
    public static Tarjeta_de_debito_view tarjetaDebito;
}
