/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class GerarPDF {

    private static String nomePDF = "Boletim";

    public static String getNomePDF() {
        return nomePDF;
    }

    public static void setNomePDF(String nomePDF) {
        GerarPDF.nomePDF = nomePDF;
    }

    public static void gerarPDF(ArrayList a) throws Exception {

        Document document = null;

        try {
            document = new com.itextpdf.text.Document(PageSize.A4, 72, 72, 72, 72);
            PdfWriter.getInstance(document, new FileOutputStream(nomePDF + ".pdf"));

            document.open();

            document.add(new Paragraph(a.toString()));

        } catch (Exception e) {
            throw new Exception("Erro ao gerar PDF! " + e.getMessage());
        } finally {
            document.close();
        }
    }

}
