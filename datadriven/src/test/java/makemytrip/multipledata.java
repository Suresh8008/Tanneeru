package makemytrip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipledata {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  ChromeDriver driver=new ChromeDriver();
	  	  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com/");
		 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  for(int i=0;i<3;i++)
		  {
			  
			  driver.findElement(By.xpath("//label[@for='fromCity']")).click();
			  
			  String from = multipledata.getfrom(i);		//hyd
			  String To = multipledata.getto(i);
			  String Date = multipledata.getdate(i);
			 
			  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[text()='"+from+"']")).click();	////div[text()='HYD']
			  Thread.sleep(2000);
			  
			  driver.findElement(By.id("toCity")).sendKeys(To);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[text()='"+To+"']")).click();	
			  Thread.sleep(2000);
			  
			  driver.findElement(By.xpath("//div[@aria-label='"+Date+"']//div[1]")).click(); ////div[@aria-label='Wed Feb 08 2023']//div[1]
			  
			  driver.findElement(By.xpath("(//li[contains(@class,'font12 blackText')])[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//p[@data-cy='submit']//a[1]")).click();
			  Thread.sleep(3000);
			  driver.navigate().back();
		  }
	}
	
	
	public static String getfrom(int i) throws Exception
	{
		FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  String data = sh.getRow(i+1).getCell(0).getStringCellValue();
		  return data;
		
	}
	
	public static String getto(int i) throws Exception
	{
		FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  String data = sh.getRow(i+1).getCell(1).getStringCellValue();
		  return data;
		
	}
	public static String getdate(int i) throws Exception
	{
		FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  String data = sh.getRow(i+1).getCell(2).getStringCellValue();
		  return data;
		
	}
}
