package builder.menu;

import builder.Dish;

public class Coffee extends Dish {

    public Coffee(String name) {
        super(name);
    }

    @Override
    public String getCourseLabel() {
        return "Coffee";
    }
}