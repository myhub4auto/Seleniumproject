import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingkeysinwebdriver06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver Driver = new ChromeDriver();
		
		
		Driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		
		
	WebElement username = 	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]"));
		
	username.sendKeys("Tester");
	
	
	WebElement password = Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]"));
	
	password.sendKeys("test");
	
	password.sendKeys(Keys.ENTER);   // keys its a class in webdriver 
	
	password.sendKeys(Keys.chord(Keys.ENTER,Keys.TAB,Keys.ARROW_LEFT));
	
	
	Driver.navigate().refresh();
	
	
	
	
	
	

	}

}
