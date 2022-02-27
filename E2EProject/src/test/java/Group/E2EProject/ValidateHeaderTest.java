package Group.E2EProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Homepage;
import resources.base;

public class ValidateHeaderTest extends base {
	public WebDriver driver;
	Homepage hp; 
	@BeforeTest
	public void initialize() throws IOException {
		driver= InitializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority=1)
	public void validateHeader() throws IOException {
	hp	= new Homepage(driver);
		Assert.assertTrue(hp.getheaderLink().isDisplayed());
	}
	

	
	@AfterTest
	public void terminate() {
		driver.close();
	}
	
}
