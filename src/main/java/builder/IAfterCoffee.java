package builder;

public interface IAfterCoffee {

    IAfterDrink withDrink(String name);

    Menu build();
}