package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import beans.CategoryBean;
import beans.CarBean;
import repository.CategoryRepository;
import repository.CarRepository;
import utilities.Utilities;
@Service
public class CarService {
@Autowired
private static CarRepo CarRepo;
@Autowired
private static CategoryRepo categoryRepo;
public CarService(CarRepo CarRepo, CategoryRepo categoryRepo) {
	this.CarRepo = CarRepo;
	this.categoryRepo = categoryRepo;
}
public  static ResponseEntity<List<CarBean>> getAllCars(){
	List<CarBean> result = CarRepo.findAll();
	if(result!=null) {
		if(!result.isEmpty()) {
	
		System.out.println("result is null===================");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	else {
		CarBean Car = new CarBean();
		Car.setName("No Car");
		Car.setRecomendedSpeed(2000);
		CarBean resultCar = CarRepo.saveAndFlush(Car);
		if(resultCar!=null) {
		return new ResponseEntity<>(Arrays.asList(resultCar),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
		
	}
	else {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
}
public static ResponseEntity<CarBean> getCarById(String id) {
	if(Utilities.tryParseInt(id)) {
	Optional<CarBean> optionalCar = CarRepo.findById(Integer.parseInt(id));
	if (optionalCar.isPresent()) {
		CarBean Car = optionalCar.get();
		
		return new ResponseEntity<>(Car, HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	}
	else {
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}






	public static ResponseEntity<Boolean> deleteCar(String id) {
		if(Utilities.tryParseInt(id)) {
			Optional<CarBean> optionalCar = CarRepo.findById(Integer.parseInt(id));
			if (optionalCar.isPresent()) {
				CarBean Car = optionalCar.get();
				CarRepo.delete(Car);
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
			}
			}
			else {
				return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
			}
	}

	public static ResponseEntity<CarBean> updateCar(String id, String name, String recSpeed, List<String> categoryIds) {
		if(Utilities.tryParseInt(id) && name!=null && recSpeed !=null && Utilities.tryParseDouble(recSpeed.trim())) {
			int CarId = Integer.parseInt(id);
			double parsedRecSpeed = Double.parseDouble(recSpeed);
			Set<CategoryBean> categories = new HashSet<CategoryBean>();
			Optional<CarBean> optionalCar = CarRepo.findById(CarId);
			CarBean Car = new CarBean();
			if(optionalCar.isPresent()) {
			Car = optionalCar.get();
			}
			
			List<CarBean> foundCars = CarRepo.findAll();
			String formattedName = name.trim().toLowerCase();
			boolean CarNameExists = false;
			if(foundCars!=null) {
				for(CarBean CarBean : foundCars) {
					if(CarBean.getName().toLowerCase().equals(formattedName) &&!(CarBean.getName().equals(Car.getName().toLowerCase()))) {
						CarNameExists = true;
						break;
					}
				}
			}
			if(CarNameExists) {
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}
			else
			{
				
			if(optionalCar.isPresent()) {

			Car.setName(formattedName);
			Car.setRecomendedSpeed(parsedRecSpeed);
			if(categoryIds !=null) {
				for (String categoryId : categoryIds) {
					if(Utilities.tryParseInt(id)) {
						Optional<CategoryBean> optionalCategory = categoryRepo.findById(Integer.parseInt(categoryId));
						if(optionalCategory.isPresent()) {
							CategoryBean foundCategory = optionalCategory.get();
							categories.add(foundCategory);
						}
						
					}
				}
				Car.setCategories(categories);
				
			}
			CarBean result = CarRepo.saveAndFlush(Car);
			if(result != null) {
				return new ResponseEntity<>(result, HttpStatus.OK);
				
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
			else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
	}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	public static ResponseEntity<CarBean> createCar(String name, String recSpeed,List<String> categoryIds) {
		if(name!=null && Utilities.tryParseDouble(recSpeed.trim())) {
			List<CarBean> foundCars = CarRepo.findAll();
			String formattedName = name.trim().toLowerCase();
			double parsedRecSpeed = Double.parseDouble(recSpeed);
			Set<CategoryBean> categories = new HashSet<CategoryBean>();
			boolean CarNameExists = false;
			if(foundCars!=null) {
				for(CarBean Car : foundCars) {
					if(Car.getName().toLowerCase().equals(formattedName)) {
						CarNameExists = true;
					}
				}
			}
			if(CarNameExists) {
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}
			else
			{	
				if(categoryIds !=null) {
					System.out.println("category ids isnt null");
				for (String id : categoryIds) {
					if(Utilities.tryParseInt(id)) {
						Optional<CategoryBean> optionalCategory = categoryRepo.findById(Integer.parseInt(id));
						System.out.println("searching for a category");
						if(optionalCategory.isPresent()) {
							System.out.println("a category has been found");
							CategoryBean foundCategory = optionalCategory.get();
							categories.add(foundCategory);
						}
						
					}
				}
				
			}
				CarBean Car = new CarBean();
				Car.setName(formattedName);
				Car.setRecomendedSpeed(parsedRecSpeed);
				
				Car.setCategories(categories);
				for(CategoryBean category : Car.getCategories()) {
					System.out.println("Category:" + category.getName());
				}
				CarBean result = CarRepo.saveAndFlush(Car);
			if(result != null) {
				return new ResponseEntity<>(result, HttpStatus.CREATED);
				
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			}
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		
	}
	public static ResponseEntity<List<CarBean>> getCarBySearchString(String query) {
		List<CarBean> allCars = CarRepo.findAll();
		for (CarBean Car : allCars) {
		}

		List<CarBean> result = new ArrayList<CarBean>();
		for(CarBean Car : allCars) {
			if(Car.getName().toLowerCase().contains(query.toLowerCase())) {
				result.add(Car);
				System.out.println("Result Car:");
				
				System.out.println(Car.getName());
				
			}
		}
		if(result.size()>0) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
