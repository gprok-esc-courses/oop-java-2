package observer;

public class TestAdder {
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.addErrorObserver(new ErrorLogger());
        adder.addErrorObserver(new ErrorScreenLogger());
        adder.addErrorObserver(new ErrorEmail());
        adder.add();
    }
}
