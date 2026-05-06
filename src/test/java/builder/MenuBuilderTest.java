package builder;

import builder.menu.Coffee;
import builder.menu.Dessert;
import builder.menu.MainCourse;
import builder.menu.Starter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing MenuBuilder")
class MenuBuilderTest {

    @Test
    void testExecutiveMenu() {
        Menu menu = new MenuBuilder()
                .withStarter("Amanida Mediterrània")
                    .isVegan()
                    .isGlutenFree()
                .withMainCourse("Filet de Vedella")
                    .withSupplement("Guarnició extra")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi Negre")
                .build();

        assertTrue(menu.getStarter().isPresent(), "Has to include Starter");
        Starter starter = menu.getStarter().get();
        assertEquals("Amanida Mediterrània", starter.getName());
        assertTrue(starter.isVegan(),      "Starter has to be Vegan");
        assertTrue(starter.isGlutenFree(), "Starter has to be gluten free");

        assertEquals("Filet de Vedella", menu.getMainCourse().getName());
        assertEquals("Guarnició extra",  menu.getMainCourse().getSupplement());
        assertFalse(menu.getMainCourse().isVegan());

        assertTrue(menu.getDessertCourse().isPresent(), "Has to include Dessert");
        assertInstanceOf(Dessert.class, menu.getDessertCourse().get());
        assertEquals("Mousse de xocolata", menu.getDessertCourse().get().getName());

        assertTrue(menu.getDrink().isPresent(), "Can't have Drink");
        assertEquals("Vi Negre", menu.getDrink().get().getName());

        System.out.println("=== Executive Menu ===");
        System.out.println(menu);
    }

    @Test
    void testKidsMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Macarrons amb tomàquet")
                .withDessert("Gelat de Vainilla")
                .withDrink("Suc de taronja")
                .build();

        assertFalse(menu.getStarter().isPresent(), "Can't have starter");
        assertEquals("Macarrons amb tomàquet", menu.getMainCourse().getName());

        assertTrue(menu.getDessertCourse().isPresent());
        assertInstanceOf(Dessert.class, menu.getDessertCourse().get());
        assertEquals("Gelat de Vainilla", menu.getDessertCourse().get().getName());

        assertEquals("Suc de taronja", menu.getDrink().get().getName());

        System.out.println("=== Kids Menu ===");
        System.out.println(menu);
    }

    @Test
    void testHalfMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Risotto de bolets")
                    .isVegan()
                .withCoffee("Espresso")
                .withDrink("Aigua")
                .build();

        assertFalse(menu.getStarter().isPresent(), "Can't have Starter");

        MainCourse main = menu.getMainCourse();
        assertEquals("Risotto de bolets", main.getName());
        assertTrue(main.isVegan(), "Has to be Vegan");
        assertNull(main.getSupplement(), "Can't have Supplement");

        assertTrue(menu.getDessertCourse().isPresent());
        assertInstanceOf(Coffee.class, menu.getDessertCourse().get(),
                "Has to be Coffee, not Dessert");
        assertEquals("Espresso", menu.getDessertCourse().get().getName());

        assertEquals("Aigua", menu.getDrink().get().getName());

        System.out.println("=== Half Menu ===");
        System.out.println(menu);
    }

    @Test
    void testMinimalMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Arròs a banda")
                .withDrink("Cervesa")
                .build();

        assertFalse(menu.getStarter().isPresent());
        assertFalse(menu.getDessertCourse().isPresent(), "Can't have dessert or coffee");
        assertEquals("Arròs a banda", menu.getMainCourse().getName());
        assertEquals("Cervesa", menu.getDrink().get().getName());

        System.out.println("=== Minimal menu (main course + drink) ===");
        System.out.println(menu);
    }

    @Test
    void testMenuWithoutDrink() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Pollastre al forn")
                .withDessert("Crema catalana")
                .build();

        assertFalse(menu.getDrink().isPresent(), "Can't include drink");
        assertTrue(menu.getDessertCourse().isPresent());
        assertEquals("Crema catalana", menu.getDessertCourse().get().getName());

        System.out.println("=== Menu without drink ===");
        System.out.println(menu);
    }

    @Test
    void testMenuOnlyMainCourse() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Sopa de verdures")
                .build();

        assertFalse(menu.getStarter().isPresent());
        assertFalse(menu.getDessertCourse().isPresent());
        assertFalse(menu.getDrink().isPresent());
        assertEquals("Sopa de verdures", menu.getMainCourse().getName());

        System.out.println("=== Only Main Course Menu ===");
        System.out.println(menu);
    }

    @Test
    void testMenuGlutenFree() {
        Menu menu = new MenuBuilder()
                .withStarter("Croquetes de quinoa")
                    .isGlutenFree()
                .withMainCourse("Albergínies farcides")
                    .isVegan()
                    .isGlutenFree()
                    .withSupplement("Salsa de tomàquet casolana")
                .withDessert("Fruita de temporada")
                .withDrink("Suc natural")
                .build();

        assertTrue(menu.getStarter().get().isGlutenFree());
        assertFalse(menu.getStarter().get().isVegan());

        assertTrue(menu.getMainCourse().isVegan());
        assertTrue(menu.getMainCourse().isGlutenFree());
        assertEquals("Salsa de tomàquet casolana", menu.getMainCourse().getSupplement());

        System.out.println("=== Gluten Free Menu ===");
        System.out.println(menu);
    }

    @Test
    void testMenuToString() {
        Menu menu = new MenuBuilder()
                .withStarter("Amanida Mediterrània")
                    .isVegan()
                    .isGlutenFree()
                .withMainCourse("Filet de Vedella")
                    .withSupplement("Guarnició extra")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi Negre")
                .build();

        String output = menu.toString();

        assertTrue(output.contains("Starter: Amanida Mediterrània (Vegan) (Gluten Free)"));
        assertTrue(output.contains("Main Course: Filet de Vedella, Supplement: Guarnició extra"));
        assertTrue(output.contains("Dessert: Mousse de xocolata"));
        assertTrue(output.contains("Drink: Vi Negre"));

        System.out.println("=== Menu.toString() ===");
        System.out.println(output);
    }

    // Tests that after withDessert() method, withCoffee() can't be reached
    @Test
    void testDessertPlusCoffeeRestriction() {
        Menu withDessert = new MenuBuilder()
                .withMainCourse("Bacallà amb mel")
                .withDessert("Tiramisu")
                .build();
        assertInstanceOf(Dessert.class, withDessert.getDessertCourse().get());

        Menu withCoffee = new MenuBuilder()
                .withMainCourse("Bacallà amb mel")
                .withCoffee("Tallat")
                .build();
        assertInstanceOf(Coffee.class, withCoffee.getDessertCourse().get());

        System.out.println("=== Dessert ===\n" + withDessert);
        System.out.println("=== Coffee ===\n" + withCoffee);
    }

    // Tests that the main course is mandatory and always the first step
    @Test
    void testMainCourseRestriction() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Truita de patates")
                .build();

        assertNotNull(menu.getMainCourse(), "Main course can't be null");
        assertEquals("Truita de patates", menu.getMainCourse().getName());
    }
}