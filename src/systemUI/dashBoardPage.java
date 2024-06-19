package systemUI;
import dbOperations.showAll;
import dbOperations.showSpecific;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class dashBoardPage implements ActionListener {
    JFrame frame;
    JPanel welcomeUser, actionButtons, mainTable;
    JLabel welcomeMessage;
    JTable dataTable;
    JScrollPane sp;
    JButton update, delete, refresh;
    String[] colData;
    String[][] rowData;
    ImageIcon logo;
    Font myfont;
    String role;
    int id;
    String user;

    public dashBoardPage(String role, int id, String user) {
        this.role = role;
        this.id = id;
        this.user = user;

        frame = new JFrame("Dashboard Page!");
        frame.setSize(1400, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0x860b09));

        logo = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\studentManagementMIS\\images\\apexLogo.png");
        frame.setIconImage(logo.getImage());

        myfont = new Font("Verdana", Font.PLAIN, 20);

        welcomeMessage = new JLabel("Welcome " + user + "!");
        welcomeMessage.setBackground(new Color(0x860b09));
        welcomeMessage.setForeground(Color.white);
        welcomeMessage.setFont(myfont);

        welcomeUser = new JPanel();
        welcomeUser.add(welcomeMessage);
        welcomeUser.setBackground(new Color(0x860b09));

        if (role.equals("Student")) {
            colData = new String[]{"ID", "Username", "Fullname", "Age", "Gender", "Faculty", "Section", "Role", "Address", "DOB"};
            rowData = showSpecific.showData(id);
            dataTable = new JTable(rowData, colData);
        } else { // Admin Role
            colData = new String[]{"ID", "Username", "Password", "Fullname", "Age", "Gender", "Role", "Faculty", "Section", "Address", "DOB"};
            ArrayList<students> studentsList = showAll.getAllStudents();
            rowData = showAll.convertListTo2DArray(studentsList);
            dataTable = new JTable(rowData, colData);
        }

        // Set custom row height and styling
        dataTable.setRowHeight(30);
        dataTable.setFont(myfont);
        dataTable.setBackground(new Color(0x860b09));
        dataTable.setForeground(Color.WHITE);
        dataTable.getTableHeader().setBackground(new Color(0x860b09));
        dataTable.getTableHeader().setForeground(Color.WHITE);
        dataTable.getTableHeader().setFont(myfont);
        dataTable.setPreferredScrollableViewportSize(new Dimension(950, 380));
        dataTable.setFillsViewportHeight(true);

        sp = new JScrollPane(dataTable);
        mainTable = new JPanel(new BorderLayout());
        mainTable.setBackground(new Color(0x860b09));
        mainTable.add(sp, BorderLayout.CENTER);

        update = new JButton("Update");
        update.setFont(myfont);
        update.setForeground(new Color(0x860b09));
        update.setBackground(Color.WHITE);
        update.addActionListener(this);

        refresh = new JButton("Refresh");
        refresh.setFont(myfont);
        refresh.setForeground(new Color(0x860b09));
        refresh.setBackground(Color.WHITE);
        refresh.addActionListener(this);

        delete = new JButton("Delete");
        delete.setFont(myfont);
        delete.setForeground(new Color(0x860b09));
        delete.setBackground(Color.WHITE);
        delete.addActionListener(this);

        actionButtons = new JPanel();
        actionButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        actionButtons.setBackground(new Color(0x860b09));
        actionButtons.add(refresh);
        actionButtons.add(update);
        actionButtons.add(delete);

        frame.add(welcomeUser, BorderLayout.NORTH);
        frame.add(mainTable, BorderLayout.CENTER);
        if (role.equals("Admin")) {
            frame.add(actionButtons, BorderLayout.SOUTH);
        }
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            deletePage dp = new deletePage();
        } else if (e.getSource() == update) {
            // Handle update logic here
            updatePage up = new updatePage();
        } else {
            // Reload data from the database
            if (role.equals("Student")) {
                rowData = showSpecific.showData(id);
            } else { // Admin Role
                ArrayList<students> studentsList = showAll.getAllStudents();
                rowData = showAll.convertListTo2DArray(studentsList);
            }

            // Create a new DefaultTableModel with the updated data
            DefaultTableModel model = new DefaultTableModel(rowData, colData);

            // Set the new model to the JTable
            dataTable.setModel(model);
        }
    }
}
