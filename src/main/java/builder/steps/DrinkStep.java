package builder.steps;

public interface DrinkStep extends BuildStep, VeganSubStep, GlutenFreeSubStep {
    BuildStep withDrink(String drink);
}
