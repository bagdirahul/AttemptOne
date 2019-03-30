package firstattempt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;

public class WebsiteAutomation {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Launching
		driver.manage().window().maximize(); //Maximizing window
		
		driver.get("https://phptravels.com/"); //Setting URL
	
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load
	    
		Thread.sleep(20000);
	//	int count=0;
	//	int size = driver.findElements(By.tagName("iframe")).size(); // Find size of frames
		

   /*   for(int i=0; i<=size; i++) //To get the index of desired frame
        {
        	
    		driver.switchTo().frame(i);
    		int total=driver.findElements(By.xpath("//input[@name='EMAIL']")).size();
    		System.out.println(total);
    	    driver.switchTo().defaultContent();
    	    count++;
    	    if(total==1) {break;}
      
        } */
   //   System.out.println(count);
		
		
	    driver.findElement(By.xpath("//button[text()='No Thanks']")).click();
	    
		
	    
	    WebElement element = driver.findElement(By.xpath("//div[@class='mc-closeModal']"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click()", element);
		    
		driver.switchTo().frame("chat-widget");   //Switching to frame
		System.out.println("Inside chat");
		Thread.sleep(4000);
	//	driver.findElement(By.xpath("//div[@class='lc-117ospz e1b9v3lg1']//button")).click(); 
		driver.findElement(By.xpath("(//button[@class='lc-e7c2r4 e1m5b1js0'])[2]")).click();
		System.out.println("Inside chat after clicking");
	   driver.switchTo().parentFrame(); 
	    
	   try 
	    {
	        //Handle the alert pop-up using seithTO alert statement
	        Alert alert = driver.switchTo().alert();

	        //Print alert is present
	        System.out.println("Alert is present");

	        //get the message which is present on pop-up
	        String message = alert.getText();

	        //print the pop-up message
	        System.out.println(message);

	        alert.sendKeys("");
	        //Click on OK button on pop-up
	        alert.dismiss();
	    } 
	    catch (NoAlertPresentException e) 
	    {
	        //if alert is not present print message
	        System.out.println("alert is not present");
	    }
	 
	    WebElement element1 = driver.findElement(By.xpath("//div[@class='Campaign__innerWrapper']/button"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
	 // driver.switchTo().frame(count-1);
//		driver.findElement(By.xpath("//input[@name='EMAIL']")).sendKeys("rahul@gmail.com");
//		driver.switchTo().parentFrame();
	//  driver.findElement(By.xpath("//div[@class='content__button']")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@class='lvl-1'])[3]"))).build().perform();
		driver.findElement(By.linkText("Hotels Module")).click();
		
		
		System.out.println("Rahul");
		
			
	}
	
}
