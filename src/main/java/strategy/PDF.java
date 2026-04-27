package strategy;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

public class PDF {
    public static void createFile() throws Exception {
        PdfWriter writer = new PdfWriter("report.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Report ID: 1").setBold());
        document.add(new Paragraph("Report Message: \"This is a report message\""));

        document.close();
    }
}