package big_task3008_chat_application.client;

import big_task3008_chat_application.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends Client.SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hello, there. I'm a bot. I understand the following commands: date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (message.contains(":")) {
                String[] split = message.split(": ");
                if (split.length != 2) {
                    return;
                }

                String senderName = split[0];
                message = split[1];
                String outputMessage = "Information for " + senderName + ": ";
                Date currentDate = Calendar.getInstance().getTime();
                SimpleDateFormat dateFormat = switch (message) {
                    case "date" -> new SimpleDateFormat("d.MM.yyyy");
                    case "day" -> new SimpleDateFormat("d");
                    case "month" -> new SimpleDateFormat("MMMM");
                    case "year" -> new SimpleDateFormat("yyyy");
                    case "time" -> new SimpleDateFormat("H:mm:ss");
                    case "hour" -> new SimpleDateFormat("H");
                    case "minutes" -> new SimpleDateFormat("m");
                    case "seconds" -> new SimpleDateFormat("s");
                    default -> null;
                };

                if (dateFormat != null) {
                    outputMessage += dateFormat.format(currentDate);
                    BotClient.this.sendTextMessage(outputMessage);
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (Math.random() * 100);
        return "date_bot_" + x;
    }
}
