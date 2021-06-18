package beans;

import entities.Car;
import entities.Mark;
import interfaces.CarService;
import java.util.List;


public class CarSearchBean{
    private CarService carService;

    private String mark;
    private String type;
    private String engineType;
    private int stYear;
    private int endYear;
    private int stPrice;
    private int endPrice;
    private int stMileage;
    private int endMileage;
    private List<Car> findCarsByParams;

    public void init(){
        mark = "";
        type = "";
        engineType = "";
        stYear = 1960;
        endYear = 2016;
        stPrice = 0;
        endPrice = 100000;
        stMileage = 0;
        endMileage = 500000;
    }

    public String findCars(){
        findCarsByParams = carService.getCarsByParams(mark, type, engineType, stYear, endYear, stPrice, endPrice, stMileage, endMileage);
        init();
        return "find-cars?faces-redirect=true";
    }

    public String findCarsAdmin(){
        findCarsByParams = carService.getCarsByParams(mark, type, engineType, stYear, endYear, stPrice, endPrice, stMileage, endMileage);
        init();
        return "admin-find-cars?faces-redirect=true";
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStYear() {
        return stYear;
    }
    public void setStYear(int stYear) {
        this.stYear = stYear;
    }
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    public int getStPrice() {
        return stPrice;
    }
    public void setStPrice(int stPrice) {
        this.stPrice = stPrice;
    }
    public int getEndPrice() {
        return endPrice;
    }
    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }
    public String getEngineType() {
        return engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public int getStMileage() {
        return stMileage;
    }
    public void setStMileage(int stMileage) {
        this.stMileage = stMileage;
    }
    public int getEndMileage() {
        return endMileage;
    }
    public void setEndMileage(int endMileage) {
        this.endMileage = endMileage;
    }
    public List<Car> getFindCarsByParams() {
        return findCarsByParams;
    }
    public void setFindCarsByParams(List<Car> findCarsByParams) {
        this.findCarsByParams = findCarsByParams;
    }
}

