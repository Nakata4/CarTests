package garage;

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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import beans.GarageBean;
import beans.CarBean;
import beans.UserBean;
import controller.UserController;
import repository.GarageRepository;
import repository.ProductRepository;
import repository.UserRepo;
import security.UserPrincipal;
import services.FridgeService;

@RunWith(Parameterized.class)
public class GetUserGarageTest {
	@Parameters(name = "{index}: with logged on user = {0} and expected result={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ null, null },
				{ new UserBean("username", "password", "email@email.com"),
						new GarageBean(1,2000) }

		});
	}
	@Parameter(0)
	public UserBean loggedUser;
	@Parameter(1)
	public GarageBean expectedResult;
	private GarageRepo garageRepo;
	private ProductRepo productRepo;
	private GarageService garageService;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@Before
	public void setup() {
		garageRepo = mock(GarageRepo.class);
		garageBean fridge = new GarageBean();
		garage.setId(1);
		garage.setTotal(2000);
		
		if(loggedUser!=null) {
		doReturn(Optional.of(garage)).when(garageRepo).findById(1);
		loggedUser.setGarage(garage);
		}
		else {
		doReturn(Optional.of(garage)).when(garageRepo).findById(5);
		}
		garageService= new FridgeService(garageRepo,null,null);
	}
	@Test
	public void testGetUserGarage() {
		final GarageBean result = garageService.getUserGarage(loggedUser);
		if(loggedUser!=null) {
		collector.checkThat(result.getId(), IsEqual.equalTo(expectedResult.getId()));
		collector.checkThat(result.getTotal(), IsEqual.equalTo(expectedResult.getTotal()));
		}
		else {
		collector.checkThat(result, IsEqual.equalTo(expectedResult));
		}
		
}
}
