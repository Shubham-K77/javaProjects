package dbOperations;
import systemUI.students;
import java.sql.*;

public class showSpecific {

    public static String[][] showData(int id) {
        String[][] tableData = new String[1][11]; // Array for a single student
        try {
            Connection con = conncetionProvider.createC();
            String query = "SELECT id, username, fullname, age, gender, faculty, section, role, address, dob FROM students WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                // If a record is found, populate the array
                students stud = new students();
                stud.setId(set.getInt("id"));
                stud.setUsername(set.getString("username"));
                stud.setFullname(set.getString("fullname"));
                stud.setAge(set.getInt("age"));
                stud.setGender(set.getString("gender"));
                stud.setFaculty(set.getString("faculty"));
                stud.setSection(set.getString("section"));
                stud.setRole(set.getString("role"));
                stud.setAddress(set.getString("address"));
                stud.setDob(set.getString("dob"));

                // Populate the 2D array with student information
                tableData[0][0] = String.valueOf(stud.getId());
                tableData[0][1] = stud.getUsername();
                tableData[0][2] = stud.getFullname();
                tableData[0][3] = String.valueOf(stud.getAge());
                tableData[0][4] = stud.getGender();
                tableData[0][5] = stud.getFaculty();
                tableData[0][6] = stud.getSection();
                tableData[0][7] = stud.getRole();
                tableData[0][8] = stud.getAddress();
                tableData[0][9] = stud.getDob();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableData;
    }

}
