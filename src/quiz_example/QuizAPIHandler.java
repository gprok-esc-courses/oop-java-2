package quiz_example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QuizAPIHandler {

    public JSONArray getQuizJSON() {
        URL url = null;
        try {
            url = new URL("https://opentdb.com/api.php?amount=10");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            JSONArray quiz = (JSONArray) json.get("results");
            return quiz;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Question> getQuiz() {
        JSONArray quizJSON = getQuizJSON();
        ArrayList<Question> quiz = new ArrayList<>();
        for(Object object : quizJSON) {
            JSONObject json = (JSONObject) object;
            String type = (String) json.get("type");
            Question question;
            int incorrectSize = 1;
            if(type.equals("multiple")) {
                question = new MultipleQuestion();
                incorrectSize = 3;
            }
            else {
                question = new BooleanQuestion();
            }
            question.question = (String) json.get("question");
            String correct = (String) json.get("correct_answer");
            String [] incorrect = new String[incorrectSize];
            JSONArray inc = (JSONArray) json.get("incorrect_answers");
            for(int i = 0; i < incorrectSize; i++) {
                String ans = (String) inc.get(i);
                incorrect[i] = ans;
            }
            question.setAnswers(correct, incorrect);
            quiz.add(question);
        }
        return quiz;
    }
}
