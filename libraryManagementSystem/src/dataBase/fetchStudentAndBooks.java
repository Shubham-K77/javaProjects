package dataBase;
import java.sql.*;
import java.util.ArrayList;
public class fetchStudentAndBooks {
    static ArrayList<String> books = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> fetchBooks(){
        try{
            String query = "SELECT title FROM books";
            Connection con = connectionProvider.getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                books.add(result.getString("title"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return books;
    }
    public static ArrayList<String> fetchNames(){
        try{
            String query = "SELECT firstName FROM students";
            Connection con = connectionProvider.getConnection();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                names.add(result.getString("firstName"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return names;
    }
}
