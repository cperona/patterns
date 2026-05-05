package builder.steps;

public interface DessertStep extends BuildStep, VeganSubStep, GlutenFreeSubStep {
    DessertStep withSuplement(String suplement);

    DrinkStep withDessert(String dessert);
}
