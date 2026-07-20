/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author juans
 */
public class Reportes_creadorPdf {
    
    
    
    public Reportes_creadorPdf(){
        
    }
    
    public void setCrearPdf(JTable tabla,JFreeChart chartTiempo,JFreeChart chartDestino, JFreeChart chartTipo, String tituloA){
        
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
                Paragraph titulo = new Paragraph("REPORTES "+tituloA+"\n\n");
                titulo.setAlignment(Paragraph.ALIGN_CENTER);
                documento.add(titulo);
                
                // Crear tabla con 2 columnas
                PdfPTable tablaGraficos = new PdfPTable(3);
                tablaGraficos.setWidthPercentage(100);

                // Gráfico 1
                File chartFile1 = new File("grafico_Tiempo.png");
                ChartUtilities.saveChartAsPNG(chartFile1, chartTiempo, 400, 300);
                Image img1 = Image.getInstance(chartFile1.getAbsolutePath());
                img1.scaleToFit(250, 200);
                PdfPCell celda1 = new PdfPCell(img1, true);
                celda1.setBorder(Rectangle.NO_BORDER);
                tablaGraficos.addCell(celda1);

                // Gráfico 2
                File chartFile2 = new File("grafico_Destinos.png");
                ChartUtilities.saveChartAsPNG(chartFile2, chartDestino, 400, 300);
                Image img2 = Image.getInstance(chartFile2.getAbsolutePath());
                img2.scaleToFit(250, 200);
                PdfPCell celda2 = new PdfPCell(img2, true);
                celda2.setBorder(Rectangle.NO_BORDER);
                tablaGraficos.addCell(celda2);
                
                // Gráfico 3
                File chartFile3 = new File("grafico_Tipo.png");
                ChartUtilities.saveChartAsPNG(chartFile3, chartTipo, 400, 300);
                Image img3 = Image.getInstance(chartFile3.getAbsolutePath());
                img3.scaleToFit(250, 200);
                PdfPCell celda3 = new PdfPCell(img3, true);
                celda3.setBorder(Rectangle.NO_BORDER);
                tablaGraficos.addCell(celda3);


                // Agregar la tabla de gráficos al documento
                documento.add(tablaGraficos);

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
