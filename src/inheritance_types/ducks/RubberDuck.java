package inheritance_types.ducks;

public class RubberDuck extends Duck {
    public RubberDuck() {
        super("Rubber");
        flyBehaviour = new FlyNoWay();
    }

    @Override
    public void quack() {
        System.out.println("Rubber squeek");
    }
}
