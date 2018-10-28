package com.heatclinic.pages;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.utilities.CheckWebLinks;
//import com.heatclinic.framework.PropertyReader;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.ScreenCapture;

public class CartPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]")
	private WebElement orderValue;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement orderQuantity;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-5 cart-product-pricing']//div")
	private WebElement productPrice;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/span[2]")
	private WebElement summarySubtotal;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/span[2]")
	private WebElement summaryTotalSavings;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/span[2]")
	private WebElement summaryTaxes;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[4]/span[2]")
	private WebElement summaryShipping;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[5]/span[2]")
	private WebElement summaryTotal;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	private WebElement checkoutButton;

	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	public CartPage() {
		loadCartPage();
	}

	private void loadCartPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Cartpage() {
		slowBrowser.delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String cartPageURL = driver.getCurrentUrl();
		System.out.println("Cart page URL is: " + cartPageURL);
		String cartPageTitle = driver.getTitle();
		System.out.println("Cart page title is: " + cartPageTitle);
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void change_quantity(String quantity) {
		Select quant = new Select(orderQuantity);
		quant.selectByValue(quantity);
		slowBrowser.sleeper(2000);
		System.out.println("Order quantity: " + quantity);
		slowBrowser.sleeper(1000);
		System.out.println("Order value= " + orderValue.getText());
		System.out.println("Subtotal= " + summarySubtotal.getText());
		System.out.println("Total savings= " + summaryTotalSavings.getText());
		System.out.println("Taxes= " + summaryTaxes.getText());
		System.out.println("Shipping= " + summaryShipping.getText());
		System.out.println("Final price: " + summaryTotal.getText() + "\n");
		slowBrowser.sleeper(2000);
		assertEquals("Assertion failed", orderValue.getText(), summaryTotal.getText());
	}

	public void go_to_checkout() {
		capture.webElementScreenShot(driver, checkoutButton);
		checkoutButton.click();
	}
}
