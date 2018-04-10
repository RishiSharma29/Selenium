package excelpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadDataTable 
{
	 
	public static void main(String[] args)
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\AppiumJars\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver=new ChromeDriver(options);
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		List<WebElement> columns=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		int columnsize=columns.size();
		System.out.println(columnsize);
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		int rowsize=rows.size();
		System.out.println(rowsize);
		
		String BeforeXpath="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		String AfterXpath="]/td[1]/a";
		
		for (int row=1;row <=rowsize;row++)
		{
			String CellValue=driver.findElement(By.xpath(BeforeXpath+row+AfterXpath)).getText();
			System.out.println(CellValue);
			if (CellValue.equalsIgnoreCase("MMTC Ltd."))
					{
				       driver.findElement(By.xpath(BeforeXpath+row+AfterXpath)).click();
				       break;
					}
			else if(row==rowsize)
			        { 
				      System.out.println("String not found");
			        }
			else
			        {
				       System.out.println("The search goes on");
			        }
			
		}
		
		System.out.println("Test Completed");
		
		
		

	}

}
