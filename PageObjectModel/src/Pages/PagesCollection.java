package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Common.*;

public class PagesCollection {
	
	//private WebDriver driver;
	public static CommonObjects getCommonObjectsPage()
	{
	return PageFactory.initElements(Browser.getDriver(), CommonObjects.class);
	
	}
	public static AccoutOptions getAccoutoptionsPage()
	{
	return PageFactory.initElements(Browser.getDriver(), AccoutOptions.class);
	
	}

}
