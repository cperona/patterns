package builder;

import builder.menu.MenuPlate;
import builder.menu.Starter;

public class Menu {
    private Starter starter;
    private String mainCourse;
    private String supplement;
    private String dessert;
    private String drink;

    public Starter getStarter() {
        return starter;
    }

    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
