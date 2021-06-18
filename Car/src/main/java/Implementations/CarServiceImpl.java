package Implementations;

import entities.Car;
import repository.CarRepository;
import interfaces.CarService;
import java.util.List;

public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public List<Car> getCarsByParams(String mark, String type, String engineType, int stYear, int endYear,
                                     int stPrice, int endPrice, int stMileage, int endMileage){
        return carRepository.getCarsByParams(mark, type, engineType, stYear, endYear, stPrice, endPrice, stMileage, endMileage);
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public void deleteCar(Car car){
        carRepository.delete(car);
    }

    public void updateCar(Car car) {
        carRepository.updateCarById(car.getModel(), car.getMileage(), car.getTypeTable(),
                car.getId(), car.getDoors(), car.getYear(), car.getInformation(), car.getPrice());
    }
}
