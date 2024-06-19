package dataBase;
import java.sql.*;
public class insertIssueBooks {
    static boolean flag = false;
    public static boolean insertData(String studentName, String bookName, String issueDate, String dueDate){
        int studentId = 0;
        int bookId = 0;
        try{
            Connection con = connectionProvider.getConnection();
            String studentQuery = "SELECT id from students WHERE firstName = ?";
            PreparedStatement studentStatement = con.prepareStatement(studentQuery);
            studentStatement.setString(1, studentName);
            ResultSet studentResult = studentStatement.executeQuery();
            while(studentResult.next()){
                studentId = studentResult.getInt("id");
            }

            String bookQuery = "SELECT id from books WHERE title = ?";
            PreparedStatement bookStatement = con.prepareStatement(bookQuery);
            bookStatement.setString(1, bookName);
            ResultSet bookResult = bookStatement.executeQuery();
            while(bookResult.next()){
                bookId = bookResult.getInt("id");
            }

            String query = "INSERT INTO issueBook (studentId, bookId, issueDate, dueDate) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, studentId);
            statement.setInt(2, bookId);
            statement.setString(3, issueDate);
            statement.setString(4, dueDate);
            statement.executeUpdate();
            flag = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
