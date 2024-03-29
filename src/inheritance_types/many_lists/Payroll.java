package inheritance_types.many_lists;

import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        ArrayList<Clerk> clerks = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<ContractWorker> contractWorkers = new ArrayList<>();

        clerks.add(new Clerk("Jimmy", 800));
        clerks.add(new Clerk("Peter", 900));
        clerks.add(new Clerk("Sam", 850));
        managers.add(new Manager("Tom", 2300, 200));
        contractWorkers.add(new ContractWorker("Sue", 23, 10));
        contractWorkers.add(new ContractWorker("Nick", 26, 50));

        // PAYROLL
        for(Clerk c : clerks) {
            System.out.println(c.getType() + "." + c.getName() + ": " + c.payment());
        }
        for(Manager m : managers) {
            System.out.println(m.getType() + "." + m.getName() + ": " + m.getPayment());
        }
        for(ContractWorker cw : contractWorkers) {
            System.out.println(cw.getType() + "." + cw.getName() + ": " + cw.calculateWage());
        }


    }
}
