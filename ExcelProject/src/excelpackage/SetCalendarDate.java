package excelpackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetCalendarDate
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\AppiumJars\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver=new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
		
		List<WebElement> col_nm=driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[2]/th"));
		int colsize=col_nm.size();
		System.out.println(colsize);
		
		List<WebElement> row_nm=driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr"));
		int rowsize=row_nm.size();
		System.out.println(rowsize);
		
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy ");
		Date date = new Date();
		String date1= dateFormat.format(date);
		String date2=date1.substring(3,5);
		int date3 = Integer.parseInt(date2)+1;
		String final_date=Integer.toString(date3);
		/*String date4;
		int date5;
		if(date3<10)
		{
			date4=date1.substring(1,2);
			//date5=Integer.parseInt(date4);
			
		}
		else
		{
			date4=date2;
		}*/
		
		String beginXpath="//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[";
		String midXpath="]/td[";
		String endXpath="]";
	  for (int row=3;row<rowsize;row++)
		{
		  for (int col=1;col<colsize;col++)
		  {
			  
			  String cellVal=driver.findElement(By.xpath(beginXpath+row+midXpath+col+endXpath)).getText();
			  System.out.println(cellVal);
			  if(cellVal.equalsIgnoreCase(final_date))
			  {
				  driver.findElement(By.xpath(beginXpath+row+midXpath+col+endXpath)).click();
			  }
			  
		  }
			
		}
		
		

	}

}
