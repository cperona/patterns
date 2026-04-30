package builder;

public interface IMenuBuilder {
    IMenuBuilder withStarter(String starter);
    IMenuBuilder withMainCourse(String mainCourse);
    IMenuBuilder withDessert(String dessert);
    IMenuBuilder withDrink(String drink);
    Menu build();
}