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

import beans.CarBean;
import beans.UserBean;
import controller.UserController;
import repository.UserRepo;
import security.UserPrincipal;

@RunWith(Parameterized.class)
public class GetCurrentUserTest {
	@Parameters(name = "{index}: with loggedUser = {0} and expected result={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ null,null},
				{ new UserBean("username","password","email@email.com"),new UserBean("username","password","email@email.com")},
		 });
	}
	@Parameter(0)
	public UserBean loggedUser;
	@Parameter(1)
	public UserBean expectedResult;
	private UserController userController;
	private UserRepo userRepo;
	private UserPrincipal principal;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@Before
	public void setup() {
		CarBean role = new CarBean();
		role.setCode("ROLE_USER");
		role.setId(1);
		Set<CarBean> cars = new HashSet<>(Arrays.asList(role));
		userRepo = mock(UserRepo.class);
		if (loggedUser != null) {
			loggedUser.setCars(cars);
			principal = new UserPrincipal(loggedUser, cars);
		} else {
			principal = new UserPrincipal(null,cars);
		}

		userController = new UserController(null, null, null, null, null,null);
	}
	@Test
	public void testGetCurrentUser() {
		
		final UserBean result = userController.getUser(principal);
		if (result != null) {
			collector.checkThat(result.getUsername(), IsEqual.equalTo(expectedResult.getUsername()));
			collector.checkThat(result.getPassword(), IsEqual.equalTo(expectedResult.getPassword()));
			collector.checkThat(result.getEmail(), IsEqual.equalTo(expectedResult.getEmail()));
		} else {
			collector.checkThat(result, IsEqual.equalTo(expectedResult));
		}

	}

}
