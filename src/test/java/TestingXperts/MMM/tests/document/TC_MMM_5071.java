package TestingXperts.MMM.tests.document;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestNGListeners.*;

import TestingXperts.MMM.tests.objects.Constants.MMM_userRoles;
import TestingXperts.MMM.tests.objects.Constants.documents;
import TestingXperts.MMM.tests.objects.Constants.services;
import Utilities.ExcelDataUtil;

import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.*;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.Utility;
import Utilities.TestData;
import Utilities.TestResults;

@Listeners(CustomListener.class)
public class TC_MMM_5071 extends KeywordUtil {
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
	public void test_TC_MMM_5071() throws Exception {

		HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);

			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "username", row)), getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "password", row)), getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "answer", row)), getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(),"Click on submit Button");
			executionDelay(15000);
			
			executeStep(click(Common.group_icon, Constants.Common.type_xpath), getClass(), "Click on group icon Button");
			executionDelay(5000);

			executeStep(click(Common.group_beneficiary_search_lnk, Constants.Common.type_xpath), getClass(), "Click on beneficiary search Button");
			
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "searched_user", row)),getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(5000);
			executeStep(click(services.searched_user_lnk, Common.type_xpath), getClass(), "Click on Searched User link");
			executionDelay(5000);
			executeStep(click(documents.documment_tab, Common.type_xpath), getClass(), "Click on document tab");
			executionDelay(5000);
			
			executeStep(click(documents.all_document_link, Common.type_xpath), getClass(), "Click on All document tab");

			executionDelay(5000);

			
			
			executeStep(click(services.advancedFilterIcon, Common.type_xpath), getClass(), "Click on advance search icon Button");
			executionDelay(1000);
			
			executeStep(isWebElementPresent(documents.expended_advance_search, Common.type_xpath), getClass(),"Verify that expanded advanced search is present");
			
			
			
			executeStep(isWebElementPresent(documents.document_type_search_select, Common.type_xpath), getClass(),"Verify that Document Type drop down is present");

			executeStep(verifyDropdownSelectedValue(documents.document_type_search_select, Common.type_xpath,getdatafromXls(testCaseID, "All", row)),getClass(), "Verify that option: " +getdatafromXls(testCaseID, "All", row) +"is selected for Document Type drop down Field");

			executeStep(isWebElementPresent(documents.document_status_select, Common.type_xpath), getClass(),"Verify that Document Status drop down is present");

			executeStep(verifyDropdownSelectedValue(documents.document_status_select, Common.type_xpath,getdatafromXls(testCaseID, "All", row)),getClass(), "Verify that option: " +getdatafromXls(testCaseID, "All", row) +"is selected for Document Type drop down Field");

			executeStep(isWebElementPresent(documents.service_date_range_start_input, Common.type_xpath), getClass(),"Verify that Service Date Range from input is present with calender icon");

			executeStep(isWebElementPresent(documents.service_date_range_end_input, Common.type_xpath), getClass(),"Verify that Service Date Range to input is present with calender icon");

			executeStep(isWebElementPresent(documents.list_view_from_input, Common.type_xpath), getClass(),"Verify that Last View Date Range from input is present with calender icon");

			executeStep(isWebElementPresent(documents.list_view_to_input, Common.type_xpath), getClass(),"Verify that Last View Date Range to input is present with calender icon");

			executeStep(isWebElementPresent(documents.upload_from_input, Common.type_xpath), getClass(),"Verify that Upload Date Range from input is present with calender icon");

			executeStep(isWebElementPresent(documents.upload_to_input, Common.type_xpath), getClass(),"Verify that Upload Date Range to input is present with calender icon");

			executeStep(selectList(services.document_type_search_select, Common.type_xpath,getdatafromXls(testCaseID, "document_type", row)),getClass(), "Select option: " +getdatafromXls(testCaseID, "document_type", row) +"for documnet type Field");

			executeStep(click(services.advancedFilterIcon, Common.type_xpath), getClass(), "Click on advance search icon Button");
			executionDelay(2000);
			executeStep(isWebElementPresent(documents.expended_collapse_search, Common.type_xpath), getClass(),"Verify that advanced search gets collapse");
			
			executeStep(isWebElementPresent(documents.documnet_ckd_type, Common.type_xpath), getClass(),"Verify that documnet of type CKD Clinic Initial Visit is present");
			
			executeStep(click(services.advancedFilterIcon, Common.type_xpath), getClass(), "Click on advance search icon Button");
			executionDelay(2000);
			executeStep(click(services.beneficiary_search_btn, Common.type_xpath), getClass(), "Click on search Button");
			executionDelay(5000);

			executeStep(isWebElementPresent(documents.applied_filter_label, Common.type_xpath), getClass(),"Verify that Document Type: Cons Hematology/Oncology is present");
			executeStep(isWebElementPresent(documents.documnet_Cons_type, Common.type_xpath), getClass(),"Verify that documnet of type Cons Hematology/Oncology is present");

			executeStep(isWebElementNotPresent(documents.documnet_ckd_type, Common.type_xpath), getClass(),"Verify that documnet of type CKD Clinic Initial Visit is not present");
			
			
			
			
		}

		catch (SkipException skip) {
			Utility.testException = skip;
			//throw skip;
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