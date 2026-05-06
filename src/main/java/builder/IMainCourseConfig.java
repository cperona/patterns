package builder;

public interface IMainCourseConfig {

    IMainCourseConfig isVegan();

    IMainCourseConfig isGlutenFree();

    IMainCourseConfig withSupplement(String supplement);

    IAfterDessert withDessert(String name);

    IAfterCoffee withCoffee(String name);

    IAfterDrink withDrink(String name);

    Menu build();
}