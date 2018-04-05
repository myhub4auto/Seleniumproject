import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingdatepikerjquery05 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		
		drive.get("http://jqueryui.com/datepicker/");
		
		
		drive.switchTo().frame(0);
		
		
		WebElement f = drive.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		
		f.click();
		
WebElement f2 = drive.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		


		f2.sendKeys("06/06/2347");
		
		f2.click();
		
		
		Thread.sleep(3000);
		
		
		 drive.navigate().back();
		 
		 
		 drive.get("http://jqueryui.com/datepicker/");
			
			
			drive.switchTo().frame(0);
		
		
		Thread.sleep(3000);
	
		WebElement b = drive.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		
		
		b.click();	
		
 WebElement b1 = drive.findElement(By.xpath("html/body/div[1]/table/tbody/tr[5]/td[2]/a"));
	
		b1.click();
		
		
	}

}
