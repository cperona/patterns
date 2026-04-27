package strategy;

public class XMLReportStrategy implements ReportStrategy<String> {
    @Override
    public String generateReport(int id, String message) {
        return "<report>\n" +
                "  <report_id>" + id + "</report_id>\n" +
                "  <report_message>" + message + "</report_message>\n" +
                "</report>";
    }
}
