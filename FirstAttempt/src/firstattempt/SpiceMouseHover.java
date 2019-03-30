package firstattempt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceMouseHover {

	public static void main(String[] args) throws InterruptedException
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); //Launching
	driver.manage().window().maximize(); //Maximizing window
	
//	driver.get("https://www.spicejet.com/"); //Setting URL

	driver.get("https://www.amazon.in/"); //Setting URL
	
	//Spice jet drop down and click
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load
/*	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"))).build().perform();
	action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
	driver.findElement(By.linkText("Sign up")).click();
	
	action.moveToElement(driver.findElement(By.xpath("//span[@class='burger-bread']"))).build().perform();
	driver.findElement(By.linkText("Tariffs")).click();
*/	
	
//Amazon drop down and click	
	WebElement menu = driver.findElement(By.xpath("//div[@id='nav-shop']"));
	Actions action = new Actions(driver);
	action.moveToElement(menu).build().perform();
	Thread.sleep(2000);
	List<WebElement>li=driver.findElements(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']/span"));
	System.out.println("size of list  "+li.size());
	
	for(WebElement e:li) {
		String product=e.getText();
		if(product.equalsIgnoreCase("Mobiles, Computers")) {
			action.moveToElement(e).build().perform();
		}
	}
	
	WebDriverWait wait = new WebDriverWait(driver,5);
	WebElement submenu=driver.findElement(By.xpath("//span[text()='Power Banks']"));
	Thread.sleep(1000);
	Thread.sleep(1000);
	submenu.click();

	}
}
