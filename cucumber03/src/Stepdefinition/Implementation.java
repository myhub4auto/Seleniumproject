package Stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Implementation {

	WebDriver Driver;
	
	String username;
	
	String password;
	
	String login;
	
	Properties prop;

	

	
public void initialization(String username, String password, String login) throws IOException
	
	{
	
	            	
	}

@Given("^i open the browser$")
public void i_open_the_browser() throws Throwable {
	
	 FileInputStream f = new FileInputStream("C:\\Users\\User\\workspace\\cucumber03\\src\\Configuration\\Repositary.properties");
	
	 prop = new Properties();
	 
	 prop.load(f);
	
	 System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
	
	 Driver = new ChromeDriver();
   
}

@Given("^i navigate the application \"([^\"]*)\"$")
public void i_navigate_the_application(String data) throws Throwable {
	
	Driver.get(data);
   
}

@When("^i enter username \"([^\"]*)\"$")

public void i_enter_username(String data) throws Throwable {
    
	Driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(data);
	
			
}

@When("^i enter password \"([^\"]*)\"$")
public void i_enter_password(String data) throws Throwable {
   
	Driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(data);
	
	
}

@When("^we click login$")
public void we_click_login() throws Throwable {
    
	

	Driver.findElement(By.xpath(prop.getProperty("login"))).click();
	
	
}

@Then("^application should loginsuccessfully$")
public void application_should_loginsuccessfully() throws Throwable {
    
}


}
