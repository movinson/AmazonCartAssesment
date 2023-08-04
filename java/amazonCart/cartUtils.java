package amazonCart;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class cartUtils {

	public static WebDriver driver;


	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void launchUrl() {
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}

	public void time(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String formattedDat = sdf.format(date);
		System.out.println(formattedDat);
	}

	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public String title() {
		return driver.getTitle();

	}

	public void type (WebElement element , String data) {
		element.sendKeys(data);
	}	

	public void btnClick (WebElement element) {
		element.click();
	}

	public String printText (WebElement element) {
		return element.getAttribute("value");
	}


	public void dropDown (WebElement element, String drop) throws AWTException {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(drop);

	}

	public void print(String print) {
		System.out.println(print);

	}

	public void quitBrowser() {
		driver.quit();

	}
}

