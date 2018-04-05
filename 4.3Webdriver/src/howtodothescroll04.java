import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class howtodothescroll04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		
		drive.get("http://www.seleniumhq.org/download/");
		
		
		((JavascriptExecutor)drive).executeScript("window.scrollBy(0,20000)");
		
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)drive).executeScript("window.scrollBy(0,-5000)");
		

	}

}
