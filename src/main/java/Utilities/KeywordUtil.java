package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import com.google.common.base.Function;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.mifmif.common.regex.Generex;
import org.openqa.selenium.JavascriptExecutor;

public class KeywordUtil extends Utility {

	public static int fail = 0;
	static WebElement webElement;
	public static String URL = "";

	public static void navigate() {

		driver.manage().deleteAllCookies();
		URL = GetValue("BASE_URL");
		driver.navigate().to(URL);
		
		System.out.println("************Navigate********");
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
	
	}

	public static By locatortype(String type, String value) {
//try {
	//Thread.sleep(3000);
//} catch (InterruptedException e) {
	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
		By locName = null;
		if (type.equalsIgnoreCase("xPath")) {
			locName = By.xpath(value);
		} else if (type.equalsIgnoreCase("linkText")) {
			locName = By.linkText(value);
		} else if (type.equalsIgnoreCase("classname")) {
			locName = By.className(value);
		} else if (type.equalsIgnoreCase("name")) {
			locName = By.name(value);
		} else
			locName = By.partialLinkText(value);
		return locName;

	}

	public static boolean isWebElementPresent(String path, String type) {

		List<WebElement> elements = driver.findElements(locatortype(type, path));

		if (elements.size() > 0) {
			System.out.println("Element Present");
			return true;
		} else {
			System.out.println("Element is not Present");

			return false;
		}
	}

	public static boolean isWebElementNotPresent(String path, String type) {

		List<WebElement> elements = driver.findElements(locatortype(type, path));

		if (elements.size() > 0) {
			System.out.println("Element Present");
			return false;
		} else {
			System.out.println("Element is not Present");

			return true;
		}
	}

	public static boolean writeInInput(String path, String type, String data) {
		WebElement element = driver.findElement(locatortype(type, path));

		element.clear();
		element.sendKeys(data);

		System.out.println("Value Entered");
		return true;

	}

	public static boolean enterInput(String path, String type, String data) {
		WebElement element = driver.findElement(locatortype(type, path));

		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", element, data);

		System.out.println("Value Entered");
		return true;

	}

	public static WebElement explicitWaitForElement(String path, String type) {
		WebDriverWait wait = new WebDriverWait(driver, GetIntValue("explicit_timeout"));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locatortype(type, path)));

		return element;

	}

	public static boolean click(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		element.click();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}*/
		System.out.println("Element Clicked");
		return true;

	}

	public static void executeStep(Boolean check, Class className, String logstep) throws Exception {

		if (check) {
			LogUtil.infoLog(className, logstep + "-PASS ");
			HtmlReportUtil.stepInfo(logstep + "-PASS");

		} else {
			LogUtil.infoLog(className, logstep + "-FAIL ");
			HtmlReportUtil.stepInfo(logstep + "-FAIL");

			throw new Exception();

		}

	}

	public static Boolean validateUsernameInput(String path, String errorMessage, String type) {
		Boolean flag = false;

		WebElement element = explicitWaitForElement(path, type);
		Generex generex = new Generex("([0-9][a-z][A-Z]){8,20}");
		String randomStr = generex.random();
		System.out.println(randomStr);
		element.sendKeys(randomStr);
		flag = isWebElementNotPresent(errorMessage, type);
		return flag;

	}

	public static void executionDelay(long time) throws InterruptedException {
		Thread.sleep(time);

	}

	public boolean verifyAllVauesOfDropDown(String path, String type, String data) {

		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		List<WebElement> options = element.findElements(By.tagName("option"));
		String temp = data;
		String allElements[] = temp.split(",");
		String actual;
		for (int i = 0; i < allElements.length; i++) {

			System.out.println("Actual : " + options.get(i).getText());

			System.out.println("Expected: " + allElements[i].trim());
			actual = options.get(i).getText().trim();
			if (actual.equals(allElements[i].trim())) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;

	}

	public boolean verifyCurrentDateInput(String path, String type) {
		boolean flag = false;
		WebElement element = explicitWaitForElement(path, type);
		String actual = element.getAttribute("value").trim();
		DateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		DtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
		String expected = DtFormat.format(date).toString().trim();
		if (actual.trim().contains(expected)) {
			flag = true;

		}
		return flag;

	}

	
	
	public static Boolean validateNotesInput(String path, String type, String errorMessage) {
		Boolean flag = false;

		WebElement element = explicitWaitForElement(path, type);
		String pattern[] = { "<", ">", "(", ")", "'", "\\" };
		for (int i = 0; i < pattern.length; i++) {
			element.clear();
			element.sendKeys(pattern[i]);
			flag = isWebElementPresent(errorMessage, type);

			if (!flag) {
				break;
			}

		}

		return flag;

	}

	public boolean selectList(final String path, String type, String data) {

		Boolean flag = false;

		WebElement select = explicitWaitForElement(path, type);

		List<WebElement> options = select.findElements(By.tagName("option"));
		String expected = data.trim();
		System.out.println("Expected: " + expected);
		for (WebElement option : options) {

			String actual = option.getText().trim();
			System.out.println("Actual: " + actual);
			if (actual.equals(expected)) {

				option.click();
				flag = true;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return flag;
			}
		}

		return flag;
	}

	public boolean verifyDropdownSelectedValue(String path, String type, String data) {

		Boolean flag = false;
		WebElement select = explicitWaitForElement(path, type);

		Select sel = new Select(select);
		String defSelectedVal = sel.getFirstSelectedOption().getText();

		if (defSelectedVal.trim().equals(data.trim())) {
			flag = true;

			return flag;
		} else {
			return flag;
		}
	}

	public static boolean verifyElementSize(String path, String type, int size) {

		List<WebElement> elements = driver.findElements(locatortype(type, path));

		if (elements.size() == size) {
			System.out.println("Element is Present " + size + "times");
			return true;
		} else {
			System.out.println("Element is not Present with required size");

			return false;
		}
	}

	public static boolean uploadFilesUsingSendKeys(String path, String type, String data) throws InterruptedException {
		WebElement element = driver.findElement(locatortype(type, path));
		element.clear();
		element.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\uploadFiles\\" + data);
		System.out.println("Value Entered");
		return true;

	}

	public static boolean writeInInputCharByChar(String path, String type, String data) throws InterruptedException {
		WebElement element = driver.findElement(locatortype(type, path));
		element.clear();
		String b[] = data.split("");

		for (int i = 0; i < b.length; i++) {

			element.sendKeys(b[i]);
			Thread.sleep(1000);

		}
		System.out.println("Value Entered");
		return true;

	}

	public static boolean isRadioSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean isRadioNotSelected(String path, String type) {

		WebElement element = (explicitWaitForElement(path, type));
		if (element.isSelected()) {
			return false;
		} else {

			return true;
		}
	}

	

	
public static boolean selectByIndex(String path, String type, Integer index){
		
		boolean status = false;
		boolean elemPresent = isWebElementPresent(path, type);
		if(elemPresent){
			WebElement elem = driver.findElement(locatortype(type, path));
			Select select = new Select(elem);
			select.selectByIndex(index);
			status = true;
			logResult(status, "Select action is performed !!!" );
			return status;
		}else{
			status = false;
			logResult(status, "No Select action performed !!!");
			return status;
		}
		
	}
	
	
public static boolean clearInput(String path, String type) {
	WebElement element = driver.findElement(locatortype(type, path));

	element.clear();
	
	System.out.println("input field cleared");
	return true;

}

public static  boolean verifyPDFData(String data,int page,String fileName) throws InterruptedException, IOException {

	{
		    FileInputStream fis=null;
            String dwnFile=null;
       
            try{


            String dirName=System.getProperty("user.dir")+ "\\src\\test\\resources\\downloadFile\\";
            File dir=new File(dirName);
            File[] path1=dir.listFiles();
         
            for(int k=0; k<path1.length;k++)
            {
             dwnFile=path1[k].toString();
           if(dwnFile.contains(fileName)){
              break;
             }
           else{
            continue;
                } 
              }
          File file=new File(dwnFile);
           fis=new FileInputStream(file.getAbsolutePath());
          PdfReader text=new PdfReader(fis);
         String expected=PdfTextExtractor.getTextFromPage(text, page);
 
         String b[] = data.split(",");

      	for (int i = 0; i < b.length; i++) {

		  if(expected.contains(b[i]))
		  continue;

	    }
  
       }
 
        catch(Exception e)
       {
         System.out.println(e);
       }
        fis.close();

       }
	
	return true;


}


public boolean delDirectory() {
	 File delDestination=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\downloadFile");
   if( delDestination.exists() ) {
     File[] files = delDestination.listFiles();
     for(int i=0; i<files.length; i++) {
        if(files[i].isDirectory()) {
        	delDirectory();
        }
        else {
          files[i].delete();
        }
     }
   }
   return( delDestination.delete() );
 }




public boolean verifyCssProperty(String path, String type,String data) {
	
			String property[] = data.split(":",2);
			String exp_prop = property[0];
			String exp_value = property[1];
			boolean flag = false;
			String prop = (explicitWaitForElement(path, type)).getCssValue(exp_prop);
			
			
			if (prop.trim().equals(exp_value.trim())) 
			{
				flag = true;
				return flag;
			}
			
			else
			{
				return flag;
				
			}
			
	

	}



	
}
