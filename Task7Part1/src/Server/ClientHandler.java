package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MainServ serv;

    private String name;

    public String getName() {
        return name;
    }



    public ClientHandler(MainServ serv, Socket socket) {
        try {
            this.serv = serv;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authentication() throws IOException, SQLException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nick = AuthService.getNickByLoginAndPass(parts[1], parts[2]);
                if (nick != null) {
                    if (!serv.individUser(nick)) {
                        sendMsg("/authok " + nick);
                        name = nick;
                        serv.broadcastMsg(name + " зашел в чат");
                        serv.subscribe(this);
                        return;
                    } else {
                        sendMsg("Учетная запись уже используется");
                    }
                } else {
                    sendMsg("Неверные логин/пароль");
                }
            }
        }
    }
    private void readMessages() throws IOException {
        while (true) {
            String str = in.readUTF();
            System.out.println("от " + name + ": " + str);
            if (str.equals("/end")) {
                return;
            }else if(str.startsWith("/w")){
                String[] parts = str.split("\\s");
                serv.broadcastMsg(name, parts[1], parts[2]);
            }else {
                serv.broadcastMsg(name + ": " + str);
            }
        }
    }
    private void closeConnection() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serv.unsubscribe(this);
        serv.broadcastMsg(name + " вышел из чата");
    }


    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
