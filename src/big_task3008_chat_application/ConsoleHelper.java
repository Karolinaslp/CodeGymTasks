package big_task3008_chat_application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String string;
        while (true) {
            try {
                string = reader.readLine();
                if (string != null) {
                    return string;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while trying to enter text. Try again");
            }
        }
    }

    public static int readInt() throws IOException {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(Objects.requireNonNull(readString()));
                return number;
            } catch (NumberFormatException e) {
                System.out.println("An error while trying to enter a number. Try again");
            }
        }
    }
}
