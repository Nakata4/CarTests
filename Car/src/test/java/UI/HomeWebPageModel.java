package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWebPageModel {
	private WebDriver driver;
	@FindBy(id="logout-link")
	private WebElement logoutBtn;
	@FindBy(id="catalog-card-2")
	private WebElement audi;
	@FindBy(id="catalog-card-1")
	private WebElement bmw;
	@FindBy(id="catalog-card-3")
	private WebElement mercedes;
	
	public HomeWebPageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToMain() {
		driver.get(
				"http://localhost:8080/home");	
		
	}
	public void clickOnElement(WebElement element) {
		element.click();
	}
	public WebElement getMoreButton(WebElement element) {
		return element.findElement(By.className("btn-primary"));
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getAudi() {
		return audi;
	}

	public WebElement getBMW() {
		return bmw;
	}

	public WebElement getMercedes() {
		return mercedes;
	}
	
	

}
