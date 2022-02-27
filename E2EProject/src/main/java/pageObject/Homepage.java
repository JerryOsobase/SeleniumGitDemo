package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	private By newsletter= By.xpath("//button[text()='NO THANKS']");
	private By LoginLink= By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	private By Featured = By.xpath("//div[@class='text-center']/h2");
	private By headerLink= By.xpath("//ul[@class='nav navbar-nav navbar-right']/li");
	
	

	public WebElement getnewsletter() {
		return driver.findElement(newsletter); 
	}
	public WebElement getFeatured() {
		return driver.findElement(Featured);
	}
	
	public LoginPage getLoginLink() {
		 driver.findElement(LoginLink).click();
		 LoginPage l=new LoginPage(driver);
		 return l;
	}
	public WebElement getheaderLink() {
		return driver.findElement(headerLink);
	}
	
}
