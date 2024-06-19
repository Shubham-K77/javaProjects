package dbOperations;
import systemUI.students;
import java.sql.*;
import java.util.ArrayList;

public class showAll {
    public static ArrayList<students> getAllStudents() {
        ArrayList<students> studentList = new ArrayList<>();

        try {
            Connection con = conncetionProvider.createC();
            String query = "SELECT * FROM students WHERE role = 'Student'";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                students student = new students();
                student.setId(set.getInt(1));
                student.setUsername(set.getString(2));
                student.setPassword(set.getString(3));
                student.setFullname(set.getString(4));
                student.setAge(set.getInt(5));
                student.setGender(set.getString(6));
                student.setFaculty(set.getString(7));
                student.setSection(set.getString(8));
                student.setRole(set.getString(9));
                student.setAddress(set.getString(10));
                student.setDob(set.getString(11));
                studentList.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static String[][] convertListTo2DArray(ArrayList<students> students) {
        String[][] tableData = new String[students.size()][11];
        for (int i = 0; i < students.size(); i++) {
            students student = students.get(i);
            tableData[i][0] = String.valueOf(student.getId());
            tableData[i][1] = student.getUsername();
            tableData[i][2] = student.getPassword();
            tableData[i][3] = student.getFullname();
            tableData[i][4] = String.valueOf(student.getAge());
            tableData[i][5] = student.getGender();
            tableData[i][6] = student.getFaculty();
            tableData[i][7] = student.getSection();
            tableData[i][8] = student.getRole();
            tableData[i][9] = student.getAddress();
            tableData[i][10] = student.getDob();
        }
        return tableData;
    }
}
