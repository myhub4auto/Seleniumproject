package Stepdefinaition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Implementation {

	WebDriver Driver;
	
	

@When("^we lunch the app$")
public void we_lunch_the_app() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  System.out.println("In the length for the day");
}

@Given("^i open the browser$")
public void i_open_the_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
	
	 Driver = new ChromeDriver();
    
}

@Given("^i navigate the application \"([^\"]*)\"$")
public void i_navigate_the_application(String data) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
	
	Driver.get(data);
}

@When("^i enter username \"([^\"]*)\"$")
public void i_enter_username(String data) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 
	

	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
}

@When("^i enter password \"([^\"]*)\"$")
public void i_enter_password(String data) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	

	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");
    
}

@When("^we click login$")
public void we_click_login() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
  
}

@Then("^application should loginsuccessfully$")
public void application_should_loginsuccessfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}




}
