package TestCases;
import java.util.List;
import java.util.concurrent.TimeUnit;
import BusinessMethods.Business;
import BusinessMethods.Business.enumCategory;
import Logging.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.*;
import Pages.*;

public class TestCase3 extends Browser {

	//Business objBusiness = new Business();
	//CommonUtils objCommonUtils = new CommonUtils();

	Business objBusiness = PageFactory.initElements(Browser.getDriver(), Business.class);
	CommonUtils objCommonUtils = PageFactory.initElements(Browser.getDriver(), CommonUtils.class);
	
	
	// Logger logger=Logger.getLogger("TestCase2");
	// configure log4j properties file
	//
	@Test
	public void Test1() throws InterruptedException
	{
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(Browser.getDriver());
		 EventHandler objEventHandler = new EventHandler();
		 eventDriver.register(objEventHandler);
		 
		 eventDriver.navigate().to("http://relevantcodes.com/get-rowcolumn-of-an-object-in-a-webtable/");
		int Rows = objCommonUtils.getTableRowCount("(//table)[1]");
		System.out.println(Rows);
		int cols = objCommonUtils.getTableColumnCount("(//table)[1]");
		System.out.println(cols);
		String[] strHeaders = objCommonUtils.getHeaderNames("(//table)[1]");
		for(String str:strHeaders)
		{
			System.out.println(str);
		}
		int num= objCommonUtils.getRowWithCellText("(//table)[1]", "12348");
		System.out.println(num);
		List<WebElement> obj= objCommonUtils.getTableRows("(//table)[1]");
		for(WebElement e: obj)
		{
			e.click();
			System.out.println(e.getText());
		}
		objCommonUtils.PerformOperationsOnTable("(//table)[1]", "ID", "Attending class? ", "12348", "");
		
	}
	@AfterTest
	public void Logout()
	{

	}

}
