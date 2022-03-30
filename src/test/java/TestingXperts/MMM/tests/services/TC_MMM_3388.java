package TestingXperts.MMM.tests.services;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.CustomListener;
import TestingXperts.MMM.tests.objects.Constants.Common;
import TestingXperts.MMM.tests.objects.Constants.MMM_login;
import TestingXperts.MMM.tests.objects.Constants.MMM_userRoles;
import TestingXperts.MMM.tests.objects.Constants.documents;
import TestingXperts.MMM.tests.objects.Constants.services;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.TestData;
import Utilities.TestResults;
import Utilities.Utility;
import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.*;
@Listeners(CustomListener.class)
public class TC_MMM_3388 extends KeywordUtil {
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
		LogUtil.infoLog(getClass(), "**********************Test Started:" + testCaseID +"*************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();

	}

	@Test
	public void test_TC_MMM_3388() throws Exception {
                HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			
			//login to website
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(8000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			executionDelay(15000);
			executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(), "Click on Profile image");
			executeStep(click(MMM_userRoles.group_admin_role, Constants.Common.type_xpath), getClass(), "Select Group Admin Role");
			executeStep(click(Constants.Common.ok_btn, Constants.Common.type_xpath), getClass(), "Click on OK button of alert");
			executionDelay(5000);
			executeStep(click(MMM_userRoles.family_med_group, Constants.Common.type_xpath), getClass(), "Select Family Medicine Group");

			//search required user
			executeStep(click(services.beneficiary_tab_lnk, Common.type_xpath), getClass(), "Click on Beneficiary tab link");
			executionDelay(5000);
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "searched_user", row)),getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(5000);
			executeStep(click(services.ghp_userLink, Common.type_xpath), getClass(), "Click on Searched User link");
			executionDelay(5000);
			executeStep(isWebElementPresent(documents.profile_active_tab, Constants.Common.type_xpath), getClass(),"verify profile tab is active");
			
			//create a new service, add a requesting provider
			executeStep(click(services.services_tab, Common.type_xpath), getClass(), "Click on Services tab");
			executionDelay(10000);
			executeStep(click(Common.create_btn, Common.type_xpath), getClass(), "Click on create button");
			
			//Adding 1st diagnoses
			executeStep(isWebElementPresent(Constants.services.activeDiagnosesTab, Common.type_xpath), getClass(),"Diagnosis tab is selected.");
			executeStep(isWebElementPresent(Constants.services.diagnoses_header, Common.type_xpath), getClass(),"Diagnosis page is displayed.");
			executionDelay(2000);
			executeStep(writeInInput(Constants.services.diagnosesInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "Diagnosis1", row)),getClass(), "Enter diagnoses "+"'"+getdatafromXls(testCaseID, "Diagnosis1", row)+"'");
			executeStep(click(Constants.services.btnAddDiagnoseProcedure, Common.type_xpath), getClass(),"Click on the first diagnoses add button");
			executeStep(isWebElementPresent(Constants.services.addedDiagnosesDarkGreenCheck, Common.type_xpath), getClass(),"Added Diagnoses under Grid is of dark green check");
			
			
	     	//add procedure
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executeStep(isWebElementPresent(Constants.services.activeProceduredTab, Common.type_xpath), getClass(),"Procedures tab is selected");
			executeStep(isWebElementPresent(Constants.services.hdrProcedure, Common.type_xpath), getClass(),"Procedures page is displayed");
			executeStep(click(services.ccm, Common.type_xpath), getClass(), "Click on Coordinated Care Management option");
			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "Procedure", row)),getClass(), "Enter A0021 in search field");
			executionDelay(2000);
			executeStep(click(Constants.services.btnAddDiagnoseProcedure, Common.type_xpath), getClass(),"Click on the first Procedures add button");
			executeStep(isWebElementPresent(Constants.services.addedprocedure, Common.type_xpath), getClass(),"Added Procedures under Grid is of orange color");
			executionDelay(3000);
			executeStep(click(services.hdrProcedure, Common.type_xpath), getClass(),"Click on Procedure header");
			executionDelay(3000);
			
			//add service provider
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executionDelay(5000);
			
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "service_provider", row)),getClass(), "Enter searched sp name");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(5000);
			executeStep(click(services.sp_ambulance_plus_icon, Common.type_xpath), getClass(), "Click on add Button");
			executionDelay(3000);
			executeStep(click(Common.next_btn, Common.type_xpath), getClass(), "Click on next button");
			executionDelay(5000);
			// Verify addtional information
			executeStep(isWebElementPresent(services.documnet_title_field, Common.type_xpath), getClass(),"verify that title Additional Information is present");
            executeStep(isWebElementPresent(services.documnet_instruction, Common.type_xpath), getClass(),"verify that Provide the corresponding Additional Information for this request is present");
			executeStep(isWebElementPresent(services.selected_standard_btn, Common.type_xpath), getClass(),"verify that selected Standard button is present");
			executeStep(isWebElementPresent(services.expedite_btn, Common.type_xpath), getClass(),"verify that expedite button is present");
			executeStep(isWebElementPresent(services.document_headers, Common.type_xpath), getClass(),"verify columns: Type, File, Required, Remove is present");
			executeStep(isWebElementPresent(services.other_browser_btn, Common.type_xpath), getClass(),"verify browse button is present with other field");
			executeStep(isWebElementPresent(services.other_create_btn, Common.type_xpath), getClass(),"verify create button is present with other field");
			executeStep(isWebElementPresent(services.other_delete_btn, Common.type_xpath), getClass(),"verify  delete button is present with other field");
			executeStep(isWebElementPresent(services.add_document_btn, Common.type_xpath), getClass(),"verify  add document button is present.");
			executeStep(click(services.notes_btn, Common.type_xpath), getClass(), "Click on Notes tab Button");
			executeStep(isWebElementPresent(services.add_note, Common.type_xpath), getClass(),"verify  add note button is present.");

			
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