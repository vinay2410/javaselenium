package TestNGListeners;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import Utilities.DriverUtil;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.Utility;

	
	public class CustomListener  extends KeywordUtil implements  ITestListener, ISuiteListener,IReporter{
		public static String testCaseID="";
		public static String browserName = null;
		public static Date startTime, endTime;
		public static long totalSeconds=0;
		public static String platformName = null;
		
		
		long hours ;
		long minutes; 
		long seconds ;

		String timeString;
		
		
		public void onStart(ISuite suite) {
	
	   if (driver == null) {
		   try {
			   	
			   platformName=ExcelDataUtil.getColumnValue("Platform(Windows,Android)", "Platform",1);
			   
		      } catch (Exception e) {
			e.printStackTrace();
		   }
		   
		   
		   if(platformName.equals("Windows"))
		   {
			   browserName = ExcelDataUtil.getColumnValue("Windows Browsers(Firefox, Chrome,IE)", "Browsers",1);
			   try {
			 DriverUtil.getBrowser(browserName);
			} catch (Exception e) {
				e.printStackTrace();
		   }
		   }
		   
		   
	   
	
	   }
	   
	 }
		

   public void onFinish(ISuite suite) {
	    HtmlReportUtil.tearDownReport();
		Utility.renameFile();
		System.out.println("Suite run has finished");
		hours = totalSeconds / 3600;
		minutes = (totalSeconds % 3600) / 60;
		seconds = totalSeconds % 60;
		JOptionPane.showMessageDialog(null, "Suite run has finished in "+ minutes+ " mins " +seconds+" seconds");
		driver.quit();
		
	}



	public void onTestStart(ITestResult result) {
		startTime = new Date();
		
	}
	
	
	public void onTestSuccess(ITestResult testResult) {
		
		endTime = new Date();
		seconds = (endTime.getTime() - startTime.getTime()) / 1000;
		
		totalSeconds+=seconds;
		LogUtil.infoLog(getClass().getSimpleName(), "Total Time taken in(seconds):" + seconds);
		Utility.testResult.setResultStatus("PASS");
		Utility.testResult.setTotalTimeTaken(seconds);
		ExcelDataUtil.updateTestResults(Utility.testData, Utility.testResult);
		HtmlReportUtil.endReport(true, Utility.testData.getTestCaseID());
		driver.manage().deleteAllCookies();
	}


	public void onTestFailure(ITestResult testResult) {
			
		
		
		//   System.out.println("Test is failed methods"+
		//	 method.getTestMethod().getMethodName() );
			endTime = new Date();
			seconds = (endTime.getTime() - startTime.getTime()) / 1000;
			// Duration.between(startTime, endTime).getSeconds();
			totalSeconds+=seconds;
			LogUtil.infoLog(getClass().getSimpleName(), "Total Time taken in(seconds):" + seconds);
			Utility.testResult.setResultStatus("FAIL");
			Utility.testResult.setTotalTimeTaken(seconds);
			Utility.testResult.setReasonForFailure(testResult.getThrowable().getMessage());
			LogUtil.errorLog(getClass().getSimpleName(), testResult.getThrowable().getMessage());
			ExcelDataUtil.updateTestResults(Utility.testData, Utility.testResult);
			HtmlReportUtil.endReport(false, Utility.testData.getTestCaseID());
			driver.manage().deleteAllCookies();
	}



	public void onTestSkipped(ITestResult testResult) {

		endTime = new Date();
		seconds = (endTime.getTime() - startTime.getTime()) / 1000;
		totalSeconds+=seconds;
		LogUtil.infoLog(getClass().getSimpleName(), "Test Skipped - Total Time taken in(seconds):" + seconds);
		Utility.testResult.setResultStatus("SKIPPED");
		Utility.testResult.setTotalTimeTaken(seconds);
		ExcelDataUtil.updateTestResults(Utility.testData, Utility.testResult);
		HtmlReportUtil.endReportSkipped(Utility.testData.getTestCaseID(), Utility.testException);

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}



	public void onStart(ITestContext context) {
		
	}



	public void onFinish(ITestContext context) {
		
	}



	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
 
		
	}



	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}


	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}
	
	

}



