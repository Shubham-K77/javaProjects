package dbOperations;
import java.sql.*;
public class deleteStudent {
    public static boolean deleteRecord(int id){
        Boolean flag = false;
        try{
            Connection con = conncetionProvider.createC();
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
