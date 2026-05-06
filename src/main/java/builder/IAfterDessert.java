package builder;

public interface IAfterDessert {

    IAfterDrink withDrink(String name);

    Menu build();
}