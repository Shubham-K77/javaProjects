package dataBase;
import Objects.studentObject;

import java.sql.*;
public class insertStudents {
    static boolean flag = false;
    public static boolean insertData(studentObject std){
        try{
            String query = "INSERT INTO students(firstName, lastName, gender, program, section) VALUES (?, ?, ?, ?, ?)";
            Connection con = connectionProvider.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, std.getFirstName());
            statement.setString(2, std.getLastName());
            statement.setString(3, std.getGender());
            statement.setString(4, std.getProgram());
            statement.setString(5, std.getSection());
            statement.executeUpdate();
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
