package builder.menu;

import builder.Dish;

public class MainCourse extends Dish {

    private String supplement;

    public MainCourse(String name) {
        super(name);
    }

    public String getSupplement() { return supplement; }

    public void setSupplement(String supplement) {
        if (supplement == null || supplement.isBlank()) {
            throw new IllegalArgumentException("Supplement can't be null or void");
        }
        this.supplement = supplement;
    }

    @Override
    public String getCourseLabel() {
        return "Main Course";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (supplement != null) {
            sb.append(", Supplement: ").append(supplement);
        }
        return sb.toString();
    }
}