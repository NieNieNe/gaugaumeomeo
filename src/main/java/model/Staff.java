package model;
import java.util.Date;

public class Staff {
    private String staffId;
    private String name;
    private String position;
    private Date schedule;

    // Getters và Setters
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    // Phương thức
    public boolean authenticAppointment() {
        // Logic xác thực lịch hẹn
        return true;
    }

    public void viewSchedule() {
        // Logic xem lịch làm việc
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
