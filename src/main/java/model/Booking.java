package model;

import java.util.Date;

public class Booking {
    private long id;
    private Appointment appointment;
    private Date date;

    // Getters và Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Phương thức
    public void addAppointment() {
        // Logic thêm booking
    }

    public void removeAppointment() {
        // Logic xóa booking
    }

    public void updateAppointment() {
        // Logic cập nhật booking
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", date=" + date +
                '}';
    }
}

