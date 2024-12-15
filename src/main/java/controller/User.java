package controller;



import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String fullname;
    private String phonenumber;
    private String dateofBirth;
    private String petsCount;


    public User() {

    }
    public User(String username, String password, String fullname, String phonenumber, String dateofBirth, String petsCount) {
        this.username = username;
        this.dateofBirth = dateofBirth;
        this.password = password;
        this.fullname = fullname;
        this.petsCount = petsCount;
        this.phonenumber = phonenumber;
    }

    public String getPetsCount() {
        return petsCount;
    }

    public void setPetsCount(String petsCount) {
        this.petsCount = petsCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}

