package helper;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigReader;

public class Utility {
	
	
	public static void wait(int sec)
	{
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	public static byte[] captureScreenshotInByte(WebDriver driver)
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] arr=ts.getScreenshotAs(OutputType.BYTES);
		return arr;
		
	
	//FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("file path"+".png"));
		
	}
	
	public static WebElement highlightEle(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow;border: solid 2px red')", element);
		
		wait(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",element);
		
		return element;
		
	}
	
	
	public static WebElement  waitforWebElement(WebDriver driver, By Locator)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(Locator));
		
		if(ConfigReader.getproperty("highlighter").contains("true"))
		{
			
			return highlightEle(driver, element);
		}
		else
		{
			return element;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
