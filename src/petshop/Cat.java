package petshop;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void message() {
        System.out.println("Cat " + name + " saying Mieow");
    }
}
