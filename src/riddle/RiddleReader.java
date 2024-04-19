package riddle;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Accesses the riddle API, brings one riddle at a time,
 * and also can convert it to a Riddle object, or even compose a list of many Riddle objects.
 */
public class RiddleReader {

    private ErrorLogger errorLogger;

    public RiddleReader() {
        errorLogger = new ErrorLogger();
    }

    /**
     * Reads a riddle from the API and converts to a JSON object.
     * @return The JSON object, or null if an error occurs
     */
    public JSONObject readFromAPI() {
        try {
            URL url = new URL("https://riddles-api.vercel.app/random2");
            InputStreamReader is = new InputStreamReader(url.openStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(is);
            return json;
        } catch (MalformedURLException e) {
            errorLogger.error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            return null;
        } catch (IOException e) {
            errorLogger.error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            return null;
        } catch (ParseException e) {
            errorLogger.error(new Date() + ", " + getClass().getSimpleName() + ", " + e.getMessage());
            return null;
        }
    }

    /**
     * Converts a JSON object retrieved from the API, into A Riddle object
     * @return the Riddle object, or null in case of error
     */
    public Riddle getRiddle() {
        JSONObject json = readFromAPI();
        if(json == null) {
            return null;
        }
        else {
            Riddle riddle = new Riddle(json.get("riddle").toString(), json.get("answer").toString());
            return riddle;
        }
    }

    /**
     * Retrieves a list of Riddle objects
     * @param n is the number of riddles we need
     * @return an Array List of Riddle objects, or null in case of error
     */
    public ArrayList<Riddle> getRiddles(int n) {
        ArrayList<Riddle> riddles = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Riddle r = getRiddle();
            if(r == null) {
                return null;
            }
            riddles.add(r);
        }
        return riddles;
    }
}
