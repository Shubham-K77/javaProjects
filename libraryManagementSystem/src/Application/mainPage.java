package Application;
import dataBase.loginValidation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mainPage implements ActionListener{
    JFrame frame;
    JLabel username, password;
    JTextField userText, passText;
    JButton login, cancel, register;
    JPanel buttonPanels;
    JOptionPane dialog;
    Font myfont;
    mainPage(){
        //Frame Methods
        frame = new JFrame("Library Management System");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        //Font Methods
        myfont = new Font("Verdana", Font.PLAIN, 20);

        //Label Methods
        username = new JLabel("Username: ");
        username.setFont(myfont);
        username.setBounds(40, 80, 200, 100);

        //TextField Methods
        userText = new JTextField();
        userText.setFont(myfont);
        userText.setBounds(200, 105, 250, 50);

        //Password Methods
        password = new JLabel("Password: ");
        password.setFont(myfont);
        password.setBounds(40, 200, 200, 100);

        //PasswordField Methods
        passText = new JTextField();
        passText.setFont(myfont);
        passText.setBounds(200, 225, 250, 50);

        //Panel For The Buttons
        buttonPanels = new JPanel();
        buttonPanels.setLayout(new FlowLayout(FlowLayout.LEFT, 10 ,10));
        buttonPanels.setBounds(65, 350, 500, 200);

        //JButtons Methods
        login = new JButton("Login");
        login.setFont(myfont);
        login.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setFont(myfont);
        cancel.addActionListener(this);
        register = new JButton("Register");
        register.setFont(myfont);
        register.addActionListener(this);

        //Add Buttons To The Panel
        buttonPanels.add(login);
        buttonPanels.add(cancel);
        buttonPanels.add(register);

        //Make The Frame Visible
        frame.add(username);
        frame.add(userText);
        frame.add(password);
        frame.add(passText);
        frame.add(buttonPanels);
        frame.setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == login){
            if(userText.getText().equals("") || passText.getText().equals("")){
                dialog = new JOptionPane();
                dialog.showMessageDialog(null, "Username And Password Must Be Filled!", "Error Login", JOptionPane.WARNING_MESSAGE);
            }
            else{
                boolean flag = loginValidation.checkValidation(userText.getText(), passText.getText());
                if(flag == true){
                    dialog.showMessageDialog(null, "Login Succesfull!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                    dashBoard db = new dashBoard();
                    frame.dispose();
                }
                else{
                    dialog.showMessageDialog(null, "Login Failure!", "Credentials Invalid!", 2);
                }
            }
        }
        else if(e.getSource() == register){
            registerPage rp = new registerPage();
        }
        else{
            frame.dispose();
        }
    }
    public static void main(String[] args){
        mainPage mP = new mainPage();
    }

}
