package dataBase;
import java.sql.*;
import Objects.userObject;
public class insertUsers {
    static boolean flag = false;
    public static boolean insertData(userObject user){
        try{
            String query = "INSERT INTO users(username, password, fullname) values(?, ?, ?);";
            Connection con = connectionProvider.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.executeUpdate();
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
