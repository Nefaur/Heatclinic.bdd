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
import com.heatclinic.framework.PropertyReader;

public class CartPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]")
	WebElement order_Value;

	@FindBy(how = How.NAME, using = "quantity")
	WebElement order_quantity;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-5 cart-product-pricing']//div")
	WebElement product_Price;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/span[2]")
	WebElement summary_Subtotal;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/span[2]")
	WebElement summary_total_savings;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/span[2]")
	WebElement summary_Taxes;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[4]/span[2]")
	WebElement summary_Shipping;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[5]/span[2]")
	WebElement summary_Total;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	WebElement checkout_Button;

	public CartPage() {
		loadCartPage();
	}

	private void loadCartPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Cartpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String cartPageURL = driver.getCurrentUrl();
		System.out.println("Cart page URL is: " + cartPageURL);
		String cartPageTitle = driver.getTitle();
		System.out.println("Cart page title is: " + cartPageTitle);
	}

	public void change_quantity(String quantity) {
		Select quant = new Select(order_quantity);
		quant.selectByValue(quantity);
		sleeper(2000);
		System.out.println("Order quantity: " + quantity);
		sleeper(1000);
		System.out.println("Order value= " + order_Value.getText());
		System.out.println("Subtotal= " + summary_Subtotal.getText());
		System.out.println("Total savings= " + summary_total_savings.getText());
		System.out.println("Taxes= " + summary_Taxes.getText());
		System.out.println("Shipping= " + summary_Shipping.getText());
		System.out.println("Final price: " + summary_Total.getText() + "\n");
		sleeper(2000);
		assertEquals("Assertion failed", order_Value.getText(), summary_Total.getText());
	}

	public void go_to_checkout() {
		checkout_Button.click();
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
