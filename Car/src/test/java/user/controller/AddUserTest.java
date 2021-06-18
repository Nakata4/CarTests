package user.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import beans.GarageBean;
import beans.CarBean;
import beans.UserBean;
import controller.UserController;
import repository.CarRepository;
import repository.UserRepo;
import security.UserPrincipal;

@RunWith(Parameterized.class)
public class AddUserTest {
	@Parameters(name = "{index}: with email = {0}, username = {1}, password = {2}, repeatPassword = {3}, carId = {4}, loggedUser = {5}, role= {6} and expected result={7}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ null, null, null, null, null, null, null, "Input parameters cant be null!" },
				{ "email5@mail.com", "username5", "pass", "pass", "0",
						new UserBean("username", "password", "email@email.com"), "CAR_ADMIN",
						"User has been successfully created!" },
				{ "email5@mail.com", "username5", "pass", "pass2", "0",
						new UserBean("username", "password", "email@email.com"), "CAR_ADMIN",
						"Error: Password mismatch!" },
				{ "email2@email.com", "username5", "pass", "pass", "0",
						new UserBean("username", "password", "email@email.com"), "CAR_ADMIN", "Error: Email exists!" },
				{ "email5@mail.com", "name", "pass", "pass", "0",
						new UserBean("username", "password", "email@email.com"), "CAR_ADMIN",
						"Error: Username exists!" },
				{ "email5@mail.com", "name", "pass", "pass", "0",
						new UserBean("username", "password", "email@email.com"), "CAR_USER", "Error: Forbidden!" }, });
	}

	@Parameter(0)
	public String email;
	@Parameter(1)
	public String username;
	@Parameter(2)
	public String password;
	@Parameter(3)
	public String repeatPassword;
	@Parameter(4)
	public String carId;
	@Parameter(5)
	public UserBean loggedUser;
	@Parameter(6)
	public String carCode;
	@Parameter(7)
	public String expectedResult;
	private UserController userController;
	private UserRepository userRepo;
	private UserPrincipal principal;
	private CarRepo carRepo;
	private GarageRepository garageRepo;
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Before
	public void setup() {
		CarBean car = new CarBean();
		car.setCode(carCode);
		car.setId(1);
		Set<CarBean> cars = new HashSet<>(Arrays.asList(car));
		carRepo = mock(CarRepository.class);
		userRepo = mock(UserRepository.class);
		garageRepo = mock(GarageRepository.class);
		GarageBean garage = new GarageBean();
		garage.setId(99);
		 Mockito.when(garageRepo.saveAndFlush(garage)).thenReturn(fridge);
		if (loggedUser != null) {
			loggedUser.setCars(cars);
			principal = new UserPrincipal(loggedUser, cars);
		} else {
			principal = null;
		}
		UserBean user1 = new UserBean();
		user1.setUsername("name");
		user1.setPassword("pass");
		user1.setEmail("email2@email.com");
		UserBean user2 = new UserBean();

		user2.setUsername("name2");
		user2.setPassword("pass2");
		user2.setEmail("email3@email.com");
		List<UserBean> users = new ArrayList<UserBean>();
		users.add(user1);
		users.add(user2);
		doReturn(users).when(userRepo).findAll();
		doReturn(car).when(carRepo).findRoleByCode("CAR_USER");
		userController = new UserController(userRepo, null, carRepo, null, encoder,garageRepo);
	}

	@Test
	public void testAddUser() {
		final List<String> result = userController.addUser(email, username, password, repeatPassword, carId,
				principal);
		collector.checkThat(result.get(0), IsEqual.equalTo(expectedResult));

	}


}
