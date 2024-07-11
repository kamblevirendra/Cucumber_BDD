package hooks;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigReader;
import factory.BrowserFactory;
import helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	public static WebDriver driver;
	
	@Before
	public void startBrowser()
	{
		driver=BrowserFactory.startBrowser(ConfigReader.getproperty("chrome"), ConfigReader.getproperty("URL"));
	}
	
	@After
	public void closeBrowser()
	{
	 // driver.quit();
	}
	
	@AfterStep
	public void tesrDown(Scenario scenario)
	{
		String name=scenario.getName();
		
		if(scenario.isFailed())
		{
			scenario.attach(Utility.captureScreenshotInByte(driver), "Image/png", name);
		}
		//capture screenshot and attached to report
		
	}

}
