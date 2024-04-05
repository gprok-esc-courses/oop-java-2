package inheritance_types.ducks;

public abstract class Duck {
    protected String type;
    protected FlyBehaviour flyBehaviour;

    public Duck(String type) {
        this.type = type;
    }

    public void fly() {
        System.out.println(type + " " + flyBehaviour.fly());
    }

    public abstract void quack();
}
