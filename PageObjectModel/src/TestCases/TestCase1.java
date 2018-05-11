package TestCases;
import java.util.concurrent.TimeUnit;
import BusinessMethods.Business;
import BusinessMethods.Business.enumCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.*;
import Logging.Log;
import Pages.*;

public class TestCase1 extends Browser {

	Business objBusiness = new Business();
	CommonUtils objCommonUtils = new CommonUtils();
	boolean blnStatus = false;
	boolean blnSelect = false;
	@Test
	public void Test1() throws InterruptedException
	{
		boolean blnStatus = false;
		
		blnStatus = objBusiness.Login();
		if(!blnStatus)
		System.out.println("Sorry for failed....");
		
		objBusiness.bFunc_SelectCategory(enumCategory.auto_sports);
		
		objBusiness.bFunc_SelectCategory(enumCategory.electronics);
		
		objBusiness.bFunc_SelectCategory(enumCategory.women);
	}
	
	
	@AfterTest
	public void Logout()
	{
		blnStatus = objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkAccountName());
		Log.info("Account link exist");
		blnSelect =objBusiness.bFunc_SelectLinkFromDropDown(enumCategory.Logout);
		Assert.assertEquals(PagesCollection.getCommonObjectsPage().getLnkLogin().getText(),"Log In");
		Log.info("Navigated to  Home");
	}
}
