package stepDefination;

import org.openqa.selenium.By;
import org.junit.Assert;


import factory.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Loginpage;

public class LoginAsAdmin {
	
	Loginpage login;
	
	@Given("User is able to load the application")
	public void user_is_able_to_load_the_application() 
	{
		login=new Loginpage(BrowserFactory.getDriver());
		
	   
	}

	@When("User enter user name as {string} and password as {string} and click on submit button")
	public void user_enter_user_name_as_and_password_as_and_click_on_submit_button(String Username, String pass) 
	{
	   
	   login.loginToApplication(Username, pass);
	}

	
	@Then("User should able to login")
	public void user_should_able_to_login() 
	{
		
	 Assert.assertTrue((BrowserFactory.getDriver().findElement(By.xpath("//span[normalize-space()='Manage1']")).isDisplayed()));
	    
	 
	  
	  
	
	   
	}

}
