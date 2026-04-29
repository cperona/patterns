package strategy;

public class Main {
    public static void main(String[] args) {
        // HTML
        ReportStrategy htmlReportStrategy = new HTMLReportStrategy();
        htmlReportStrategy.generateReport(1, "An error occurred...");

        // CSV
        ReportStrategy csvReportStrategy = new CsvReportStrategy();
        csvReportStrategy.generateReport(2, "An error occurred...");

        // PDF
        ReportStrategy pdfReportStrategy = new PDFReportStrategy();
        pdfReportStrategy.generateReport(3, "An error occurred...");

        // ODT
        ReportStrategy odtReportStrategy = new ODTReportStrategy();
        odtReportStrategy.generateReport(4, "An error occurred...");
    }
}