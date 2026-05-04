package menus;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public final class Dish {
    public final String name;
    public final boolean vegan;
    public final boolean glutenFree;
    public final Optional<Supplement> supplement;

    private Dish(String name, boolean vegan, boolean glutenFree, Supplement supplement) {
        this.name = Objects.requireNonNull(name);
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.supplement = Optional.ofNullable(supplement);
    }

    public static DishBuilder named(String name) { return new DishBuilder(name); }

    public static final class Supplement {
        public final String name;
        public final BigDecimal price;
        public Supplement(String name, BigDecimal price){
            this.name = Objects.requireNonNull(name);
            this.price = Objects.requireNonNull(price);
        }
    }

    public static final class DishBuilder {
        private final String name;
        private boolean vegan = false;
        private boolean glutenFree = false;
        private Supplement supplement = null;

        DishBuilder(String name){ this.name = Objects.requireNonNull(name); }

        // Fluent expressive methods (no booleans)
        public DishBuilder vegan(){ this.vegan = true; return this; }
        public DishBuilder glutenFree(){ this.glutenFree = true; return this; }
        public DishBuilder withSupplement(String name, BigDecimal price){ this.supplement = new Supplement(name, price); return this; }
        public Dish build(){ return new Dish(name, vegan, glutenFree, supplement); }
    }
}
