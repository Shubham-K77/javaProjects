package dbOperations;
import java.sql.*;

public class conncetionProvider {
    static Connection con;
    public static Connection createC(){
        try{
            //1. Load The Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. Create The Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apexStudentApp", "root", "Shubham@707");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
