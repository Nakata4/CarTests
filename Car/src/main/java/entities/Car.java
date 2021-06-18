package entities;

import java.util.ArrayList;
import java.util.List;


public class Car  {
    private int id;
    private int price;
    private int year;
    private String information;
    private String model;
    private int doors;
    private int mileage;
    private String color;
    private Mark markTable;
    private Type typeTable;
    private Engine engineTable;
    private Options options;

    public Car() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getDoors() {
        return doors;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Mark getMarkTable() {
        return markTable;
    }
    public void setMarkTable(Mark markTable) {
        this.markTable = markTable;
    }
    public Type getTypeTable() {
        return typeTable;
    }
    public void setTypeTable(Type typeTable) {
        this.typeTable = typeTable;
    }
    public Engine getEngineTable() {
        return engineTable;
    }
    public void setEngineTable(Engine engineTable) {
        this.engineTable = engineTable;
    }
    public Options getOptions() {
        return options;
    }
    public void setOptions(Options options) {
        this.options = options;
    }
    private List<Photo> photos = new ArrayList<Photo>();

    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                ", year=" + year +
                ", information='" + information + '\'' +
                ", markTable=" + markTable +
                ", typeTable=" + typeTable +
                ", engineTable=" + engineTable +
                '}';
    }
}
