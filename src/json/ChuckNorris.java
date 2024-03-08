package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ChuckNorris {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            System.out.println(json.get("value"));
        } catch (MalformedURLException e) {
            System.out.println("URL has a problem");
        } catch (IOException e) {
            System.out.println("Cannot read from the URL");
        } catch (ParseException e) {
            System.out.println("Cannot parse stream");
        }
    }
}
