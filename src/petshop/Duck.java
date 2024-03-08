package petshop;

public class Duck extends Animal {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void message() {
        System.out.println("Duck " + name + " saying Quack");
    }
}
