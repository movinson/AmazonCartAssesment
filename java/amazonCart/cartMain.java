package amazonCart;
import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cartMain extends cartUtils {

	//Using POM ,Base Class with TestNG framework	
	WebDriver driver;
	cartPojo1 cp = new cartPojo1(); 

	//SetUp of Driver & Browser Launch
	@BeforeClass
	public void setup() {
		launchBrowser();
	}

	//Launching of URL and navigate to Cart	
	@BeforeTest
	public void addToCartAndOpenCartPage() {
		launchUrl();
		implicitlyWait();
		type(cp.searchBox(),"HP v236w USB 2.0 64GB Pen Drive, Metal, Silver");
		cp.searchBtn().click();
		implicitlyWait();
		cp.productLink().click();
		implicitlyWait();
		cp.addToCartButton().click();
		implicitlyWait();
		cp.cartIcon().click();
		implicitlyWait();
		print("PreRes Passed");
	}

	//Verify whether we landed on Cart Page
	@Test(priority = 1)
	public void getTitle() {
		String Title = title();
		Assert.assertEquals("Amazon.in Shopping Cart",Title);
		print("1--Landed on Right Page--1--Test Passed--1");
	}

	//Verify whether the added products present in the cart
	@Test(priority = 2)
	public void verifyProductInCart() {
		String cartProduct = cp.productInCart().getText();
		Assert.assertEquals(cartProduct,"HP v236w USB 2.0 64GB Pen Drive, Metal, Silver");
		print("2--Product is in Cart--Test Passed--2");
	}

	//Verify whether the quantity of the products in the cart can be modified in cart page
	@Test(priority = 3)
	public void increaseProductQuantity() throws AWTException {
		implicitlyWait();
		dropDown(cp.quantityDropdown(),"2");
		Assert.assertEquals("2",cp.quantityVerify().getText());
		print("3--Product Quantity is Increased from cart--Test Passed--3");
	}

	//Verify whether the products in the cart can be deleted in cart page
	@Test(priority = 4)
	public void deleteProductFromCart() {
		cp.deleteLink().click();
		implicitlyWait();
		Assert.assertNotNull(cp.deletedProduct());
		System.out.print("4--Product can be deleted from cart--Test Passed--4");

	}

	//Verify whether the User can Checkout without any product in cart
	@Test(priority = 5)
	public void checkProceedToPayButton() {
		cp.deleteLink().click();
		implicitlyWait();
		Assert.assertNotNull(cp.proceedToPayButton());
		print("5--Without product checkout cannot be done--Test Passed--5");
	}

	//End Time	
	@AfterTest
	public void EveryTestEndTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String formattedDat = sdf.format(date);
		System.out.println("The End Time is :" +formattedDat);
	}

	//TearDown Browser
	@AfterClass
	public void tearDown() {
		driver.quit();
		print("Test Completed sucessfully");
	}
}
