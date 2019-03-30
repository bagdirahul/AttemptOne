package firstattempt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndigoCalendar
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Launching
		driver.manage().window().maximize(); //Maximizing window
		
		driver.get("https://www.goindigo.in/"); //Setting URL
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load

		String inputdate = "2-April-2019";
		String datearr[] = inputdate.split("-");
		String day = datearr[0];
		String month = datearr[1];
		boolean b=false;
		
		driver.findElement(By.xpath("//input[@name='or-depart'][1]")).click();
		
		for(int k=0; k<6; k++)
		{
			String currentmonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']")).getText();
			String montharr[] = currentmonth.split("//s");
			String matchingmonth = montharr[0];
			
			if(month.equalsIgnoreCase(matchingmonth))
			{
				List <WebElement> dates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//td"));
				for(WebElement e:dates)
				{
					String matchingdate = e.getText();
					if(day.equalsIgnoreCase(matchingdate))
					{
						e.click();
						b=true;
						break;
					}
				
				}
				if(b==true)
				{
					break;
				}
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			
		}
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
	}
}
