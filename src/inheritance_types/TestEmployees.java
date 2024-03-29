package inheritance_types;

public class TestEmployees {
    public static void main(String[] args) {
        Employee e = new Clerk();
        System.out.println(e.salary());
    }
}
