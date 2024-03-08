package petshop;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void message() {
        System.out.println("Generic Animal, no sound");
    }
}
