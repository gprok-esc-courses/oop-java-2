package files;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("test.txt"), true)));
        writer.write("Hello World using the DECORATOR Pattern");
        writer.println();
        writer.close();
    }
}
