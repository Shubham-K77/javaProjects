package dbOperations;
import systemUI.students;
import java.sql.*;
public class updateStudent {
    static boolean flag = false;
    public static boolean updateData(int id, students std) {
        try {
            Connection con = conncetionProvider.createC();
            String query = "UPDATE students SET username = ?, fullname = ?, age = ?, gender = ?, faculty = ?, section = ?, address = ?, dob =? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, std.getUsername());
            statement.setString(2, std.getFullname());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getGender());
            statement.setString(5, std.getFaculty());
            statement.setString(6, std.getSection());
            statement.setString(7, std.getAddress());
            statement.setString(8, std.getDob());
            statement.setInt(9, id);
            statement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
