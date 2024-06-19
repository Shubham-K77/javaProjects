package Application;
import Objects.userObject;
import dataBase.insertUsers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class registerPage implements ActionListener{
    JFrame frame;
    JLabel userName, passWord, fullName;
    JTextField userText, passText, fullText;
    Font myfont;
    JButton register, cancel;
    JOptionPane message;
    registerPage(){
        //Frame Methods
        frame = new JFrame("Register Page");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        //Font Methods
        myfont = new Font("Verdana", Font.PLAIN, 20);

        //Label Methods
        userName = new JLabel("Username: ");
        userName.setFont(myfont);
        userName.setBounds(40, 20, 200, 100);
        passWord = new JLabel("Password: ");
        passWord.setFont(myfont);
        passWord.setBounds(40, 130, 200, 100);
        fullName = new JLabel("FullName: ");
        fullName.setFont(myfont);
        fullName.setBounds(40, 250, 200, 100);

        //TextField Methods
        userText = new JTextField();
        userText.setFont(myfont);
        userText.setBounds(200,40, 240, 60);
        passText = new JTextField();
        passText.setFont(myfont);
        passText.setBounds(200,150, 240, 60);
        fullText = new JTextField();
        fullText.setFont(myfont);
        fullText.setBounds(200,270, 240, 60);

        //Buttons Method
        register = new JButton("Register");
        register.setFont(myfont);
        register.setBounds(80, 390, 150, 50);
        register.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setFont(myfont);
        cancel.setBounds(260, 390, 150, 50);
        cancel.addActionListener(this);
        //Visibility Of The Frame
        frame.add(userName);
        frame.add(passWord);
        frame.add(fullName);
        frame.add(userText);
        frame.add(passText);
        frame.add(fullText);
        frame.add(register);
        frame.add(cancel);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == register){
            if(userText.getText().equals("") || passText.getText().equals("") || fullText.getText().equals("")){
                message = new JOptionPane();
                message.showMessageDialog(null, "Fields Must Be Filled!", "Error Registration!", JOptionPane.WARNING_MESSAGE);
            }
            else{
                userObject user = new userObject(userText.getText(), passText.getText(), fullText.getText());
                boolean flag = insertUsers.insertData(user);
                if(flag == true){
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Register Succesfull!", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
                else{
                    message.showMessageDialog(null, "Register Failure!", "Register Error!", 2);
                }
            }

        }else{
            frame.dispose();
        }
    }
}
