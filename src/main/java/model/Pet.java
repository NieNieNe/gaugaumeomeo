package model;

public class Pet {
    private String id;
    private String petName;
    private String petType;
    private int petAge;
    private int weight;
    private int length;
    private int height;

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void getPet() {
        // Logic lấy thông tin thú cưng
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", petName='" + petName + '\'' +
                ", petType='" + petType + '\'' +
                ", petAge=" + petAge +
                ", weight=" + weight +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
