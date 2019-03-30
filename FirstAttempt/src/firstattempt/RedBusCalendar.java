package firstattempt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusCalendar
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Launching
		driver.manage().window().maximize(); //Maximizing window
		
		driver.get("https://www.redbus.in/"); //Setting URL
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Maximum wait for page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Maximum wait for a webelement to load

		String inputdate = "23-Aug-2019";
		String datearr[] = inputdate.split("-");
		String day = datearr[0];
		String month = datearr[1];
		
		String a = "//div[@id='rb-calendar_onward_cal']//tr[";
		String z = "]//td[";
		boolean b = false;
		
		driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
	
		for(int k=0; k<6; k++)
		{
		String calendermonth = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='monthTitle']")).getText();
		String matchmonth[] = calendermonth.split("\\s+");
		String matchingmonth = matchmonth[0];
		
		if(month.equalsIgnoreCase(matchingmonth))
		{
			for(int i=3; i<=8; i++)
			{
				for(int j=1; j<=7; j++)
				{
					
					WebElement dayfound = driver.findElement(By.xpath(a+i+z+j+"]"));
					String matchingday = dayfound.getText();
					 
					if(day.equalsIgnoreCase(matchingday))
					{
					dayfound.click();	
					System.out.println("It worked");
					b=true;
					break;
					}
					if(i>=7 && matchingday.equalsIgnoreCase(""))
					{
						System.out.println("Invalid date bro");	
						b=true;
						break;
					}
				}
				if(b==true)
				{
					break;
				}
			}
		}
		else
		{
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='next']")).click();
		}
		if(b==true)
		{
			break;
		}
		}
	}
}
