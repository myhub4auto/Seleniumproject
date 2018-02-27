import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		
		drive.get("https://accounts.google.com/SignUp?hl=en");
		
		
		WebElement mon = drive.findElement(By.xpath("//*[@id=\"BirthMonth\"]/div"));
		
		Thread.sleep(3000);
		
		mon.sendKeys("April");
		
		
		
		java.util.List<WebElement> userlist =	mon.findElements(By.tagName("Option"));
		
		System.out.println(userlist.size());
		
		

		
		for(int i=0; i<userlist.size(); i++)
			
		{
			
			System.out.println(userlist.get(i).getText());
			
			
		}
		
		
		
		
		
	}

}
