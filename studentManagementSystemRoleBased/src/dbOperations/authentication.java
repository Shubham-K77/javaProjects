package dbOperations;

import java.sql.*;

public class authentication {
    static String role, user;
    static int id;

    public static boolean auth(String username, String password) {
        boolean flag = false;
        try {
            Connection con = conncetionProvider.createC();
            String query = "SELECT id, username, password, role FROM students WHERE username = ? AND password = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // If a record is found, the credentials are correct, then get the role and id of the user
                id = resultSet.getInt("id");
                role = resultSet.getString("role");
                user = resultSet.getString("username");
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    public static String getRole() {
        return role;
    }
    public static String getUser(){
        return user;
    }
    public static int getId() {
        return id;
    }
}
