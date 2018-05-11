package TestCases;
import Reporting.*;
import BusinessMethods.Business;
import BusinessMethods.Business.enumCategory;
import Logging.*;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Common.*;
import Common.CommonUtils.enObjectType;
import Pages.*;

public class TestCase2 extends Browser {

	//Business objBusiness = new Business();
	//CommonUtils objCommonUtils = new CommonUtils();

	Business objBusiness = PageFactory.initElements(Browser.getDriver(), Business.class);
	CommonUtils objCommonUtils = PageFactory.initElements(Browser.getDriver(), CommonUtils.class);
	boolean blnStatus = false;
	boolean blnSelect = false;
	@Test
	public void LoginToFlipCart() throws InterruptedException, IOException
	{
		blnStatus = objBusiness.Login();
		if(!blnStatus)
		{
			Log.info("login method failed");
			HtmlReporting.createResult("FlipCartLogin", "Login to FlipCart site", "Fail");
		}
		else
		{
			Log.info("Login Method passed");
			HtmlReporting.createResult("", "Login to FlipCart site", "Pass");
		}

	}
@Test
	public void SearchInFlipKart() throws IOException
	{
		//Map<String,String> objTestData= objCommonUtils.gFunc_ReadTestData("", "", 1);
		blnStatus=	objCommonUtils.gFunc_CheckElementExistence(PagesCollection.getAccoutoptionsPage().getTxtSearchFiled());
	
			blnStatus=	objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getTxtSearchFiled(), enObjectType.TextBox, "iphone");

		PagesCollection.getAccoutoptionsPage().getBtnSearchButton().click();
		

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
