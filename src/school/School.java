package school;

public class School {
    public static void main(String[] args) {
        Person s = new Student(1, "Mike", "mike@school.test", "Computing");
        Person t = new Teacher(2, "Tom", "tom@school.test");

        System.out.println(s);
        System.out.println(t);

    }
}
