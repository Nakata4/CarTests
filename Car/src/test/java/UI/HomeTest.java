package UI;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomeTest {
	WebDriver driver;
	LogInWebPageModel loginModel;
	HomeWebPageModel homeModel;
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}
	@Before
	public void setup() {
		driver = new ChromeDriver();
		loginModel = new LogInWebPageModel(driver);
		homeModel = new HomeWebPageModel(driver);
		loginModel.navigateToMain();
		loginModel.sendKeysToElement("garage", loginModel.getUsernameField());
		loginModel.sendKeysToElement("12345", loginModel.getPasswordField());
		loginModel.clickOnElement(loginModel.getLoginBtn());
	}
	@Test
	public void viewBMWPage() {
		String expectedUrl = "http://localhost:8080/catalog.html";
		String expectedHeadingText="BMW";
		WebElement moreBtn = homeModel.getMoreButton(homeModel.getBMW());
		homeModel.clickOnElement(moreBtn);
		collector.checkThat(driver.getCurrentUrl(),IsEqual.equalToObject(expectedUrl));
		WebElement heading = driver.findElement(By.id("heading"));
		collector.checkThat(heading.getText(),IsEqual.equalToObject(expectedHeadingText));
	}
	@Test
	public void viewAudiPage() {
		String expectedUrl = "http://localhost:8080/catalog.html";
		String expectedHeadingText="Audi";
		WebElement moreBtn = homeModel.getMoreButton(homeModel.getAudi());
		homeModel.clickOnElement(moreBtn);
		collector.checkThat(driver.getCurrentUrl(),IsEqual.equalToObject(expectedUrl));
		WebElement heading = driver.findElement(By.id("heading"));
		collector.checkThat(heading.getText(),IsEqual.equalToObject(expectedHeadingText));
	}
	@Test
	public void viewMercedesPage() {
		String expectedUrl = "http://localhost:8080/catalog.html";
		String expectedHeadingText="Mercedes";
		WebElement moreBtn = homeModel.getMoreButton(homeModel.getMercedes());
		homeModel.clickOnElement(moreBtn);
		collector.checkThat(driver.getCurrentUrl(),IsEqual.equalToObject(expectedUrl));
		WebElement heading = driver.findElement(By.id("heading"));
		collector.checkThat(heading.getText(),IsEqual.equalToObject(expectedHeadingText));
	}
	@After
	public void after() {
		homeModel.navigateToMain();
		homeModel.clickOnElement(homeModel.getLogoutBtn());
		driver.close();
	}
}


