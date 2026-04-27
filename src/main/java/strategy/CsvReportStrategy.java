package strategy;

public class CsvReportStrategy implements ReportStrategy {

    @Override
    public void generateReport(int id, String message) {
        System.out.println(
                "Report_ID; Report_Message" + "\n"
                + id + "; " + message
        );
    }
}
