package builder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main() {
        Menu executiveMenu = MenuBuilder.builder()
                .withStarter("Amanida Mediterrània")
                .withMainCourse("\"Filet de Vedella")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi negre")
                .build();
    }
}