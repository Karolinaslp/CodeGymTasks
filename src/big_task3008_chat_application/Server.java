package big_task3008_chat_application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

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
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage("A new connection with " + socket.getRemoteSocketAddress() + " has been established.");

            String userName = null;

            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                notifyUsers(connection, userName);

                serverMainLoop(connection, userName);


            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error while communicating with " + socket.getRemoteSocketAddress());
            }
            if (userName != null) {
                connectionMap.remove(userName);
                try {
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ConsoleHelper.writeMessage("The connection with " + socket.getRemoteSocketAddress() + " is closed.");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message request = connection.receive();

                if (request.getType().equals(MessageType.USER_NAME)) {
                    String data = request.getData();
                    if (data != null && !(data.equals(""))) {
                        if (!(connectionMap.containsKey(data))) {
                            connectionMap.put(data, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return data;
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException, ClassNotFoundException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (!(userName.equals(pair.getKey())))
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message received = connection.receive();
                if (received.getType() == MessageType.TEXT) {
                    String message = userName + ": " + received.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));
                } else {
                    ConsoleHelper.writeMessage("Message received from " + socket.getRemoteSocketAddress() + ". The message type does not match the protocol.");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) throws IOException {
        try {
            for (Connection c : connectionMap.values()) {
                c.send(message);
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Message couldn't be sent");
        }
    }
}
