package systemUI;

import dbOperations.authentication;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class displayPage implements ActionListener {
    JFrame frame;
    JLabel username, password;
    JTextField userText;
    JPasswordField passText;
    JButton login, signup;
    Font myfont;
    JOptionPane messageDisplay;
    ImageIcon logo;

    displayPage() {
        frame = new JFrame("Welcome To MIS!");
        messageDisplay = new JOptionPane();
        frame.setSize(500, 420);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x860b09));

        myfont = new Font("Verdana", Font.PLAIN, 20);

        username = new JLabel("Username: ");
        username.setBackground(new Color(0x860b09));
        username.setForeground(Color.WHITE);
        username.setFont(myfont);

        password = new JLabel("Password: ");
        password.setBackground(new Color(0x860b09));
        password.setForeground(Color.WHITE);
        password.setFont(myfont);

        logo = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\studentManagementMIS\\images\\apexLogo.png");
        frame.setIconImage(logo.getImage());

        userText = new JTextField();
        userText.setFont(myfont);
        passText = new JPasswordField();
        passText.setFont(myfont);

        login = new JButton("Login");
        login.setFont(myfont);
        login.setForeground(new Color(0x860b09));
        login.setBackground(Color.WHITE);

        signup = new JButton("Signup");
        signup.setFont(myfont);
        signup.setForeground(new Color(0x860b09));
        signup.setBackground(Color.WHITE);

        login.addActionListener(this);
        signup.addActionListener(this);

        username.setBounds(50, 50, 200, 50);
        userText.setBounds(200, 50, 200, 50);
        password.setBounds(50, 150, 200, 50);
        passText.setBounds(200, 150, 200, 50);
        login.setBounds(50, 260, 150, 50);
        signup.setBounds(250, 260, 150, 50);

        frame.add(username);
        frame.add(userText);
        frame.add(password);
        frame.add(passText);
        frame.add(login);
        frame.add(signup);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            new signupPage();
        } else {
            String username = userText.getText();
            String password = new String(passText.getPassword()); // Correctly fetching password
            boolean ans = authentication.auth(username, password);
            if (ans) {
                String role = authentication.getRole();
                int id = authentication.getId();
                String user = authentication.getUser();
                messageDisplay.showMessageDialog(frame, "Authentication Valid", "Authentication Validation", JOptionPane.INFORMATION_MESSAGE);
                new dashBoardPage(role, id, user); // Pass role, id, user
            } else {
                messageDisplay.showMessageDialog(frame, "Authentication Failed", "Authentication Validation", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new displayPage();
    }
}
