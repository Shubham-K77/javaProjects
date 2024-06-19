package Application;
import dataBase.insertBooks;
import Objects.bookObject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class addBookPage extends JPanel{
    JLabel authorName, title, publicationName, subject;
    JTextField authorNameText, titleText, publicationNameText, subjectText;
    JButton addBook;
    JOptionPane message;
    Font myfont;
    bookObject book;
    addBookPage(){
        //JPanel Methods
        this.setSize(500, 500);
        this.setLayout(null);
        //Font Methods
        myfont = new Font("Verdana", Font.PLAIN, 20);
        //Label Methods
        authorName = new JLabel("AuthorName: ");
        authorName.setFont(myfont);
        authorName.setBounds(20,10, 200, 80);
        title = new JLabel("Title: ");
        title.setFont(myfont);
        title.setBounds(20,80, 200, 80);
        publicationName = new JLabel("PublicationName: ");
        publicationName.setFont(myfont);
        publicationName.setBounds(20,150, 200, 80);
        subject = new JLabel("Subject: ");
        subject.setFont(myfont);
        subject.setBounds(20,230, 200, 80);
        //Buttons Method
        addBook = new JButton("Add Book!");
        addBook.setFont(myfont);
        addBook.setBounds(20, 340, 200, 60);
        //TextFieldMethods
        authorNameText = new JTextField();
        authorNameText.setFont(myfont);
        authorNameText.setBounds(250, 20, 210, 50);
        titleText = new JTextField();
        titleText.setFont(myfont);
        titleText.setBounds(250, 90, 210, 50);
        publicationNameText = new JTextField();
        publicationNameText.setFont(myfont);
        publicationNameText.setBounds(250, 160, 210, 50);
        subjectText = new JTextField();
        subjectText.setFont(myfont);
        subjectText.setBounds(250, 240, 210, 50);

        //Add To Panel
        this.add(authorName);
        this.add(title);
        this.add(publicationName);
        this.add(subject);
        this.add(addBook);
        this.add(authorNameText);
        this.add(titleText);
        this.add(publicationNameText);
        this.add(subjectText);

        //ActionListener =>
        addBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(authorNameText.getText().equals("") || titleText.getText().equals("") || publicationNameText.getText().equals("") || subjectText.getText().equals("") ){
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Fields Must Be Filled!", "Create Book", 2);
                }
                book = new bookObject(authorNameText.getText(), titleText.getText(), publicationNameText.getText(), subjectText.getText());
                boolean flag = insertBooks.insertData(book);
                if(flag == true){
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Book Succesfully Created!", "Create Book", 1);
                    authorNameText.setText("");
                    titleText.setText("");
                    publicationNameText.setText("");
                    subjectText.setText("");
                }else{
                    message = new JOptionPane();
                    message.showMessageDialog(null, "OOPS INSERT PROBLEM!", "Create Book", 2);
                }
            }
        });
    }

}
