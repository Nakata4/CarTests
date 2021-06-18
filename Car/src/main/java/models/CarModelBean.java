package models;

public class CarModelBean {

    private Integer markId;
    private String model;
    private Integer typeId;
    private Integer gearBoxId;
    private int year;
    private String info;
    private int price;
    private int doors;
    private int mileage;
    private String color;

    public void init(){
        markId = null;
        model = "";
        typeId = null;
        gearBoxId = null;
        year = 0;
        info = "";
        price = 0;
        doors = 0;
        mileage = 0;
        color = "";
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGearBoxId() {
        return gearBoxId;
    }

    public void setGearBoxId(Integer gearBoxId) {
        this.gearBoxId = gearBoxId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}

