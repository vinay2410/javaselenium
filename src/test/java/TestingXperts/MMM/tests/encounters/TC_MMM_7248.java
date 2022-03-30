package TestingXperts.MMM.tests.encounters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestNGListeners.*;
import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.*;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.Utility;
import Utilities.TestData;
import Utilities.TestResults;

@Listeners(CustomListener.class)
public class TC_MMM_7248 extends KeywordUtil {
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
		
		System.out.println("test case id is "+testCaseID);
		
        Utility.testData = new TestData();
		Utility.testResult = new TestResults();
		Utility.testData = ExcelDataUtil.getTestDataWithTestCaseID(testCaseID);
		Utility.testResult.setDateOfExecution(Utility.getDateTime());
		LogUtil.infoLog(getClass(), "Test Started:" + testCaseID);
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();
		
	}
	@Test
	public void test_TC_MMM_7248() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			System.out.println("value of test case id "+testCaseID);
			
			HtmlReportUtil.stepInfo(logStep);
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "username", row)), getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "password", row)), getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "answer", row)), getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(),"Click on submit Button");
			executionDelay(15000);
			executeStep(writeInInput(documents.search_input, Common.type_xpath,getdatafromXls(testCaseID, "searched_user", row)), getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(8000);
			executeStep(click(services.searched_carmen_user_lnk, Common.type_xpath), getClass(),"Click on Searched User link");
			executionDelay(5000);
			executeStep(click(encounter.encounters_tab, Common.type_xpath), getClass(),"Click on the Encounter tab");
			executionDelay(5000);
			executeStep(click(Constants.services.create_icon, Common.type_xpath), getClass(),"Click on the Create icon.");
			executionDelay(5000);
			executeStep(click(Constants.services.discharge_summary, Common.type_xpath), getClass(),"Click on the discharge summary link.");
			executionDelay(3000);
			executeStep(isWebElementPresent(Constants.services.new_encounter1_tab, Common.type_xpath), getClass(),"Verify that Encounter 1 tab gets opened");
			executeStep(selectList(services.referedBy_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "refered_by", row)),getClass(),"Choose " + "'" + getdatafromXls(testCaseID, "refered_by", row) + "from drop down" + "'");
			executeStep(selectList(services.facility_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "facility", row)),getClass(), "Choose " + "'" + getdatafromXls(testCaseID, "facility", row) + "from drop down" + "'");
			executeStep(selectList(services.treating_physcian_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "facility", row)),getClass(), "Choose " + "'" + getdatafromXls(testCaseID, "facility", row) + "from drop down" + "'");
			
			
			executeStep(click(Constants.encounter.procedure_sidemenu_lnk, Common.type_xpath), getClass(),"Click on procedures sidemenu link.");
			executionDelay(5000);
			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath,getdatafromXls(testCaseID, "procedure_1", row)), getClass(), "Enter a0021 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executionDelay(2000);
			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "procedure_2", row)),getClass(), "Enter l1270 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executionDelay(2000);
			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "procedure_3", row)),getClass(), "Enter L1630 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executionDelay(2000);
			executeStep(click(services.hdrProcedure, Common.type_xpath), getClass(),"Click on Procedure header");
			executionDelay(3000);
			
			
			executeStep(click(encounter.a0021_delete_icon, Common.type_xpath), getClass(), "Click on delete button for A0021");
			executionDelay(2000);
			executeStep(isWebElementNotPresent(encounter.a0021_delete_icon, Common.type_xpath), getClass(),"Verify that A0021 is not present");
			
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