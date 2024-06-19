package Application;

import Objects.studentObject;
import dataBase.insertStudents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class addStudentPage extends JPanel {
    JLabel firstName, lastName, gender, program, section;
    Font myfont;
    JTextField firstNameText, lastNameText;
    JRadioButton male, female, others;
    JButton addStudent;
    ButtonGroup bg;
    JComboBox<String> programSelection, sectionSelection;
    JPanel genderButtons;
    JOptionPane message;
    studentObject student;
    String sectionData, genderData, programData;
    String[] bcis, bba, bbaBi, bbaTt;

    public addStudentPage() {
        // Panel Methods
        this.setLayout(null);

        // Font Methods
        myfont = new Font("Verdana", Font.PLAIN, 20);

        // JLabel Methods
        firstName = new JLabel("First Name: ");
        firstName.setFont(myfont);
        firstName.setBounds(20, 10, 200, 100);
        lastName = new JLabel("Last Name: ");
        lastName.setFont(myfont);
        lastName.setBounds(20, 80, 200, 100);
        gender = new JLabel("Gender: ");
        gender.setFont(myfont);
        gender.setBounds(20, 150, 200, 100);
        program = new JLabel("Program: ");
        program.setFont(myfont);
        program.setBounds(20, 220, 200, 100);
        section = new JLabel("Section: ");
        section.setFont(myfont);
        section.setBounds(20, 290, 200, 100);

        // Button Methods
        addStudent = new JButton("Add Student");
        addStudent.setFont(myfont);
        addStudent.setBounds(20, 390, 160, 60);

        // TextField Methods
        firstNameText = new JTextField();
        firstNameText.setFont(myfont);
        firstNameText.setBounds(200, 35, 220, 50);
        lastNameText = new JTextField();
        lastNameText.setFont(myfont);
        lastNameText.setBounds(200, 105, 220, 50);

        // Gender Buttons
        genderButtons = new JPanel();
        genderButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        male = new JRadioButton("Male");
        male.setFont(myfont);
        male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderData = "Male";
            }
        });
        female = new JRadioButton("Female");
        female.setFont(myfont);
        female.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderData = "Female";
            }
        });
        others = new JRadioButton("Others");
        others.setFont(myfont);
        others.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderData = "Others";
            }
        });
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(others);
        genderButtons.add(male);
        genderButtons.add(female);
        genderButtons.add(others);
        genderButtons.setBounds(160, 175, 300, 50);

        // ComboBox Methods
        String[] programs = {"BBA", "BCIS", "BBA-BI", "BBA-TT"};
        bcis = new String[]{"Garnet", "Grit", "Fusion", "Fourier", "Enum", "Efika"};
        bba = new String[]{"Icon", "Image", "Ideal", "Helm", "Heritage", "Harmony", "Grace", "Glory", "Grandeur"};
        bbaBi = new String[]{"Trade", "Trend", "Transit", "Forex", "Fiscal", "Fintech", "Nostro", "Vostro"};
        bbaTt = new String[]{"Minivet", "Phewa", "Tilicho", "Yala"};
        programSelection = new JComboBox<>(programs);
        programSelection.setFont(myfont);
        programSelection.setBounds(200, 240, 220, 50);
        sectionSelection = new JComboBox<>();
        sectionSelection.setFont(myfont);
        sectionSelection.setBounds(200, 315, 220, 50);

        //ComboBox Action Listeners
        programSelection.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    programData = (String) e.getItem();
                    sectionSelection.removeAllItems();
                    if(programData.equals("BCIS")){
                        for(String item : bcis){
                            sectionSelection.addItem(item);
                        }
                    }
                    else if(programData.equals("BBA")){
                        for(String item : bba){
                            sectionSelection.addItem(item);
                        }
                    }
                    else if(programData.equals("BBA-BI")){
                        for(String item : bbaBi){
                            sectionSelection.addItem(item);
                        }
                    }
                    else{
                        for(String item : bbaTt){
                            sectionSelection.addItem(item);
                        }
                    }
                }
            }
        });

        sectionSelection.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sectionData = (String) sectionSelection.getSelectedItem();
                }
            }
        });

        // Add components to the panel
        this.add(firstName);
        this.add(lastName);
        this.add(gender);
        this.add(program);
        this.add(section);
        this.add(firstNameText);
        this.add(lastNameText);
        this.add(addStudent);
        this.add(genderButtons);
        this.add(programSelection);
        this.add(sectionSelection);

        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student = new studentObject(firstNameText.getText(), lastNameText.getText(), genderData, programData, sectionData);
                boolean result = insertStudents.insertData(student);
                if (result) {
                    message = new JOptionPane();
                    message.showMessageDialog(null, "New Student Created!", "Student Creation!", JOptionPane.INFORMATION_MESSAGE);
                    firstNameText.setText("");
                    lastNameText.setText("");
                    bg.clearSelection();
                    programSelection.setSelectedItem(" ");
                    sectionSelection.setSelectedItem(" ");
                } else {
                    message = new JOptionPane();
                    message.showMessageDialog(null, "Student Creation Failed!", "Student Creation", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
