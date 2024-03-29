package inheritance_types.one_list;

public abstract class Employee {
    protected String name;
    protected String type;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double getPayment();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
