package inheritance_types.one_list;

public class ContractWorker extends Employee {
    private double wage;
    private int hours;

    public ContractWorker(String name, double wage, int hours) {
        super(name);
        this.wage = wage;
        this.hours = hours;
        type = "Contract Worker";
    }

    public double getPayment() {
        return wage * hours;
    }
}
