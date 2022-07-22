package big_task3008_chat_application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Enter server port:");
        final int port = ConsoleHelper.readInt();


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Chat server is running");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("An error occurred while starting or running the server.");

        }
    }
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

    }


    public static void sendBroadcastMessage(Message message) throws IOException {
        try {
            for (Connection c : connectionMap.values()) {
                c.send(message);
            }
        }catch (Exception e) {
            ConsoleHelper.writeMessage("Message couldn't be sent");
        }
    }
}
