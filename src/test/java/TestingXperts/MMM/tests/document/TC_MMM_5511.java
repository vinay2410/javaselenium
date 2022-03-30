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
public class TC_MMM_5511 extends KeywordUtil {
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
		try {
			executionDelay(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test_TC_MMM_5511() throws Exception {
		

		HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			
			System.out.println("************************---Starting Test---:" + testCaseID+"************************");

			
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			//login to application
			executeStep(writeInInput(Common.username_input, Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Common.login_btn, Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Common.answer_input, Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Common.submit_btn, Common.type_xpath), getClass(), "Click on submit Button");
			executionDelay(10000);
			executeStep(isWebElementPresent(MMM_userRoles.membership_management_span, Constants.Common.type_xpath), getClass(),"verify that user redirect to Membership management page");

			//search desired user and navigates to documents tab
			executeStep(writeInInput(documents.search_input, Common.type_xpath, getdatafromXls(testCaseID, "searched_user", row)),getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(5000);
			executeStep(click(services.searched_user_lnk, Common.type_xpath), getClass(), "Click on Searched User link");
			executionDelay(5000);
			executeStep(isWebElementPresent(documents.profile_active_tab, Constants.Common.type_xpath), getClass(),"verify profile tab is active");
			executionDelay(5000);
			executeStep(click(documents.documment_tab, Common.type_xpath), getClass(), "Click on document tab");
			executionDelay(5000);
		    executeStep(click(documents.all_document_link, Common.type_xpath), getClass(), "Click on all documents link");
			executeStep(isWebElementPresent(documents.document_cons, Constants.Common.type_xpath), getClass(),"verify that document Cons Hematology/Oncology is present");
			
			//click on upload button and verify fields
			executeStep(click(documents.upload_btn, Common.type_xpath), getClass(), "Click on Upload Button");
			executionDelay(8000);
        	executeStep(isWebElementPresent(documents.document1_tab, Common.type_xpath), getClass(), "Verify that New Tab Document is present");
        	executeStep(isWebElementPresent(Common.save_btn, Constants.Common.type_xpath), getClass(),"verify that save button is present");
         	executeStep(isWebElementPresent(documents.upload_document_header,Common.type_xpath), getClass(),"verify that upload document header is present");
         	executeStep(verifyCurrentDateInput(documents.service_date_input,Common.type_xpath), getClass(),"verify that service date input is present with current date");
         	executeStep(isWebElementPresent(documents.service_date_cal_icon,Common.type_xpath), getClass(),"verify that service date calender is present");
         	executeStep(isWebElementPresent(documents.document_browse_btn,Common.type_xpath), getClass(),"verify document upload browse button is present");
         	executeStep(isWebElementPresent(documents.document_type_select,Common.type_xpath), getClass(),"verify document type drop down is present");
         	executeStep(isWebElementPresent(documents.maximum_size_info,Common.type_xpath), getClass(),"verify Maximum size info is present");
         	executeStep(isWebElementPresent(documents.allowed_file_type,Common.type_xpath), getClass(),"verify Allowed File format info is present");
            executeStep(writeInInput(documents.service_date_input, Common.type_xpath, getdatafromXls(testCaseID, "date", row)),getClass(), "Enter a valid date 12/12/2014 in date input");
            executionDelay(2000);
            executeStep(isWebElementNotPresent(documents.invalid_date_error,Common.type_xpath), getClass(),"verify invalid date error message is not present");
         	executeStep(selectList(documents.document_type_select, Common.type_xpath,getdatafromXls(testCaseID, "document_type", row)),getClass(), "Select option: " +getdatafromXls(testCaseID, "document_type", row) +"for documnet type Field");
         	executeStep(verifyDropdownSelectedValue(documents.document_type_select, Common.type_xpath,getdatafromXls(testCaseID, "document_type", row)),getClass(), "Verify that option: " +getdatafromXls(testCaseID, "document_type", row) +"is selected for Document Type drop down Field");
			executeStep(validateNotesInput(documents.notes_textarea,Common.type_xpath,documents.notes_error_msg), getClass(),"verify Notes input with invaild data");
			
			//upload invalid document
			executeStep(uploadFilesUsingSendKeys(Constants.services.file_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "uploadFilePath", row)),getClass(), "Select invalid Document to upload ");
			executionDelay(10000);
         	executeStep(isWebElementPresent(documents.invalid_file_format_error,Common.type_xpath), getClass(),"verify File format is incorrect error message is present");
        	
         	//upload valid document
         	executeStep(uploadFilesUsingSendKeys(Constants.services.file_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "test_pdf", row)),getClass(), "Select valid Document to upload ");
			executionDelay(15000);
         	executeStep(isWebElementNotPresent(documents.invalid_file_format_error,Common.type_xpath), getClass(),"verify File format is incorrect error message is not present");

         	//click on close button and press no button of alert
         	executeStep(click(documents.document_1_x_icon, Common.type_xpath), getClass(), "Click on x icon of document 1");
			executionDelay(5000);
			executeStep(isWebElementPresent(documents.upload_doc_alert,Common.type_xpath), getClass(),"verify alert message Are you sure you want to close the Load New Document screen without upload a document? is present");
			executeStep(click(Common.no_btn, Common.type_xpath), getClass(), "Click on No Button");
			executionDelay(2000);
			executeStep(isWebElementPresent(documents.upload_document_header,Common.type_xpath), getClass(),"verify that upload document header is present");
			
			//click on close button and press yes button of alert
			executeStep(click(documents.document_1_x_icon, Common.type_xpath), getClass(), "Click on x icon of document 1");
			executionDelay(5000);
			executeStep(click(Common.yes_btn, Common.type_xpath), getClass(), "Click on Yes Button");
			executeStep(isWebElementPresent(documents.document_active_tab,Common.type_xpath), getClass(),"verify application navigates to document tab");

			// upload and save socument and verify
         	executeStep(click(documents.upload_btn, Common.type_xpath), getClass(), "Click on Upload Button");
			executionDelay(8000);
         	executeStep(writeInInput(documents.service_date_input, Common.type_xpath, getdatafromXls(testCaseID, "date", row)),getClass(), "Enter a valid date 12/12/2014 in date input");
         	executeStep(selectList(documents.document_type_select, Common.type_xpath,getdatafromXls(testCaseID, "document_type", row)),getClass(), "Select option: " +getdatafromXls(testCaseID, "document_type", row) +"for documnet type Field");
         	executeStep(uploadFilesUsingSendKeys(Constants.services.file_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "test_pdf", row)),getClass(), "Select valid Document to upload ");
			executionDelay(15000);
			executeStep(click(Common.save_btn, Common.type_xpath), getClass(), "Click on save Button");
			executionDelay(15000);
			executeStep(click(documents.care_older_x_icon, Common.type_xpath), getClass(), "Click on X Button");
         	executionDelay(15000);
         	executeStep(isWebElementPresent(documents.added_doc_link,Common.type_xpath), getClass(),"verify document gets uploaded");


         	
			
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
		finally{
			
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