package model;
import java.util.Date;

public class Appointment {
    private long idAppoint;
    private Client client;
    private String appointment;
    private Date date;
    private Service service;

    // Getters và Setters


    public long getIdAppoint() {
        return idAppoint;
    }

    public void setIdAppoint(long idAppoint) {
        this.idAppoint = idAppoint;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    // Phương thức
    public void addAppointment() {
        // Logic thêm lịch hẹn
    }

    public void removeAppointment() {
        // Logic xóa lịch hẹn
    }

    public void updateAppointment() {
        // Logic cập nhật lịch hẹn
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idAppoint=" + idAppoint +
                ", appointment='" + appointment + '\'' +
                ", date=" + date +
                ", service=" + service +
                '}';
    }
}
