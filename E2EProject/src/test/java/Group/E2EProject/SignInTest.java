package Group.E2EProject;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.Homepage;
import pageObject.LoginPage;
import resources.base;

public class SignInTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	Homepage hp;
	LoginPage l;
	@BeforeTest
	public void initialize() throws IOException {
		driver= InitializeBrowser();
		log.info("Initialize browser");
		
	}
	
	@Test(dataProvider="getData")
	public void signIn(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the URL");
		 hp=new Homepage(driver);
		 l = hp.getLoginLink();
		log.info("Click on the Login link");
		l.email().sendKeys(username);
		log.info("Input email address");
		l.password().sendKeys(password);
		log.info("Input password");
		System.out.println(text);
		
		
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		data[0][0]="hello@gmail.com";
		data[0][1]="password";
		data[0][2]="User";
		
		data[1][0]="hello1@gmail.com";
		data[1][1]="password1";
	    data[1][2]="User1"; 
		return data;
	}
	
	
}
