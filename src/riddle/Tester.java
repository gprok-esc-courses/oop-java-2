package riddle;

import org.json.simple.JSONObject;

public class Tester {

    public static void main(String[] args) {
        RiddleReader rr = new RiddleReader();
        Riddle r = rr.getRiddle();
        System.out.println(r);
    }
}
