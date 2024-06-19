package dataBase;
import java.sql.*;
public class fetchAll {
    static String [][] fetchedData = new String[20][6]; //Default Size = 20
    public static String [][] getFetchedData(){
        try{
            Connection con = connectionProvider.getConnection();
            String query = "SELECT s.firstName, s.lastName, s.gender, s.program, s.section, b.title FROM issueBook i JOIN students s ON i.studentId = s.id JOIN books b ON i.bookId = b.id;";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            int i = 0;
            while(result.next()){
                fetchedData[i][0] = result.getString(1);
                fetchedData[i][1] = result.getString(2);
                fetchedData[i][2] = result.getString(3);
                fetchedData[i][3] = result.getString(4);
                fetchedData[i][4] = result.getString(5);
                fetchedData[i][5] = result.getString(6);
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return fetchedData;
    }
}
