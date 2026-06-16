package observer;

public class StockBrokerAgency implements Observer {

    private final String name;

    public StockBrokerAgency(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Agency name cannot be empty");
        }
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    public String getName() {
        return name;
    }
}
