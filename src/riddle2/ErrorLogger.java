package riddle2;

import java.io.*;

public class ErrorLogger implements ErrorObserver {
    @Override
    public void error(String message) {
        try {
            File file = new File("error.log");
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.write(message);
            writer.println();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error log not possible, file could not be opened");
        }
    }
}
