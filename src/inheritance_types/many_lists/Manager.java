package inheritance_types.many_lists;

public class Manager {

    private double salary;
    private double bonus;
    private String name;

    private String type;

    public Manager(String name, double salary, double bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        type = "Manager";
    }

    public double getPayment() {
        return salary + bonus;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
