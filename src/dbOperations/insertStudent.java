package dbOperations;
import systemUI.students;
import java.sql.*;
public class insertStudent {
    public static boolean insertToDB(students std){
        Boolean flag = false;
        try{
            Connection con = conncetionProvider.createC();
            //3. Fire The Queries Using Connection
            String query = "INSERT INTO students (username, password, fullname, age, gender, faculty, section, address, dob) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //Prepared Statement
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, std.getUsername());
            statement.setString(2, std.getPassword());
            statement.setString(3, std.getFullname());
            statement.setInt(4, std.getAge());
            statement.setString(5, std.getGender());
            statement.setString(6, std.getFaculty());
            statement.setString(7, std.getSection());
            statement.setString(8, std.getAddress());
            statement.setString(9, std.getDob());
            //4. Execute The Query
            statement.executeUpdate();
            flag = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
