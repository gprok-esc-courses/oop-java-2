package inheritance_types.one_list;

public class Researcher extends Employee {
    private double projectAmount;
    private int percentage;

    public Researcher(String name, double amount, int percentage) {
        super(name);
        this.projectAmount = amount;
        this.percentage = percentage;
        this.type = "Researcher";
    }

    public double getPayment() {
        return projectAmount * percentage / 100;
    }
}
