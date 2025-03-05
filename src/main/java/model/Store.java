package model;
import java.util.Collection;
import java.util.Date;

public class Store {
    private String storeId;
    private String name;
    private String address;
    private long revenue;

    // Constructors
    public Store() {}

    public Store(String storeId, String name, String address, long revenue) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
        this.revenue = revenue;
    }

    // Getters and Setters
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}
