package makemytrip;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelreading {

	public static void main(String[] args) throws Exception {
		
		  FileInputStream fin  = new FileInputStream("C:\\Users\\sures\\OneDrive\\Desktop\\sureshdata.xlsx");
		  XSSFWorkbook wb = new XSSFWorkbook(fin);
		  XSSFSheet sh = wb.getSheet("Sheet1");
		  int nrow = sh.getLastRowNum();
		  int ncolumn = sh.getRow(0).getLastCellNum();
		  Object[][] obj = new Object[nrow][ncolumn];
		  for(int i =0;i<nrow;i++)
		  {
			  for(int j=0;j<ncolumn;j++)
			  {
				  obj[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				  System.out.print(obj[i][j] + " ");
			  }
		  }
	}

}
