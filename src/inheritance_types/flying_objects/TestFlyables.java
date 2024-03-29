package inheritance_types.flying_objects;

import java.util.ArrayList;

public class TestFlyables {
    public static void main(String[] args) {
        ArrayList<Flyable> flyables = new ArrayList<>();

        flyables.add(new Airplane());
        flyables.add(new Kite());
        flyables.add(new Bird());

        for(Flyable f : flyables) {
            f.fly();
        }
    }
}
