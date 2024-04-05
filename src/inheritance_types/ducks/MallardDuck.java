package inheritance_types.ducks;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super("Mallard");
        flyBehaviour = new FlyWithWings();
    }

    public void quack() {
        System.out.println(type + " quack");
    }
}
