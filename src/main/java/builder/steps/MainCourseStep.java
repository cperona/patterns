package builder.steps;

public interface MainCourseStep extends BuildStep, VeganSubStep, GlutenFreeSubStep {
    DessertStep withMainCourse(String mainCourse);
}