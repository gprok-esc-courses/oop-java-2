package quiz_example;

import java.util.Random;

public class MultipleQuestion extends Question {

    public void setAnswers(String correctAns, String [] incorrectAns) {
        Random rand = new Random();
        answers = new String[4];
        int r = rand.nextInt(0, 4);
        int w = 0;
        for(int i = 0; i < answers.length; i++) {
            if(i == r) {
                answers[i] = correctAns;
            }
            else {
                answers[i] = incorrectAns[w];
                w++;
            }
        }
        correct = r;
    }
}
