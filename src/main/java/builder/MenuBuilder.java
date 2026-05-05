package builder;

import builder.menu.MenuPlate;
import builder.menu.Starter;
import builder.steps.*;
import org.apache.jena.atlas.logging.Log;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder implements StarterStep, MainCourseStep, DessertStep, DrinkStep, BuildStep {

    private List<MenuPlate> menu;

    private MenuBuilder() {
        this.menu = new ArrayList<>();
    }

    public static StarterStep builder() {
        return new MenuBuilder();
    }

    @Override
    public MenuBuilder isVegan() {
        Vegan.setVegan(menu.getLast());
        return this;
    }

    @Override
    public MenuBuilder isGlutenFree() {
        GlutenFree.setGlutenFree(menu.getLast());
        return this;
    }

    // 1 - Starter step

    @Override
    public MainCourseStep withStarter(String starter) {
        menu.add(new Starter(starter, false, false));

        return this;
    }

    // 2 - MainCourse step

    @Override
    public DessertStep withMainCourse(String mainCourse) {
        menu.setMainCourse(mainCourse);
        return this;
    }
   // 2.1 - MainCourse substep
    @Override
    public DessertStep withSuplement(String suplement) {
        return null;
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
