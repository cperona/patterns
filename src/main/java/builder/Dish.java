package builder;

public abstract class Dish {

    private final String name;
    private boolean vegan;
    private boolean glutenFree;

    protected Dish(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nom del plat no pot ser buit");
        }
        this.name = name;
    }

    public String getName()      { return name; }
    public boolean isVegan()     { return vegan; }
    public boolean isGlutenFree(){ return glutenFree; }

    public void setVegan(boolean vegan)           { this.vegan = vegan; }
    public void setGlutenFree(boolean glutenFree) { this.glutenFree = glutenFree; }

    public abstract String getCourseLabel();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (vegan)      sb.append(" (Vegan)");
        if (glutenFree) sb.append(" (Gluten Free)");
        return sb.toString();
    }
}