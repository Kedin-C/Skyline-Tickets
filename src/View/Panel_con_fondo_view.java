/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author juans
 */
public class Panel_con_fondo_view extends JPanel{
    
    private Image imagenFondo;

    public Panel_con_fondo_view(String rutaImagen){
        java.net.URL recurso = getClass().getResource(rutaImagen);
        if (recurso == null) {
            throw new RuntimeException("No se encontró la imagen de fondo en la ruta: " + rutaImagen
                    + ". Verifica que el archivo exista dentro de src/Imagenes y haz un Clean and Build.");
        }
        imagenFondo = new ImageIcon(recurso).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
    
}
