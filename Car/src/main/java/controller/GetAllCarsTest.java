package controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import beans.CarBean;
import controller.CarController;
import repository.CarRepository;

public class GetAllCarsTest {
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
		car.setRecomendedSpeed(2000);
		CarBean car2 = new CarBean();
		car2.setId(2);
		car2.setName("Electric");
		car2.setRecomendedSpeed(2500);	
		List<CarBean> cars = new ArrayList<CarBean>();
		cars.add(car);
		cars.add(car2);
		doReturn(cars).when(carRepo).findAll();
		carController = new CarController(carRepo, null);
	}
	@Test
	public void testGetCarById() {
		final List<CarBean> result = carController.getAllCars();
		collector.checkThat(result.size(),IsEqual.equalTo(2));
		collector.checkThat(result.get(0).getName(),IsEqual.equalTo("Automatic"));
		collector.checkThat(result.get(0).getId(),IsEqual.equalTo(1));
		collector.checkThat(result.get(0).getRecomendedCalories(),IsEqual.equalTo(2000.0));
		collector.checkThat(result.get(1).getName(),IsEqual.equalTo("Electric"));
		collector.checkThat(result.get(1).getId(),IsEqual.equalTo(2));
		collector.checkThat(result.get(1).getRecomendedCalories(),IsEqual.equalTo(2500.0));
		

	
	}

}
