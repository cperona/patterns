
package strategy;

public class PDFReportStrategy implements ReportStrategy<PDF> {

    @Override
    public PDF generateReport(int id, String message) {
        return PDF.createFile();
    }
}