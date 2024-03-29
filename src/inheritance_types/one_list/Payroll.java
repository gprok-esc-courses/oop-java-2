package inheritance_types.one_list;

import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Clerk("Jimmy", 800));
        employees.add(new Clerk("Peter", 900));
        employees.add(new Clerk("Sam", 850));
        employees.add(new Manager("Tom", 2300, 200));
        employees.add(new ContractWorker("Sue", 23, 10));
        employees.add(new ContractWorker("Nick", 26, 50));
        employees.add(new Researcher("William", 30000, 12));

        // PAYROLL
        for(Employee e : employees) {
            System.out.println(e.getType() + "." + e.getName() + ": " + e.getPayment());
        }
    }
}
