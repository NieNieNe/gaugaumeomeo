package model;
import java.util.Date;

public class Staff {
    private String staffId;
    private String name;
    private String position;
    private Store store;

    // Constructors
    public Staff() {}

    public Staff(String staffId, String name, String position, Store store) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
        this.store = store;
    }

    // Getters and Setters
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

public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}