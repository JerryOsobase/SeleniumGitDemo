package Group.E2EProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Homepage;
import resources.base;

public class ValidateTitleTest extends base {
	public WebDriver driver;
	Homepage hp;
	@BeforeTest
	public void initialize() throws IOException {
		driver= InitializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateTitle() throws IOException {
		 hp=new Homepage(driver);
		hp.getFeatured().getText();
		Assert.assertEquals(hp.getFeatured().getText(), "FEATURED COUR676SES");
			
	}
	
	
	
	@AfterTest
	public void terminate() {
		driver.close();
	}
	
}
