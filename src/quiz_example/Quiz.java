package quiz_example;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int currentQuestion;

    public void newGame() {
        QuizAPIHandler handler = new QuizAPIHandler();
        questions = handler.getQuiz();
        score = 0;
        currentQuestion = 0;
    }

    public boolean hasNextQuestion() {
        return currentQuestion < 10;
    }

    public void play() {
        newGame();
        while(hasNextQuestion()) {
            Question question = questions.get(currentQuestion);
            question.display();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Answer: ");
            int answer = scanner.nextInt();
            if(question.correctAnswer(answer)) {
                score++;
            }
            currentQuestion++;
        }
        System.out.println("SCORE: " + score);
    }
}
