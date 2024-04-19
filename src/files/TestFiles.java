package files;

import java.io.*;

public class TestFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        if(file.exists()) {
            System.out.println("File openned");
        }
        else {
            file.createNewFile();
            System.out.println("File created");
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter buffered = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(buffered);
        printWriter.write("Hello File with print writer");
        printWriter.println();
        printWriter.close();
    }
}
