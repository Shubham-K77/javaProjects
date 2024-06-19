package systemUI;
import dbOperations.deleteStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deletePage{
    JFrame frame;
    JLabel delete;
    JTextField deleteText;
    JButton deleteButton;
    ImageIcon logo;
    Font myfont;
    JOptionPane messageDisplay;
    int id;
    deletePage(){
        frame = new JFrame("Delete User!");
        frame.setSize(500, 250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x860b09));

        myfont = new Font("Verdana", Font.PLAIN, 20);

        delete = new JLabel("ID: ");
        delete.setBackground(new Color(0x860b09));
        delete.setForeground(Color.WHITE);
        delete.setFont(myfont);

        deleteText = new JTextField();
        deleteText.setFont(myfont);

        logo = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\studentManagementMIS\\images\\apexLogo.png");
        frame.setIconImage(logo.getImage());

        deleteButton = new JButton("Delete");
        deleteButton.setFont(myfont);
        deleteButton.setForeground(new Color(0x860b09));
        deleteButton.setBackground(Color.WHITE);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(deleteText.getText());
                boolean ans = deleteStudent.deleteRecord(id);
                if(ans == true){
                    messageDisplay.showMessageDialog(frame, "User Deleted!", "User Delete", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
                else{
                    messageDisplay.showMessageDialog(frame, "User Deletion Failed!", "User Delete", JOptionPane.WARNING_MESSAGE);
                    frame.dispose();
                }
            }
        });

        delete.setBounds(25, 25, 200, 100);
        deleteText.setBounds(225, 50, 200, 50);
        deleteButton.setBounds(150, 140, 200, 50);

        frame.add(delete);
        frame.add(deleteText);
        frame.add(deleteButton);
        frame.setVisible(true);
    }
}
