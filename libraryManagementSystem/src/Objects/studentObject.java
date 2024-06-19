package Objects;
public class studentObject {
    private String firstName, lastName, gender, program, section;
    //Setters & Getters

    public studentObject(String firstName, String lastName, String gender, String program, String section){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.program = program;
        this.section = section;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public String getProgram(){
        return program;
    }
    public String getSection() {
        return section;
    }
}
