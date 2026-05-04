package menus;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MenuBuilderTest {
    @Test
    public void fullMenu_withDessert_noCoffee() {
        Dish main = Dish.named("Risotto").vegan().glutenFree().withSupplement("Extra garnish", new BigDecimal("1.50")).build();
        Menu menu = Menu.builder()
                .main(main)
                .withDrink("Wine")
                .continueToFullMenu()
                .withDessert("Tiramisu")
                .finishMenu();

        assertEquals(Menu.Kind.REGULAR, menu.kind);
        assertTrue(menu.main.vegan);
        assertTrue(menu.main.glutenFree);
        assertTrue(menu.main.supplement.isPresent());
        assertTrue(menu.drink.isPresent());
        assertTrue(menu.dessertOrCoffee.isPresent());
        assertEquals("Tiramisu", menu.dessertOrCoffee.get());
    }

    @Test
    public void halfMenu_onlyMainAndDrink() {
        Dish main = Dish.named("Burger").build();
        Menu menu = Menu.builder().main(main).withDrink("Soda").finishHalfMenu();
        assertEquals(Menu.Kind.HALF, menu.kind);
        assertTrue(menu.drink.isPresent());
        assertFalse(menu.dessertOrCoffee.isPresent());
    }

    @Test
    public void kidsMenu_mainDrinkDessert() {
        Dish main = Dish.named("Nuggets").build();
        Menu menu = Menu.kidsBuilder().main(main).withDrink("Juice").continueToFullMenu().withDessert("IceCream").finishMenu();
        assertEquals(Menu.Kind.KIDS, menu.kind);
        assertEquals("IceCream", menu.dessertOrCoffee.get());
    }

    @Test
    public void menuWithoutDrink_butWithCoffee() {
        Dish main = Dish.named("Salad").vegan().build();
        Menu menu = Menu.builder().main(main).withoutDrink().withCoffee().finishMenu();
        assertFalse(menu.drink.isPresent());
        assertEquals("COFFEE", menu.dessertOrCoffee.get());
    }
}
