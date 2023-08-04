package amazonCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class temp {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeTest
	public void addToCartAndOpenCartPage() {
		driver.get("https://www.amazon.com/");
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("HP v236w USB 2.0 64GB Pen Drive, Metal, Silver");
		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchBtn.click();

		WebElement productLink = driver.findElement(By.partialLinkText("HP v236w USB 2.0 64GB Pen Drive, Metal, Silver"));
		productLink.click();

		WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCartButton.click();

		WebElement cartIcon = driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']"));
		cartIcon.click();
	}

	@Test(priority = 1)
	public void verifyProductInCart() {
		WebElement productInCart = driver.findElement(By.xpath("//span[contains(text(),'HP v236w USB 2.0 64GB Pen Drive, Metal, Silver')]"));
		String cartProduct = productInCart.getText();
		Assert.assertEquals(cartProduct, "HP v236w USB 2.0 64GB Pen Drive, Metal, Silver");
		System.out.println("1--Product is in Cart--Test Passed--");
	}

	@Test(priority = 2)
	public void increaseProductQuantity() {
		WebElement quantityDropdown = driver.findElement(By.xpath("//span[@id='a-autoid-1-announce']"));
		Select s = new Select(quantityDropdown);
		s.selectByVisibleText("2");

		WebElement quantityVerify = driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']"));
		String quantityValue = quantityVerify.getText();
		Assert.assertEquals(quantityValue, "2");
		System.out.println("2--Product Quantity is Increased from cart--Test Passed--");
	}

	@Test(priority = 3)
	public void deleteProductFromCart() {
		WebElement deleteLink = driver.findElement(By.xpath("//input[@aria-label='Delete HP v236w USB 2.0 64GB Pen Drive, Metal, Silver']"));
		deleteLink.click();

		WebElement deletedProduct = driver.findElement(By.xpath("//h2[contains(text(),'Cart is empty')]"));
		Assert.assertNotNull(deletedProduct);
		System.out.println("3--Product can be deleted from cart--Test Passed--");
	}

	@Test(priority = 4)
	public void checkProceedToPayButton() {
		WebElement deleteLink = driver.findElement(By.xpath("//input[@aria-label='Delete HP v236w USB 2.0 64GB Pen Drive, Metal, Silver']"));
		deleteLink.click();

		WebElement proceedToPayButton = driver.findElement(By.name("proceedToRetailCheckout"));
		Assert.assertNotNull(proceedToPayButton);
		System.out.println("4--Without product checkout cannot be done--Test Passed--");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
