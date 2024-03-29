package inheritance_types.many_lists;

public class ContractWorker {
    private double wage;
    private int hours;
    private String name;
    private String type;

    public ContractWorker(String name, double wage, int hours) {
        this.name = name;
        this.wage = wage;
        this.hours = hours;
        type = "Contract Worker";
    }

    public double calculateWage() {
        return wage * hours;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
