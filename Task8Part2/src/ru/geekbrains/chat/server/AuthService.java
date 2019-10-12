package ru.geekbrains.chat.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBlackList(Integer idUser, Integer idBlockUser) {
        try {
            String query = "INSERT INTO BlackList (id_user, id_block_user) VALUES (?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idUser);
            ps.setInt(2, idBlockUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getBlackList(Integer idByUser) {

        ArrayList blackList = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery("SELECT id_block_user FROM BlackList WHERE id_user = '" + idByUser + "'");
            while (rs.next()) {
                blackList.add(rs.getInt("id_block_user"));
            }
            return blackList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getIdByUser(String nickname) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id FROM main WHERE nickname = '" + nickname + "'");
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id, nickname, password FROM main WHERE login = '" + login + "'");
            int myHash = pass.hashCode();
            if (rs.next()) {
                String[] userData = {rs.getString(1), rs.getString(2)};
                int dbHash = rs.getInt(3);
                if (myHash == dbHash) {
                    return userData;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
