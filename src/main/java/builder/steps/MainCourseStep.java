package builder.steps;

public interface MainCourseStep extends BuildStep {
    DessertStep withMainCourse(String mainCourse);
}