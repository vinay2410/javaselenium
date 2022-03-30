package TestingXperts.MMM.tests.beneficiarySearch;

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
public class TC_MMM_4562 extends KeywordUtil {
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
		
		navigate();

	
	
	}

	@Test
	public void test_TC_MMM_4562() throws Exception {

		HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);

			
			executeStep(writeInInput(Constants.Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Constants.Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Constants.Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(8000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			executionDelay(10000);
			executeStep(click(Constants.BeneficiarySearch.advance_search_arrow, Constants.Common.type_xpath), getClass(), "Click on Adavance Search Button");
			executeStep(verifyAllVauesOfDropDown(Constants.BeneficiarySearch.biling_npi_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "biling npi", row)),getClass(), "Verify that The Billing NPI drop drown display two options: All, 1214929005");
		
			executeStep(click(Constants.BeneficiarySearch.shared_benefic_lnk, Constants.Common.type_xpath), getClass(), "Click on Shared Beneficiaries ]");
			executionDelay(8000);
			executeStep(click(Constants.BeneficiarySearch.advance_search_arrow, Constants.Common.type_xpath), getClass(), "Click on Adavance Search Button");
			executeStep(verifyAllVauesOfDropDown(Constants.BeneficiarySearch.pcp_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "PCP Option", row)),getClass(), "Verify values of PCP Select");
			
			executeStep(click(Constants.BeneficiarySearch.all_benefic_lnk, Constants.Common.type_xpath), getClass(), "Click on All Beneficiaries ]");
			executionDelay(5000);
			executeStep(click(Constants.BeneficiarySearch.advance_search_arrow, Constants.Common.type_xpath), getClass(), "Click on Adavance Search Button");
			executeStep(verifyAllVauesOfDropDown(Constants.BeneficiarySearch.pcp_select, Constants.Common.type_xpath,getdatafromXls(testCaseID, "PCP All options", row)),getClass(), "Verify values of PCP Select");
		
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