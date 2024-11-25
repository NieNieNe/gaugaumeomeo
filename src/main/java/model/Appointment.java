package model;

public class Appointment {
    private String name;
    private String phone;
    private String date;
    private String time;
    private String service;

    public Appointment(String name, String phone, String date, String time, String service) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.service = service;
    }

    // Getters và setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
}
