package observer;

import java.io.*;

/**
 * logs error into a file
 */
public class ErrorLogger implements ErrorObserver {
    @Override
    public void error(String message) {
        try {
            File file = new File("adder_errors.log");
            if(!file.exists()) {
                    file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.write(message);
            writer.println();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
