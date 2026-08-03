/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author juans
 */
public class CreadorPDFTickets {
    
    
    public File generarTicket(String nombrePasajero, String documento, String vuelo,
                              String origen, String destino, String fecha, String asiento,
                              double costo, String codigoReserva,int ticket, int clase, int equipaje) {
        
        File archivo = null;
        try {
            Document document = new Document();
            String nombreArchivo = "Ticket_"+nombrePasajero+"_"+origen+"_"+destino+".pdf";
            nombreArchivo = nombreArchivo.replaceAll("\\s+", "_");
            archivo = new File("Ticket_"+nombreArchivo+".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(archivo));
            document.open();

            // Encabezado
            Font titulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Paragraph encabezado = new Paragraph("TICKET DE VUELO\n\n", titulo);
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);

            // Datos del pasajero
            Font subtitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            document.add(new Paragraph("Pasajero", subtitulo));
            document.add(new Paragraph("Nombre: " + nombrePasajero));
            document.add(new Paragraph("Documento: " + documento + "\n"));

            // Datos del vuelo
            document.add(new Paragraph("Vuelo", subtitulo));
            document.add(new Paragraph("Código de vuelo: " + vuelo));
            document.add(new Paragraph("Código de ticket: " + ticket));
            document.add(new Paragraph("Origen: " + origen));
            document.add(new Paragraph("Destino: " + destino));
            document.add(new Paragraph("Fecha: " + fecha));
            document.add(new Paragraph("Asiento: " + asiento));
            String nombreClase = "";
            String costoClase = "";
            double costoC = 0;
            if(clase == 1){
                nombreClase = "Clase Económica";
                costoClase = " + $0 COP";
            } else if (clase == 2) {
                nombreClase = "Clase Ejecutiva";
                costoClase = " + $250.000 COP";
                costoC = 250000.0;
            } else if (clase == 3) {
                nombreClase = "Primera Clase";
                costoClase = " + $400.000 COP";
                costoC = 400000.0;
            }
            document.add(new Paragraph("Clase: " + nombreClase + costoClase + "\n"));
            if (equipaje > 0) {
                double precioPorKg = 10000;
                double costoE = equipaje * precioPorKg;

                document.add(new Paragraph("Equipaje Extra en Bodega: " + equipaje + " KG"));
                document.add(new Paragraph("Costo de Equipaje Extra en Bodega: $" + String.format("%,.0f", costoE) + " COP"));
            }

            double costoFinal = costoC + (equipaje * 10000) + costo;

            // Costo
            Font costoFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.DARK_GRAY);
            document.add(new Paragraph("Costo Final: $" + String.format("%,.0f", costoFinal) + " COP\n", costoFont));

            // Generar QR con datos clave
            String dataQR = "Reserva:" + codigoReserva + ".\nVuelo:" + vuelo + ".\nPasajero:" + nombrePasajero;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(dataQR, BarcodeFormat.QR_CODE, 150, 150);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            Image qr = Image.getInstance(qrImage, null);
            qr.setAlignment(Element.ALIGN_CENTER);
            document.add(qr);

            document.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el ticket PDF: " + e.getMessage());
        }
        return archivo;
    }
    
}
