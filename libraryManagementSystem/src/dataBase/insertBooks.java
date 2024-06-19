package dataBase;
import Objects.bookObject;

import java.sql.*;
public class insertBooks {
    static boolean flag = false;
    public static boolean insertData(bookObject book){
        try{
            String query = "INSERT INTO books (authorName, title, publicationName, subject) VALUES (?, ?, ?, ?)";
            Connection con = connectionProvider.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, book.getAuthorName());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getPublicationName());
            statement.setString(4, book.getSubject());
            statement.executeUpdate();
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
