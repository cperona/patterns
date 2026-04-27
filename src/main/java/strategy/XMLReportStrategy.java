package strategy;

public class XMLReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(int id, String message) {
        System.out.println(
                "<report>\n" +
                "  <report_id>" + id + "</report_id>\n" +
                "  <report_message>" + message + "</report_message>\n" +
                "</report>"
        );
    }
}
