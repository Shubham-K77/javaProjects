package systemUI;

public class students {

    //Db Columns
    private int id;
    private String username, password;
    private String fullname;
    private int age;
    private String gender;
    private String role;
    private String faculty, section;
    private String address;
    private String dob;

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {this.password = password;}
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void setRole(String role){this.role = role;}
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword(){return password;}
    public String getFullname() {
        return fullname;
    }
    public String getAddress() {
        return address;
    }
    public int getAge() {
        return age;
    }
    public String getRole(){return role;}
    public String getSection() {
        return section;
    }

    public String getGender() {
        return gender;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getDob() {
        return dob;
    }
}
