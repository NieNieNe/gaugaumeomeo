package model;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String phonenumber;
    private String dateofBirth;
    private String petsCount;
    private String appointment_date;
    private String appointment_time;
    private String service;
    private String petType;
    private String email;

    public User() {

    }
    public User(String username, String password, String fullname, String phonenumber, String dateofBirth, String petsCount, String appointment_date, String appointment_time, String service, String petType) {
        this.username = username;
        this.dateofBirth = dateofBirth;
        this.password = password;
        this.fullname = fullname;
        this.petsCount = petsCount;
        this.phonenumber = phonenumber;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.service = service;
        this.petType = petType;

    }
public int getId() {
        return id;
}
public void setId(int id) {
        this.id = id;
}
public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
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

