package inheritance_types.ducks;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super("Decoy");
        flyBehaviour = new FlyNoWay();
    }

    @Override
    public void quack() {
        System.out.println("Decoy makes no sound");
    }
}
