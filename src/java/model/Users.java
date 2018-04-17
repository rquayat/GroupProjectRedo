package model;

public class Users {
    
    private String email;
    private String firstName;
    private String lastName;
    private String passwd;
    private String role;

    public Users() {
        this.email = "";
        this.firstName = "";
        this.lastName = "";
        this.passwd = "";
        this.role = "";
    }

    public Users(String email, String firstName, String lastName, String passwd, String role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", passwd=" + passwd + ", role=" + role + '}';
    }
 
}
