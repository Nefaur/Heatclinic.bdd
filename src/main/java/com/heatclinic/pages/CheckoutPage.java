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

public class CheckoutPage extends ExcelReader{

	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//i[@class='material-icons text-success']")
	WebElement SHIPPING_TICKMARK;
	
	@FindBy(how=How.XPATH,using="//i[@class='material-icons text-success js-checkoutStageCompleteIcon']")
	WebElement BILLING_TICKMARK;
	
	@FindBy(how=How.ID,using="fullName")
	WebElement FULLNAME;
	
	@FindBy(how=How.ID,using="addressLine1")
	WebElement ADDRESS1;
	
	@FindBy(how=How.ID,using="addressLine2")
	WebElement ADDRESS2;
	
	@FindBy(how=How.ID,using="city")
	WebElement CITY;
	
	@FindBy(how=How.ID,using="stateProvinceRegion")
	WebElement STATE;
	
	@FindBy(how=How.ID,using="postalCode")
	WebElement POSTCODE;
	
	@FindBy(how=How.ID,using="phonePrimary")
	WebElement PHONE;

	@FindBy(how=How.XPATH,using="//div[@class='col-sm-6 shipping-methods-wrapper']//div[3]//label[1]//span[1]")
	WebElement EXPSHIPPING;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-danger payment-alert']//div[@class='container-fluid']")
	WebElement PAYMENT_ALERT;
	
	@FindBy(how=How.XPATH,using="//div[@class='checkbox use-shipping-address-wrapper']//span[@class='check']")
	WebElement BILLING_ADDRESS_SAME;
	
	@FindBy(how=How.XPATH,using="//div[@class='billing-address-btn js-copiedShippingAddress']")
	WebElement BILLING_ADDRESS_PREVIEW;
	
	@FindBy(how=How.XPATH,using="//div[@class='card define-new-credit-card js-defineNewCreditCard']//div[@class='card-content']")
	WebElement NEW_CARD_PAYMENT;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Save this card for future purchases')]")
	WebElement SAVE_FOR_FUTURE;
	
	@FindBy(how=How.ID,using="cardNumber")
	WebElement CARD_NUMBER;
	
	@FindBy(how=How.ID,using="securityCode")
	WebElement SECURITY_CODE;
	
	@FindBy(how=How.ID,using="cardExpDate")
	WebElement CARD_EXP_DATE;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-primary pull-right js-submitCheckoutStage']")
	WebElement CONTINUE_PAYMENT;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-primary pull-right js-submitPaymentCheckoutStage']")
	WebElement CONTINUE_CHECKOUT;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/a[1]/span[1]")
	WebElement PLACE_ORDER;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement ORDER_CONFIRMATION;
	
	public CheckoutPage(){
		loadCheckoutPage();
	}
	
	private void loadCheckoutPage() {
		this.driver=DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}
	
	public void verify_Checkoutpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String checkoutPageURL=driver.getCurrentUrl();
		System.out.println("Checkout page URL is: "+checkoutPageURL);
		String checkoutPageTitle=driver.getTitle();
		System.out.println("Checkout title is: "+checkoutPageTitle);
	}
	
	public void enterShippingInfo(){
		sleeper(2000);
		try {
			FULLNAME.sendKeys(readExcel(1));
			ADDRESS1.sendKeys(readExcel(2));
			ADDRESS2.sendKeys(readExcel(3));
			CITY.sendKeys(readExcel(4));
			Select state=new Select(STATE);
			state.selectByValue(readExcel(5));
			POSTCODE.sendKeys(readExcel(6));
			PHONE.sendKeys(readExcel(7));
			close_Excel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			EXPSHIPPING.click();
			sleeper(2000);
			CONTINUE_PAYMENT.click();
	}
	
	public void paymentInfo() {
		sleeper(2000);
		assertTrue(SHIPPING_TICKMARK.isDisplayed());
		assertTrue(PAYMENT_ALERT.isDisplayed());
		System.out.println(PAYMENT_ALERT.getText());
		if(NEW_CARD_PAYMENT.isDisplayed()) {
			NEW_CARD_PAYMENT.click();
		}
		sleeper(2000);
		SAVE_FOR_FUTURE.click();
		BILLING_ADDRESS_SAME.click();
		System.out.println("Billing info: \n"+BILLING_ADDRESS_PREVIEW.getText());
		sleeper(2000);
		try {
			CARD_NUMBER.clear();
			sleeper(1000);
			CARD_NUMBER.sendKeys(readExcel(8));
			SECURITY_CODE.clear();
			sleeper(1000);
			SECURITY_CODE.sendKeys(readExcel(9));
			CARD_EXP_DATE.clear();
			sleeper(1000);
			CARD_EXP_DATE.sendKeys(readExcel(10));
			close_Excel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CONTINUE_CHECKOUT.click();
		sleeper(1000);
		assertTrue(BILLING_TICKMARK.isDisplayed());
	}
	
	public void order_Confirmation() {
		PLACE_ORDER.click();
		sleeper(1000);
		assertTrue(ORDER_CONFIRMATION.isDisplayed());
		System.out.println(ORDER_CONFIRMATION.getText());
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
