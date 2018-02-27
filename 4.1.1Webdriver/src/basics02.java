import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basics02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("Webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		drive.get("www.google.com");
		
		

System.out.println(drive.getCurrentUrl());

System.out.println(drive.getPageSource());

System.out.println(drive.getTitle());


				
	}

}
