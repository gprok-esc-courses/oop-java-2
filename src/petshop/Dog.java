package petshop;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void message() {
        System.out.println("Dog " + name + " saying Wooof");
    }
}
