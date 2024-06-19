package dataBase;
import java.sql.*;
public class loginValidation {
    static boolean flag = false;
    public static boolean checkValidation(String username, String password){
        try{
            String query = "SELECT * FROM users WHERE username = ?";
            Connection con = connectionProvider.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet userFound = statement.executeQuery();
            while(userFound.next()){
                if(userFound.getString("password").equals(password)){
                    flag = true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
