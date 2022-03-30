package Utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverUtil extends KeywordUtil{
	
	public static AppiumDriverLocalService service = null;
	public static boolean adbFlag;
	@SuppressWarnings("rawtypes")
	public static Wait wait;
	public static String deviceVersion;
	public static  String browserVersion;
	public static String webBrowserName;
	
	
	
	
public static void getBrowser(String browserName) throws Exception {
		
		
		if(driver==null)
		
		{
		if (browserName.equalsIgnoreCase("Chrome")) {
										
			File dir=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\downloadFile");
			 if(!dir.exists())
			    dir.mkdir();
			 
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//ChromeDriverManager.getInstance().setup();
			File chromeExecutable = new File(Utility.GetValue("ChromeDriverPath"));
			   System.setProperty("webdriver.chrome.driver", chromeExecutable.getAbsolutePath());
			Map<String, Object> prefs = new HashMap<String, Object>();  
			prefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
			prefs.put("download.default_directory",  System.getProperty("user.dir")+ "\\src\\test\\resources\\downloadFile");
			
			ChromeOptions options = new ChromeOptions();
			 options.setExperimentalOption("prefs", prefs);
		     options.addArguments("--disable-extensions");
		     options.addArguments("--disable-popup-blocking"); 
		     capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		     driver = new ChromeDriver(capabilities);
		     getBrowserNameAndVersion();
				
				
			  }

			else if (browserName.equalsIgnoreCase("IE")) {
				
					InternetExplorerDriverManager.getInstance().setup();
					DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
					capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					capabilitiesIE.setCapability("ie.ensureCleanSession", true);
					capabilitiesIE.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
					driver = new InternetExplorerDriver(capabilitiesIE);
					getBrowserNameAndVersion();
				
			}
		
		
		else if (browserName.equalsIgnoreCase("PhantomJS")) {
			
			 File file = new File("E:\\PJS\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");    
             System.setProperty("phantomjs.binary.path", file.getAbsolutePath());  
              driver = new PhantomJSDriver(); 
		
	}
		
		
		

			else {
				
					driver = new FirefoxDriver();
					getBrowserNameAndVersion();

				
			}

			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(GetIntValue("implicitlyWait"), TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

		}
		
		
		
	}
	
	

	public static void getBrowserNameAndVersion() {
		org.openqa.selenium.Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		webBrowserName = caps.getBrowserName();
		browserVersion = caps.getVersion();
	}
	

}
