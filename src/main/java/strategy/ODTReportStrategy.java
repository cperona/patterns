package strategy;

import org.odftoolkit.odfdom.doc.OdfTextDocument;

public class ODTReportStrategy implements ReportStrategy{
    @Override
    public void generateReport(int id, String message) {
        OdfTextDocument odt = null;
        try {
            odt = OdfTextDocument.newTextDocument();
            odt.addText("Report ID: " + id);
            odt.newParagraph();
            odt.addText("Message: " + message);
            odt.save("report.odt");
        } catch (Exception e) {
            throw new RuntimeException("Error on file creation");
        }
    }
}
