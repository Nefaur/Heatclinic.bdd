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
import com.heatclinic.utilities.JavaScriptActions;
import io.cucumber.datatable.DataTable;

public class LoginPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	WebElement sign_In_Email_Input;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement sign_In_Password_Input;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	WebElement sign_In_Submit_Button;

	@FindBy(how = How.XPATH, using = "//p[@class='text-danger']")
	WebElement login_Fail_Alert;

	private JavaScriptActions js = new JavaScriptActions();
	private String loginPageURL = "https://demo.broadleafcommerce.org/login";
	private String loginPageTitle = "Broadleaf Commerce Demo Store - Heat Clinic - Login";

	public LoginPage() {
		loadLoginPage();
	}

	private void loadLoginPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_LoginPage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String expectedLoginPageURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedLoginPageURL, loginPageURL);
		System.out.println("Loginpage URL is: " + expectedLoginPageURL);
		String expectedLoginPageTitle = driver.getTitle();
		Assert.assertEquals(expectedLoginPageTitle, loginPageTitle);
		System.out.println("Loginpage title is: " + expectedLoginPageTitle);
	}

	public void enterUsername(String username) {
		delay(2000);
		sign_In_Email_Input.sendKeys(username);
		System.out.println("Username is: " + username);
	}

	public void enterPassword(String password) {
		delay(2000);
		sign_In_Password_Input.sendKeys(password);
		System.out.println("Password is: " + password);
	}

	public void dataMaps(DataTable usercredentials) {
		List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
		sign_In_Email_Input.sendKeys(data.get(0).get("Username"));
		sign_In_Password_Input.sendKeys(data.get(0).get("Password"));
	}

	public void dataTable(DataTable validuser) {
		List<String> list = validuser.asList(String.class);
		sign_In_Email_Input.sendKeys(list.get(0));
		sign_In_Password_Input.sendKeys(list.get(1));
	}

	public void clickSubmit() {
		delay(2000);
		js.javaClickWebElement(sign_In_Submit_Button, driver);
	}

	public void failedLogin() {
		assertTrue(login_Fail_Alert.isDisplayed());
		String msg = login_Fail_Alert.getText();
		System.out.println(msg);
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