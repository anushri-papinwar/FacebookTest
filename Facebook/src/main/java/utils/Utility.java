package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
    public static String getDataFromExcel(String s,int r, int c) throws IOException {
    	FileInputStream file = new FileInputStream("D:\\VCTC\\SeleniumLectures\\TestNGFetch.xlsx");

    	 Workbook book  = WorkbookFactory.create(file);
    	 Sheet sheet  = book.getSheet(s);
    	 Row row = sheet.getRow(r);
    	 Cell cell = row.getCell(c);
    	 String data = cell.getStringCellValue();
      
         book.close();
         
         return data;
    }
    
    public static void captureScreenshot(WebDriver driver, String tid) throws IOException {
    	TakesScreenshot t = (TakesScreenshot)driver;
    	File source = t.getScreenshotAs(OutputType.FILE);
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    	String dateTime = formatter.format(new Date());
    	
    	File dest = new File("D:\\VCTC\\SeleniumLectures\\TestNGSS\\Test-" +tid +" "+dateTime+".jpg");
    	
    	FileHandler.copy(source,dest);
    }
}
