package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.CategoryBean;
import beans.CarBean;
import beans.ProductBean;
import beans.UserBean;
import repository.CarRepository;
import repository.UserRepo;
import security.UserPrincipal;
import services.CategoryService;
import services.Carservice;

@RestController
public class CarController {
	@Autowired
	private CarRepo CarRepo;
	private UserRepo userRepo;

	public CarController(CarRepo CarRepo, UserRepo userRepo) {
		this.CarRepo = CarRepo;
		this.userRepo = userRepo;
	}

	@GetMapping(path = "/Car/all")
	public List<CarBean> getAllCars() {
		return CarRepo.findAll();
	}
	@GetMapping(path = "/Car/initial")
	public ResponseEntity<List<CarBean>> getAllCarsInitially() {
		return Carservice.getAllCars();
	}

	@GetMapping(path = "/Car/{id}")
	public CarBean getCarById(@PathVariable int id) {
		Optional<CarBean> Car = CarRepo.findById(id);
		if (Car.isPresent()) {
			return Car.get();
		} else {
			return null;
		}


	}
	@GetMapping(path = "/Car")
	public ResponseEntity<List<CarBean>> retrieveAllCars(@AuthenticationPrincipal UserPrincipal principal) {
		UserBean user = principal.getLoggedInUser();
		if (user != null) {
			return Carservice.getAllCars();
		} else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}

	}
	@PostMapping(path = "/Car")
	public ResponseEntity<CarBean> createCar(@AuthenticationPrincipal UserPrincipal principal, @RequestParam (value="name")String name,@RequestParam(value="recCalories") String recCalories,@RequestParam (value="categoryIds")List<String> categoryIds) {
		UserBean user = principal.getLoggedInUser();
		if (user != null) {
			for(String id : categoryIds) {
				System.out.println(id);
			}
			return Carservice.createCar(name, recCalories, categoryIds);
		} else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}

	}
	@PutMapping(path = "/Car/{id}")
	public ResponseEntity<CarBean> updateCar(@AuthenticationPrincipal UserPrincipal principal, @RequestParam (value="name")String name,@RequestParam(value="recCalories") String recCalories, @RequestParam (value="categoryIds")List<String> categoryIds,@PathVariable String id) {
		UserBean user = principal.getLoggedInUser();
		if (user != null) {
			return Carservice.updateCar(id,name, recCalories, categoryIds);
		} else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}

	}
	@DeleteMapping(path = "/Car/{id}")
	public ResponseEntity<Boolean> deleteCar(@AuthenticationPrincipal UserPrincipal principal,@PathVariable String id){
		UserBean user = principal.getLoggedInUser();
		if (user != null) {
			return Carservice.deleteCar(id);
		} else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}

	}
	@PostMapping(path = "/Car/search")
	public ResponseEntity<List<CarBean>> searchCars(@AuthenticationPrincipal UserPrincipal principal,@RequestParam (value="searchTerm")String query) {
			UserBean user = principal.getLoggedInUser();
			if (user != null) {
				if(query!=null) {
					ResponseEntity<List<CarBean>> response = Carservice.getCarBySearchString(query.trim());
					return response;
				}
				else {
					return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
			}
		}

}

