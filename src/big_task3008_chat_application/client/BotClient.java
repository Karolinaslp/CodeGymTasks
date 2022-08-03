package big_task3008_chat_application.client;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends Client.SocketThread {
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
