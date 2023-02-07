package makemytrip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipledataobj {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  ChromeDriver driver=new ChromeDriver();
	  	  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com/");
		  
		  String[] data = multipledataobj.getdata();
		  for(int i=0;i<=data.length;i++)
		  {
			  driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchCity')]")).click();
			  String from = data[i];		//hyd
			  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//div[text()='"+from+"']")).click();		//div[text()='hyd']
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("(//li[contains(@class,'font12 blackText')])[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//a[contains(@class,'primaryBtn font24')]")).click();
			  Thread.sleep(3000);
			  driver.navigate().back();
		  }
	}
	
	
	public static String[] getdata() throws Exception
	{
		FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  String[] data = new String[3];
		  for(int i=0;i<3;i++)
		  {
			  data[i] = sh.getRow(i+1).getCell(0).getStringCellValue();
		  }
		  return data;
		
	}
}
