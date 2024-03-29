package inheritance_types.one_list;

public class Clerk extends Employee {
    private double salary;

    public Clerk(String name, double salary) {
        super(name);
        this.salary = salary;
        type = "Clerk";
    }

    public double getPayment() {
        return salary;
    }

}
