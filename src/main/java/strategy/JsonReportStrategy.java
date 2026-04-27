package strategy;

public class JsonReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(int id, String message) {
        System.out.println(
                "{\n" +
                "  \"report_id\": " + id + "1,\n" +
                "  \"report_message\":" + message + "\n" +
                "}"
        );
    }
}
