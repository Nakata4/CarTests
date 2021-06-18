package entities;

public class EngineType {
    private int id;
    private String type;

    public EngineType() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return "EngineType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
