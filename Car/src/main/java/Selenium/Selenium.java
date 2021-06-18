package Selenium;

import java.rmi.server.RemoteServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
public class Selenium {

public static RemoteServer driver = null;
public static DesiredCapabilities capabilities = null;

@Before
public void initializeSelenium() {
capabilities = new DesiredCapabilities();
capabilities.setCapability("browserName", "chrome");
capabilities.setCapability("version", "70.0");
capabilities.setCapability("platform", "win10");

}

@Test
public void signUp() {
driver.findElement(By.name("Name")).sendKeys("Nakata Cholov");
driver.findElement(By.email("Email")).sendKeys("example@test.com");
driver.findElement(By.sub("submit_btn")).click();

}

@Test
@RepeatedTest(3)
public void reloadPage() {
	
}

@AfterClass
public void cleanUp() {

driver.wait();
}
}