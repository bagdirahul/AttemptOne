package firstattempt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fanny {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe"); //open chrome
		
		WebDriver driver = new ChromeDriver(); // create object of webdriver
		
		driver.manage().deleteAllCookies(); //delete cookies
		driver.manage().window().maximize(); //maximize window
		driver.get("https://www.google.com/");
		
	//	Thread.sleep(45000);//static - not global
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //dynamic wait - global  - page
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // dynamic wait - global  - webelements
		
		
		//*[@id="tsf"]/div[2]/div/div[1]/div/div[1]/input  -  absolute xpath - not recommended
		
		//input[@id='email'] - relative xpath
	/*	
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("khareayushi123@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Password123");
//		driver.findElement(By.id("loginbutton")).click();
		
		driver.findElement(By.xpath("//input[@id='u_0_j']")).sendKeys("Fanny");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khare");
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("9407289195");
		driver.findElement(By.xpath("//input[@id='u_0_v']")).sendKeys("Ayu@230894");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 layerCancel _2rsa uiOverlayButton _4jy3 _517h _51sy']")).click();
		
	//	driver.findElement(By.linkText("Forgotten account?")).click();
		driver.findElement(By.partialLinkText("Forgotten acc")).click();
		
		driver.navigate().to("https://www.google.com/");
		*/
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Rahul");
		
		List <WebElement> l1 = driver.findElements(By.xpath("//ul[@class='erkvQe']//span"));
		
		System.out.println(l1.size());
		
		for(int i=0; i<=l1.size(); i++)
		{
		//	String a = l1.get(i).getText();
			
			if(l1.get(i).getText().equalsIgnoreCase("Rahul Dravid"))
			{
				l1.get(i).click();
			}
		}
		
						
	}
}
