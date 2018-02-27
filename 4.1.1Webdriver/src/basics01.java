import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basics01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver Driver = new ChromeDriver();
		
		
		Driver.get("https://www.google.com");
		
		
		System.out.println(Driver.getTitle());
		
		
		System.out.println(Driver.getCurrentUrl());
		
		System.out.println(Driver.getPageSource());
		
		System.out.println(Driver.getPageSource());

	}

}
