package controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

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
import controller.CarController;
import repository.CarRepository;

@RunWith(Parameterized.class)
public class GetCarByIdTest {
	@Parameters(name = "{index}: with id={0} and expected result={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				 {0, null}, //1
				 {1, new CarBean(1,"Automatic",2000)}, //2
				 {2, null},//3
				 {3, null}//4
		});
	}
	@Parameter(0)
	public int id;
	@Parameter(1)
	public CarBean Car;
	private CarController CarController; 
	private CarRepo CarRepo;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@Before
	public void setup() {
		CarRepo = mock(CarRepo.class);
		CarBean Car = new CarBean();
		Car.setId(1);
		Car.setName("Automatic");
		Car.setRecomendedCalories(2000);
		if(id==1) {
		doReturn(Optional.of(Car)).when(CarRepo).findById(id);
		}
		else {
		doReturn(Optional.empty()).when(CarRepo).findById(id);
		}
		CarController = new CarController(CarRepo, null);
	}
	@Test
	public void testGetCarById() {
		final CarBean result = CarController.getCarById(id);
		if(result!=null) {
		collector.checkThat(result.getId(),IsEqual.equalTo(id));
		collector.checkThat(result.getName(),IsEqual.equalTo(Car.getName()));
		collector.checkThat(result.getRecomendedCalories(),IsEqual.equalTo(Car.getRecomendedCalories()));
		}
		else {
			collector.checkThat(result,IsEqual.equalTo(Car));
		}
	}
}
