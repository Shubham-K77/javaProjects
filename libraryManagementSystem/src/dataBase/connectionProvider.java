package dataBase;
import java.sql.*;
public class connectionProvider {
    static Connection con;
    public static Connection getConnection(){
        try{
            //1. Load The Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. Build The Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem", "root", "Shubham@707");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
