import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium JAR\\chrome\\chromedriver.exe");
		
		WebDriver drive = new ChromeDriver();
		
		drive.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		
		WebElement username = drive.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		
		username.sendKeys("bartibeckam");
		
		
		WebElement next = drive.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
		
		next.click();
		
		
WebElement password1 = drive.findElement(By.xpath("///*[@id=\"password\"]/div[1]/div/div[1]/input"));
		
		password1.sendKeys("123456789*b");
		
		
		
			
		
      WebElement next1 = drive.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
		
		next1.click();
		
		
		  WebElement done = drive.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/c-wiz/div/div[1]/div/div/div/div[2]/div[3]/div/div[2]/div/content/span"));
			
			done.click();
			
			
		
	
		
	}

}
