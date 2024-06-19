package Application;
import dataBase.fetchStudentAndBooks;
import dataBase.insertIssueBooks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class issueBookPage extends JPanel{
    JLabel studentName, bookIssued, issuedDate, dueDate;
    JTextField issuedDateText, dueDateText;
    JButton issueBook;
    ArrayList<String> books, students;
    JComboBox<String> studNames, bookNames;
    String studName, bookName;
    Font myfont;
    JOptionPane message;
    public issueBookPage(){
        //Panel Methods
        this.setLayout(null);
        //Font Methods
        myfont = new Font("Verdana", Font.PLAIN, 20);
        //Label Methods
        studentName = new JLabel("StudentName: ");
        studentName.setFont(myfont);
        studentName.setBounds(20, 20, 200, 100);
        bookIssued = new JLabel("BookIssued: ");
        bookIssued.setFont(myfont);
        bookIssued.setBounds(20, 100, 200, 100);
        issuedDate = new JLabel("IssuedDate: ");
        issuedDate.setFont(myfont);
        issuedDate.setBounds(20, 180, 200, 100);
        dueDate = new JLabel("DueDate: ");
        dueDate.setFont(myfont);
        dueDate.setBounds(20, 260, 200, 100);
        //Button Methods
        issueBook = new JButton("Issue Book!");
        issueBook.setFont(myfont);
        issueBook.setBounds(20, 380, 180, 50);
        //ComboBox Methods
        studNames = new JComboBox<>();
        students = fetchStudentAndBooks.fetchNames();
        for(String names : students){
            studNames.addItem(names);
        }
        studNames.setBounds(220, 40, 200, 60);
        studNames.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                studName = (String) studNames.getSelectedItem();
            }
        });
        bookNames = new JComboBox<>();
        books = fetchStudentAndBooks.fetchBooks();
        for(String titles : books){
            bookNames.addItem(titles);
        }
        bookNames.setBounds(220, 120, 200, 60);
        bookNames.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                 bookName = (String) bookNames.getSelectedItem();
            }
        });
        //TextField Methods
        issuedDateText = new JTextField();
        issuedDateText.setFont(myfont);
        issuedDateText.setBounds(220, 200,200, 60);
        dueDateText = new JTextField();
        dueDateText.setFont(myfont);
        dueDateText.setBounds(220, 280,200, 60);
        //Frame Methods
        this.add(studentName);
        this.add(bookIssued);
        this.add(issuedDate);
        this.add(dueDate);
        this.add(issueBook);
        this.add(studNames);
        this.add(bookNames);
        this.add(issuedDateText);
        this.add(dueDateText);
        //Handle Button Events
        issueBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean flag = insertIssueBooks.insertData(studName, bookName, issuedDateText.getText(), dueDateText.getText());
                if(flag == true){
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Book Issue Complete!", "Book Issue", 1);
                    studNames.setSelectedItem(' ');
                    bookNames.setSelectedItem(' ');
                    issuedDateText.setText("");
                    dueDateText.setText("");
                }
                else{
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Book Issue Incomplete!", "Book Issue", 2);
                }
            }
        });
    }
}
