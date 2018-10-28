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
import com.heatclinic.utilities.CheckWebLinks;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.ExcelReader;
import com.heatclinic.utilities.ScreenCapture;

public class CheckoutPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//i[@class='material-icons text-success']")
	private WebElement shippingTickmark;

	@FindBy(how = How.XPATH, using = "//i[@class='material-icons text-success js-checkoutStageCompleteIcon']")
	private WebElement billingTickmark;

	@FindBy(how = How.ID, using = "fullName")
	private WebElement fullName;

	@FindBy(how = How.ID, using = "addressLine1")
	private WebElement address1;

	@FindBy(how = How.ID, using = "addressLine2")
	private WebElement address2;

	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	@FindBy(how = How.ID, using = "stateProvinceRegion")
	private WebElement stateAbbreviation;

	@FindBy(how = How.ID, using = "postalCode")
	private WebElement postCode;

	@FindBy(how = How.ID, using = "phonePrimary")
	private WebElement phone;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-6 shipping-methods-wrapper']//div[3]//label[1]//span[1]")
	private WebElement expressShipping;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger payment-alert']//div[@class='container-fluid']")
	private WebElement paymentAlert;

	@FindBy(how = How.XPATH, using = "//div[@class='checkbox use-shipping-address-wrapper']//span[@class='check']")
	private WebElement billingAddressSame;

	@FindBy(how = How.XPATH, using = "//div[@class='billing-address-btn js-copiedShippingAddress']")
	private WebElement billingAddressPreview;

	@FindBy(how = How.XPATH, using = "//div[@class='card define-new-credit-card js-defineNewCreditCard']//div[@class='card-content']")
	private WebElement newCardPayment;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save this card for future purchases')]")
	private WebElement saveForFuture;

	@FindBy(how = How.ID, using = "cardNumber")
	private WebElement cardNumber;

	@FindBy(how = How.ID, using = "securityCode")
	private WebElement securityCode;

	@FindBy(how = How.ID, using = "cardExpDate")
	private WebElement cardExpiryDate;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary pull-right js-submitCheckoutStage']")
	private WebElement continuePayment;

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary pull-right js-submitPaymentCheckoutStage']")
	private WebElement continueCheckout;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/a[1]/span[1]")
	private WebElement placeOrder;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	private WebElement orderConfirmation;

	private ExcelReader excel = new ExcelReader();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	public CheckoutPage() {
		loadCheckoutPage();
	}

	private void loadCheckoutPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_Checkoutpage() {
		slowBrowser.delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String checkoutPageURL = driver.getCurrentUrl();
		System.out.println("Checkout page URL is: " + checkoutPageURL);
		String checkoutPageTitle = driver.getTitle();
		System.out.println("Checkout title is: " + checkoutPageTitle);
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void enterShippingInfo() {
		slowBrowser.sleeper(2000);
		try {
			capture.webElementScreenShot(driver, fullName);
			fullName.sendKeys(excel.readExcel(1));
			capture.webElementScreenShot(driver, address1);
			address1.sendKeys(excel.readExcel(2));
			capture.webElementScreenShot(driver, address2);
			address2.sendKeys(excel.readExcel(3));
			capture.webElementScreenShot(driver, city);
			city.sendKeys(excel.readExcel(4));
			Select state = new Select(stateAbbreviation);
			state.selectByValue(excel.readExcel(5));
			capture.webElementScreenShot(driver, postCode);
			postCode.sendKeys(excel.readExcel(6));
			capture.webElementScreenShot(driver, phone);
			phone.sendKeys(excel.readExcel(7));
			excel.close_Excel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		expressShipping.click();
		slowBrowser.sleeper(2000);
		continuePayment.click();
	}

	public void paymentInfo() {
		slowBrowser.sleeper(2000);
		assertTrue(shippingTickmark.isDisplayed());
		assertTrue(paymentAlert.isDisplayed());
		System.out.println(paymentAlert.getText());
		if (newCardPayment.isDisplayed()) {
			newCardPayment.click();
		}
		slowBrowser.sleeper(2000);
		saveForFuture.click();
		slowBrowser.sleeper(2000);
		billingAddressSame.click();
		System.out.println("Billing info: \n" + billingAddressPreview.getText());
		slowBrowser.sleeper(2000);
		try {
			cardNumber.clear();
			slowBrowser.sleeper(1000);
			cardNumber.sendKeys(excel.readExcel(8));
			securityCode.clear();
			slowBrowser.sleeper(1000);
			securityCode.sendKeys(excel.readExcel(9));
			cardExpiryDate.clear();
			slowBrowser.sleeper(1000);
			cardExpiryDate.sendKeys(excel.readExcel(10));
			excel.close_Excel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		continueCheckout.click();
		slowBrowser.sleeper(1000);
		assertTrue(billingTickmark.isDisplayed());
	}

	public void order_Confirmation() {
		placeOrder.click();
		slowBrowser.sleeper(1000);
		assertTrue(orderConfirmation.isDisplayed());
		System.out.println(orderConfirmation.getText());
	}
}
