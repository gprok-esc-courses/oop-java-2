package carrental;

public class CarRental {
    public static void main(String[] args) {
        Car a = new Car("AAA9988", 1000);
        Car b = new Car("AZZ1234", 700);
        Car c = b;

        System.out.println(a);
        System.out.println(b);
    }
}
