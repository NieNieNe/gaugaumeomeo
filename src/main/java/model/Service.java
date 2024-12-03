package model;

public class Service {
    private long id;
    private String nameService;
    private double price;
    private String describe;
    private String executionTime;

    // Getters và Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nameService='" + nameService + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                ", executionTime='" + executionTime + '\'' +
                '}';
    }
}


