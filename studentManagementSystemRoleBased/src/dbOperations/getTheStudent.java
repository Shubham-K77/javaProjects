package dbOperations;
import systemUI.students;

import java.sql.*;
public class getTheStudent {
    public static students fetchTheData(int id){
        students stud = null;
        try{
            Connection con = conncetionProvider.createC();
            String query = "SELECT id, username, fullname, age, gender, faculty, section, role, address, dob FROM students WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                // If a record is found, populate the array
                stud = new students();
                stud.setUsername(set.getString("username"));
                stud.setFullname(set.getString("fullname"));
                stud.setAge(set.getInt("age"));
                stud.setGender(set.getString("gender"));
                stud.setFaculty(set.getString("faculty"));
                stud.setSection(set.getString("section"));
                stud.setRole(set.getString("role"));
                stud.setAddress(set.getString("address"));
                stud.setDob(set.getString("dob"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return stud;
    }
}
