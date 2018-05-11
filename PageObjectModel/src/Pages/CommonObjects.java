package Pages;

import org.openqa.selenium.WebElement;
import Common.*;
import org.openqa.selenium.support.FindBy;

import Common.Browser;

public class CommonObjects {


	CommonUtils objCommonUtils = new CommonUtils();
	@FindBy(xpath="(//div[@class='_39M2dM']//input)[1]")
	private WebElement txtUsername;
	@FindBy(xpath = "(//div[@class='_39M2dM']//input)[2]")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement btnlogin;
	@FindBy(xpath="//span[@class='_2cyQi_']")
	private WebElement lnkAccountName;
	@FindBy(xpath="//a[contains(text(),'Log')]")
	private WebElement lnkSignout;
	@FindBy(xpath = "//h1 ")
	private WebElement txtPageName;
	
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	private WebElement lnkLogin;
	
	public WebElement getLnkLogin() {
		return lnkLogin;
	}
	public WebElement getTxtPageName() {
		return txtPageName;
	}
	public CommonUtils getObjCommonUtils() {
		return objCommonUtils;
	}
	public WebElement getLnkElectronics() {
		return lnkElectronics;
	}
	public WebElement getLnkmen() {
		return lnkmen;
	}
	public WebElement getLnkwomen() {
		return lnkwomen;
	}
	public WebElement getLnkbaby_kids() {
		return lnkbaby_kids;
	}
	public WebElement getLnkhome_furniture() {
		return lnkhome_furniture;
	}
	public WebElement getLnkbooks_media() {
		return lnkbooks_media;
	}
	public WebElement getLnkauto_sports() {
		return lnkauto_sports;
	}
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Electronics')]")
	private WebElement lnkElectronics;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Men')]")
	private WebElement lnkmen;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Women')]")
	private WebElement lnkwomen;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Baby & Kids')]")
	private WebElement lnkbaby_kids;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Home & Furniture')]")
	private WebElement lnkhome_furniture;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'TVs & Appliances')]")
	private WebElement lnkbooks_media;
	@FindBy(xpath="//li[@class='Wbt_B2']//a[contains(@title,'Sports, Books & More')]")
	private WebElement lnkauto_sports;


	public WebElement getLnkAccountName() {
		boolean blnStatus = false;
		blnStatus = objCommonUtils.gFunc_CheckElementExistence(lnkAccountName);
		if(blnStatus)
			return lnkAccountName;
		else
			return null;
	}
	public WebElement getLnkSignout() {
		return lnkSignout;
	}
	public WebElement getTxtUsername() {

		boolean blnStatus = false;
		blnStatus = objCommonUtils.gFunc_CheckElementExistence(txtUsername);
		if(blnStatus)
			return txtUsername;
		else
			return null;
	}
	public WebElement getTxtPassword() {
		boolean blnStatus = false;
		blnStatus = objCommonUtils.gFunc_CheckElementExistence(txtPassword);
		if(blnStatus)
			return txtPassword;
		else
			return null;
	}
	public WebElement getBtnlogin() {
		boolean blnStatus = false;
		blnStatus = objCommonUtils.gFunc_CheckElementExistence(btnlogin);
		if(blnStatus)
			return btnlogin;
		else
			return null;
	}


}
