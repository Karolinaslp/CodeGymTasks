package big_task3110_archiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public String readString() throws IOException {
        String string = reader.readLine();
        return string;
    }

    public int readInt() throws IOException {
        String text = readString();
        return  Integer.parseInt(text.trim());
    }
}