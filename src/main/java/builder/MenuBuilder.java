package builder;

public class MenuBuilder implements IMenuBuilder{

    private Menu menu;

    public MenuBuilder() {
        this.menu = new Menu();
    }

    @Override
    public IMenuBuilder withStarter(String starter) {
        menu.setStarter(starter);
        return this;
    }

    @Override
    public IMenuBuilder withMainCourse(String mainCourse) {
        menu.setMainCourse(mainCourse);
        return this;
    }

    @Override
    public IMenuBuilder withDessert(String dessert) {
        menu.setDessert(dessert);
        return this;
    }

    @Override
    public IMenuBuilder withDrink(String drink) {
        menu.setDrink(drink);
        return this;
    }

    @Override
    public Menu build() {
        return menu;
    }
}
