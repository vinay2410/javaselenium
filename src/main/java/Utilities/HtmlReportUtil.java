package Utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import TestNGListeners.*;


public class HtmlReportUtil {
	
	private static ExtentReports extentNoHistory=null;
	private static ExtentReports extentPreserverHistory=null;
	private static ExtentTest test=null; 
	private static ExtentTest testHist=null; 
	
	
	
	private static void init() {
		
		
		
		if(extentNoHistory==null )
			{
			extentNoHistory = new ExtentReports(Utility.GetValue("HtmlReport")+"\\TestReport.html",true,DisplayOrder.NEWEST_FIRST);
			extentNoHistory = new ExtentReports(System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\TestReport.html",true,DisplayOrder.NEWEST_FIRST);
			extentNoHistory.loadConfig(new File(Utility.GetValue("HtmlReportConfigFile")));
			
			
			
			}
	  	if(extentPreserverHistory==null )
			{
			extentPreserverHistory = new ExtentReports(Utility.GetValue("HtmlReport")+"\\TestReportHistory.html",true,DisplayOrder.NEWEST_FIRST);
			extentPreserverHistory = new ExtentReports(System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\TestHistoryReport.html",true,DisplayOrder.NEWEST_FIRST);
			extentPreserverHistory.loadConfig(new File(Utility.GetValue("HtmlReportConfigFile")));
			
			
			
			}
	}

	public static  void startReport(String testName, String testInfo, String category){
		init();
		 test = extentNoHistory.startTest(testName, testInfo);
		 testHist = extentPreserverHistory.startTest(testName, testInfo);
		 test .assignCategory(category);
		 testHist.assignCategory(category);
	//	 if(CustomListener.platformName.equals("Native_App"))
	//	 {
	//	 extentNoHistory.addSystemInfo("OS",CustomListener.platformName +" "+DriverUtil.deviceVersion);
	//	 extentNoHistory.addSystemInfo("Browser","N.A.");
	//	 extentPreserverHistory.addSystemInfo("OS",CustomListener.platformName +" "+DriverUtil.deviceVersion);
	//	 extentPreserverHistory.addSystemInfo("Browser","N.A.");
	//	 }
		 
	     extentNoHistory.addSystemInfo("Browser",DriverUtil.webBrowserName+" "+DriverUtil.browserVersion);
		 extentPreserverHistory.addSystemInfo("Browser",DriverUtil.webBrowserName+" "+DriverUtil.browserVersion);
         		 
	}
	
	public static  void endReport(boolean status, String stepName){
		
		if(status)
		{	    test.log(LogStatus.PASS, stepName);
				testHist.log(LogStatus.PASS, stepName);
				
		}
		else{
			 	test.log(LogStatus.FAIL, stepName);
				testHist.log(LogStatus.FAIL, stepName);
			}
		
		
		extentNoHistory.endTest(test);
		extentPreserverHistory.endTest(testHist);
		
		extentNoHistory.flush();
		extentPreserverHistory.flush();
		
		
	}
	
	public static void stepPass(String stepName){
		String html= "<span style='color:green'><b>"+stepName+ "-PASS</b></span>";
		   test.log(LogStatus.INFO, html);
		   testHist.log(LogStatus.INFO, html);
		
	}
	public static void stepFail(String stepName){
		String html= "<span style='color:red'><b>"+stepName+ "-FAIL</b></span>";
		   test.log(LogStatus.INFO, html);
		   testHist.log(LogStatus.INFO, html);
		
	}
	
	public static void stepInfo(String stepName){
		
		   test.log(LogStatus.INFO, stepName);
		   testHist.log(LogStatus.INFO, stepName);
		
	}
	public static void stepError(String stepName){
		
		String html= "<span class='fatal'><b>"+stepName+ "</b></span>";
		   test.log(LogStatus.ERROR, html);
		   testHist.log(LogStatus.ERROR, html);
		
	}
	
	public static void stepError(String stepName, Throwable t){
		
		String html= "<span class='fatal'>"+stepName+ "</span>";
		   test.log(LogStatus.ERROR, html,t);
		   testHist.log(LogStatus.ERROR, html,t);
		
	}
	
	
public static  void endReportSkipped(String stepName, Throwable t){
	
	String html= "<span style='color:#e59127'>"+stepName+ "</span>";
		
			    test.log(LogStatus.SKIP, html,t);
				testHist.log(LogStatus.SKIP, html,t);
				
				extentNoHistory.endTest(test);
				extentPreserverHistory.endTest(testHist);
		
				extentNoHistory.flush();
				extentPreserverHistory.flush();
		
	}
	
	
	
public static void attachScreenshot(String imagePath){
		
	String image = test.addScreenCapture(imagePath);
		      test.log(LogStatus.FAIL, "ScreenShot: "+Utility.testException  ,image);
		      testHist.log(LogStatus.FAIL,"ScreenShot:"+Utility.testException, image);
		      
	}
	
	
	public static void tearDownReport(){
		extentNoHistory.flush();
		extentPreserverHistory.flush();
		
		
		if(extentNoHistory!=null )
			extentNoHistory.close();
		
		if(extentPreserverHistory!=null )
			extentPreserverHistory.close();
		
		
	}
	
	
}
