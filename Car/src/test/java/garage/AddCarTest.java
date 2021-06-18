package garage;

	import static org.mockito.Mockito.doReturn;
	import static org.mockito.Mockito.mock;

	import java.util.ArrayList;
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
	import org.springframework.beans.factory.annotation.Autowired;

	
	import beans.GarageBean;
    import beans.ProductBean;
    import beans.CarBean;
	import beans.UserBean;
	import controller.UserController;
	import repository.GarageRepository;
	import repository.ProductRepository;
	import repository.UserRepo;
	import security.UserPrincipal;
	import services.GarageService;

	@RunWith(Parameterized.class)
	public class AddCarTest { 
		@Parameters(name = "{index}: with product_id = {0}, user_id= {1} and expected result={2}")
		public static Iterable<Object[]> data() {
			return Arrays.asList(new Object[][] { //
					{ 1, 1,true },
					
					

			});
		}
		@Parameter(0)
		public int product_id;
		@Parameter(1)
		public int user_id;
		@Parameter(2)
		public boolean exptectedResult;
		private ProductRepository productRepo;
		private GarageService garageService;
		private UserRepo userRepo;
		@Rule
		public ErrorCollector collector = new ErrorCollector();
		@Before
		public void setup() {
			productRepo = mock(ProductRepository.class);
			GarageBean garage = new GarageBean();
			garage.setId(1);
			garage.setTotalSpeed(2000);
			garage.setProducts(new HashSet<ProductBean>());
			userRepo = mock(UserRepo.class);
			UserBean user = new UserBean();
			user.setId(user_id);
			user.setgarage(garage);
			doReturn(user).when(userRepo).getOne(user_id);
			productRepo = mock(ProductRepo.class);
			ProductBean product = new ProductBean();
			product.setId(1);
			product.setSpeed(100);
			product.setName("Name");
			doReturn(Optional.of(product)).when(productRepo).findById(product_id);
			garageService= new GarageService(null,productRepo,userRepo);
		}
		@Test
		public void testAddProduct() {
			final boolean result = garageService.addProduct(product_id, user_id);
			
			collector.checkThat(result, IsEqual.equalTo(exptectedResult));
			
		
			
	}
		
	

}
