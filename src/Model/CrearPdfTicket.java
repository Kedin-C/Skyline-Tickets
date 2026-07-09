/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CrearPdfTicket {
    
    public void CrearPdfTicket() throws FileNotFoundException, DocumentException, BadElementException, IOException{
        Document documento = new Document();
        
        String ruta = System.getProperty("user.home") + "\\Documents\\Ticket.pdf";
        
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        
        documento.open();
        
        Image logo = Image.getInstance("src/Imagenes/Skylinelogo.png");
        
        logo.scaleToFit(120,120);
        
        logo.setAlignment(Element.ALIGN_CENTER);
        
        documento.add(logo);
        
        Paragraph titulo = new Paragraph("SKYLINE TICKETS");
        titulo.setAlignment(Element.ALIGN_CENTER);

        documento.add(titulo);
        
        documento.add(new Paragraph(" "));
        documento.add(new Paragraph("TICKET ELECTRONICO"));
        
        documento.close();
        
        File archivo = new File(ruta);

        System.out.println("Existe: " + archivo.exists());
        System.out.println("Ruta: " + archivo.getAbsolutePath());
    }
    
}
