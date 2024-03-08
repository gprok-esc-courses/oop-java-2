package petshop;

public class Lizzard extends Animal {
    public Lizzard(String name) {
        super(name);
    }

    @Override
    public void message() {
        System.out.println("Lizzard " + name + " saying fssssss");
    }
}
