package TestingXperts.MMM.tests.login;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestNGListeners.*;
import TestNGListeners.*;
import TestingXperts.MMM.tests.objects.Constants.*;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.Utility;
import Utilities.TestData;
import Utilities.TestResults;
import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.*;

@Listeners(CustomListener.class)
public class TC_MMM_4630 extends KeywordUtil {
	String suiteName = GetValue("suiteName");
	public List<String[]> errLogs = new ArrayList<String[]>();
	boolean isRun;
	boolean check = true;
	boolean status = true;
	String expected = "NA", actual = "NA";
	String logStep;
	String testCaseID = getClass().getSimpleName();
	int row = 1;
	boolean logout_flag = true;
	@BeforeMethod
	public void beforeTest() {
        Utility.testData = new TestData();
		Utility.testResult = new TestResults();
		Utility.testData = ExcelDataUtil.getTestDataWithTestCaseID(testCaseID);
		Utility.testResult.setDateOfExecution(Utility.getDateTime());
		LogUtil.infoLog(getClass(),"**********************Test Started:" + testCaseID +"*************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();

	}

	@Test
	public void test_TC_MMM_4630() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			executeStep(writeInInput(Common.username, Constants.Common.type_name, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			/*executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
		    executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
		   //executionDelay(5000);

		    executeStep(isWebElementPresent(MMM_userRoles.membership_management_span, Constants.Common.type_xpath), getClass(),"verify that user redirect to Membership management page");
			executeStep(isWebElementPresent(MMM_userRoles.beneficiary_male_icon, Constants.Common.type_xpath), getClass(),"verify that beneficiaries present on the page");
			executeStep(isWebElementNotPresent(MMM_userRoles.PCP_header, Constants.Common.type_xpath), getClass(),"verify that PCP header is present on the page");
			executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
			executeStep(click(MMM_userRoles.group_admin_role, Constants.Common.type_xpath), getClass(), "Select Group Admin Role");
			executeStep(click(Constants.Common.ok_btn, Constants.Common.type_xpath), getClass(), "Click on OK button of alert");
		executionDelay(8000);
		//	executeStep(click(MMM_userRoles.family_med_group, Constants.Common.type_xpath), getClass(), "Select Family Medicine Group");
		//	executeStep(isWebElementPresent(MMM_userRoles.user_icon, Constants.Common.type_xpath), getClass(),"verify that PCP user is present on the page");
	//		executeStep(isWebElementPresent(MMM_userRoles.PCP_header, Constants.Common.type_xpath), getClass(),"verify that PCP header is present on the page");
			executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
			executeStep(click(Common.logout, Constants.Common.type_xpath), getClass(), "Click on logout button");
			executeStep(isWebElementPresent(MMM_login.welcome_header, Common.type_xpath), getClass(),"Welcome to InnovaMD is present");*/
			logout_flag=false;
			
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