package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	
	
	By email= By.id("user_email");
	By password= By.id("user_password");
	By login= By.name("commit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	
}
