package Application;
import javax.swing.*;

public class dashBoard {
    JFrame frame;
    JPanel addStudent, addBook, issueBook, displayRecord;
    JTabbedPane jtp;

    public dashBoard() {
        // Frame Methods
        frame = new JFrame("Dashboard");
        frame.setSize(1000, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Panel Methods
        addStudent = new addStudentPage();
        addBook = new addBookPage();
        issueBook = new issueBookPage();
        displayRecord = new displayRecordPage();

        // TabbedPane Methods
        jtp = new JTabbedPane();
        jtp.add("Add Student", addStudent);
        jtp.add("Add Book", addBook);
        jtp.add("Issue Book", issueBook);
        jtp.add("Display Records", displayRecord);

        // Frame Visibility
        frame.add(jtp);
        frame.setVisible(true);
    }
}
