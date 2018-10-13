package com.heatclinic.pages;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.utilities.JavaScriptActions;

public class ProductPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary js-addToCart']")
	WebElement add_To_Cart;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-secondary']")
	WebElement added_To_Cart;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/h3[1]")
	WebElement selected_Product;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/h3[1]/span[1]")
	WebElement selected_Product_Price;

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right']//i[@class='material-icons'][contains(text(),'shopping_cart')]")
	WebElement cart_Icon;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown js-miniCart open']//li[@class='mini-cart-subtotal']//div")
	WebElement cart_Wrapper_Subtotal;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[2]/div[1]/span[1]")
	WebElement item_Name_In_Wrapper;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/a[1]/span[1]")
	WebElement number_Items_Cart;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[1]")
	WebElement empty_Cart;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
	WebElement view_Cart;

	private JavaScriptActions js = new JavaScriptActions();

	public ProductPage() {
		loadProductPage();
	}

	private void loadProductPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Productpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String productPageURL = driver.getCurrentUrl();
		System.out.println("Product page URL is: " + productPageURL);
		String productPageTitle = driver.getTitle();
		System.out.println("Product title is: " + productPageTitle);
	}

	public void product_Details() {
		System.out.println("Selected sauce: " + selected_Product.getText() + "\nPrice of product: "
				+ selected_Product_Price.getText());
	}

	public void addToCart() {
		delay(2000);
		js.javaClickWebElement(add_To_Cart, driver);
		sleeper(2000);
		if (added_To_Cart.isDisplayed()) {
			System.out.println("Item added to cart.");
		} else {
			System.out.println("Item not added to cart.");
		}
	}

	public void go_to_cartpage() {
		System.out.println("Total number of items in cart: " + number_Items_Cart.getText());
		sleeper(2000);
		System.out.println("Items in cart: " + item_Name_In_Wrapper.getText() + "\n" + cart_Wrapper_Subtotal.getText());
		view_Cart.click();
	}

	private void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void delay(int time) {
		String tbrowser = PropertyReader.BROWSER_TO_RUN;
		switch (tbrowser) {

		case "chrome":
			sleeper(time - time);
			break;

		case "ch-grid":
			sleeper(time - time);
			break;

		case "ch-cloud":
			sleeper(time - time);
			break;

		case "":
			sleeper(time - time);
			break;

		default:
			sleeper(time);
			break;
		}
	}
}
