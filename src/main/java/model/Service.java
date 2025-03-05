package model;

public class Service {
    private long id;
    private String nameService;


    // Constructors
    public Service() {}

    public Service(long id, String nameService) {
        this.id = id;
        this.nameService = nameService;

    }

    // Getters and Setters
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


}


