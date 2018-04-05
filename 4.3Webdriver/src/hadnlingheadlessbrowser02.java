import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class hadnlingheadlessbrowser02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
System.setProperty("phantomjs.binary.path", "E:\\Selenium JAR\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		WebDriver Driver = new PhantomJSDriver();
		
		
		Driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		
		
	WebElement username = 	Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]"));
		
	username.sendKeys("Tester");
	
	
	WebElement password = Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]"));
	
	password.sendKeys("test");
	
	WebElement login = Driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]"));
	
	login.click();
	
	
	System.out.println(Driver.getTitle());
	
	
	
	
	}

}
