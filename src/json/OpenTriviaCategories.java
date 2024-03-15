package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenTriviaCategories {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://opentdb.com/api_category.php");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            // System.out.println(json.get("trivia_categories"));
            JSONArray categories = (JSONArray) json.get("trivia_categories");
            for(Object item : categories) {
                JSONObject category = (JSONObject) item;
                System.out.println(category.get("name"));
            }
        } catch (MalformedURLException e) {
            System.out.println("Problem with the URL");
        } catch (IOException e) {
            System.out.println("IO problem");
        } catch (ParseException e) {
            System.out.println("Problem parsing JSON data");
        }
    }
}
