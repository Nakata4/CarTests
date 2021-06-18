package beans;

import models.CarModelBean;
import models.EngineModelBean;
import models.OptionsBean;
import entities.*;
import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class NewCarBean {

    private MarkService markService;
    private TypeService typeService;
    private CarService carService;
    private EngineService engineService;
    private EngineTypeService engineTypeService;
    private PhotoService photoService;
    private OptionsService optionsService;
    
    MarkBean markBean;
    EngineModelBean engineModelBean;
    CarModelBean carModelBean;
    OptionsBean optionsBean;
    CarBean carBean;
    PhotoBean photoBean;

    public String saveCar() {
        Car car = new Car();
        car.setMarkTable(markService.getMarkById(carModelBean.getMarkId()));
        car.setModel(carModelBean.getModel());
        car.setMileage(carModelBean.getMileage());
        car.setTypeTable(typeService.getTypeById(carModelBean.getTypeId()));
        car.setDoors(carModelBean.getDoors());
        car.setYear(carModelBean.getYear());
        car.setColor(carModelBean.getColor());
        car.setInformation(carModelBean.getInfo());
        car.setPrice(carModelBean.getPrice());

        Engine engine = new Engine();
        engine.setEngineType(engineTypeService.getEngineTypeById(engineModelBean.getEngineTypeId()));
        engine.setVolume(engineModelBean.getVolume());
        engine.setHp(engineModelBean.getHp());
        engine.setNm(engineModelBean.getNm());
        engineService.saveEngine(engine);
        car.setEngineTable(engine);

        Options options = new Options();
        options.setConditioner(optionsBean.getConditioner());
        options.setLeather(optionsBean.getLeather());
        options.setAlloyWheels(optionsBean.getAlloyWheels());
        options.setFogLights(optionsBean.getFogLights());
        options.setSignaling(optionsBean.getSignaling());
        optionsService.saveOptions(options);
        car.setOptions(options);

        carService.saveCar(car);

        if(photoBean.savePhotosToSystem())
            for(Photo photo : photoBean.getPhotos()) {
                photo.setCar(car);
                photoService.savePhoto(photo);
                car.addPhoto(photo);
            }
        photoBean.getPhotos().clear();
        carBean.getAllCars().add(car);
        return "admin-index";
    }
    public List<Integer> getYears(){
        List<Integer> years = new ArrayList<Integer>();
        for (int i = 2016; i >= 1960; i--)
            years.add(i);
        return years;
    }

    public List<Integer> getDoorsCount(){
        List<Integer> doorsCount = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++)
            doorsCount.add(i);
        return doorsCount;
    }
}
