package strategy;

public interface ReportStrategy<T> {
    T generateReport(int id, String message);
}
