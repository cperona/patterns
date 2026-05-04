package builder;

import builder.steps.*;

public class MenuBuilder implements StarterStep, MainCourseStep, DessertStep, DrinkStep , BuildStep {

    private Menu menu;

    private MenuBuilder() {
        this.menu = new Menu();
    }

    public static StarterStep builder() {
        return new MenuBuilder();
    }

    @Override
    public MainCourseStep withStarter(String starter) {
        menu.setStarter(starter);
        return this;
    }

    @Override
    public DessertStep withMainCourse(String mainCourse) {
        menu.setMainCourse(mainCourse);
        return this;
    }

    @Override
    public DrinkStep withDessert(String dessert) {
        menu.setDessert(dessert);
        return this;
    }

    @Override
    public BuildStep withDrink(String drink) {
        menu.setDrink(drink);
        return this;
    }

    @Override
    public Menu build() {
        return menu;
    }
}
