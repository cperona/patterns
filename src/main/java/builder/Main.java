package builder;

public class Main {
    public static void main() {
        Menu executiveMenu = new MenuBuilder()
                .withStarter("Amanida Mediterrània")
                .withMainCourse("Filet de Vedella")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi Negre")
                .build();
    }
}