package Common;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;


import Logging.EventHandler;

public class Browser {

	public static WebDriver Driver;
	private static ThreadLocal<WebDriver> ThreadDriver = null;
	protected static String baseUrl = "https://www.flipkart.com/account/login?ret=%2F";
	public static String browserHandle;
	
	public static void Intilize(@Optional("Chrome") String strBrowserType)
	{
		ThreadDriver = new ThreadLocal<>();
		Driver = ThreadDriver.get();
		if(Driver==null) {
			if(strBrowserType.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				Driver = new ChromeDriver();
				ThreadDriver.set(Driver);
			} else if(strBrowserType.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
				Driver =new InternetExplorerDriver();
				ThreadDriver.set(Driver);
			} else if(strBrowserType.equalsIgnoreCase("safari")){
				Driver = new org.openqa.selenium.safari.SafariDriver();
			} else if(strBrowserType.equalsIgnoreCase("firefox")) {
				//driver = new FirefoxDriver();
				Driver = new FirefoxDriver();
				//driver = new FirefoxDriver();
				ThreadDriver.set(Driver);
			}
		}
		NavigateToURL(baseUrl);
	}
	
	public static WebDriver getDriver()
	{
		
		return Driver;
	}
	
	public static void NavigateToURL(String baseUrl)
	{
		Driver.navigate().to(baseUrl);
		Driver.manage().window().maximize();
	}
	
	public static String strGetWindowTitle()
	{
		return Driver.getTitle();
	}
	
	@BeforeTest
	public void setup()
	{
		Intilize("Chrome");
		browserHandle= getDriver().getWindowHandle();
		PropertyConfigurator.configure("./Log/log4j.properties");
		
		NavigateToURL(baseUrl);
	}

}
