package builder.menu;

import builder.Dish;

public class Dessert extends Dish {

    public Dessert(String name) {
        super(name);
    }

    @Override
    public String getCourseLabel() {
        return "Dessert";
    }
}