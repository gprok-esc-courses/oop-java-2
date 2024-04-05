package inheritance_types.ducks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        MallardDuck m = new MallardDuck();
        ducks.add(m);
        RedheadDuck r = new RedheadDuck();
        r.flyBehaviour = new FlyNoWay();
        ducks.add(r);
        CrestedDuck c = new CrestedDuck();
        ducks.add(c);
        RubberDuck rd = new RubberDuck();
        rd.flyBehaviour = new FlyAsDrone();
        ducks.add(rd);
        DecoyDuck dd = new DecoyDuck();
        ducks.add(dd);

        for(Duck d : ducks) {
            d.fly();
            d.quack();
            System.out.println();
        }
    }
}
