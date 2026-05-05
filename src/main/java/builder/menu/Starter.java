package builder.menu;

import java.util.Objects;

public class Starter implements MenuPlate{
    private final String name;
    private boolean isVegan;
    private boolean isGlutenFree;

    public Starter(String name, boolean isVegan, boolean isGlutenFree) {
        this.name = name;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean isVegan() {
        return isVegan;
    }

    @Override
    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    @Override
    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Starter) obj;
        return Objects.equals(this.name, that.name) &&
                this.isVegan == that.isVegan &&
                this.isGlutenFree == that.isGlutenFree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isVegan, isGlutenFree);
    }

    @Override
    public String toString() {
        return "Starter[" +
                "name=" + name + ", " +
                "isVegan=" + isVegan + ", " +
                "isGlutenFree=" + isGlutenFree + ']';
    }
}
