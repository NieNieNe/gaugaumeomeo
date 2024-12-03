package model;
import java.util.Collection;
import java.util.Date;

public class Store {
    private String storeId;
    private String name;
    private String address;
    private long revenue;

    // Getters và Setters
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

    // Phương thức
    public void getStoreInfo() {
        System.out.println("Store Info: " + this.toString());
    }

    public Collection<Appointment> getAllAppointments() {
        // Logic xử lý (ví dụ lấy từ database)
        return null;
    }

    public Appointment getAppointment(long id) {
        // Logic xử lý (ví dụ lấy từ database)
        return null;
    }

    public void saveClient(Client client) {
        // Logic xử lý
    }

    public void saveBooking(Booking booking) {
        // Logic xử lý
    }

    public long calculateRevenue() {
        // Logic xử lý
        return 0;
    }

    public void manageStaff() {
        // Logic xử lý
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}