package builder.steps;

public interface DrinkStep extends BuildStep {
    BuildStep withDrink(String drink);
}
