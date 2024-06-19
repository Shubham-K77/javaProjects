package Objects;
public class userObject {
    private String username, password, fullname;
    public userObject(String username, String password, String fullname){
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFullname() {
        return fullname;
    }
}
