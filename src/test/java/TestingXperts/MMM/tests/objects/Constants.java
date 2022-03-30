package TestingXperts.MMM.tests.objects;

public class Constants {

	public class Common {
		public static final String type_xpath = "xPath";
		public static final String type_name = "name";
		public static final String ok_btn = "//button[text()='OK']";
		public static final String submit_btn = "//button[contains(.,'Submit')]";
		public static final String username_input = "//div[label[contains(.,'Username')]]/input[@name='username']";
		public static final String username = "username";
		
		
		public static final String password_input = "//div[label[contains(.,'Password')]]//input[@name='password']";
		public static final String login_btn = "//button[contains(.,'Login')]";
		
		public static final String login_btn12 = "//button[contains(.,'Login')]";
		public static final String answer_input = "//input[@name='answer']";
		public static final String logout = "//span[contains(.,'Log out')]";
		public static final String search_btn = "//button[contains(.,'Search')]";

		public static final String save_btn = "//a[span[contains(.,'Save')]]/em";
		public static final String create_btn= "//em[@class='fa fa-plus fa-2x']";
		public static final String next_btn="//button[contains(.,'Next')]";
		
		public static final String add_btn="//em[@class='fa fa-plus fa-lg']";
		
		public static final String yes_btn="//button[contains(.,'Yes')]";
		public static final String no_btn="//button[contains(.,'No')]";
		public static final String print_btn="//a[span[contains(.,'Print')]]/em";
		
		
		public static final String cancel_btn="//a[span[contains(.,'Cancel')]]/em";
		
		public static final String group_icon="//em[@class='fa fa-group']";
		
		public static final String beneficiary_search_lnk="//a/span[contains(.,'Beneficiary Search')]";
		
		public static final String group_beneficiary_search_lnk="(//a/span[contains(.,'Beneficiary Search')])[position()=2]";
		
	}

	public class MMM_login {

		public static final String innovaMD_img = "//img[@src='img/logo.png']";
		public static final String mso_img = "//img[@src='img/mso-logo.png']";
		public static final String welcome_header = "//h2[contains(.,'Welcome to InnovaMD')]";
		public static final String forget_username_lnk = "//a[contains(.,'Forgot username?')]";
		public static final String forget_password_lnk = "//a[contains(.,'Forgot password?')]";
		public static final String register_message = "//p[contains(.,'If you are a first time user, please click Register button.')]";
		public static final String register_btn = "//a[contains(.,'Register')]";
		public static final String invalid_username_error_msg = "//span[@class='text-danger ng-binding'][contains(.,'Username must only contain letters or numbers.')]";
		public static final String copy_write_notice = "//span[contains(.,'© 2016, InnovaMD')]";
		public static final String privacy_link = "//a[text()='Privacy']";
		public static final String terms_link = "//a[text()='Terms']";
		public static final String invalid_username_pass_msg = "//div[@style='display: block;'][contains(.,'Invalid Username or Password.')]";
	}

	public class MMM_userRoles extends MMM_login {
		public static final String membership_management_span = "//span[text()='membership management']";
		public static final String profile_img = "//img[@class='img-circle']";
		public static final String group_admin_role = "//span[contains(.,'Group Administrator')]";
		public static final String family_med_group = "//div/strong[contains(.,'FAMILY MEDICINE GROUP')]";
		public static final String beneficiary_male_icon = " //em[@class='fa fa-fw fa-3x fa-male']";
		public static final String user_icon = "//em[@class='fa fa-fw fa-3x fa-user-md']";
		public static final String PCP_header = "//li[contains(@heading,'PCP')]";

	}

	public	class BeneficiarySearch {
		public static final String advance_search_arrow = "//button[@class='btn btn-primary dropdown-toggle']";
		public static final String biling_npi_select = "//div[label[contains(.,'Billing NPI')]]//select";
		public static final String shared_benefic_lnk = "//div/a[contains(.,'Shared Beneficiaries')]";
		public static final String pcp_select = "//div[label[contains(.,'PCP')]]//select";
		public static final String all_benefic_lnk = "//div/a[contains(.,'All Beneficiaries')]";
		
		 public static final String searchCriteriaName = "searchCriteria"; // beneficiary search box
		 public static final String SearchBeneficiaryButton = "//*[@class='btn btn-primary ng-binding']"; // searchButton
		 public static final String searchedUser = "//*[@class='media-left']/em"; // searched user
	}

	public class documents {
		public static final String search_input = "//input[@name='searchCriteria']";
		public static final String documment_tab = "//span[text()='Documents']";
		public static final String profile_active_tab = "//li[@class='ng-scope active'][contains(.,'Profile')]";
		
		public static final String document_active_tab = "//li[@class='ng-scope active'][contains(.,'Documents')]";
		public static final String searched_user_lnk = "//span[contains(.,'agripino ayala reyes')]";
		public static final String document_cons = "//strong[contains(.,'Cons Hematology/Oncology')]";
		public static final String upload_btn = "//em[@class='fa fa-upload fa-2x']";
		public static final String document1_tab = "//li/a/span[contains(.,'Document 1')]";
		public static final String service_date_input = "//div[label[contains(.,'Service Date')]]//input[@id='serviceDate']";
		public static final String upload_document_header = "//h3[contains(.,'Upload Document')]";
		public static final String service_date_cal_icon = "//div[label[contains(.,'Service Date')]]//button/em[@class='fa fa-calendar']";
		public static final String document_browse_btn = "//div[//input[@type='file']][label[contains(.,'Document')]]//label/span[contains(.,'Browse...')]";
		public static final String maximum_size_info = "//p[contains(.,'Maximum size: 10MB')]";
		public static final String allowed_file_type = "//p[contains(.,'Allowed file format: .PDF,.GIF,.JPG,.JPEG')]";
		public static final String notes_textarea = "	//div[label[contains(.,'Notes')]]//textarea[@id='notes']";
		public static final String notes_error_msg = "//li[@class='text-danger ng-binding'][contains(.,'Notes cannot contain the following special characters: = < > ( ) ') and contains(.,'\')]";

		public static final String document_type_select = "//div[label[contains(.,'Document Type')]]//select[@id='documentTypes']";
		public static final String document_status_select = "//div[label[contains(.,'Document Status')]]//select";

		public static final String document_type_search_select = "//div[label[contains(.,'Document Type')]]//select";

		public static final String service_date_range_start_input=" //div[//em[@class='fa fa-calendar']][label[contains(.,'Service Date Range')]]//input[@id='serviceDateFrom']";
		
		public static final String service_date_range_end_input=" //div[//em[@class='fa fa-calendar']]//input[@name='serviceDateTo']";

		public static final String list_view_from_input="	//div[//em[@class='fa fa-calendar']][label[contains(.,'Last View Date Range')]]//input[@id='lastViewFrom']";
		
		public static final String list_view_to_input="//div[//em[@class='fa fa-calendar']]//input[@name='lastViewTo']";
		
		
		public static final String upload_from_input="//div[//em[@class='fa fa-calendar']][label[contains(.,'Upload Date Range')]]//input[@id='uploadDateFrom']";
		
		public static final String upload_to_input="//div[//em[@class='fa fa-calendar']]//input[@name='uploadDateTo']";

		
		
		public static final String expended_advance_search="//button[@aria-expanded='true']/following-sibling::ul[@class='dropdown-menu dropdown-menu-custom-content pull-right']//li//h4[contains(.,'Advanced Search')]";
		
		public static final String expended_collapse_search="//button[@aria-expanded='false']/following-sibling::ul[@class='dropdown-menu dropdown-menu-custom-content pull-right']//li//h4[contains(.,'Advanced Search')]";

		public static final String all_document_link="//a[contains(.,'All Documents')]";
		
		public static final String documnet_ckd_type="//div[span/strong[contains(.,'CKD Clinic Initial Visit')]]";
		
		public static final String applied_filter_label="//h4[span[contains(.,'Document Type:')]]//strong[contains(.,'Cons Hematology/Oncology')]";
		public static final String documnet_Cons_type="//div[span/strong[contains(.,'Cons Hematology/Oncology')]]";

		public static final String invalid_date_error="//li[contains(@class,'ng-show')][contains(.,'Invalid date')]";
		public static final String invalid_file_format_error="//li[@class='text-danger ng-binding'][contains(@ng-show,'documents')][contains(.,'File format is incorrect')]";
		public static final String file_input=	"//input[@type='file']";
		public static final String document_1_x_icon="//li/a[span[contains(.,'Document 1')]]/span/em";
		public static final String upload_doc_alert="//div[contains(@style,'display: block;')][h2[contains(.,'Document Upload')]][div[contains(.,'Are you sure you want to close the Load New')and contains(.,'Document screen without upload a document?')]]";
		public static final String care_older_x_icon="//li/a[span[contains(.,'Care Older')]]/span/em";
		public static final String added_doc_link="//strong[position()=1][contains(.,'Care Older Adult')]";
	
	
	}
	
	public	class services extends documents
	{
		public static final String searched_carmen_user_lnk = "//span[contains(.,'carmen a ramos rivera')]";
		public static final String services_tab = "//span[text()='Services']";
		public static final String requesting_provider_header="//h3[contains(.,'Requesting Provider')]";
		
		
		public static final String biling_npi_select="//select[@name='billingNpi']";
		
		public static final String requesting_provider_alert	="//div[contains(@style,'display: block;')][h2[contains(.,'Requesting Provider')]][div[contains(.,'A requesting provider must be selected.')]]";
		
		public static final String rendering_npi_select="//select[@name='renderingNpi']";

		public static final String pcp_name_green_tick="//dd[span[contains(.,'kiyomi  santos onoda')]][em[@class='fa fa-check-circle fa-fw text-success']]";
	
		public static final String pcp_name="//div[@class='media-body'][h4[contains(.,'kiyomi  santos onoda')]]";
		public static final String pcp_female_icon="//em[@class='fa fa-3x mr ng-scope fa-female']";
		
		public static final String pcp_speciality="//div[contains(.,'Specialties')]/span[contains(.,'General Practice')]";
		public static final String location_icon="//em[@class='fa fa-map-marker fa-3x mr']";
		
		public static final String diagnoses_header="//h3[contains(.,'Diagnoses')]";
		
		public static final String ccm="//strong[contains(.,'Coordinated Care Management')]";
		
		public static final String service_submit_confirmation_alert="//div[contains(@style,'display: block;')][h2[contains(.,'Service Submit Confirmation')]][div[contains(.,'By submitting this service for approval you certify that all information is correct.')and contains(.,'Do you want to submit this service?')]]";
		public static final String service_submit_response_alert="//div[contains(@style,'display: block;')][h2[contains(.,'Service Submit Response')]][div[contains(.,'Service submission completed successfully.')]][div[contains(.,'Do you want to create another service for the same')and contains(.,'diagnosis?')]]";
		public static final String select_green_tick="//table//tbody//tr[1]//td//button[contains(@class,'btn btn-success')]";
		
       //Added by nitin
		
		
		public static final String beneficiary_search_btn="//button[contains(.,'Search')]";
		  public static final String benficiaryInput="//input[@name='searchCriteria']";
		  public static final String beneficiarySearchResults="(//div[contains(@ng-show,'beneficiaries.searchResults')]//div//div[@class='media allow-overflow'][div//div //span[contains(.,'rivera')]])[position()='1']";
		  public static final String advancedFilterIcon="//button[span[@class='caret']]";
		  public static final String advanceFilter="//select[contains(@class,'form-control ng-pristine')][contains(@ng-model,'beneficiaries.session.lineOfBusiness')]";
		  public static final String beneficiaryFilterResults="//div[contains(@ng-show,'beneficiaries.searchResults')]//div//div[@class='media allow-overflow'][div[div[contains(.,'LOB:')][contains(.,'MA')]]]";
		  public static final String activeServicesTab="//li[contains(@class,'active')]//a[span[contains(.,'Services')]]";
		     public static final String create_icon="//li//a[span[contains(.,'Create')]]";
		     public static final String activeDiagnosesTab="//a[contains(@class,'btn-primary')][contains(.,'Diagnoses')]";
		     public static final String  diagnosesInput= "//input[@id='searchCriteria']";
		     public static final String  searchDiagnoses="//span[contains(@class,'input-group-addon')]";
		     public static final String  btnAddDiagnoseProcedure="//table//tbody//tr//td//button";
		     public static final String  addedDiagnosesDarkGreenCheck="//dd[contains(@class,'ng-binding')][em[contains(@class,'success')][contains(@style,'opacity: 1')]][contains(.,'AA COUNSEL SURVEILLANCE ALCOHOLIC')]";
		     public static final String  addedDiagnosesLightGreenCheck="//dd[contains(@class,'ng-binding')][em[contains(@class,'success')][contains(@style,'opacity: 0.5')]][contains(.,'ALCOHOL ABUS INDUC PSYCH')]";
		     public static final String activeProceduredTab="//a[contains(@class,'btn-primary')][contains(.,'Procedures')]";
		     public static final String hdrProcedure="//h3[contains(.,'Procedures')]";
		     public static final String selectServiceType="(//div[contains(@class,'media-body')]//strong)[position()='1']";
		     public static final String inputProcedure=".//*[@id='searchCriteria']";
		  
		     public static final String activeServiceProviderTab="//a[contains(@class,'btn-primary')][contains(.,'Servicing Provider')]";
		     public static final String addedprocedure="//dd[contains(@class,'ng-binding')][em[contains(@class,'warning')]][contains(.,'A0021')]";
		     public static final String addServiceProviderBtn="//table//tbody//tr[1]//td//button[contains(@class,'btn btn-success')]";
		     public static final String addedServiceProvider="//dd[contains(@class,'ng-scope')][em[contains(@class,'star')]]";
		     public static final String additionalInfoLink="//a[contains(@class,'btn-primary')][contains(.,'Additional Information')]";
		     public static final String uploadFile="//input[contains(@id,'filestyle')]";
		     public static final String delUploadedFile="(//table/tbody//tr//a[em])[position()='2']";
		     public static final String ddBillingNPI="//select[@name='billingNpi']";
		     public static final String addDocumentbtn="//button[contains(.,'Add Document')]";
		     public static final String fileType="//select[contains(@class,'form-control ng-pristine')]";
		    
		   //added by vikas
		     public static final String discharge_summary="//div[Strong[contains(.,'Discharge Summary')]]";
		     public static final String referedBy_select="//select[@name='referredByType']";
		     public static final String facility_select="//select[@name='facilityProvider']";
		     
		     public static final String treating_physcian_select="//select[@name='treatingPhysician']";
		     
		     
		     public static final String diagnoses_sidemenu_lnk=  "//a[contains(@class,'list-group-item')][span[text()='Diagnoses']]";
		     
		     public static final String diagnoses_d15_1_remove_img="//tr[contains(.,'D15.1')]//em[contains(@class,'fa fa-trash')]";
	
		     public static final String diagnoses_added_z="//tr[contains(.,'Z95.811')]";
		     public static final String diagnoses_added_e="//tr[contains(.,'E23.2')]";
		     public static final String diagnoses_added_r="//tr[contains(.,'R00.1')]";

		     public static final String diagnoses_added_d2="//tr[contains(.,'D15.9')]";
	
		     public static final String diagnoses_added_r_primary_rb ="//tr[contains(.,'R00.1')]//input[@type='radio']";
		     public static final String diagnoses_added_e_primary_rb="//tr[contains(.,'E23.2')]//input[@type='radio']";
	
	
		     
		     
		     
		     public static final String new_encounter1_tab=" //li[a[span[contains(.,'Encounter 1')]]]";
		     
		     
		     public static final String units_input=" //input[@type='number']";
		     
		     
		     public static final String units_alert= "//div[contains(@style,'display: block')]//li[contains(.,'The AMB SRVC OTSD STATE-MILE TRANSPORT required the selection of units.')]";
	
		     
		     
		     public static final String aa0021_X_icon=  "//dd[span[contains(.,'A0021')]]/em[contains(@class,'text-danger')]";
		     
				public static final String ccm_alert_header="//h2[contains(.,'Coordinated Care Management')]";
				
				
				
				public static final String all_procedure_select=	"//select[@id='selectCategory'][not(disabled='disabled')]";
				public static final String a0021_instant_search	="//div[@id='searchResutls']//tr[contains(.,'AMB SRVC OTSD STATE-MILE TRANSPORT')]/td/span[contains(.,'A0021')]";
	
	
				public static final String beneficiary_tab_lnk= "//li[contains(@class,'uib-tab')]/a[contains(.,'Beneficiary')]";
				public static final String ghp_userLink	="//span[contains(.,'alma s robles osorio')]";
				public static final String sp_ambulance_plus_icon="//tr[contains(.,'ambulance inc')]//button[@class='btn btn-success btn-sm']";
	

				public static final String documnet_title_field="//h3[contains(.,'Additional Information')]/i[@class='fa fa-files-o']";
	
	
	
				public static final String documnet_instruction="//p[contains(.,'Provide the corresponding Additional Information for this request.')]";
	
	
				public static final String selected_standard_btn	="//a[@class='btn ng-binding btn-primary'][contains(.,'Standard')]";
	
				public static final String expedite_btn	="//a[@class='btn ng-binding btn-default'][contains(.,'Expedite')]";

				public static final String document_headers="//thead/tr[th[contains(.,'Type')]][th[contains(.,'File')]][th[contains(.,'Required')]][th[contains(.,'Remove')]]";
				public static final String other_browser_btn=	"//tr[contains(.,'Other')]/td/div[//input]//label[contains(.,'Browse...')]";
	
	
				public static final String other_create_btn=	"//tr[contains(.,'Other')]/td/div//button[contains(.,'Create...')]";
				public static final String other_delete_btn="//tr[contains(.,'Other')]/td//em[contains(@class,'text-danger')]";
				public static final String add_document_btn="//button[contains(.,'Add Document')]";
				public static final String document_green_tick="//dd[contains(.,'Documents')]/em[@class='fa fa-fw fa-check-circle text-success']";
	
				public static final String notes_btn="//a[contains(.,'Notes')]";
				public static final String add_note="//button[contains(.,'Add Note')]";
			    public static final String addedA0432procedure="//dd[contains(@class,'ng-binding')][em[contains(@class,'warning')]][contains(.,'A0432')]";
			    public static final String disabled_modifier_select=" //select[contains(@ng-options,'modifiers')][not(@disabled='disabled')]";
	
			    //Added by vikas on 05/08/2016
			    public static final String rha160_green_tick=" //dd[contains(.,'RHA60')]/em[@class='fa fa-fw fa-check-circle text-success']";

			    
			    
			    
	}
	
	
	public class encounter{ 
		public static final String encounterTab = "//span[@class='ng-binding ng-scope'][text()='Encounters']"; // encounter tab
		public static final String createEncounterButton = "//em[@class='fa fa-plus fa-2x']";  // create encounter
		public static final String dischargeSummary = "//div/strong[contains(.,'Discharge Summary')]";  // discharge summary
		public static final String referredBySelect="//select[@name='referredByType']";   // referred by
		public static final String physcianSelect="//select[@name='treatingPhysician']";  // treating physician
		public static final String facilityBySelect="//select[@name='facilityProvider']";  // facility provider
		public static final String diagnoses = "//*[contains(@ui-sref,'encounter.diagnoses')]";  // diagnoses tab
		public static final String diagnosesSearch = "//input[@ placeholder='Search by Diagnosis Code or Description']";
		public static final String immunizationLink="//div[Strong[contains(.,'Immunization')]]";
	    public static final String tabsCount="//ul[contains(@class,'nav nav-tabs custom-nav-tabs')]//li";
	    public static final String encounters_tab="//span[text()='Encounters']";
	    public static final String encounterSaveBtn="//li//a[span[contains(.,'Save')]]";
	   
    	 public static final String encounterFieldCompleteMsg="//h4[contains(.,'Please complete all required fields for this section.')]";
 	    public static final String incrementHoursUpArrow ="//a[contains(@class,'btn btn-link')][span[contains(@class,'chevron-up')]][contains(@ng-disabled,'noIncrementHours()')]";
 	    public static final String futureDatesErrorMsg="//li[contains(.,'Future dates are not allowed')]";
 	    public static final String decrementHoursDownArrow="//a[contains(@class,'btn btn-link')][span[contains(@class,'chevron-down')]][contains(@ng-disabled,'noDecrementHours()')]";
 	    public static final String ddReferredBy="//select[@name='referredByType']";
 	    public static final String ddFacilityprovider="//select[@name='facilityProvider']";
 	    public static final String ddTreatingPhysician="//select[@name='treatingPhysician']";
 	    public static final String encounterResponseOKBtn="//button[contains(.,'OK')]";
 	    public static final String immunizationSideLink="//a[span[contains(.,'Immunization')]]";
 	    public static final String searchByVaccineName="//input[@placeholder='Search by Vaccine Name']";
 	    public static final String vaccineNameAddBtn="//table/tbody//tr[1]//td//button[contains(@class,'btn-success')]";
 	    public static final String immunizationQnty="//input[contains(@ng-model,'immunization.quantity')]";
 	    public static final String immunizationDose="//input[contains(@ng-model,'immunization.dose')]";
 	    public static final String immunizationDate="//input[contains(@ng-model,'immunization.immunizationDate')]";
 	    public static final String encouterImmunizationStatus="//select[contains(@ng-model,'immunization.encounterImmunization')]";
 	    public static final String dialogEncounterSaveResponseText="//h2[contains(.,'Encounter Save Response')]";
 	    public static final String encounterSaveMsg="//div[contains(@class,'swal2-content')][contains(@style,'block')][contains(.,'Encounter save completed successfully.')]";
       public static final String closeEncounterTab="(//ul[contains(@class,'nav nav-tabs custom-nav-tabs')]//li)[last()]//a//span//em[contains(@class,'fa fa-times')]";
    public static final String pag_last_lnk="//a[contains(.,'Last')]";
   	public static final String searchIcon="//span[em[contains(@class,'fa fa-search')]]";
   	public static final String encounterSearchlastItem="(//div[contains(@class,'panel panel-default')]//div[contains(@block-ui,'encountersSearch')]//a)[last()]";
    public static final String addedVaccineCount="//table/tbody//tr[contains(@class,'ng-scope')]";
    public static final String addedVaccineDelbtn ="(//table/tbody//tr[contains(@class,'ng-scope')])[last()]//td//a[em]";
    public static final String encounterSignBtn="//li//a[span[contains(.,'Sign')]]";
    public static final String immunizationQnty1="(//input[contains(@ng-model,'immunization.quantity')])[position()='2']";
    public static final String immunizationDose1="(//input[contains(@ng-model,'immunization.dose')])[position()='2']";
    public static final String immunizationDate1="(//input[contains(@ng-model,'immunization.immunizationDate')])[position()='2']";
    public static final String encouterImmunizationStatus1="(//select[contains(@ng-model,'immunization.encounterImmunization')])[position()='2']";
    public static final String encounterTitle="//h2[contains(.,'Encounter')]";
    public static final String encounterMsg="//div[@class='text-left'][contains(.,'To complete the Sign process fill the following information in the General Section:')]";
    public static final String fieldToCompleteMsg="//ul[li[contains(.,'Chief Complaint is required')]][contains(.,'Medical History is required')]";
    public static final String cancelBtn="//button[text()='Cancel']";
    public static final String encounterDialogBox="//div[contains(@class,'swal2-modal show-swal2')][contains(@style,'block')]";
    public static final String activeGeneralsideTab="//a[contains(@class,'active')][span[contains(.,'General')]]";
    public static final String chiefComplaintErrorMsg="//ul//li[contains(@class,'text-danger')][contains(.,'Chief Complaint is required')]";
    public static final String medicalHistoryErrorMsg="//ul//li[contains(@class,'text-danger')][contains(.,'Medical History is required')]";
    public static final String chiefComplaintInput=".//*[@id='chiefComplaint']";
    public static final String pastMedicalHisInput=".//*[@id='pastMedicalHistory']";
    public static final String dialogEncounterSaveConfirmationText="//h2[contains(.,'Encounter Save Confirmation')]";
    public static final String dialogEncounterMsg="//div[contains(@class,'content')][contains(.,'An encounter cannot be modified after it has been signed. Do you want to sign the encounter?')]";
    public static final String no_btn="//button[contains(.,'No')]";
    public static final String yes_btn="//button[contains(.,'Yes')]";
    public static final String signConfirmationMsg="//h2[contains(.,'Sign Confirmation')]";
    public static final String signedCompleteMsg="//div[contains(@class,'content')][contains(.,'The Signed process and the submission of the claim was completed successfully.')]";
    public static final String print_btn="//a[span[contains(.,'Print')]]";
    public static final String encounterSideGeneralTab="//a[contains(@class,'list-group')][contains(.,'General')]";
    public static final String encounterSideBeneficiaryTab="//a[contains(@class,'list-group')][contains(.,'Beneficiary')]";
    public static final String encounterSidePCPTab="//a[contains(@class,'list-group')][contains(.,'PCP')]";
    public static final String encounterSideImmunizationTab="//a[contains(@class,'list-group')][contains(.,'Immunization')]";
    public static final String createdEncounterSignedField="(//div[contains(@class,'panel panel-default')]//div[contains(@block-ui,'encountersSearch')]//a)[last()]//div[@class='text-right'][contains(.,'Signed')]";
    public static final String immunizationHdr="//h3[contains(.,'Immunization')]";
	public static final String beneficiarySearchResults1="(//div[contains(@ng-show,'beneficiaries.searchResults')]//div//div[@class='media allow-overflow'])[position()='1']";
		
		
	//added by vikas 08/08/2016
	
    public static final String procedure_sidemenu_lnk=  "//a[contains(@class,'list-group-item')][span[text()='Procedures']]";
    
    public static final String a0021_delete_icon="//tr[contains(.,'A0021')]//em[contains(@class,'text-danger')]";
    

	
	
	
		
		
		
	}
	
public static class smartPaper{ 
		
	    public static final String memberShipManagement="(//a[span[contains(.,'Membership Management')]])[position()=1]";
		public static final String sharedBeneficiaryLnk="//a[contains(.,'Shared Beneficiaries')]";
		public static final String clinicalLink="//a[contains(.,'Clinical')]";
		public static final String activeProfileLink="//li[contains(@class,'ng-scope active')]//a[contains(.,'Profile')]";
		public static final String smartPaperLink ="//a[contains(@class,'ng-scope active')][contains(.,'SMART Paper')]";
		public static final String smartPaperSaveBtn="//button[@busy-button='save']";
		public static final String pcpSmartpaperEntry="//ul[contains(@class,'dropdown-menu')]//li//a[contains(.,'PCP SMART Paper')][contains(@ng-click,'save')]";
		public static final String patientSmartPaperEntry="//ul[contains(@class,'dropdown-menu')]//li//a[contains(.,'Patient SMART Paper')][contains(@ng-click,'save')]";
		public static final String group_icon1="//a//em[@class='fa fa-group']";
		public static final String beneficiaryResults="(//div[contains(@ng-show,'beneficiaries.searchResults')]//div//div[@class='media allow-overflow'])[position()='1']";


	}
	
	}


