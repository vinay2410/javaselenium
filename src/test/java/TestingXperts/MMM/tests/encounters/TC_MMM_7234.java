package TestingXperts.MMM.tests.encounters;

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
public class TC_MMM_7234 extends KeywordUtil {
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
	public void test_TC_MMM_7234() throws Exception {
		HtmlReportUtil.startReport(testCaseID + "-" + CustomListener.browserName, Utility.testData.getTestCaseSummary(),
				Utility.testData.getTestSet() + "-" + CustomListener.browserName);
		try {
			isRun = ExcelDataUtil.getControls(suiteName, testCaseID);

			if (!isRun)
				throw new SkipException("Skipping this exception");
			Utility.testData.setBrowser(CustomListener.browserName);
			logStep = Utility.testData.getTestCaseSummary();
			HtmlReportUtil.stepInfo(logStep);
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath,
					getdatafromXls(testCaseID, "username", row)), getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath,
					getdatafromXls(testCaseID, "password", row)), getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath,
					getdatafromXls(testCaseID, "answer", row)), getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(),
					"Click on submit Button");
			executionDelay(15000);

			executeStep(writeInInput(documents.search_input, Common.type_xpath,
					getdatafromXls(testCaseID, "searched_user", row)), getClass(), "Enter searched Username");
			executeStep(click(Common.search_btn, Common.type_xpath), getClass(), "Click on Search Button");
			executionDelay(8000);
			executeStep(click(services.searched_carmen_user_lnk, Common.type_xpath), getClass(),
					"Click on Searched User link");
			executionDelay(5000);
			executeStep(click(encounter.encounters_tab, Common.type_xpath), getClass(),
					"Click on the Encounter tab");
			executionDelay(5000);
			executeStep(click(Constants.services.create_icon, Common.type_xpath), getClass(),
					"Click on the Create icon.");
			executionDelay(5000);

			executeStep(click(Constants.services.discharge_summary, Common.type_xpath), getClass(),
					"Click on the discharge summary link.");
			executionDelay(3000);
			executeStep(isWebElementPresent(Constants.services.new_encounter1_tab, Common.type_xpath), getClass(),
					"Verify that Encounter 1 tab gets opened");

			executeStep(
					selectList(services.referedBy_select, Constants.Common.type_xpath,
							getdatafromXls(testCaseID, "refered_by", row)),
					getClass(),
					"Choose " + "'" + getdatafromXls(testCaseID, "refered_by", row) + "from drop down" + "'");
			executeStep(
					selectList(services.facility_select, Constants.Common.type_xpath,
							getdatafromXls(testCaseID, "facility", row)),
					getClass(), "Choose " + "'" + getdatafromXls(testCaseID, "facility", row) + "from drop down" + "'");
			executeStep(
					selectList(services.treating_physcian_select, Constants.Common.type_xpath,
							getdatafromXls(testCaseID, "facility", row)),
					getClass(), "Choose " + "'" + getdatafromXls(testCaseID, "facility", row) + "from drop down" + "'");

			executeStep(click(Constants.services.diagnoses_sidemenu_lnk, Common.type_xpath), getClass(),
					"Click on diagnoses sidemenu link.");

			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath,
					getdatafromXls(testCaseID, "diagnoses_e", row)), getClass(), "Enter E23.2 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");

			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath,
					getdatafromXls(testCaseID, "diagnoses_r", row)), getClass(), "Enter R00.1 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");

			executeStep(writeInInputCharByChar(documents.search_input, Common.type_xpath,
					getdatafromXls(testCaseID, "diagnoses_d", row)), getClass(), "Enter D15.1 in search field");
			executionDelay(3000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");

			executeStep(
					writeInInputCharByChar(documents.search_input, Common.type_xpath,
							getdatafromXls(testCaseID, "diagnoses_z", row)),
					getClass(), "Enter Z95.811 in search field");
			executionDelay(2000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");

			executeStep(click(Constants.services.diagnoses_sidemenu_lnk, Common.type_xpath), getClass(),
					"Click on diagnoses sidemenu link.");

			executionDelay(5000);

			executeStep(isWebElementPresent(services.diagnoses_added_e, Constants.Common.type_xpath), getClass(),
					"Verify that diagnose E23.2 gets added ");
			executeStep(isWebElementPresent(services.diagnoses_added_r, Constants.Common.type_xpath), getClass(),
					"Verify that diagnose R00.1 gets added");
			executeStep(isWebElementPresent(services.diagnoses_added_z, Constants.Common.type_xpath), getClass(),
					"Verify that diagnose Z95.811 gets added");
			executeStep(isWebElementPresent(services.diagnoses_d15_1_remove_img, Constants.Common.type_xpath),
					getClass(), "Verify that diagnose D15.1 gets added");

			executeStep(click(services.diagnoses_d15_1_remove_img, Common.type_xpath), getClass(),
					"Click on remove icon for D15.1");
			executeStep(isWebElementNotPresent(services.diagnoses_d15_1_remove_img, Common.type_xpath), getClass(),
					"Verify that D15.1 is Not present");

			executeStep(
					writeInInputCharByChar(documents.search_input, Common.type_xpath,
							getdatafromXls(testCaseID, "diagnoses_2d", row)),
					getClass(), "Enter D15.9 in search field");
			executionDelay(5000);
			executeStep(click(Common.add_btn, Common.type_xpath), getClass(), "Click on plus icon button");
			executeStep(isWebElementPresent(services.diagnoses_added_d2, Constants.Common.type_xpath), getClass(),
					"Verify that diagnose D15.9 gets added");

			executeStep(click(Constants.services.diagnoses_sidemenu_lnk, Common.type_xpath), getClass(),
					"Click on diagnoses sidemenu link.");

			executionDelay(5000);
			executeStep(click(services.diagnoses_added_r_primary_rb, Common.type_xpath), getClass(),
					"Select Priamry Radio for R00.1");
			executeStep(isRadioNotSelected(services.diagnoses_added_e_primary_rb, Common.type_xpath), getClass(),
					"Verify that Priamry Radio for E23.2 	 is not selected");

			executeStep(isRadioSelected(services.diagnoses_added_r_primary_rb, Common.type_xpath), getClass(),
					"Verify that Priamry Radio for R00.1 is selected");

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
			//LogUtil.infoLog(getClass(), "Error:" + e);//addedvgcxvxcvc
			throw e;
		}

	}

	@AfterMethod
	public void afterTest(ITestResult testResult) {
		Utility.resettData();

		if (logout_flag) {
			try {
				executeStep(click(MMM_userRoles.profile_img, Constants.Common.type_xpath), getClass(),
						"Click on Profile image");

				executeStep(click(Common.logout, Constants.Common.type_xpath), getClass(), "Click on logout button");

				executionDelay(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}