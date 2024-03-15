package practice1_airport;


import java.util.Random;

public class MakeProgramWait {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);

            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
