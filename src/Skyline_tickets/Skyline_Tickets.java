/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Skyline_tickets;

import Controller.Buscar_vuelos_controller;
import Controller.Informacion_personal_controller;
import Controller.Inicio_usuario_controller;
import Controller.Interfaz_cambio_clase_controller;
import Controller.Interfaz_equipaje_controller;
import Controller.Login_controller;
import Controller.Modificacion_clase_equipaje_controller;
import Controller.Pagina_principal_administrador_controller_2;
import Controller.Registro_controller;
import Controller.Seleccion_forma_pago_controller;
import Controller.Seleccion_modificacion_vuelo_usuario_controlador;
import Controller.Tarjeta_de_credito_controller;
import Controller.Tarjeta_de_debito_controller;
import Controller.Transferencia_controller;
import Controller.seleccion_modificacion_usuario_no_registrado_controller;
import Model.Datos;
import Model.Seleccion_equipaje_extra_dao;
import Model.Seleccion_modificacion_clase_de_vuelo_dao;
import Model.Seleccion_vuelo_usuario_no_registrado_dao;
import Model.Sesion_usuario;
import Model.Ticket;
import Model.Usuario;
import View.Agregar_equipaje_extra_view;
import View.Apartado_reportes_menu_view;
import View.Buscar_vuelos_view;
import View.Informacion_personal_view;
import View.Inicio_usuario_view;
import View.Login_view;
import View.Menu_principal_view;
import View.Pagina_principal_administrador_view;
import View.Registro_view;
import View.Seleccion_de_Modificacion_de_vuelo_view;
import View.Seleccion_de_vuelo_usuarioNoregistrado_view;
import View.Seleccion_de_vuelo_usuarioRegistrado_view;
import View.Seleccion_forma_de_pago_view;
import View.Tarjeta_de_credito_view;
import View.Tarjeta_de_debito_view;
import View.Transferencia_view;
import View.ViewPrincipal;
import View.cambio_de_clase_de_vuelo_viiew;
import controller.Pagina_principal_controller;

public class Skyline_Tickets {

    public static void main(String[] args) {
        
        ViewPrincipal vista_principal = new ViewPrincipal();
        Login_view login = new Login_view();
        Pagina_principal_administrador_view pagina_admin = new Pagina_principal_administrador_view();
        Inicio_usuario_view pagina_usuario = new Inicio_usuario_view();
        Informacion_personal_view info_per_view = new Informacion_personal_view();
        Usuario usuario = new Usuario();
        Sesion_usuario sesion_usuario =  new Sesion_usuario();
        
        Seleccion_de_vuelo_usuarioRegistrado_view select_vuelo = new Seleccion_de_vuelo_usuarioRegistrado_view();
        Seleccion_de_vuelo_usuarioNoregistrado_view select_vuelo_nor = new Seleccion_de_vuelo_usuarioNoregistrado_view();
        Seleccion_de_Modificacion_de_vuelo_view modificacion = new Seleccion_de_Modificacion_de_vuelo_view();
        cambio_de_clase_de_vuelo_viiew clase = new cambio_de_clase_de_vuelo_viiew();
        Agregar_equipaje_extra_view bodega = new Agregar_equipaje_extra_view();
        Seleccion_forma_de_pago_view forma_pago_vista = new Seleccion_forma_de_pago_view();
        Tarjeta_de_credito_view credito = new Tarjeta_de_credito_view();
        Tarjeta_de_debito_view debito = new Tarjeta_de_debito_view();
        Transferencia_view transferencia = new Transferencia_view();
        Registro_view registro_view = new Registro_view();
        Menu_principal_view menu = new Menu_principal_view(vista_principal,login,registro_view);
        Apartado_reportes_menu_view apart_reportes_menu =  new Apartado_reportes_menu_view();
        Buscar_vuelos_view buscar_v = new Buscar_vuelos_view();
        Informacion_personal_view info_personal = new Informacion_personal_view();
        
        
        
        Ticket ticket = new Ticket();
        Datos datos = new Datos();
        
        Seleccion_vuelo_usuario_no_registrado_dao dao_modificacion_vuelo = new Seleccion_vuelo_usuario_no_registrado_dao();
        Seleccion_modificacion_clase_de_vuelo_dao dao_modificacion_clase_vuelo = new Seleccion_modificacion_clase_de_vuelo_dao();
        Seleccion_equipaje_extra_dao dao_equipaje_extra = new Seleccion_equipaje_extra_dao();
        
        
        Informacion_personal_controller info_per_cont = new Informacion_personal_controller(info_per_view,pagina_usuario,sesion_usuario);

        Interfaz_equipaje_controller interfaz2 = new Interfaz_equipaje_controller(modificacion,bodega,dao_equipaje_extra,ticket,forma_pago_vista);
        Interfaz_cambio_clase_controller interfaz3 = new Interfaz_cambio_clase_controller(modificacion,clase,dao_modificacion_clase_vuelo,ticket,forma_pago_vista);
        Modificacion_clase_equipaje_controller interfaz1 = new Modificacion_clase_equipaje_controller(modificacion,clase,bodega,select_vuelo_nor,ticket,interfaz3,dao_equipaje_extra,select_vuelo);
        seleccion_modificacion_usuario_no_registrado_controller interfaz = new seleccion_modificacion_usuario_no_registrado_controller(dao_modificacion_vuelo,select_vuelo_nor,modificacion,interfaz1,ticket,vista_principal);
        Seleccion_forma_pago_controller forma_pago_controlador = new Seleccion_forma_pago_controller(forma_pago_vista, clase, bodega,credito,debito,transferencia,datos);        
        Tarjeta_de_credito_controller credito_cont = new Tarjeta_de_credito_controller(credito,datos,forma_pago_vista);
        Tarjeta_de_debito_controller debito_cont = new Tarjeta_de_debito_controller(debito,datos,forma_pago_vista);
        Transferencia_controller transferencia_cont = new Transferencia_controller(transferencia,datos,forma_pago_vista);
        Login_controller login_cont = new Login_controller(login,vista_principal,usuario,registro_view,pagina_admin,pagina_usuario,sesion_usuario);
        Registro_controller registro_cont = new Registro_controller(registro_view,menu); 
        Pagina_principal_administrador_controller_2 pagina_admin_cont = new Pagina_principal_administrador_controller_2(pagina_admin,apart_reportes_menu,select_vuelo,buscar_v,ticket,usuario);
        Inicio_usuario_controller pagina_usuario_cont = new Inicio_usuario_controller(pagina_usuario,select_vuelo,buscar_v,info_personal,ticket,usuario,info_per_cont,sesion_usuario);
        Seleccion_modificacion_vuelo_usuario_controlador cont_select_vuelo_registrado = new Seleccion_modificacion_vuelo_usuario_controlador(select_vuelo,usuario,ticket,pagina_admin,pagina_admin_cont,pagina_usuario,pagina_usuario_cont,modificacion);
        
        Buscar_vuelos_controller buscar_v_cont = new Buscar_vuelos_controller(buscar_v,datos,vista_principal,pagina_admin,pagina_usuario);
        
        
        Pagina_principal_controller pagina_princ_cont = new Pagina_principal_controller(vista_principal,select_vuelo_nor,buscar_v,menu);
        
        String ruta = System.getProperty("user.home") + "\\Documents\\Ticket.pdf";
        System.out.println(ruta);
    }
    
}
