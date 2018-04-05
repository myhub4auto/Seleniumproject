

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdataretrivefromtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
       System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver Driver = new ChromeDriver();
		
		
		Driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		
		
	WebElement username = 	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]"));
		
	username.sendKeys("Tester");
	
	
	WebElement password = Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]"));
	
	password.sendKeys("test");
	
	WebElement login = Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]"));
	
	login.click();
	
	WebElement table = Driver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/div[2]"));
	
	

	List <WebElement> rows =  table.findElements(By.tagName("tr"));
	
	for(int i=0; i<rows.size(); i++)
		
	{
		
	
		List <WebElement> rows01 =  rows.get(i).findElements(By.tagName("td"));
		
		
		for(int j=0; j<rows01.size(); j++)
			
		{
			
		String data = 	rows01.get(j).getText();
			
			System.out.println(data);
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	}

}
