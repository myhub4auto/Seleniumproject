import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getthenumberoftextbox08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		   
		
   System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver Driver = new ChromeDriver();
		
		
		Driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		
		
		int text = Driver.findElements(By.xpath("//input[@type='text']")).size();
		
		System.out.println(text);
		
		
	}

}
