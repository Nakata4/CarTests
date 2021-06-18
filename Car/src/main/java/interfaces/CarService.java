package interfaces;

import entities.Car;
import entities.Mark;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByParams(String mark, String type, String engineType, int stYear, int endYear, int stPrice, int endPrice, int stMileage, int endMileage);

    void saveCar(Car car);

    void deleteCar(Car car);

    void updateCar(Car car);
}