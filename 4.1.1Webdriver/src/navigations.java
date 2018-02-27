import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		drive.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		
		WebElement delete = drive.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnDelete\"]"));
		
		
		delete.click();
		
		Thread.sleep(19000);
		
		
		drive.navigate().back();
		
		Thread.sleep(19000);
		
		
		drive.navigate().forward();
		
		
		
		
		
		
		
	}

}
