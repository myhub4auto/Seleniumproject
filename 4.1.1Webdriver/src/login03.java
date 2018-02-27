import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login03 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
    System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
    WebDriver drive = new ChromeDriver();
		
		
		drive.get("https://52.220.168.61:8080/#!/authentication/login");
		
		Thread.sleep(2000);
		
		WebElement username = drive.findElement(By.xpath("//*[@id=\"login\"]"));
		
				
		username.sendKeys("admin");
		
		
		Thread.sleep(2000);
		
WebElement password = drive.findElement(By.xpath("//*[@id=\"password\"]"));
		
password.sendKeys("incarnushis");


Thread.sleep(2000);	

WebElement login = drive.findElement(By.xpath("//*[@id=\"loginbutton\"]/span"));

login.click();

//
//
//WebElement doctor = drive.findElement(By.xpath("//*[@id=\"filterpattxt\"]"));
//
//Thread.sleep(2000);
//
//doctor.click();
//
//Thread.sleep(2000);
//
//
//doctor.clear();
//
//
//Thread.sleep(2000);
//
//
//doctor.sendKeys("a");
//
//
//Thread.sleep(2000);

//  
//  try {
//	  
//	  int x=1;
//	  
//	  while(true)
//	  {
//		  
//		  String names = drive.findElement(By.xpath("//*[@id=\"fl-input-"+x+"\"]")).getText();
//		  
//		  
//		  System.out.println(names);
//		  
//		  x++;
//		 
//	  }
//		  
//	  } catch (Throwable t)
//	  
//	  {
//		  
//		  System.out.println("Docotr name ends");
//	  }
//  
//  
//  
 
  
	
  }		
	

	}
