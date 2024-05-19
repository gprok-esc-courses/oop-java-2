package quiz_example;

public abstract class Question {
    protected String question;
    protected String [] answers;
    protected int correct;

    public abstract void  setAnswers(String correctAns, String [] incorrectAns);


    public void display() {
        System.out.println("Q: " + question);
        int i = 1;
        for (String s : answers) {
            System.out.println("A" + i + ": " + s);
            i++;
        }
        System.out.println("Cheat: " + correct);
    }

    public boolean correctAnswer(int answer) {
        return correct == answer - 1;
    }

    public String toString() {
        String s = "Q: " +  question;
        for (int i = 0; i < answers.length; i++) {
            s +=  "\n" + answers[i] + " ";
        }
        s += " ------------- ";
        return s;
    }
}
