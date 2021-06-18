package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import beans.CarBean;
import beans.UserBean;
import repository.CarRepository;
import repository.GarageRepo;
import repository.CarRepository;
import repository.UserRepo;
import security.WebSecurityConfig;

@Service
public class UserService {
	@Autowired
	private static PasswordEncoder passwordEncoder;
	@Autowired
	private static UserRepo userRepo;
	@Autowired
	private static WebSecurityConfig webSecurityConfig;
	@Autowired
	private static List<UserBean> foundUsers;
	@Autowired
	private static CarRepo carRepo;
	@Autowired
	private static CarRepo CarRepo;
	@Autowired
	private static garageRepo garageRepo;
	
	public UserService (UserRepo userRepo, WebSecurityConfig webSecurityConfig, CarRepo carRepo, CarRepo CarRepo,
			PasswordEncoder passwordEncoder,garageRepo garageRepo) {
		this.userRepo = userRepo;
		this.webSecurityConfig = webSecurityConfig;
		this.roleRepo = roleRepo;
		this.CarRepo = CarRepo;
		this.passwordEncoder = passwordEncoder;
		this.garageRepo = garageRepo;
	}
	public static ResponseEntity<List<UserBean>> getUserBySearchString(String query) {
		List<UserBean> allUsers = userRepo.findAll();
		for (UserBean user : allUsers) {
		}

		List<UserBean> result = new ArrayList<UserBean>();
		for(UserBean user : allUsers) {
			if(user.getUsername().toLowerCase().contains(query.toLowerCase())) {
				result.add(user);
				System.out.println("Result User:");
				
				System.out.println(user.getUsername());
				
			}
		}
		if(result.size()>0) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	

}
