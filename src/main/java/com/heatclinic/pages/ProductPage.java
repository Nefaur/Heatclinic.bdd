package com.heatclinic.pages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
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
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary js-addToCart']")
	WebElement ADD_TO_CART;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-secondary']")
	WebElement ADDED_TO_CART;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/h3[1]")
	WebElement SELECTED_PRODUCT;

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/h3[1]/span[1]")
	WebElement SELECTED_PRODUCT_PRICE;
	
	@FindBy(how=How.XPATH,using="//i[contains(text(),'favorite_border')]")
	WebElement FAVORITE_BUTTON;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='toast-message']")
	WebElement FAVORITE_SUCCESS;
	
	@FindBy(how=How.XPATH,using="//ul[@class='nav navbar-nav navbar-right']//i[@class='material-icons'][contains(text(),'shopping_cart')]")
	WebElement CART_ICON;
	
//	@FindBy(how=How.XPATH,using="//li[@class='dropdown js-miniCart open']//ul[@class='dropdown-menu mini-cart-wrapper']")
//	WebElement OPEN_CART_WRAPPER;
	
	@FindBy(how=How.XPATH,using="//li[@class='dropdown js-miniCart open']//li[@class='mini-cart-subtotal']//div")
	WebElement CART_WRAPPER_SUBTOTAL;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[2]/div[1]/span[1]")
	WebElement ITEM_NAME_IN_WRAPPER;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/a[1]/span[1]")
	WebElement NO_ITEMS_IN_CART;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[4]/ul[1]/li[1]/div[1]")
	WebElement EMPTY_CART;
	
	@FindBy(how=How.XPATH,using="//li[@class='dropdown js-miniCart open']//a[@class='btn btn-primary goto-full-cart'][contains(text(),'View Your Cart')]")
	WebElement VIEW_CART;
	
	private JavaScriptActions js=new JavaScriptActions();
	
	public ProductPage(){
		loadProductPage();
	}
	
	private void loadProductPage() {
		this.driver=DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}
	
	public void verify_Productpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String productPageURL=driver.getCurrentUrl();
		System.out.println("Product page URL is: "+productPageURL);
		String productPageTitle=driver.getTitle();
		System.out.println("Product title is: "+productPageTitle);
	}
	
	public void product_Details() {
		System.out.println("Selected sauce: "+SELECTED_PRODUCT.getText()+"\nPrice of product: "+SELECTED_PRODUCT_PRICE.getText());	
	}
	
	public void addToCart() {
		delay(2000);
			FAVORITE_BUTTON.click();
			sleeper(2000);
			assertTrue(FAVORITE_SUCCESS.isDisplayed());
			System.out.println(FAVORITE_SUCCESS.getText());
			delay(3000);
			sleeper(1000);
			js.javaClickWebElement(ADD_TO_CART, driver);
			sleeper(2000);
			if(ADDED_TO_CART.isDisplayed()) {
			System.out.println("Item added to cart.");
			}else{
			System.out.println("Item not added to cart.");
	}
		}
		
		
	public void go_to_cartpage() {
		System.out.println("Total number of items in cart: "+NO_ITEMS_IN_CART.getText());
		sleeper(2000);
		System.out.println("Items in cart: "+ITEM_NAME_IN_WRAPPER.getText()+"\n"+CART_WRAPPER_SUBTOTAL.getText());
		VIEW_CART.click();
		}
	
	private void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void delay(int time) {
		String tbrowser=PropertyReader.BROWSER_TO_RUN;
		switch (tbrowser) {
		
		case "chrome":
			sleeper(time-time);
			break;
		
		case "ch-grid":
			sleeper(time-time);
			break;
			
		case "ch-cloud":
			sleeper(time-time);
			break;
			
		case "":
			sleeper(time-time);
			break;
			
		default:
			sleeper(time);
			break;
	}
}

	
	
	
}
