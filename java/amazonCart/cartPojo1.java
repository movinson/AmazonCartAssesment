package amazonCart;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPojo1 {
	public static WebDriver driver;
	public cartPojo1() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchBtn;

	@FindBy(xpath = "HP v236w USB 2.0 64GB Pen Drive, Metal, Silver")
	private WebElement productLink;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[@id='attach-sidesheet-view-cart-button-announce']")
	private WebElement cartIcon;
	

	@FindBy(xpath = "HP v236w USB 2.0 64GB Pen Drive, Metal, Silver")
	private WebElement productInCart;


	@FindBy(xpath = "//span[@id='a-autoid-1-announce']")
	private WebElement quantityDropdown;

	@FindBy(xpath = "\"a-dropdown-prompt")
	private WebElement quantityVerify;

	@FindBy(xpath = "//input[@aria-label='Delete HP v236w USB 2.0 64GB Pen Drive, Metal, Silver']")
	private WebElement deleteLink;

	@FindBy(xpath = "//h2[contains(text(),'Shopping Cart is empty')]")
	private WebElement deletedProduct;

	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToPayButton;

	/////////////////////////////////

	public WebElement searchBox() {
		return searchBox;
	}

	public WebElement searchBtn() {
		return searchBtn;
	}

	public WebElement productLink() {
		return productLink;
	}

	public WebElement addToCartButton() {
		return addToCartButton;
	}

	public WebElement cartIcon() {
		return cartIcon;
	}
	
	public WebElement productInCart() {
		return productInCart;
	}

	public WebElement quantityDropdown() {
		return quantityDropdown;
	}

	public WebElement quantityVerify() {
		return quantityVerify;
	}

	public WebElement deleteLink() {
		return deleteLink;
	}

	public WebElement deletedProduct() {
		return deletedProduct;
	}

	public WebElement proceedToPayButton() {
		return proceedToPayButton;
	}

}



