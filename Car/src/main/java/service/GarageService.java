package service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.GarageBean;
import beans.ProductBean;
import beans.UserBean;
import repository.GarageRepository;
import repository.ProductRepository;
import repository.UserRepo;
@Service
public class GarageService {
	@Autowired
	private  static GarageRepository garageRepo;
	@Autowired
	private  static ProductRepository productRepo;
	@Autowired
	private  static UserRepo userRepo;
	public GarageService (GarageRepository garageRepo,ProductRepository productRepo, UserRepo userRepo) {
		this.garageRepo = garageRepo;
		this.productRepo = productRepo;
		this.userRepo = userRepo;
	}
public  static GarageBean getUserGarage(UserBean user) {
	if(user!=null) {
	int id = user.getGarage().getId();
	Optional<GarageBean> garage = garageRepo.findById(id);
	return garage.get();
	}
	return null;
}	

public static boolean addProduct(int product_id, int user_id) {
	UserBean user = userRepo.getOne(user_id);
	GarageBean userGarage = user.getGarage();
	Optional<ProductBean> product = productRepo.findById(product_id);
	if(product.isPresent()) {
		Set<ProductBean> products = userGarage.getProducts();
		boolean result = products.add(product.get());
		userGarage.setProducts(products);
		user.setGarage(userGarage);
		userRepo.saveAndFlush(user);
		return result;
	}
	return false;
}
public static boolean removeProduct(int product_id, int user_id) {
	UserBean user = userRepo.getOne(user_id);
	GarageBean userGarage = user.getGarage();
	Optional<ProductBean> product = productRepo.findById(product_id);
	if(product.isPresent()) {
		Set<ProductBean> products = userGarage.getProducts();
		boolean result = products.remove(product.get());
		userGarage.setProducts(products);
		user.setGarage(userGarage);
		userRepo.saveAndFlush(user);
		return result;
	}
	return false;
}
}
