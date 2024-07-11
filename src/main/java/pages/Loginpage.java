package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class Loginpage {
	
	

	protected WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//private By newuserLink=By.linkText("New user? Signup");
	
	private By errorMessage=By.className("errorMessage");
	
	private By username=By.id("email1");
	
	private By password=By.id("password1");
	
	private By loginbutton=By.className("submit-btn");
	
	
	public void loginToApplication(String uname,String pass)
	{
		Utility.waitforWebElement(driver, username).sendKeys(uname);
		Utility.waitforWebElement(driver, password).sendKeys(pass);
		Utility.waitforWebElement(driver, loginbutton).click();
	}
	
	
	public String captureErrorMsg()
	{
		WebElement element=Utility.waitforWebElement(driver, errorMessage);
		
		String error_msg=Utility.highlightEle(driver, element).getText();
		
		return error_msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
