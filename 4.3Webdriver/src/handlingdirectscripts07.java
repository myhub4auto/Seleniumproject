import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingdirectscripts07 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver Driver = new ChromeDriver();
		
		long starttime = System.currentTimeMillis();
		
		Driver.get("http://www.seleniumhq.org/download/");
		
		// the following scripts is jquery JS 
		
		
		((JavascriptExecutor)Driver).executeScript("history.back()");
		
		Thread.sleep(3000);
		
		
		((JavascriptExecutor)Driver).executeScript("history.forward()");
		
	
		
		
		String status = (String) ((JavascriptExecutor)Driver).executeScript("return document.readystate");
		
		// the webpage is loaded completely 

		
		  System.out.println(status);
		  
		  Long endtime = System.currentTimeMillis();
		  
		  Long total = endtime-starttime;
		  
		  System.out.println(total);
		  
		  
			((JavascriptExecutor)Driver).executeScript("return location.href"); // get the current URL 
			
			
		  
	}

}
