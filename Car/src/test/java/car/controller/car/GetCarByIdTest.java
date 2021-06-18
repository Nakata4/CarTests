package car.controller.car;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

@RunWith(Parameterized.class)
public class GetCarByIdTest {
	@Parameters(name = "{index}: with id={0} and expected result={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				 {0, null}, //1
				 {1, new CarBean(1,"Cars",2000)}, //2
				 {2, null},//3
				 {3, null}//4
		});
	}
	@Parameter(0)
	public int id;
	@Parameter(1)
	public CarBean car;
	private CarController carController; 
	private CarRepo carRepo;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@Before
	public void setup() {
		carRepo = mock(CarRepo.class);
		CarBean car = new CarBean();
		car.setId(1);
		car.setName("Automatic");
		car.setRecomendedCSpeed(2000);
		if(id==1) {
		doReturn(Optional.of(car).when(carRepo).findById(id);
		}
		else {
		doReturn(Optional.empty()).whencarRepo).findById(id);
		}
		carController = new CarController(carRepo, null);
	}
	@Test
	public void testGetCarById() {
		final CarBean result = carController.getCarById(id);
		if(result!=null) {
		collector.checkThat(result.getId(),IsEqual.equalTo(id));
		collector.checkThat(result.getName(),IsEqual.equalTo(car.getName()));
		collector.checkThat(result.getRecomendedSpeed(),IsEqual.equalTo(car.getRecomendedSpeed()));
		}
		else {
			collector.checkThat(result,IsEqual.equalTo(car));
		}
	}
}
