package school;

import java.util.ArrayList;

public class Teacher extends Person {

    protected ArrayList<String> courses;

    public Teacher(int id, String name, String email) {
        super(id, name, email);
        courses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TEACHER: " + name;
    }


    public void addCourse(String course) {
        courses.add(course);
    }

    public ArrayList<String> getCourses() {
        return courses;
    }
}
