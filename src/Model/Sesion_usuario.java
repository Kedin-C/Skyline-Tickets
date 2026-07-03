/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nikob
 */

public class Sesion_usuario {

    
    private static Usuario usuarioLogueado;

    public static void setUsuario(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioLogueado;
    }
}
