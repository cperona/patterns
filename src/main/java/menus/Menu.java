package menus;

import java.util.Optional;

public final class Menu {
    public enum Kind { REGULAR, HALF, KIDS }

    public final Kind kind;
    public final Dish main;
    public final Optional<String> drink;
    public final Optional<String> dessertOrCoffee; // dessert name OR "COFFEE"

    private Menu(Kind kind, Dish main, String drink, String dessertOrCoffee){
        this.kind = kind;
        this.main = main;
        this.drink = Optional.ofNullable(drink);
        this.dessertOrCoffee = Optional.ofNullable(dessertOrCoffee);
    }

    // Staged builder interfaces
    public interface Start { MainAdded main(Dish main); }
    public interface MainAdded {
        AfterMain withDrink(String drink);
        DessertChoice withoutDrink(); // menus can be without drink
        Menu finishWithoutDrink();    // finish menu that only has main (no drink, no dessert)
    }
    public interface AfterMain {
        Menu finishHalfMenu(); // main + drink only
        DessertChoice continueToFullMenu(); // go on to choose dessert/coffee or skip them
    }
    public interface DessertChoice {
        AfterDessert withDessert(String dessert);
        AfterCoffee withCoffee();
        Menu finishMenuWithoutDessert(); // optional: finish (no dessert/coffee)
    }
    public interface AfterDessert { Menu finishMenu(); /* no coffee method -> enforced */ }
    public interface AfterCoffee { Menu finishMenu(); /* no dessert method -> enforced */ }

    // Builder entry points
    public static Start builder(){ return new Impl(false); }
    public static Start kidsBuilder(){ return new Impl(true); }

    // Implementation
    private static final class Impl implements Start, MainAdded, AfterMain, DessertChoice, AfterDessert, AfterCoffee {
        private Dish main;
        private String drink;
        private String dessertOrCoffee;
        private Kind kind = Kind.REGULAR;
        private final boolean startAsKids;

        Impl(boolean kids){ this.startAsKids = kids; if (kids) this.kind = Kind.KIDS; }

        public MainAdded main(Dish main){ this.main = main; return this; }

        // MainAdded:
        public DessertChoice withoutDrink(){ this.drink = null; return this; }
        public Menu finishWithoutDrink(){ this.drink = null; this.dessertOrCoffee = null; return build(kind); }
        public AfterMain withDrink(String drink){ this.drink = drink; return this; }

        // AfterMain:
        public Menu finishHalfMenu(){ this.kind = Kind.HALF; this.dessertOrCoffee = null; return build(Kind.HALF); }
        public DessertChoice continueToFullMenu(){ return this; }

        // DessertChoice:
        public AfterDessert withDessert(String dessert){ this.dessertOrCoffee = dessert; return this; }
        public AfterCoffee withCoffee(){ this.dessertOrCoffee = "COFFEE"; return this; }
        public Menu finishMenuWithoutDessert(){ this.dessertOrCoffee = null; return build(kind); }

        // AfterDessert / AfterCoffee
        public Menu finishMenu(){ return build(kind); }

        private Menu build(Kind k){ return new Menu(k, main, drink, dessertOrCoffee); }
    }
}
