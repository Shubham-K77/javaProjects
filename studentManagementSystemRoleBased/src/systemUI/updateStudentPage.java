package systemUI;

import dbOperations.updateStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updateStudentPage implements ActionListener {
    private int studentId; // Make it non-static
    JFrame frame;
    static JLabel username;
    static students student;
    JLabel fullname;
    JLabel age;
    JLabel gender;
    JLabel faculties;
    JLabel section;
    JLabel address;
    JLabel dob;
    static JTextField userText;
    static JTextField fullnameText;
    static JTextField ageText;
    static JTextField addressText;
    static JTextField dobText;
    static JRadioButton male;
    static JRadioButton female;
    static JRadioButton others;
    JPanel genderButtons;
    JOptionPane messageDisplay;
    ButtonGroup genderSelect;
    static JComboBox<String> facultySelect;
    JComboBox<String> sectionSelect;
    ImageIcon logo;
    JButton update;
    Font myfont;
    String selectedFaculty, sectionValue;
    String genderValue = "";

    updateStudentPage(int studentId) {
        this.studentId = studentId;
        messageDisplay = new JOptionPane(); // Initialize The JOptionPane
        frame = new JFrame("Update Student!");
        frame.setSize(500, 820);
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

        fullname = new JLabel("Fullname: ");
        fullname.setBackground(new Color(0x860b09));
        fullname.setForeground(Color.WHITE);
        fullname.setFont(myfont);

        age = new JLabel("Age: ");
        age.setBackground(new Color(0x860b09));
        age.setForeground(Color.WHITE);
        age.setFont(myfont);

        gender = new JLabel("Gender: ");
        gender.setBackground(new Color(0x860b09));
        gender.setForeground(Color.WHITE);
        gender.setFont(myfont);

        faculties = new JLabel("Faculty: ");
        faculties.setBackground(new Color(0x860b09));
        faculties.setForeground(Color.WHITE);
        faculties.setFont(myfont);

        section = new JLabel("Section: ");
        section.setBackground(new Color(0x860b09));
        section.setForeground(Color.WHITE);
        section.setFont(myfont);

        address = new JLabel("Address: ");
        address.setBackground(new Color(0x860b09));
        address.setForeground(Color.WHITE);
        address.setFont(myfont);

        dob = new JLabel("DOB: ");
        dob.setBackground(new Color(0x860b09));
        dob.setForeground(Color.WHITE);
        dob.setFont(myfont);

        genderButtons = new JPanel();
        genderButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");
        genderButtons.add(male);
        genderButtons.add(female);
        genderButtons.add(others);
        genderSelect = new ButtonGroup();
        genderSelect.add(male);
        genderSelect.add(female);
        genderSelect.add(others);

        userText = new JTextField();
        userText.setFont(myfont);
        fullnameText = new JTextField();
        fullnameText.setFont(myfont);
        ageText = new JTextField();
        ageText.setFont(myfont);
        addressText = new JTextField();
        addressText.setFont(myfont);
        dobText = new JTextField();
        dobText.setFont(myfont);
        genderButtons.setBackground(new Color(0x860b09));
        male.setBackground(new Color(0x860b09));
        male.setFont(myfont);
        male.setForeground(Color.WHITE);
        female.setBackground(new Color(0x860b09));
        female.setFont(myfont);
        female.setForeground(Color.WHITE);
        others.setBackground(new Color(0x860b09));
        others.setFont(myfont);
        others.setForeground(Color.WHITE);

        logo = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\studentManagementMIS\\images\\apexLogo.png");
        frame.setIconImage(logo.getImage());
        male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderValue = "Male";
            }
        });

        female.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderValue = "Female";
            }
        });

        others.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genderValue = "Others";
            }
        });

        String[] faculty = {"Select A Faculty: ", "BCIS", "BBA", "BBA-TT"};
        String[] bcis = {"Garnet", "Grit", "Fusion", "Fourier", "Enum", "Efika"};
        String[] bba = {"Icon", "Ideal", "Image", "Helm", "Heritage", "Harmony", "Grace", "Glory", "Grandeur"};
        String[] bba_tt = {"Minivet", "Phewa", "Tilicho", "Yala"};

        facultySelect = new JComboBox<>(faculty);
        sectionSelect = new JComboBox<>();

        facultySelect.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedFaculty = (String) e.getItem();
                    sectionSelect.removeAllItems();
                    if (selectedFaculty.equals("BCIS")) {
                        for (String section : bcis) {
                            sectionSelect.addItem(section);
                        }
                    } else if (selectedFaculty.equals("BBA")) {
                        for (String section : bba) {
                            sectionSelect.addItem(section);
                        }
                    } else if (selectedFaculty.equals("BBA-TT")) {
                        for (String section : bba_tt) {
                            sectionSelect.addItem(section);
                        }
                    }
                }
            }
        });
        sectionSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sectionValue = (String) sectionSelect.getSelectedItem();
                }
            }
        });

        update = new JButton("Update Data");
        update.setFont(myfont);
        update.setForeground(new Color(0x860b09));
        update.setBackground(Color.WHITE);
        update.addActionListener(this);

        username.setBounds(50, 20, 200, 50);
        userText.setBounds(200, 20, 200, 50);
        fullname.setBounds(50, 180, 200, 50);
        fullnameText.setBounds(200, 180, 200, 50);
        age.setBounds(50, 260, 200, 50);
        ageText.setBounds(200, 260, 200, 50);
        gender.setBounds(50, 325, 200, 50);
        genderButtons.setBounds(150, 325, 300, 50);
        faculties.setBounds(50, 400, 200, 50);
        facultySelect.setBounds(200, 400, 200, 50);
        section.setBounds(50, 480, 200, 50);
        sectionSelect.setBounds(200, 480, 200, 50);
        address.setBounds(50, 560, 200, 50);
        addressText.setBounds(200, 560, 200, 50);
        dob.setBounds(50, 640, 200, 50);
        dobText.setBounds(200, 640, 200, 50);
        update.setBounds(150, 720, 200, 50);

        frame.add(username);
        frame.add(userText);
        frame.add(fullname);
        frame.add(fullnameText);
        frame.add(age);
        frame.add(ageText);
        frame.add(gender);
        frame.add(genderButtons);
        frame.add(faculties);
        frame.add(facultySelect);
        frame.add(section);
        frame.add(sectionSelect);
        frame.add(address);
        frame.add(addressText);
        frame.add(dob);
        frame.add(dobText);
        frame.add(update);
        frame.setVisible(true);
    }

    public static void setTheInitialValues(students std) {
        if (userText != null) userText.setText(std.getUsername());
        if (fullnameText != null) fullnameText.setText(std.getFullname());
        if (ageText != null) ageText.setText(String.valueOf(std.getAge()));
        if (std.getGender().equals("Male")) {
            male.setSelected(true);
        } else if (std.getGender().equals("Female")) {
            female.setSelected(true);
        } else if (std.getGender().equals("Others")) {
            others.setSelected(true);
        }
        if (facultySelect != null) facultySelect.setSelectedItem(std.getFaculty());
        if (addressText != null) addressText.setText(std.getAddress());
        if (dobText != null) dobText.setText(std.getDob());
        student = std;
    }

    public void updateTheNewValues(students std) {
        std.setUsername(userText.getText());
        std.setFullname(fullnameText.getText());
        std.setAge(Integer.parseInt(ageText.getText()));
        std.setGender(genderValue);
        std.setFaculty(selectedFaculty);
        std.setSection(sectionValue);
        std.setAddress(addressText.getText());
        std.setDob(dobText.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            updateTheNewValues(student);
            boolean result = updateStudent.updateData(studentId, student);
            if (result) {
                messageDisplay.showMessageDialog(null, "Data Updated Successfully!", "Update Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                messageDisplay.showMessageDialog(null, "Failed to Update Data", "Update Status", JOptionPane.ERROR_MESSAGE);
            }
            frame.dispose();
        }
    }
}
