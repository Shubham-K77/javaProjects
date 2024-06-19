package systemUI;
import dbOperations.insertStudent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class signupPage implements ActionListener {
    JFrame frame;
    JLabel username, password, fullname, age, gender, faculties, section, address, dob;
    JTextField userText, fullnameText, ageText, addressText, dobText;
    JPasswordField  passwordText;
    JRadioButton male, female, others;
    JPanel genderButtons;
    JOptionPane messageDisplay;
    ButtonGroup genderSelect;
    JComboBox<String> facultySelect;
    JComboBox<String> sectionSelect;
    ImageIcon logo;
    JButton signup, reset;
    Font myfont;
    students std;
    String selectedFaculty, sectionValue;
    String genderValue = "";

    signupPage() {
        messageDisplay = new JOptionPane(); //Initialize The JOptionPane
        frame = new JFrame("Signup Page!");
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

        password = new JLabel("Password: ");
        password.setBackground(new Color(0x860b09));
        password.setForeground(Color.WHITE);
        password.setFont(myfont);

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
        passwordText = new JPasswordField();
        passwordText.setFont(myfont);
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
                    } else {
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

        signup = new JButton("Signup");
        signup.setFont(myfont);
        signup.setForeground(new Color(0x860b09));
        signup.setBackground(Color.WHITE);

        reset = new JButton("Reset");
        reset.setFont(myfont);
        reset.setForeground(new Color(0x860b09));
        reset.setBackground(Color.WHITE);

        signup.addActionListener(this);
        reset.addActionListener(this);

        username.setBounds(50, 20, 200, 50);
        userText.setBounds(200, 20, 200, 50);
        password.setBounds(50, 100, 200, 50);
        passwordText.setBounds(200,100, 200, 50);
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
        signup.setBounds(30, 720, 200, 50);
        reset.setBounds(260, 720, 200, 50);

        frame.add(username);
        frame.add(userText);
        frame.add(password);
        frame.add(passwordText);
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
        frame.add(signup);
        frame.add(reset);
        frame.setVisible(true);
    }

    public void resetToDefaults(){
        userText.setText("");
        fullnameText.setText("");
        ageText.setText("");
        addressText.setText("");
        dobText.setText("");
        genderSelect.clearSelection();
        facultySelect.setSelectedIndex(0);
        sectionSelect.setSelectedIndex(-1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            std = new students(); // Initialize the instance variable
            std.setUsername(userText.getText());
            std.setPassword(passwordText.getText());
            std.setFullname(fullnameText.getText());
            std.setAge(Integer.parseInt(ageText.getText()));
            std.setGender(genderValue);
            std.setFaculty(selectedFaculty);
            std.setSection(sectionValue);
            std.setAddress(addressText.getText());
            std.setDob(dobText.getText());
            String message = std.getUsername() + " " + std.getPassword() + " " +  std.getFullname() + " " + std.getAge()
                    + " " + std.getGender() + " " + std.getFaculty() + " " + std.getSection()+ " "
                    + std.getAddress() + " " + std.getDob();
             Boolean ans = insertStudent.insertToDB(std);
             if(ans == true){
                 messageDisplay.showMessageDialog(frame, message, "Success Message", JOptionPane.INFORMATION_MESSAGE);
             } else{
                 messageDisplay.showMessageDialog(frame, "Signup Failed!", "Failure Message", JOptionPane.WARNING_MESSAGE);
             }
            resetToDefaults();
            frame.dispose();
        } else {
            resetToDefaults();
            messageDisplay.showMessageDialog(frame, "Reset To Defaults!", "Reset Message", JOptionPane.WARNING_MESSAGE);
        }
    }
}
