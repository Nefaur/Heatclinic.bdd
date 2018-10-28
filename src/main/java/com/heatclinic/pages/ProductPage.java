package com.heatclinic.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.utilities.CheckWebLinks;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.JavaScriptActions;
import com.heatclinic.utilities.ScreenCapture;

public class ProductPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary js-addToCart']")
	private WebElement addToCart;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-secondary']")
	private WebElement addedToCart;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/h3[1]")
	private WebElement selectedProduct;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/h3[1]/span[1]")
	private WebElement selectedProductPrice;

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right']//i[@class='material-icons'][contains(text(),'shopping_cart')]")
	private WebElement cartIcon;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown js-miniCart open']//li[@class='mini-cart-subtotal']//div")
	private WebElement cartWrapperSubtotal;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[2]/div[1]/span[1]")
	private WebElement itemNameInWrapper;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/a[1]/span[1]")
	private WebElement numberOfItemsCart;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[1]")
	private WebElement emptyCart;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
	private WebElement viewCart;

	private JavaScriptActions js = new JavaScriptActions();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture=new ScreenCapture();

	public ProductPage() {
		loadProductPage();
	}

	private void loadProductPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Productpage() {
		slowBrowser.delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String productPageURL = driver.getCurrentUrl();
		System.out.println("Product page URL is: " + productPageURL);
		String productPageTitle = driver.getTitle();
		System.out.println("Product title is: " + productPageTitle);
	}
	
	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void product_Details() {
		System.out.println("Selected sauce: " + selectedProduct.getText() + "\nPrice of product: "
				+ selectedProductPrice.getText());
	}

	public void addToCart() {
		slowBrowser.delay(2000);
		capture.webElementScreenShot(driver, addToCart);	
		js.javaClickWebElement(addToCart, driver);
		slowBrowser.sleeper(2000);
		if (addedToCart.isDisplayed()) {
			System.out.println("Item added to cart.");
		} else {
			System.out.println("Item not added to cart.");
		}
	}

	public void go_to_cartpage() {
		System.out.println("Total number of items in cart: " + numberOfItemsCart.getText());
		slowBrowser.sleeper(2000);
		System.out.println("Items in cart: " + itemNameInWrapper.getText() + "\n" + cartWrapperSubtotal.getText());
		capture.webElementScreenShot(driver, viewCart);	
		viewCart.click();
	}
}
