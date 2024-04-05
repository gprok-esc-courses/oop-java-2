package inheritance_types.ducks_wrong_implementation;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> ducks = new ArrayList<>();
        MallardDuck m = new MallardDuck();
        ducks.add(m);
        RedheadDuck r = new RedheadDuck();
        ducks.add(r);
        CrestedDuck c = new CrestedDuck();
        ducks.add(c);

        for(Object d : ducks) {
            if(d instanceof MallardDuck) {
                MallardDuck mallardDuck = (MallardDuck) d;
                mallardDuck.fly();
                mallardDuck.quack();
            }
            else if(d instanceof RedheadDuck) {
                RedheadDuck redheadDuck = (RedheadDuck) d;
                redheadDuck.flying();
                redheadDuck.sound();
            }
            else if(d instanceof CrestedDuck) {
                CrestedDuck crestedDuck = (CrestedDuck) d;
                crestedDuck.flywithwings();
                crestedDuck.doSound();
            }
            System.out.println();
        }
    }
}
