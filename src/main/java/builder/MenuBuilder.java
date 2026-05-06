package builder;

import builder.menu.*;

public class MenuBuilder {

    public IStarterConfig withStarter(String name) {
        MenuData data = new MenuData();
        data.starter = new Starter(name);
        return new StarterConfigStep(data);
    }

    public IMainCourseConfig withMainCourse(String name) {
        MenuData data = new MenuData();
        data.mainCourse = new MainCourse(name);
        return new MainCourseConfigStep(data);
    }

    private static final class MenuData {
        Starter starter;
        MainCourse mainCourse;
        Dish dessertCourse; // It can be a proper dessert or a coffee
        Drink drink;

        Menu build() {
            return new Menu(starter, mainCourse, dessertCourse, drink);
        }
    }

    private static final class StarterConfigStep implements IStarterConfig {

        private final MenuData data;

        private StarterConfigStep(MenuData data) {
            this.data = data;
        }

        @Override
        public IStarterConfig isVegan() {
            data.starter.setVegan(true);
            return this;
        }

        @Override
        public IStarterConfig isGlutenFree() {
            data.starter.setGlutenFree(true);
            return this;
        }

        @Override
        public IMainCourseConfig withMainCourse(String name) {
            data.mainCourse = new MainCourse(name);
            return new MainCourseConfigStep(data);
        }
    }

    private static final class MainCourseConfigStep implements IMainCourseConfig {

        private final MenuData data;

        private MainCourseConfigStep(MenuData data) {
            this.data = data;
        }

        @Override
        public IMainCourseConfig isVegan() {
            data.mainCourse.setVegan(true);
            return this;
        }

        @Override
        public IMainCourseConfig isGlutenFree() {
            data.mainCourse.setGlutenFree(true);
            return this;
        }

        @Override
        public IMainCourseConfig withSupplement(String supplement) {
            data.mainCourse.setSupplement(supplement);
            return this;
        }

        @Override
        public IAfterDessert withDessert(String name) {
            data.dessertCourse = new Dessert(name);
            return new AfterDessertStep(data);
        }

        @Override
        public IAfterCoffee withCoffee(String name) {
            data.dessertCourse = new Coffee(name);
            return new AfterCoffeeStep(data);
        }

        @Override
        public IAfterDrink withDrink(String name) {
            data.drink = new Drink(name);
            return new AfterDrinkStep(data);
        }

        @Override
        public Menu build() {
            return data.build();
        }
    }

    private static final class AfterDessertStep implements IAfterDessert {

        private final MenuData data;

        private AfterDessertStep(MenuData data) {
            this.data = data;
        }

        @Override
        public IAfterDrink withDrink(String name) {
            data.drink = new Drink(name);
            return new AfterDrinkStep(data);
        }

        @Override
        public Menu build() {
            return data.build();
        }
    }

    private static final class AfterCoffeeStep implements IAfterCoffee {

        private final MenuData data;

        private AfterCoffeeStep(MenuData data) {
            this.data = data;
        }

        @Override
        public IAfterDrink withDrink(String name) {
            data.drink = new Drink(name);
            return new AfterDrinkStep(data);
        }

        @Override
        public Menu build() {
            return data.build();
        }
    }

    private static final class AfterDrinkStep implements IAfterDrink {

        private final MenuData data;

        private AfterDrinkStep(MenuData data) {
            this.data = data;
        }

        @Override
        public Menu build() {
            return data.build();
        }
    }
}