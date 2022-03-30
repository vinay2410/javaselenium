package TestingXperts.MMM.tests.smartPP;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestNGListeners.CustomListener;
import TestingXperts.MMM.tests.objects.Constants;
import TestingXperts.MMM.tests.objects.Constants.Common;
import TestingXperts.MMM.tests.objects.Constants.MMM_userRoles;
import TestingXperts.MMM.tests.objects.Constants.smartPaper;
import Utilities.ExcelDataUtil;
import Utilities.HtmlReportUtil;
import Utilities.KeywordUtil;
import Utilities.LogUtil;
import Utilities.TestData;
import Utilities.TestResults;
import Utilities.Utility;

@Listeners(CustomListener.class)
public class TC_MMM_2678 extends KeywordUtil {
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
	public void test_TC_MMM_2678() throws Exception {

		HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);

			//login user
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "username", row)), getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "password", row)), getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath,getdatafromXls(testCaseID, "answer", row)), getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(),"Click on submit Button");
			executionDelay(15000);
			
			executeStep(isWebElementPresent(MMM_userRoles.membership_management_span, Constants.Common.type_xpath), getClass(), "Application shows the Membership Management page.");
			executeStep(click(smartPaper.sharedBeneficiaryLnk, Constants.Common.type_xpath), getClass(), "Click on shared benefiaciary link");
			executeStep(writeInInput(Constants.services.benficiaryInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "beneficiary", row)),getClass(), "Enter beneficiary name "+"'"+getdatafromXls(testCaseID, "beneficiary", row)+"'");
			executeStep(click(Constants.services.beneficiary_search_btn, Constants.Common.type_xpath), getClass(), "Click on beneficiary search button");
			executeStep(isWebElementPresent(Constants.smartPaper.beneficiaryResults, Common.type_xpath), getClass(),"Check for the beneficiary results "+"'"+getdatafromXls(testCaseID, "benefieciery", row)+"'");
			executionDelay(3000);
			executeStep(isWebElementPresent(Constants.services.beneficiaryFilterResults, Constants.Common.type_xpath), getClass(), "Check for the beneficiary results");
			executeStep(click(Constants.smartPaper.beneficiaryResults, Common.type_xpath), getClass(),"Click on beneficiary");
			
			executeStep(isWebElementPresent(Constants.smartPaper.activeProfileLink, Constants.Common.type_xpath), getClass(), "Check for the 'Profile' active Tab");
			executeStep(click(Constants.smartPaper.clinicalLink, Common.type_xpath), getClass(),"Click on 'clinical' link");
			
			//check for the PCP smart Paper
			executeStep(isWebElementPresent(Constants.smartPaper.smartPaperLink, Constants.Common.type_xpath), getClass(), "The aplication shows the 'SMART Paper report'.");
			executeStep(click(Constants.smartPaper.smartPaperSaveBtn, Common.type_xpath), getClass(),"Click on Save button");
			executeStep(isWebElementPresent(Constants.smartPaper.pcpSmartpaperEntry, Constants.Common.type_xpath), getClass(), "The Drop Down box shows the options 'PCP SMART Paper'.");
			executeStep(isWebElementPresent(Constants.smartPaper.patientSmartPaperEntry, Constants.Common.type_xpath), getClass(), "The Drop Down box shows the options 'Patient SMART Paper'");
			executeStep(click(Constants.smartPaper.pcpSmartpaperEntry, Constants.Common.type_xpath), getClass(), "Click on PCP SMART Paper.");
            Thread.sleep(8000);

            //check for the PDF data
            executeStep(verifyPDFData(getdatafromXls(testCaseID, "fileData", row),1,getdatafromXls(testCaseID, "fileName", row)), getClass(), "Pdf contains following fields: 'Beneficiary ID', ' Date of Birth', ' Gender', ' PCP', ' Name', ' Age', ' Phone', ' Eligibility Date', ' Generated by: InnovaMD',' Title: Smart Paper',' Printed On'.");
             
			
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
			delDirectory();
			executionDelay(5000);
		 } catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
}
}