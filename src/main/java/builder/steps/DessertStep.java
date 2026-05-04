package builder.steps;

public interface DessertStep extends BuildStep {
    DrinkStep withDessert(String dessert);
}
