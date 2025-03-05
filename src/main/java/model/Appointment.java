package model;

public class Appointment {
    private String idAppoint;
    private String userName;
    private String sdt;
    private String email;
    private String pet;
    private String date;
    private String time;
    private Service service;

    public Appointment(String userName, String sdt, String email, String pet, String date, String time, Service service) {
        this.userName = userName;
        this.sdt = sdt;
        this.email = email;
        this.pet = pet;
        this.date = date;
        this.time = time;
        this.service = service;
    }

    public Appointment() {

    }

    public String getIdAppoint() {
        return idAppoint;
    }

    public void setIdAppoint(String id) {
        this.idAppoint = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}



