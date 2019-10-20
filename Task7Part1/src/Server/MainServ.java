package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainServ {
    private List<ClientHandler> clients = new ArrayList<>();

    public MainServ() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            AuthService.connect();
            server = new ServerSocket(8180);
            System.out.println("Сервер запущен!");
            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AuthService.disconnect();
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public void broadcastMsg(String sender, String recipient, String msg) {
        for (ClientHandler o: clients) {
            if (o.getName().equals(sender)) o.sendMsg("Отправлено для: " + recipient + " SMS: " + msg);
            if (o.getName().equals(recipient)) o.sendMsg("Получено от: " + recipient + " SMS: " + msg);
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public boolean individUser(String name) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(name)) {
                return true;
            }
        }
        return false;

    }
}
