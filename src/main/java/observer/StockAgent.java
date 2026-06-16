package observer;

import java.util.ArrayList;
import java.util.List;

public class StockAgent implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void stockMarketUp(double value) {
        String message = String.format("Stock market went UP to %.2f", value);
        notifyObservers(message);
    }

    public void stockMarketDown(double value) {
        String message = String.format("Stock market went DOWN to %.2f", value);
        notifyObservers(message);
    }
}
