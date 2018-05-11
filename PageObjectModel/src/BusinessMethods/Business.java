package BusinessMethods;
import Common.*;
import Common.CommonUtils.enObjectType;
import Common.*;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Logging.Log;
import Pages.PagesCollection;

public class Business {

	/*CommonUtils objCommonUtils = new CommonUtils();
	GenericMethods objGenericMethods = new GenericMethods();*/
	CommonUtils objCommonUtils = PageFactory.initElements(Browser.getDriver(), CommonUtils.class);
	
	public boolean Login() throws InterruptedException
	{
		boolean blnStatus = false;
		try
		{

			PagesCollection.getCommonObjectsPage().getTxtUsername().sendKeys("srinu9tech@gmail.com");
			PagesCollection.getCommonObjectsPage().getTxtUsername().sendKeys(Keys.TAB);
			PagesCollection.getCommonObjectsPage().getTxtPassword().sendKeys("second");
			PagesCollection.getCommonObjectsPage().getBtnlogin().click();
			WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='_2cyQi_']")));
			if(Browser.getDriver().findElement(By.xpath("//span[@class='_2cyQi_']")).isDisplayed())
			{
				blnStatus = true;
				Log.info("Login :Login successful");
			}
		}
		catch(NoSuchElementException e)
		{
			Log.warn("Login :Login failed");
			blnStatus = false;
		}
		return blnStatus;
	}
	public boolean Logout()
	{
		boolean blnStatus = false;
		try
		{
			Thread.sleep(10000);
			if(PagesCollection.getCommonObjectsPage().getLnkAccountName().isDisplayed())
			{
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkAccountName());
				PagesCollection.getCommonObjectsPage().getLnkSignout().click();
				blnStatus = bFunc_SelectLinkFromDropDown(enumCategory.Logout);
				if(blnStatus)
				{
					Log.info("Logout :Logout successful");
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception :-"+e.toString());
			blnStatus = false;
		}
		return blnStatus;
	}


	public boolean bFunc_SelectCategory(enumCategory objenumCategory)
	{
		boolean blnStatus = false;
		try
		{
			switch (objenumCategory)
			{
			case  electronics :
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkElectronics());
				break;
			case  men :
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkmen());
				break;
			case  women :
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkwomen());
				break;
			case  baby_kids :
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkbaby_kids());
				break;
			case  home_furniture:
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkhome_furniture());
				break;
			case books_media:
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkbooks_media());
				break;
			case auto_sports :
				objCommonUtils.HoverMouse(PagesCollection.getCommonObjectsPage().getLnkauto_sports());
				break;
			}
		}
		catch(Exception e)
		{

		}
		return blnStatus;
	}
	
	public boolean bFunc_SelectLinkFromDropDown(enumCategory objenumCategory)
	{
		boolean blnStatus  = false;
		
		try
		{
			switch(objenumCategory)
			{
			case Logout:
				//PagesCollection.getAccoutoptionsPage().getLnkSignout().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkSignout(), enObjectType.Link, "");
				blnStatus = true;
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Logout");
				break;
			case Orders:
				//PagesCollection.getAccoutoptionsPage().getLnkOrders().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkOrders(), enObjectType.Link, "");
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Orders");
				blnStatus = true;
				break;
			case Wallet:
				//PagesCollection.getAccoutoptionsPage().getLnkWallet().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkWallet(), enObjectType.Link, "");
				blnStatus = true;
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Wallet");
				break;
			case WishList:
				//PagesCollection.getAccoutoptionsPage().getLnkWishlist().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkWishlist(), enObjectType.Link, "");
				blnStatus = true;
				Log.info("bFunc_SelectLinkFromDropDown :clicked on WishList");
				break;
			case eBooksLibrary:
				//PagesCollection.getAccoutoptionsPage().getLnkeBooks().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkeBooks(), enObjectType.Link, "");
				blnStatus = true;
				Log.info("bFunc_SelectLinkFromDropDown :clicked on eBooksLibrary");
				break;
			case Review_Ratings:
				//PagesCollection.getAccoutoptionsPage().getLnkReviews().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkReviews(), enObjectType.Link, "");
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Review_Ratings");
				blnStatus = true;
				break;
			case Recommendations:
				//PagesCollection.getAccoutoptionsPage().getLnkRecommendations().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkRecommendations(), enObjectType.Link, "");
				blnStatus = true;
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Recommendations");
				break;
			case EmailPreferences:
				//PagesCollection.getAccoutoptionsPage().getLnkEmail().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkEmail(), enObjectType.Link, "");
				Log.info("bFunc_SelectLinkFromDropDown :clicked on EmailPreferences");
				blnStatus = true;
				break;
			case Flipcartfirst:
				//PagesCollection.getAccoutoptionsPage().getLnkFlipCartFirst().click();
				objCommonUtils.gFunc_PerformObjectAction(PagesCollection.getAccoutoptionsPage().getLnkFlipCartFirst(), enObjectType.Link, "");
				Log.info("bFunc_SelectLinkFromDropDown :clicked on Flipcartfirst");
				blnStatus = true;
				break;
			}
		}
		catch(Exception e)
		{
			
		}
		return blnStatus;
	}

	public enum enumCategory
	{
		men,women,baby_kids,home_furniture,books_media,auto_sports,electronics,Orders,Wallet,WishList,eBooksLibrary,Review_Ratings,
		Recommendations,EmailPreferences,Flipcartfirst,Logout;
	}
}
