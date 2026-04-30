package builder;

public class Menu {
    private String starter;
    private String mainCourse;
    private String dessert;
    private String drink;

    public String getStarter() {
        return starter;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public String getDessert() {
        return dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
