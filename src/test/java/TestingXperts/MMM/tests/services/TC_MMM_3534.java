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
public class TC_MMM_3534 extends KeywordUtil {
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
	public void test_TC_MMM_3534() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			
			
			//Check Home Page details and Fill required Fields
			executeStep(isWebElementPresent(MMM_login.welcome_header, Common.type_xpath), getClass(),"Welcome to InnovaMD is present");
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username "+"'"+getdatafromXls(testCaseID, "username", row)+"'");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password "+"'"+getdatafromXls(testCaseID, "password", row)+"'");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			
			//Fill in the security questions
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer "+"'"+getdatafromXls(testCaseID, "answer", row)+"'");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			executionDelay(15000);
			
			//Enter Benficiary Name
			executeStep(writeInInput(Constants.services.benficiaryInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "beneficiary", row)),getClass(), "Enter beneficiary name"+getdatafromXls(testCaseID, "beneficiary", row));
			executeStep(click(Constants.services.beneficiary_search_btn, Constants.Common.type_xpath), getClass(), "Click on beneficiary search button");
			executeStep(isWebElementPresent(Constants.services.beneficiarySearchResults, Common.type_xpath), getClass(),"Check for the beneficiary "+"'"+getdatafromXls(testCaseID, "benefieciery", row)+"'");
			executionDelay(3000);
			executeStep(selectList(Constants.services.advanceFilter, Constants.Common.type_xpath,getdatafromXls(testCaseID, "filter", row)), getClass(), "Choose "+"'"+getdatafromXls(testCaseID, "filter", row)+"from filter"+"'");
			executionDelay(3000);
			executeStep(isWebElementPresent(Constants.services.beneficiaryFilterResults, Constants.Common.type_xpath), getClass(), "Check for the beneficiary results");
			executeStep(click(Constants.services.beneficiarySearchResults, Common.type_xpath), getClass(),"Click on beneficiary "+"'"+getdatafromXls(testCaseID, "benefieciery", row)+"'");
			
			
			//check for the service page fields
			executeStep(click(Constants.services.services_tab, Common.type_xpath), getClass(),"Click on the services tab");
			executeStep(isWebElementPresent(Constants.services.activeServicesTab, Common.type_xpath), getClass(),"Service page is displayed.");
			executeStep(click(Constants.services.create_icon, Common.type_xpath), getClass(),"Click on the create icon.");
			
			
			//select NPI billing and click on next
			executeStep(selectList(Constants.services.ddBillingNPI, Constants.Common.type_xpath,getdatafromXls(testCaseID, "BillingNPI", row)), getClass(), "Choose "+"'"+getdatafromXls(testCaseID, "BillingNPI", row)+"'"+"from Billing NPI dropdown");
			executionDelay(3000);
			executeStep(click(Constants.Common.next_btn, Common.type_xpath), getClass(),"Click on the next button");
			
			
			//check for the diagnoses tab
			executeStep(isWebElementPresent(Constants.services.activeDiagnosesTab, Common.type_xpath), getClass(),"Diagnosis tab is selected.");
			executeStep(isWebElementPresent(Constants.services.diagnoses_header, Common.type_xpath), getClass(),"Diagnosis page is displayed.");
			
			//Adding 1st diagnoses
			executionDelay(2000);
			executeStep(writeInInput(Constants.services.diagnosesInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "Diagnosis1", row)),getClass(), "Enter diagnoses "+"'"+getdatafromXls(testCaseID, "Diagnosis1", row)+"'");
			
			executeStep(click(Constants.services.btnAddDiagnoseProcedure, Common.type_xpath), getClass(),"Click on the first diagnoses add button");
			executeStep(isWebElementPresent(Constants.services.addedDiagnosesDarkGreenCheck, Common.type_xpath), getClass(),"Added Diagnoses under Grid is of dark green check");
			
			//Adding 2nd diagnoses
			executeStep(writeInInput(Constants.services.diagnosesInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "Diagnosis2", row)),getClass(), "Enter diagnoses "+"'"+getdatafromXls(testCaseID, "Diagnosis2", row)+"'");
			executeStep(click(Constants.services.btnAddDiagnoseProcedure, Common.type_xpath), getClass(),"Click on the second diagnoses add button");
			executeStep(isWebElementPresent(Constants.services.addedDiagnosesLightGreenCheck, Common.type_xpath), getClass(),"Added Diagnoses under Grid is of light green check");
			
			//check for the Procedure page field displayed
			executeStep(click(Constants.Common.next_btn, Common.type_xpath), getClass(),"Click on the next button");
			executeStep(isWebElementPresent(Constants.services.activeProceduredTab, Common.type_xpath), getClass(),"Procedures tab is selected");
			executeStep(isWebElementPresent(Constants.services.hdrProcedure, Common.type_xpath), getClass(),"Procedures page is displayed");
			executeStep(click(Constants.services.selectServiceType, Common.type_xpath), getClass(),"Select Service Type");
			
			//Adding 1st procedure
			
			executeStep(writeInInputCharByChar(Constants.services.inputProcedure, Constants.Common.type_xpath, getdatafromXls(testCaseID, "Procedures", row)),getClass(), "Enter Procedures "+"'"+getdatafromXls(testCaseID, "Procedures", row)+"'");
			executionDelay(2000);
			executeStep(click(Constants.services.btnAddDiagnoseProcedure, Common.type_xpath), getClass(),"Click on the first Procedures add button");
			executeStep(isWebElementPresent(Constants.services.rha160_green_tick, Common.type_xpath), getClass(),"Added Procedures under Grid is of green color");
			

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