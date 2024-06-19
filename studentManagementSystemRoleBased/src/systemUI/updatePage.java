package systemUI;
import dbOperations.getTheStudent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updatePage {
    JFrame frame;
    JLabel update;
    JTextField updateText;
    JButton updateButton;
    ImageIcon logo;
    Font myfont;
    JOptionPane messageDisplay;
    int id;

    updatePage() {
        frame = new JFrame("Update User!");
        frame.setSize(500, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x860b09));

        myfont = new Font("Verdana", Font.PLAIN, 20);

        update = new JLabel("ID: ");
        update.setBackground(new Color(0x860b09));
        update.setForeground(Color.WHITE);
        update.setFont(myfont);

        updateText = new JTextField();
        updateText.setFont(myfont);

        logo = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\studentManagementMIS\\images\\apexLogo.png");
        frame.setIconImage(logo.getImage());

        updateButton = new JButton("Update");
        updateButton.setFont(myfont);
        updateButton.setForeground(new Color(0x860b09));
        updateButton.setBackground(Color.WHITE);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(updateText.getText());
                students std = getTheStudent.fetchTheData(id);
                updateStudentPage updatePage = new updateStudentPage(id);
                updatePage.setTheInitialValues(std);
                frame.dispose();
            }
        });

        update.setBounds(25, 25, 200, 100);
        updateText.setBounds(225, 50, 200, 50);
        updateButton.setBounds(150, 140, 200, 50);

        frame.add(update);
        frame.add(updateText);
        frame.add(updateButton);
        frame.setVisible(true);
    }
}
