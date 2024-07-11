package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigReader;

public class BrowserFactory {
	
	
	public static WebDriver driver;
	
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String name, String URL)
	{
		
		
			
			driver=new ChromeDriver();
			
		
		
	
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getproperty("implicitwait"))));
	
	
	return driver;
	}
}
