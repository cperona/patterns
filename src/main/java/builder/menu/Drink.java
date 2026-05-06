package builder.menu;

public class Drink {

    private final String name;

    public Drink(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nom de la beguda no pot ser buit");
        }
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }
}