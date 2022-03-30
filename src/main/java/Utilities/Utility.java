package Utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class Utility{

public static TestData testData;
public static TestResults  testResult;
public static Exception  testException;
public static boolean login=false;
public static String testCaseID="";
public static WebDriver driver=null;
public static int cellNumber=0;
	public static WebElement FindWithWait(WebDriver driver,By locator, int seconds) throws Exception{
			WebElement element=null;
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			try{
						FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
								.withTimeout(seconds, TimeUnit.SECONDS)
								.pollingEvery(200, TimeUnit.MILLISECONDS)
								.ignoring(NoSuchElementException.class)
								.ignoring(StaleElementReferenceException.class)
								.ignoring(WebDriverException.class);
										 
					element=fluentWait.until(
								
								ExpectedConditions.visibilityOfElementLocated(locator)
								
								);
					return element;
						
			} catch(Exception e){
				
				throw new Exception("Timeout reached when searching for element! Time: " + seconds+" seconds " +"\n" +e.getMessage());
				
			}
			finally {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			
		}

	
	
	
	public static String takeScreenshot(WebDriver driver, String testCaseID) throws Exception 
    {
		 String path=GetValue("screenshotPath")+"\\"+testCaseID+".jpg"; 
		 Screenshot screenshot = new AShot().shootingStrategy(new    ViewportPastingStrategy(100)).takeScreenshot(driver);
	     File src=new File(path);
		 ImageIO.write(screenshot.getImage(), "PNG", src);
		 System.out.println("Taking screen shot");
         System.out.println("File path:" + src.getAbsolutePath());
         return src.getAbsolutePath();
            
    }
	
	
	
	public static boolean checkVisible(WebDriver driver , By by){
		
		return	driver.findElement(by).isDisplayed() && driver.findElement(by).isEnabled();  
			
		}

		public static void logResult(boolean status, String logStep ){
			if (status) {
				LogUtil.infoLog(Utility.class, logStep + "-PASS ");
				HtmlReportUtil.stepPass(logStep);
			} else {
				LogUtil.infoLog(Utility.class, logStep + "-FAIL ");
				HtmlReportUtil.stepFail(logStep);
				
			}
			  
				
			}

		public static void logStep(String logStep ){
			
				LogUtil.infoLog(Utility.class, logStep );
				HtmlReportUtil.stepInfo(logStep);
					  
				
			}
	
	
	
		public static String GetValue(String key)
		{ 
			File file = new File("src\\main\\resources\\ConfigFiles\\config.properties");

			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();

			try {
				prop.load(fileInput);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String strbaseURL = prop.getProperty(key);
			return strbaseURL;
		}
		
		
		public static int GetIntValue(String key)
		{
			File file = new File("src\\main\\resources\\ConfigFiles\\config.properties");

			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();

			try {
				prop.load(fileInput);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String strbaseURL = prop.getProperty(key);
			return Integer.parseInt(strbaseURL);
		}
		
		
		
		
		
		public static String getDateTime(){
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateOfExecution= dateFormat.format(date);
			return dateOfExecution;
		}
		
		public static void renameFile(){
			
//			Path source = Paths.get(PropertyFileReader.getValue("testResultExcelPath"));
//			
//			Files.move(source, source.resolveSibling("newname"));

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
			String timeStamp= dateFormat.format(date);
			
			
			  try {
				  
				  File oldFile = new File(System.getProperty("user.dir")+Utility.GetValue("testResultExcelPath"));
				  //File newFile  = new File(PropertyFileReader.getValue("testResultExcelPath"));
				  String newFilePath = oldFile.getAbsolutePath().replace(oldFile.getName(), "") +"\\ReportHistory\\"+ timeStamp+"-TestResult.xls";
				  File newFile  = new File (newFilePath);
					
				    
						    
			    FileUtils.copyFile(oldFile, newFile);
			    System.out.println("History File successfully created... ");
			    
			  } catch (IOException e) {
			    e.printStackTrace();
			  }
		}
		 	
		
		
		
		public static void resettData(){
			testResult.setFailedScreenShotReference("");
			testResult.setDateOfExecution("");
			testResult.setReasonForFailure("");
			testResult.setResultStatus("");
			testResult.setTotalTimeTaken(0);
			testData.setBrowser("");
			testData.setComplexity("");
			testData.setTestCaseID("");
			testData.setTestCaseSummary("");
			testData.setTestSet("");
			
			
		}
		

	

		public static String getObjectValue(String key) {
			File file = new File("src\\main\\resources\\objects.properties");

			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();

			try {
				prop.load(fileInput);
			} catch (Exception e) {
				e.printStackTrace();
			}


			String strKey = prop.getProperty(key);

			return strKey;
		}


public static String getdatafromXls(String subSheetName,String columnName,int row)
{
	String cellValue = null;
	 try {
	
	FileInputStream fileInputStream = new FileInputStream(Utility.GetValue("DataSheetPath"));

	   HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet(subSheetName);
	
	for(int y=0;y<worksheet.getRow(0).getLastCellNum();y++)
	{
	 HSSFCell cellA2 = worksheet.getRow(0).getCell(y);
	 cellA2.setCellType(cellA2.CELL_TYPE_STRING);
	 String getCellName= cellA2.getStringCellValue();
	 if(getCellName.contains(columnName))
	 {
		 cellNumber=cellA2.getColumnIndex();
	 }
	}
	
	cellValue=ExcelDataUtil.getCellData(worksheet, row, cellNumber);
	
}catch (Exception e){
	System.out.println("Could not read the Excel sheet");
	e.printStackTrace();

	}


	return cellValue;




		
}

}






