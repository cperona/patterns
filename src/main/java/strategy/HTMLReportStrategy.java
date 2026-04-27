package strategy;

public class HTMLReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(int id, String message) {
        System.out.println(
                "<!doctype html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Report page</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <p>This is the generated report.</p>\n" +
                "    <p>Report ID: </p>\n" + id +
                "    <p>Report Message: </p>\n" + message +
                "  </body>\n" +
                "</html>"
        );
    }
}
