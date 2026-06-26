/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package skyline_tickets;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author juans
 */
public class Reportes_creadorPdf {
    
    
    
    public Reportes_creadorPdf(){
        
    }
    
    public void setCrearPdf(JTable tabla){
        
        try{
            // Cuadro de diálogo para elegir dónde guardar
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar reporte PDF");
            int opcion = chooser.showSaveDialog(null);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                File archivo = chooser.getSelectedFile();
                // Si el usuario no pone extensión, se la agregamos
                String ruta = archivo.getAbsolutePath();
                if (!ruta.toLowerCase().endsWith(".pdf")) {
                    ruta += ".pdf";
                }

                Document documento = new Document();
                PdfWriter.getInstance(documento, new FileOutputStream(ruta));
                documento.open();

                // Título
                Paragraph titulo = new Paragraph("Reportes Financieros\n\n");
                titulo.setAlignment(Paragraph.ALIGN_CENTER);
                documento.add(titulo);

                // Crear tabla PDF con el mismo número de columnas que la JTable
                PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
                pdfTable.setWidthPercentage(100);
                pdfTable.setHorizontalAlignment(Element.ALIGN_CENTER);

                // Encabezados
                for (int i = 0; i < tabla.getColumnCount(); i++) {
                    PdfPCell celda = new PdfPCell(new Paragraph(tabla.getColumnName(i)));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(celda);
                }

                // Filas
                for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                    for (int col = 0; col < tabla.getColumnCount(); col++) {
                        Object valor = tabla.getValueAt(fila, col);
                        PdfPCell celda = new PdfPCell(new Paragraph(valor != null ? valor.toString() : ""));
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfTable.addCell(celda);
                    }
                }

                documento.add(pdfTable);
                documento.close();

                JOptionPane.showMessageDialog(null, "PDF creado con éxito en:\n" + ruta);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear PDF: " + e.getMessage());
        }
    }
    
}
