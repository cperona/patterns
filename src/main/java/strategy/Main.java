package strategy;

public class Main {
    public static void main(String[] args) {
        // HTML
        ReportStrategy<String> htmlReportStrategy = new HTMLReportStrategy();
        String HTMLReport = htmlReportStrategy.generateReport(1, "An error occurred...");
        System.out.println(HTMLReport);

        // CSV
        ReportStrategy<String> csvReportStrategy = new CsvReportStrategy();
        String CSVReport = csvReportStrategy.generateReport(2, "An error occurred...");
        System.out.println(CSVReport);

        // CSV2
        ReportStrategy<String> csvReportStrategy2 = (id, message) -> "Report_ID; Report_Message" + "\n" + id + "; " + message;
        String CSVReport2 = csvReportStrategy2.generateReport(3, "An error occurred...");
        System.out.println(CSVReport2);

        // PDF
        PDFReportStrategy pdfReportStrategy = new PDFReportStrategy();

    }
}