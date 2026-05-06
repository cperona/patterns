package builder;

import builder.menu.Drink;
import builder.menu.MainCourse;
import builder.menu.Starter;

import java.util.Optional;

public class Menu {

    private final Starter starter;
    private final MainCourse mainCourse;
    private final Dish dessertCourse;
    private final Drink drink;

    public Menu(Starter starter, MainCourse mainCourse, Dish dessertCourse, Drink drink) {
        if (mainCourse == null) {
            throw new IllegalStateException("MainCourse is mandatory");
        }
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessertCourse = dessertCourse;
        this.drink = drink;
    }

    // Use Optional class to handle null values
    public Optional<Starter> getStarter() {
        return Optional.ofNullable(starter);
    }
    public MainCourse getMainCourse() {
        return mainCourse;
    }
    public Optional<Dish> getDessertCourse() {
        return Optional.ofNullable(dessertCourse);
    }
    public Optional<Drink> getDrink() {
        return Optional.ofNullable(drink);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu:\n");

        getStarter().ifPresent(s ->
            sb.append(" - ").append(s.getCourseLabel()).append(": ").append(s).append("\n")
        );

        sb.append(" - ").append(mainCourse.getCourseLabel())
          .append(": ").append(mainCourse).append("\n");

        getDessertCourse().ifPresent(d ->
            sb.append(" - ").append(d.getCourseLabel()).append(": ").append(d).append("\n")
        );

        getDrink().ifPresent(dr ->
            sb.append(" - Drink: ").append(dr).append("\n")
        );

        return sb.toString().stripTrailing();
    }
}