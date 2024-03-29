package inheritance_types.many_lists;

public class Clerk {
    private double salary;
    private String name;
    private String type;

    public Clerk(String name, double salary) {
        this.name = name;
        this.salary = salary;
        type = "Clerk";
    }

    public double payment() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
