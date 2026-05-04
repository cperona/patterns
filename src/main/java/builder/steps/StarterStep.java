package builder.steps;

public interface StarterStep extends BuildStep {
    MainCourseStep withStarter(String starter);
}