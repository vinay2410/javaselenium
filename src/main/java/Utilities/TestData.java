package Utilities;

public class TestData {

	private String testSet, testCaseID, testCaseSummary, complexity;
	private String browser,platform;

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	
	public String getPlatform() {
		  return platform;
		 }
		 
		 public void setPlatform(String platform) {
		  this.platform = platform;
		 }
	
	public String getTestSet() {
		return testSet;
	}

	public void setTestSet(String testSet) {
		this.testSet = testSet;
	}

	

	@Override
	public String toString() {
		return "TestData [testSet=" + testSet + ", testCaseID=" + testCaseID + ", testCaseSummary=" + testCaseSummary
				+ ", complexity=" + complexity + ", estimatedExecutionTime=" + browser + "]";
	}

	public String getTestCaseID() {
		return testCaseID;
	}

	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	public String getTestCaseSummary() {
		return testCaseSummary;
	}

	public void setTestCaseSummary(String testCaseSummary) {
		this.testCaseSummary = testCaseSummary;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String currentBrowser) {
		this.browser = currentBrowser;
	}

	
	
	
	
}
