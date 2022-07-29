package big_task3008_chat_application.client;

import big_task3008_chat_application.Connection;
import big_task3008_chat_application.ConsoleHelper;
import big_task3008_chat_application.Message;
import big_task3008_chat_application.MessageType;

import java.io.IOException;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }

    protected String getServerAddress() throws IOException {
        System.out.println("Please, enter server address:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        System.out.println("Please, enter server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        System.out.println("Please, enter user name:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Unable to send massage");
            clientConnected = false;
        }
    }
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();


        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("An error occurred while running the client");
            return;
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("A connection has been established. To exit, enter 'exit'.");
        else
            ConsoleHelper.writeMessage("An error occurred while running the client.");

        while (clientConnected) {
            String text = null;
            try {
                text = ConsoleHelper.readString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (text.equalsIgnoreCase("exit"))
                break;

            if (shouldSendTextFromConsole())
                sendTextMessage(text);
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
