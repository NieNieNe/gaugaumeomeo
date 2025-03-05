package model;

public class Pet {
    private String petId;
    private String petName;
    private String petType;
    private int petAge;
    private float weight;
    private float length;
    private float height;
    private Client client;

    // Constructors
    public Pet() {}

    public Pet(String petId, String petName, String petType, int petAge, float weight, float length, float height, Client client) {
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
        this.petAge = petAge;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.client = client;
    }

    // Getters and Setters
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

