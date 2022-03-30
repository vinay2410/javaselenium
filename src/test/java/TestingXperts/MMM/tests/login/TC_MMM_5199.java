package TestingXperts.MMM.tests.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestNGListeners.*;
import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.*;
import Utilities.DriverUtil;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.Utility;
import Utilities.TestData;
import Utilities.TestResults;

@Listeners(CustomListener.class)
public class TC_MMM_5199 extends KeywordUtil {
	String suiteName = GetValue("suiteName");
	public List<String[]> errLogs = new ArrayList<String[]>();
	boolean isRun;
	boolean check = true;
	boolean status = true;
	String expected = "NA", actual = "NA";
	String logStep;
	String testCaseID = getClass().getSimpleName();
	int row = 1;
	
	boolean logout_flag=true;

	@BeforeMethod
	public void beforeTest() {
        Utility.testData = new TestData();
		Utility.testResult = new TestResults();
		Utility.testData = ExcelDataUtil.getTestDataWithTestCaseID(testCaseID);
		Utility.testResult.setDateOfExecution(Utility.getDateTime());
		LogUtil.infoLog(getClass(), "**********************Test Started:" + testCaseID +"*************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		driver.manage().deleteAllCookies();
		
		
		navigate();
	}

	@Test
	public void test_TC_MMM_5199() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);

			executeStep(isWebElementPresent(Common.username_input, Common.type_xpath), getClass(),"Username Field is present");
			executeStep(isWebElementPresent(Common.password_input, Common.type_xpath), getClass(),"Password Field is present");
			/*executeStep(isWebElementPresent(Common.login_btn, Common.type_xpath), getClass(),"Login Button Field is present");
			executeStep(isWebElementPresent(MMM_login.innovaMD_img, Common.type_xpath), getClass(),"Innova MD logo is present");
			executeStep(isWebElementPresent(MMM_login.mso_img, Common.type_xpath), getClass(),"Mso logo is present");
			executeStep(isWebElementPresent(MMM_login.welcome_header, Common.type_xpath), getClass(),"Welcome to InnovaMD is present");
			executeStep(isWebElementPresent(MMM_login.forget_username_lnk, Common.type_xpath), getClass(),"Forgot Username link is present");
			executeStep(isWebElementPresent(MMM_login.forget_password_lnk, Common.type_xpath), getClass(),"Forgot password link is present");
			executeStep(isWebElementPresent(MMM_login.register_message, Common.type_xpath), getClass(),"please click Register button is present");
			executeStep(isWebElementPresent(MMM_login.register_btn, Common.type_xpath), getClass(),"Register button is present");
			executeStep(isWebElementPresent(MMM_login.copy_write_notice, Common.type_xpath), getClass(),"verfiy that Copyright text is present");
			executeStep(isWebElementPresent(MMM_login.privacy_link, Common.type_xpath), getClass(),"verfiy that Privacy link is present");
			executeStep(isWebElementPresent(MMM_login.terms_link, Common.type_xpath), getClass(),"verfiy that terms link is present");
			executeStep(writeInInput(Common.username_input, Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter incorrect password");
			executeStep(click(Common.login_btn, Common.type_xpath), getClass(), "Click on Login Button");
		//	executeStep(isWebElementPresent(MMM_login.invalid_username_pass_msg, Common.type_xpath), getClass(), "Invalid Username or Password Message is present");
*/			logout_flag=false;
		
		
		}

		    catch (SkipException skip) {
			Utility.testException = skip;
			throw skip;
		}

		catch (Exception e) {
			String imagePath = Utility.takeScreenshot(driver, testCaseID);
			Utility.testResult.setFailedScreenShotReference(imagePath);
			HtmlReportUtil.stepError(testCaseID, e);
			Utility.testException = e;
			HtmlReportUtil.attachScreenshot(imagePath);
			throw e;
       }
		
		finally
		{
			if(logout_flag)
			{
			 executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
			 executeStep(click(Common.logout, Constants.Common.type_xpath), getClass(), "Click on logout button");
			
		}
		
		
	}
	
	}
	
	

	@AfterMethod
	public void afterTest(ITestResult testResult) {
		Utility.resettData();

	}
}