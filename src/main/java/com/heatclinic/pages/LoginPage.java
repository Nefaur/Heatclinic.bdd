package com.heatclinic.pages;

import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.utilities.CheckWebLinks;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.JavaScriptActions;
import com.heatclinic.utilities.ScreenCapture;

import io.cucumber.datatable.DataTable;

public class LoginPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement signInEmailInput;

	@FindBy(how = How.XPATH, using = "//div[@class='label-floating form-group is-empty']//input[@id='password']")
	private WebElement signInPasswordInput;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	private WebElement signInSubmitButton;

	@FindBy(how = How.XPATH, using = "//p[@class='text-danger']")
	private WebElement loginFailAlert;

	private JavaScriptActions js = new JavaScriptActions();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	private String loginPageURL = PropertyReader.TEST_LOGINPAGE_URL;
	private String loginPageTitle = PropertyReader.TEST_LOGINPATE_TITLE;

	public LoginPage() {
		loadLoginPage();
	}

	private void loadLoginPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_LoginPage() {
		slowBrowser.delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String expectedLoginPageURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedLoginPageURL, loginPageURL);
		System.out.println("Loginpage URL is: " + expectedLoginPageURL);
		String expectedLoginPageTitle = driver.getTitle();
		Assert.assertEquals(expectedLoginPageTitle, loginPageTitle);
		System.out.println("Loginpage title is: " + expectedLoginPageTitle);
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void enterUsername(String username) {
		slowBrowser.delay(2000);
		capture.webElementScreenShot(driver, signInEmailInput);
		signInEmailInput.sendKeys(username);
		System.out.println("Username is: " + username);
	}

	public void enterPassword(String password) {
		slowBrowser.delay(2000);
		capture.webElementScreenShot(driver, signInPasswordInput);
		signInPasswordInput.sendKeys(password);
		System.out.println("Password is: " + password);
	}

	public void dataMaps(DataTable usercredentials) {
		List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
		signInEmailInput.sendKeys(data.get(0).get("Username"));
		signInPasswordInput.sendKeys(data.get(0).get("Password"));
	}

	public void dataTable(DataTable validuser) {
		List<String> list = validuser.asList(String.class);
		signInEmailInput.sendKeys(list.get(0));
		signInPasswordInput.sendKeys(list.get(1));
	}

	public void clickSubmit() {
		slowBrowser.delay(2000);
		capture.webElementScreenShot(driver, signInSubmitButton);
		js.javaClickWebElement(signInSubmitButton, driver);
	}

	public void failedLogin() {
		assertTrue(loginFailAlert.isDisplayed());
		String msg = loginFailAlert.getText();
		System.out.println(msg);
	}
}