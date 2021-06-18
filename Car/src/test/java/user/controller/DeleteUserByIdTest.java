package user.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import beans.CarBean;
import beans.UserBean;
import controller.UserController;
import repository.CarRepository;
import repository.UserRepo;
import security.UserPrincipal;

@RunWith(Parameterized.class)
public class DeleteUserByIdTest {
	@Parameters(name = "{index}: with user id={0}, logged on user = {1} and expected result={2}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ 0, null, new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED) }, // 1
				{ 0, new UserBean("username", "password", "email@email.com"),
						new ResponseEntity<>(false, HttpStatus.NOT_FOUND) }, // 2
				{ 1, new UserBean("username", "password", "email@email.com"),
						new ResponseEntity<>(true, HttpStatus.OK) }// 3

		});
	}

	@Parameter(0)
	public int id;
	@Parameter(1)
	public UserBean loggedUser;
	@Parameter(2)
	public ResponseEntity<Boolean> expectedResult;
	private UserController userController;
	private UserRepo userRepo;
	private UserPrincipal principal;
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Before
	public void setup() {
		CarBean car = new CarBean();
		car.setCode("CAR_USER");
		car.setId(1);
		Set<CarBean> cars = new HashSet<>(Arrays.asList(car));
		userRepo = mock(UserRepo.class);
		principal = new UserPrincipal(loggedUser, cars);
		UserBean user1 = new UserBean();
		user1.setId(1);
		user1.setUsername("username");
		user1.setPassword("password");
		if (id == 1) {
			doReturn(Optional.of(user1)).when(userRepo).findById(id);
		} else {
			doReturn(Optional.empty()).when(userRepo).findById(id);
		}
		userController = new UserController(userRepo, null, null, null, encoder,null);
	}

	@Test
	public void testDeleteUserById() {
		final ResponseEntity<Boolean> result = userController.deleteUserById(id, principal);
		collector.checkThat(result.getStatusCode(), IsEqual.equalTo(expectedResult.getStatusCode()));
		collector.checkThat(result.getBody(), IsEqual.equalTo(expectedResult.getBody()));

	}

}
