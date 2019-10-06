import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class EchoServer {

    private static ServerSocket serverSocket = null;
    private static Socket socket = null;
    private static BufferedReader console = null;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try{
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения0");
        }
        new Thread(() -> {
            while (true) {
                try {
                    String txt = in.readUTF();
                    if (txt.equals("/end")) {
                        closeConnection();
                        break;
                    }
                    out.writeUTF("Клиент: " + txt);
                    System.out.println(("Клиент: " + txt));
                } catch (Exception e) {
                    System.out.println("Сервер отключен");
                    break;
                }
            }
        }).start();
        new Thread(() -> {
            try {
                writeToConsole();
            } catch (Exception e) {
                System.out.println("Клиент отключен");
            }
        }).start();
    }
    private static void sendMessage(String msg) throws Exception {
            out.writeUTF("Сервер: " + msg);
            System.out.println("Сервер: " + msg);
    }
    private static void writeToConsole() throws Exception {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
    private static void closeConnection() throws Exception {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

}