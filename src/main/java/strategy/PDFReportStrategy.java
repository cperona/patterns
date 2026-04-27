
package strategy;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFReportStrategy implements ReportStrategy{

    @Override
    public void generateReport(int id, String message) {
        try {

            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Report ID: " + id);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 680);
                contentStream.showText("Report Message: " + message);
                contentStream.endText();
            }

            document.save("report.pdf");
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Error on file creation");
        }
    }
}