package TestingXperts.MMM.tests.services;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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
public class TC_MMM_2599 extends KeywordUtil {
	String suiteName = GetValue("suiteName");
	public List<String[]> errLogs = new ArrayList<String[]>();
	boolean isRun;
	boolean check = true;
	boolean status = true;
	String expected = "NA", actual = "NA";
	String logStep;
	String testCaseID = getClass().getSimpleName();
	int row = 1;
	String URL;
	boolean logout_flag=true;

	@BeforeMethod
	public void beforeTest() {
        Utility.testData = new TestData();
		Utility.testResult = new TestResults();
		Utility.testData = ExcelDataUtil.getTestDataWithTestCaseID(testCaseID);
		Utility.testResult.setDateOfExecution(Utility.getDateTime());
		Utility.testData.setPlatform(CustomListener.platformName);
		LogUtil.infoLog(getClass(), "**********************Test Started:" + testCaseID +"*************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();
	}

	@Test
	public void test_TC_MMM_2599() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			executionDelay(8000);
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(8000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			
			executionDelay(15000);
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "searched_user", row)),getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(5000);
			executeStep(click(services.searched_carmen_user_lnk, Common.type_xpath), getClass(), "Click on Searched User link");
			executionDelay(5000);
			executeStep(isWebElementPresent(documents.profile_active_tab, Constants.Common.type_xpath), getClass(),"verify profile tab is active");
			
			executeStep(click(services.services_tab, Common.type_xpath), getClass(), "Click on Services tab");
			executionDelay(10000);
			executeStep(click(Common.create_btn, Common.type_xpath), getClass(), "Click on create button");
			executeStep(isWebElementPresent(services.requesting_provider_header, Constants.Common.type_xpath), getClass(),"The Requesting Pages is open.");
			
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executeStep(isWebElementPresent(services.requesting_provider_alert, Constants.Common.type_xpath), getClass(),"The Requesting Provider alert is present.");
			executeStep(click(Common.ok_btn, Common.type_xpath), getClass(), "Click on ok button");

			executeStep(verifyAllVauesOfDropDown(services.biling_npi_select, Common.type_xpath,getdatafromXls(testCaseID, "biling_npi", row)),getClass(), "Verify that The Billing NPI drop drown display values : " +getdatafromXls(testCaseID, "biling_npi", row));
			executeStep(selectList(services.biling_npi_select, Common.type_xpath,getdatafromXls(testCaseID, "biling npi_option1", row)),getClass(), "Select option: " +getdatafromXls(testCaseID, "biling npi_option1", row) +"for Biling NPI Field");
			executeStep(verifyDropdownSelectedValue(services.biling_npi_select, Common.type_xpath,getdatafromXls(testCaseID, "biling npi_option1", row)),getClass(), "Verify that option: " +getdatafromXls(testCaseID, "biling npi_option1", row) +"is selected for Biling NPI Field");
			executionDelay(5000);
			
			executeStep(isWebElementPresent(services.pcp_name, Constants.Common.type_xpath), getClass(),"Verify that PCP Name (kiyomi santos onoda) is present");
			executeStep(isWebElementPresent(services.pcp_female_icon, Constants.Common.type_xpath), getClass(),"Verify that Female gender icon is present");
			executeStep(isWebElementPresent(services.pcp_speciality, Constants.Common.type_xpath), getClass(),"Verify that Specialties: General Practice is present");
			executeStep(isWebElementPresent(services.location_icon, Constants.Common.type_xpath), getClass(),"Verify that location icon is present");

			executeStep(isWebElementPresent(services.pcp_name_green_tick, Constants.Common.type_xpath), getClass(),"Verify that green tick is present with PCP name");

			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executeStep(isWebElementPresent(services.diagnoses_header, Constants.Common.type_xpath), getClass(),"Verify that Diagnosis header is present");
		
	
			
			
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