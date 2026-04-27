package strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StrategyTest {

    @Test
    void testCsvReportStrategy() {
        ReportStrategy strategy = new CsvReportStrategy();
        assertDoesNotThrow(() -> strategy.generateReport(1, "Test message"));
    }

    @Test
    void testHtmlReportStrategy() {
        ReportStrategy strategy = new HTMLReportStrategy();
        assertDoesNotThrow(() -> strategy.generateReport(2, "HTML message"));
    }

    @Test
    void testJsonReportStrategy() {
        ReportStrategy strategy = new JsonReportStrategy();
        assertDoesNotThrow(() -> strategy.generateReport(3, "JSON message"));
    }

    @Test
    void testXmlReportStrategy() {
        ReportStrategy strategy = new XMLReportStrategy();
        assertDoesNotThrow(() -> strategy.generateReport(4, "XML message"));
    }

    @Test
    void testPdfReportStrategy() {
        ReportStrategy strategy = new PDFReportStrategy();
        assertDoesNotThrow(() -> strategy.generateReport(5, "PDF message"));
    }
}