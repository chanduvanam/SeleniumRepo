package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoutOptions {

	@FindBy(xpath="//a[contains(text(),'Log')]")
	private WebElement lnkSignout;
	@FindBy(xpath="(//a[contains(text(),'Account')])[1]")
	private WebElement lnkAccount;
	@FindBy(xpath="(//a[contains(text(),'Orders')])[1]")
	private WebElement lnkOrders;
	@FindBy(xpath="(//a[contains(text(),'Wallet')])[1]")
	private WebElement lnkWallet;
	@FindBy(xpath="(//a[contains(text(),'Wishlist')])[1]")
	private WebElement lnkWishlist;							
	@FindBy(xpath="(//a[contains(text(),'eBooks')])[1]")
	private WebElement lnkeBooks;		
	@FindBy(xpath="(//a[contains(text(),'Reviews')])[1]")
	private WebElement lnkReviews;	
	@FindBy(xpath="(//a[contains(text(),'Recomme')])[1]")
	private WebElement lnkRecommendations;															
	@FindBy(xpath="(//a[contains(text(),'First')])[1]")
	private WebElement lnkFlipCartFirst;
	@FindBy(xpath="(//a[contains(text(),'Email')])[1]")
	private WebElement lnkEmail;
	@FindBy(className ="LM6RPg")
	private WebElement txtSearchFiled;
	@FindBy(xpath = "html/body/div[1]/div/div/header/div[2]/div/div[2]/div/form/input[1]")
	private WebElement btnSearchButton;
	
	public WebElement getTxtSearchFiled() {
		return txtSearchFiled;
	}
	public WebElement getBtnSearchButton() {
		return btnSearchButton;
	}
	public WebElement getLnkSignout() {
		return lnkSignout;
	}
	public WebElement getLnkAccount() {
		return lnkAccount;
	}
	public WebElement getLnkOrders() {
		return lnkOrders;
	}
	public WebElement getLnkWallet() {
		return lnkWallet;
	}
	public WebElement getLnkWishlist() {
		return lnkWishlist;
	}
	public WebElement getLnkeBooks() {
		return lnkeBooks;
	}
	public WebElement getLnkReviews() {
		return lnkReviews;
	}
	public WebElement getLnkRecommendations() {
		return lnkRecommendations;
	}
	public WebElement getLnkFlipCartFirst() {
		return lnkFlipCartFirst;
	}
	public WebElement getLnkEmail() {
		return lnkEmail;
	}


}
