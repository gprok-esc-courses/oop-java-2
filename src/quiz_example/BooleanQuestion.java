package quiz_example;

public class BooleanQuestion extends Question {

    public void setAnswers(String correctAns, String [] incorrectAns) {
        answers = new String[2];
        answers[0] = "True";
        answers[1] = "False";
        if(correctAns.equals("True")) {
            correct = 0;
        }
        else {
            correct = 1;
        }
    }
}
