package model;
import java.sql.Time;
import java.util.Date;

public class Appointment {
    private long idAppoint;
    private Client client;
    private String appointment;
    private Date date;
    private Service service;
    private String petType;
    private Date appointmentDate;
    private Time appointmentTime;
    private String services;

    // Getters và Setters
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

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
