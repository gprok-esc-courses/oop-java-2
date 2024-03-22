package mysql.statics;

public class RunTest {
    public static void main(String[] args) {
        Test.hello();

        Test t1 = new Test();
        Test t2 = new Test();

        t1.a = 1;
        t1.b = 1;

        t2.a = 2;
        t2.b = 2;

        Test.a = 3;

        System.out.println(t1.a);

    }
}
