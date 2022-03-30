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
public class TC_MMM_4760 extends KeywordUtil {
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
		LogUtil.infoLog(getClass(), "**********************Test Started:" + testCaseID +"*************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();


	}

	@Test
	public void test_TC_MMM_4760() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			executionDelay(15000);
			
			
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "searched_user", row)),getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(8000);
			executeStep(click(services.searched_carmen_user_lnk, Common.type_xpath), getClass(), "Click on Searched User link");
			executionDelay(5000);
			executeStep(isWebElementPresent(documents.profile_active_tab, Constants.Common.type_xpath), getClass(),"verify profile tab is active");
			
			executeStep(click(services.services_tab, Common.type_xpath), getClass(), "Click on Services tab");
			executionDelay(10000);
			executeStep(click(Common.create_btn, Common.type_xpath), getClass(), "Click on create button");
			executeStep(isWebElementPresent(services.requesting_provider_header, Constants.Common.type_xpath), getClass(),"The Requesting Pages is open.");
			
			executeStep(selectList(services.biling_npi_select, Common.type_xpath,getdatafromXls(testCaseID, "biling npi_option1", row)),getClass(), "Select option: " +getdatafromXls(testCaseID, "biling npi_option1", row) +"for Biling NPI Field");
			executionDelay(3000);
			
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");

			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "Diagnoses", row)),getClass(), "Enter AA COUNSEL SURVEILLANCE ALCOHOLIC in search field");
			executionDelay(3000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
 
			executeStep(click(services.ccm, Common.type_xpath), getClass(), "Click on Coordinated Care Management option");
			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "Procedure", row)),getClass(), "Enter A0021 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executionDelay(5000);
			executeStep(click(services.select_green_tick, Common.type_xpath), getClass(), "Select service provider");
			executionDelay(3000);
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executionDelay(5000);

			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			
			
			executeStep(click(Common.submit_btn,Common.type_xpath), getClass(), "Click on submit Button");

			executeStep(isWebElementPresent(services.service_submit_confirmation_alert, Constants.Common.type_xpath), getClass(),"Verify that Service Submit Confirmation alert is present");
			executeStep(click(Common.yes_btn, Common.type_xpath), getClass(), "Click on Yes Button");
			executionDelay(3000);
			executeStep(isWebElementPresent(services.service_submit_response_alert, Constants.Common.type_xpath), getClass(),"Verify that Service Submit response alert is present");
			executeStep(click(Common.no_btn, Common.type_xpath), getClass(), "Click on No Button");
			executeStep(isWebElementPresent(Common.save_btn, Common.type_xpath), getClass(),"Verify that Save button is present");
			
			executeStep(isWebElementPresent(Common.print_btn, Common.type_xpath), getClass(),"Verify that Print button is present");
			
			executeStep(isWebElementPresent(Common.cancel_btn, Common.type_xpath), getClass(),"Verify that Cancel button is present");
			
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
		
		/*finally
		{
			if(logout_flag)
			{
			 executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
			 executeStep(click(Common.logout, Constants.Common.type_xpath), getClass(), "Click on logout button");
			
		}	
		
	}*/
		
	}

	@AfterMethod
	public void afterTest(ITestResult testResult) {
		Utility.resettData();
		
		if(logout_flag)
		{
		 try {
			executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
		
			executeStep(click(Common.logout, Constants.Common.type_xpath), getClass(), "Click on logout button");
			
			executionDelay(5000);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}		

	}
}