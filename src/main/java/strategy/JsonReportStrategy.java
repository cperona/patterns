package strategy;

public class JsonReportStrategy implements ReportStrategy<String> {
    @Override
    public String generateReport(int id, String message) {
        return "{\n" +
                "  \"report_id\": " + id + "1,\n" +
                "  \"report_message\":" + message + "\n" +
                "}";
    }
}
