package beans;

import entities.Car;
import entities.Photo;
import interfaces.CarService;
import interfaces.EngineService;
import interfaces.OptionsService;
import interfaces.PhotoService;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class CarBean {

    CarService carService;
    EngineService engineService;
    OptionsService optionsService;
    PhotoService photoService;

    private List<Car> allCars;
    private Car selectedCar;
    private MapModel simpleModel;

    public CarBean(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}
	public CarBean() {
		// TODO Auto-generated constructor stub
	}
	public void init() {
        allCars = carService.getAllCars();
        simpleModel = new DefaultMapModel();
        LatLng coord = new LatLng(53.68479341, 23.83977795);
        simpleModel.addOverlay(new Marker(coord, "Address"));
    }
    public List<Car> getAllCars() {
        return allCars;
    }
    public Car getSelectedCar() {
        return selectedCar;
    }
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    public String getFirstPhoto(Car car) {
        if (car.getPhotos().size() > 0)
            return car.getPhotos().get(0).getPath();
        else
            return "noimage.jpg";
    }
    public String deleteCar() {
        for (Photo photo : selectedCar.getPhotos()) {
            File file = new File("E:\\CarsOnline\\WebContent\\img\\" + photo.getPath());
            if (file.delete())
                System.out.println(photo.getPath() + " delete sucessfull");
            else
                System.out.println("file not found");
        }
        carService.deleteCar(selectedCar);
        engineService.deleteEngine(selectedCar.getEngineTable());
        optionsService.deleteOptions(selectedCar.getOptions());

        allCars.remove(selectedCar);
        selectedCar = null;
        return "admin-index?faces-redirect=true";
    }
    public String updateCar() {
        engineService.updateEngine(selectedCar.getEngineTable());
        optionsService.updateOptions(selectedCar.getOptions());
        carService.updateCar(selectedCar);
        return "admin-index";
    }
    public List<Car> getSortedCars(){
        List<Car> sort = allCars;
        Collections.reverse(sort);
        return sort;
    }
	public void add(CarBean car) {		
	}
	public Object removeUser(UserBean userBean) {
		return null;
	}
	public void setCode(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
}

