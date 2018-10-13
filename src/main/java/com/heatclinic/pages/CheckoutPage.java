package com.heatclinic.pages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.utilities.ExcelReader;

public class CheckoutPage extends ExcelReader {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//i[@class='material-icons text-success']")
	WebElement shipping_Tickmark;

	@FindBy(how = How.XPATH, using = "//i[@class='material-icons text-success js-checkoutStageCompleteIcon']")
	WebElement billing_Tickmark;

	@FindBy(how = How.ID, using = "fullName")
	WebElement fullName;

	@FindBy(how = How.ID, using = "addressLine1")
	WebElement address1;

	@FindBy(how = How.ID, using = "addressLine2")
	WebElement address2;

	@FindBy(how = How.ID, using = "city")
	WebElement city;

	@FindBy(how = How.ID, using = "stateProvinceRegion")
	WebElement state_Abbreviation;

	@FindBy(how = How.ID, using = "postalCode")
	WebElement postCode;

	@FindBy(how = How.ID, using = "phonePrimary")
	WebElement phone;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-6 shipping-methods-wrapper']//div[3]//label[1]//span[1]")
	WebElement express_Shipping;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger payment-alert']//div[@class='container-fluid']")
	WebElement payment_Alert;

	@FindBy(how = How.XPATH, using = "//div[@class='checkbox use-shipping-address-wrapper']//span[@class='check']")
	WebElement billing_Address_Same;

	@FindBy(how = How.XPATH, using = "//div[@class='billing-address-btn js-copiedShippingAddress']")
	WebElement billing_Address_Preview;

	@FindBy(how = How.XPATH, using = "//div[@class='card define-new-credit-card js-defineNewCreditCard']//div[@class='card-content']")
	WebElement new_Card_Payment;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save this card for future purchases')]")
	WebElement save_For_Future;

	@FindBy(how = How.ID, using = "cardNumber")
	WebElement card_Number;

	@FindBy(how = How.ID, using = "securityCode")
	WebElement security_Code;

	@FindBy(how = How.ID, using = "cardExpDate")
	WebElement card_Expiry_Date;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary pull-right js-submitCheckoutStage']")
	WebElement continue_Payment;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary pull-right js-submitPaymentCheckoutStage']")
	WebElement continue_Checkout;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/a[1]/span[1]")
	WebElement place_Order;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement order_Confirmation;

	public CheckoutPage() {
		loadCheckoutPage();
	}

	private void loadCheckoutPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Checkoutpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String checkoutPageURL = driver.getCurrentUrl();
		System.out.println("Checkout page URL is: " + checkoutPageURL);
		String checkoutPageTitle = driver.getTitle();
		System.out.println("Checkout title is: " + checkoutPageTitle);
	}

	public void enterShippingInfo() {
		sleeper(2000);
		try {
			fullName.sendKeys(readExcel(1));
			address1.sendKeys(readExcel(2));
			address2.sendKeys(readExcel(3));
			city.sendKeys(readExcel(4));
			Select state = new Select(state_Abbreviation);
			state.selectByValue(readExcel(5));
			postCode.sendKeys(readExcel(6));
			phone.sendKeys(readExcel(7));
			close_Excel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		express_Shipping.click();
		sleeper(2000);
		continue_Payment.click();
	}

	public void paymentInfo() {
		sleeper(2000);
		assertTrue(shipping_Tickmark.isDisplayed());
		assertTrue(payment_Alert.isDisplayed());
		System.out.println(payment_Alert.getText());
		if (new_Card_Payment.isDisplayed()) {
			new_Card_Payment.click();
		}
		sleeper(2000);
		save_For_Future.click();
		billing_Address_Same.click();
		System.out.println("Billing info: \n" + billing_Address_Preview.getText());
		sleeper(2000);
		try {
			card_Number.clear();
			sleeper(1000);
			card_Number.sendKeys(readExcel(8));
			security_Code.clear();
			sleeper(1000);
			security_Code.sendKeys(readExcel(9));
			card_Expiry_Date.clear();
			sleeper(1000);
			card_Expiry_Date.sendKeys(readExcel(10));
			close_Excel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		continue_Checkout.click();
		sleeper(1000);
		assertTrue(billing_Tickmark.isDisplayed());
	}

	public void order_Confirmation() {
		place_Order.click();
		sleeper(1000);
		assertTrue(order_Confirmation.isDisplayed());
		System.out.println(order_Confirmation.getText());
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
