package inheritance_types.ducks;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        super("RedHead");
        flyBehaviour = new FlyWithWings();
    }

    public void quack() {
        System.out.println(type + " quack");
    }
}
