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
public class TC_MMM_7094 extends KeywordUtil {
	String suiteName = GetValue("suiteName");
	public List<String[]> errLogs = new ArrayList<String[]>();
	boolean isRun;
	boolean check = true;
	boolean status = true;
	String expected = "NA", actual = "NA";
	String logStep;
	String testCaseID = getClass().getSimpleName();
	boolean logout_flag=true;
	int row = 1;

	@BeforeMethod
	public void beforeTest() {
        Utility.testData = new TestData();
		Utility.testResult = new TestResults();
		Utility.testData = ExcelDataUtil.getTestDataWithTestCaseID(testCaseID);
		Utility.testResult.setDateOfExecution(Utility.getDateTime());
		LogUtil.infoLog(getClass(), "***********************************Test Started:" + testCaseID + "*******************************************");
		LogUtil.infoLog(getClass(), Utility.testData.getTestCaseSummary());
		navigate();
	}

	@Test
	public void test_TC_MMM_7094() throws Exception {
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
			executeStep(writeInInput(Common.username_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "username", row)),getClass(), "Enter Username");
			executeStep(writeInInput(Common.password_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "password", row)),getClass(), "Enter password");
			executeStep(click(Common.login_btn, Constants.Common.type_xpath), getClass(), "Click on Login Button");
			executionDelay(5000);
			
			//Fill in the security questions
			executeStep(writeInInput(Constants.Common.answer_input, Constants.Common.type_xpath, getdatafromXls(testCaseID, "answer", row)),getClass(), "Enter answer");
			executeStep(click(Constants.Common.submit_btn, Constants.Common.type_xpath), getClass(), "Click on submit Button");
			Thread.sleep(15000);
			
			executeStep(click(Constants.encounter.beneficiarySearchResults1, Common.type_xpath), getClass(),"Click on beneficiary ");
			
			
			executeStep(click(Constants.encounter.encounters_tab, Common.type_xpath), getClass(),"Click on the Encounter tab");
			executionDelay(2000);
			executeStep(verifyElementSize(Constants.encounter.tabsCount, Common.type_xpath, 5), getClass(),"Count the number of tabs");
			executeStep(click(Constants.services.create_icon, Common.type_xpath), getClass(),"Click on the Create icon.");
			executionDelay(2000);
			executeStep(click(Constants.encounter.immunizationLink, Common.type_xpath), getClass(),"Click on the Immunization link.");
			Thread.sleep(5000);
			executeStep(verifyElementSize(Constants.encounter.tabsCount, Common.type_xpath, 6), getClass(),"Count the number of tabs");
			executeStep(click(Constants.encounter.encounterSaveBtn, Common.type_xpath), getClass(),"Click on the save encounter button");
			executeStep(isWebElementPresent(Constants.encounter.encounterFieldCompleteMsg, Common.type_xpath), getClass(),"Please complete all required fields for this section.");
			executeStep(click(Constants.encounter.incrementHoursUpArrow, Common.type_xpath), getClass(),"Select a future encounter date");
			executeStep(isWebElementPresent(Constants.encounter.futureDatesErrorMsg, Common.type_xpath), getClass(),"Future dates are not allowed.");
			executeStep(click(Constants.encounter.decrementHoursDownArrow, Common.type_xpath), getClass(),"Decrement a hour");
			executeStep(selectList(Constants.encounter.ddReferredBy, Constants.Common.type_xpath,getdatafromXls(testCaseID, "ReferredBy", row)), getClass(), "Choose"+"'"+getdatafromXls(testCaseID, "ReferredBy", row)+"'");
     
			executeStep(selectList(Constants.encounter.ddFacilityprovider, Constants.Common.type_xpath,getdatafromXls(testCaseID, "FacilityProvider", row)), getClass(), "Choose Facilty Provider- "+getdatafromXls(testCaseID, "FacilityProvider", row));
			executeStep(selectList(Constants.encounter.ddTreatingPhysician, Constants.Common.type_xpath,getdatafromXls(testCaseID, "TreatingPhysician", row)), getClass(), "Choose Treating Physician- "+getdatafromXls(testCaseID, "TreatingPhysician", row));
			executionDelay(5000);
			executeStep(click(Constants.encounter.encounterSaveBtn, Common.type_xpath), getClass(),"Click on the save encounter button");
			executeStep(click(Constants.encounter.encounterResponseOKBtn, Common.type_xpath), getClass(),"Click OK Button");
			executeStep(click(Constants.encounter.immunizationSideLink, Common.type_xpath), getClass(),"Click on the Immunization section");
			executeStep(writeInInput(Constants.encounter.searchByVaccineName, Constants.Common.type_xpath, getdatafromXls(testCaseID, "vaccineName", row)),getClass(), "Enter vaccine name");
             Thread.sleep(5000);
 			executeStep(click(Constants.encounter.vaccineNameAddBtn, Common.type_xpath), getClass(),"Click on the Vaccine Name Add btn");
 			executeStep(click(Constants.encounter.immunizationHdr, Constants.Common.type_xpath),getClass(), "Click in immunization hdr");

 			executeStep(verifyCssProperty(Constants.encounter.immunizationQnty, Constants.Common.type_xpath, getdatafromXls(testCaseID, "cssProperty", row)),getClass(), "Color verified");

 			
 			
 			executeStep(click(Constants.encounter.encounterSaveBtn, Common.type_xpath), getClass(),"Click on the save encounter button");
			executeStep(isWebElementPresent(Constants.encounter.encounterFieldCompleteMsg, Common.type_xpath), getClass(),"Please complete all required fields for this section.");
 			
			executeStep(writeInInput(Constants.encounter.immunizationQnty, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationQty", row)),getClass(), "Enter immunization qty");
			executeStep(writeInInput(Constants.encounter.immunizationDose, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationDose", row)),getClass(), "Enter immunization dose");
			executeStep(writeInInput(Constants.encounter.immunizationDate, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationDate", row)),getClass(), "Enter immunization date");

			executeStep(selectList(Constants.encounter.encouterImmunizationStatus, Constants.Common.type_xpath,getdatafromXls(testCaseID, "Status", row)), getClass(), "Enter immunization status- "+getdatafromXls(testCaseID, "Status", row));
			executionDelay(6000);
			executeStep(click(Constants.encounter.encounterSaveBtn, Common.type_xpath), getClass(),"Click on the save encounter button");
			executeStep(isWebElementPresent(Constants.encounter.encounterSaveMsg, Common.type_xpath), getClass(),"Title: Encounter Save Response.");
			executeStep(isWebElementPresent(Constants.encounter.dialogEncounterSaveResponseText, Common.type_xpath), getClass(),"Message: Encounter save completed successfully.");
			executeStep(click(Constants.encounter.encounterResponseOKBtn, Common.type_xpath), getClass(),"Click OK Button");

			executeStep(click(Constants.encounter.closeEncounterTab, Common.type_xpath), getClass(),"Close Encounter tab");
			executionDelay(5000);
			executeStep(click(Constants.encounter.pag_last_lnk, Common.type_xpath), getClass(),"Click on pagination last link");
			executeStep(click(Constants.encounter.encounterSearchlastItem, Common.type_xpath), getClass(),"Click on encounter search last item");
			executionDelay(2000);
			executeStep(click(Constants.encounter.immunizationSideLink, Common.type_xpath), getClass(),"Click on the Immunization section");
			
			//Add first vaccine name
			executeStep(writeInInput(Constants.encounter.searchByVaccineName, Constants.Common.type_xpath, getdatafromXls(testCaseID, "vaccineName1", row)),getClass(), "Enter vaccine name");
            Thread.sleep(5000);
			executeStep(click(Constants.encounter.vaccineNameAddBtn, Common.type_xpath), getClass(),"Click on the Vaccine Name Add btn");
			executeStep(click(Constants.encounter.immunizationHdr, Constants.Common.type_xpath),getClass(), "Click in immunization hdr");
			executeStep(verifyElementSize(Constants.encounter.addedVaccineCount, Common.type_xpath, 2), getClass(),"Count the number of vaccines "+'2');
			executeStep(writeInInput(Constants.encounter.immunizationQnty1, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationQty", row)),getClass(), "Enter immunization qty");
			executeStep(writeInInput(Constants.encounter.immunizationDose1, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationDose", row)),getClass(), "Enter immunization dose");
			executeStep(writeInInput(Constants.encounter.immunizationDate1, Constants.Common.type_xpath, getdatafromXls(testCaseID, "immunizationDate", row)),getClass(), "Enter immunization date");
			executeStep(selectList(Constants.encounter.encouterImmunizationStatus1, Constants.Common.type_xpath,getdatafromXls(testCaseID, "Status", row)), getClass(), "Enter immunization status- "+getdatafromXls(testCaseID, "Status", row));
			executionDelay(5000);
			executeStep(click(Constants.encounter.encounterSaveBtn, Common.type_xpath), getClass(),"Click on the save encounter button");
			executionDelay(3000);
			executeStep(click(Constants.encounter.encounterResponseOKBtn, Common.type_xpath), getClass(),"Click OK Button");
			executeStep(click(Constants.encounter.immunizationSideLink, Common.type_xpath), getClass(),"Click on immunization side link");
			
			
			//delete vaccine,check count and click on sign button
			executeStep(click(Constants.encounter.addedVaccineDelbtn, Constants.Common.type_xpath),getClass(), "Click on vaccine Delete btn");
			executeStep(verifyElementSize(Constants.encounter.addedVaccineCount, Common.type_xpath, 1), getClass(),"Count the number of vaccines "+'1');
 			executeStep(click(Constants.encounter.encounterSignBtn, Common.type_xpath), getClass(),"Click on the sign encounter button");
			executeStep(isWebElementPresent(Constants.encounter.encounterMsg, Common.type_xpath), getClass(),"Check Message: To complete the Sign process fill the following information in the General Section.");
			executeStep(isWebElementPresent(Constants.encounter.fieldToCompleteMsg, Common.type_xpath), getClass()," Chief Complaint is required, Medical History is required.");
 			executeStep(click(Constants.encounter.cancelBtn, Common.type_xpath), getClass(),"Click on the Cancel button.");
			executeStep(isWebElementNotPresent(Constants.encounter.encounterDialogBox, Common.type_xpath), getClass()," Check that encounter dialog box is not present");

			
			//check for the dialog box title and messages
			executeStep(click(Constants.encounter.encounterSignBtn, Common.type_xpath), getClass(),"Click on the sign encounter button");
			executeStep(isWebElementPresent(Constants.encounter.encounterMsg, Common.type_xpath), getClass(),"Check Message: To complete the Sign process fill the following information in the General Section.");
			executeStep(isWebElementPresent(Constants.encounter.fieldToCompleteMsg, Common.type_xpath), getClass()," Chief Complaint is required, Medical History is required.");
 			executeStep(click(Constants.Common.ok_btn, Common.type_xpath), getClass(),"Click on the OK button.");
			executeStep(isWebElementNotPresent(Constants.encounter.encounterDialogBox, Common.type_xpath), getClass()," Check that encounter dialog box is not present");
			
			//check for the inline messages
 			executeStep(isWebElementPresent(Constants.encounter.activeGeneralsideTab, Common.type_xpath), getClass(),"The General Section is displayed.");
			executeStep(isWebElementPresent(Constants.encounter.encounterFieldCompleteMsg, Common.type_xpath), getClass(),"Please complete all required fields for this section.");
			executeStep(isWebElementPresent(Constants.encounter.chiefComplaintErrorMsg, Common.type_xpath), getClass(),"Check inline messages are displayed 'Chief Complain is required.'");
			executeStep(isWebElementPresent(Constants.encounter.medicalHistoryErrorMsg, Common.type_xpath), getClass(),"Check inline messages are displayed 'Medical History is required.");

			//enter mandatory field details
			executeStep(writeInInput(Constants.encounter.chiefComplaintInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "chieFComplaint", row)),getClass(), "Enter Chief Complaint "+"'"+getdatafromXls(testCaseID, "chieFComplaint", row)+"'");
			executeStep(writeInInput(Constants.encounter.pastMedicalHisInput, Constants.Common.type_xpath, getdatafromXls(testCaseID, "pastMedicalHist", row)),getClass(), "Enter Past Medical History "+"'"+getdatafromXls(testCaseID, "pastMedicalHist", row)+"'");
			
			//check encounter dialog box messages and click No btn
			executeStep(click(Constants.encounter.encounterSignBtn, Common.type_xpath), getClass(),"Click on the sign encounter button");
			executeStep(isWebElementPresent(Constants.encounter.dialogEncounterSaveConfirmationText, Common.type_xpath), getClass(),"Check for 'Encounter Save Confirmation'");
			executeStep(isWebElementPresent(Constants.encounter.dialogEncounterMsg, Common.type_xpath), getClass(),"Check for 'An encounter cannot be modified after it has been signed. Do you want to sign the encounter?'");
			executeStep(click(Constants.encounter.no_btn, Common.type_xpath), getClass(),"Click on 'No' button of Encounter dialog box");
			executeStep(isWebElementNotPresent(Constants.encounter.encounterDialogBox, Common.type_xpath), getClass()," Check that encounter dialog box is not present");
			
			//check encounter dialog box messages and click Yes btn
			executeStep(click(Constants.encounter.encounterSignBtn, Common.type_xpath), getClass(),"Click on the sign encounter button");
			executeStep(isWebElementPresent(Constants.encounter.dialogEncounterSaveConfirmationText, Common.type_xpath), getClass(),"Check for 'Encounter Save Confirmation'");
			executeStep(isWebElementPresent(Constants.encounter.dialogEncounterMsg, Common.type_xpath), getClass(),"Check for 'An encounter cannot be modified after it has been signed. Do you want to sign the encounter?'");
			executeStep(click(Constants.encounter.yes_btn, Common.type_xpath), getClass(),"Click on 'Yes' button of Encounter dialog box");
			executeStep(isWebElementPresent(Constants.encounter.signConfirmationMsg, Common.type_xpath), getClass(),"Check for title 'Sign Confirmation");
			executeStep(isWebElementPresent(Constants.encounter.signedCompleteMsg, Common.type_xpath), getClass(),"Check for Message 'The Signed process and the submission of the claim was completed successfully.'");
			executeStep(click(Constants.Common.ok_btn, Common.type_xpath), getClass(),"Click on the OK button.");
			executionDelay(2000);
			executeStep(click(Constants.encounter.closeEncounterTab, Common.type_xpath), getClass(),"Close Encounter tab");
			executionDelay(10000);
			
			executeStep(click(Constants.encounter.encounterSearchlastItem, Common.type_xpath), getClass(),"Click on encounter search last item");
			
			
			executionDelay(10000);
			executeStep(click(Constants.encounter.closeEncounterTab, Common.type_xpath), getClass(),"Close Encounter tab");
			executionDelay(10000);
			executeStep(isWebElementPresent(Constants.encounter.createdEncounterSignedField, Common.type_xpath), getClass(),"Check for 'Signed' Encounter"); 
			executeStep(click(Constants.encounter.encounterSearchlastItem, Common.type_xpath), getClass(),"Click on encounter search last item");
			
			
			//check for the View Page (General,Beneficiary,PCP,Immunization) tabs
			executeStep(isWebElementPresent(Constants.encounter.print_btn, Common.type_xpath), getClass(),"Check for 'Print' button");
			executeStep(isWebElementPresent(Constants.encounter.encounterSideGeneralTab, Common.type_xpath), getClass(),"Check for 'General' Tab");
			executeStep(isWebElementPresent(Constants.encounter.encounterSideBeneficiaryTab, Common.type_xpath), getClass(),"Check for 'Beneficiary' Tab");
			executeStep(isWebElementPresent(Constants.encounter.encounterSidePCPTab, Common.type_xpath), getClass(),"Check for 'PCP' Tab");
			executeStep(isWebElementPresent(Constants.encounter.encounterSideImmunizationTab, Common.type_xpath), getClass(),"Check for 'Immunization' Tab");
			
			
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