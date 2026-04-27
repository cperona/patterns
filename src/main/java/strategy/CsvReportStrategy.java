package strategy;

public class CsvReportStrategy implements ReportStrategy<String> {

    @Override
    public String generateReport(int id, String message) {
        return "Report_ID; Report_Message" + "\n"
                + id + "; " + message;
    }
}
