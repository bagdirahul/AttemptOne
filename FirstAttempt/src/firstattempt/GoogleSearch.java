package firstattempt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Launching
		driver.manage().window().maximize(); //Maximizing window
		
		driver.get("https://www.google.co.in/"); //Setting URL
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load

		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Java");
		
		List <WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbtc']"));
		
		for(int i=0; i<searchlist.size();i++)
		{
			if(searchlist.get(i).getText().contains("javascript"))
			{
				searchlist.get(i).click();
				break;
			}
		}
			
	}
}
