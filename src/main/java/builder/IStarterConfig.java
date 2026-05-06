package builder;

public interface IStarterConfig {

    IStarterConfig isVegan();

    IStarterConfig isGlutenFree();

    IMainCourseConfig withMainCourse(String name);
}