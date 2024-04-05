package inheritance_types.ducks;

public class CrestedDuck extends Duck {
    public CrestedDuck() {
        super("Crested");
        flyBehaviour = new FlyWithWings();
    }

    public void quack() {
        System.out.println(type + " quack");
    }
}
