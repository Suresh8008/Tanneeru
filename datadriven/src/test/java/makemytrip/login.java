package makemytrip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sures\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  ChromeDriver driver=new ChromeDriver();
	  	  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com/");
		  
		  FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  Cell num = sh.getRow(6).getCell(0);
		  
		  DataFormatter df = new DataFormatter();
		  String mnum = df.formatCellValue(num);
		  
		  driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys(mnum);
		  //driver.findElement(By.xpath("//body[@class='desktop in']")).click();

	}

}