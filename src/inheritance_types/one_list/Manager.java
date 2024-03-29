package inheritance_types.one_list;

public class Manager extends Employee {

    private double salary;
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name);
        this.salary = salary;
        this.bonus = bonus;
        type = "Manager";
    }

    public double getPayment() {
        return salary + bonus;
    }
}
