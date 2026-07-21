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
                              double costo, String codigoReserva) {
        
        File archivo = null;
        try {
            Document document = new Document();
            archivo = new File("Ticket");
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
            document.add(new Paragraph("Origen: " + origen));
            document.add(new Paragraph("Destino: " + destino));
            document.add(new Paragraph("Fecha: " + fecha));
            document.add(new Paragraph("Asiento: " + asiento + "\n"));

            // Costo
            Font costoFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.DARK_GRAY);
            document.add(new Paragraph("Costo del boleto: $" + costo + " COP\n", costoFont));

            // Generar QR con datos clave
            String dataQR = "Reserva:" + codigoReserva + ".\nVuelo:" + vuelo + ".\nPasajero:" + nombrePasajero;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(dataQR, BarcodeFormat.QR_CODE, 150, 150);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            Image qr = Image.getInstance(qrImage, null);
            qr.setAlignment(Element.ALIGN_CENTER);
            document.add(qr);

            document.close();
            JOptionPane.showMessageDialog(null, "Ticket PDF generado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el ticket PDF: " + e.getMessage());
        }
        return archivo;
    }
    
}
