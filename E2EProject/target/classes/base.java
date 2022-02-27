package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	@SuppressWarnings("deprecation")
	public WebDriver InitializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//"
				+ "main//java//resources//data.properties");
		prop.load(fis);
		String BrowserName= prop.getProperty("browser");
		System.out.println(BrowserName);
		if(BrowserName.equals("chrome")) {
			// TODO Auto-generated method stub
			ChromeOptions options=new ChromeOptions();
			options.addArguments("use-fake-ui-for-media-stream");
			
			Map<String, Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			//1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs",prefs);
			System.setProperty("webdriver.chrome.driver", "//Users//jerryosobase//Applications//chromedriver 2");
			driver=new ChromeDriver(options);
		}
		
		else if(BrowserName.equals("firefox")) {
			//execute firefox system properties
		}
		
		else if(BrowserName.equals("IE")) {
			//execute internet explorer system properties
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
			
	}
	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String DestinationName= System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(DestinationName));
		return DestinationName;
	}
}
