package com.heatclinic.pages;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.utilities.Mouseandkeyboardactions;

public class MemberPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
	WebElement user_Menu;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[1]/a[1]")
	WebElement user_Profile;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	WebElement log_Out;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private String expectedMemberPageURL = PropertyReader.TEST_MEMBER_URL;
	LoginPage logPage = new LoginPage();

	public MemberPage() {
		loadMemberPage();
	}

	private void loadMemberPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_MemberPage() {
		delay(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String memberPageURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedMemberPageURL, memberPageURL);
		System.out.println("Memberpage URL is: " + memberPageURL);
		String memberPageTitle = driver.getTitle();
		System.out.println("Memberpage title is: " + memberPageTitle);
	}

	public void verify_Member() {
		delay(3000);
		String userlogged = user_Profile.getText();
		System.out.println("User name: " + userlogged.substring(14, 20));
	}

	public void logout() {
		mousefunction.mouseClick(driver, user_Menu);
		sleeper(2000);
		mousefunction.mouseClick(driver, log_Out);
		System.out.println("User is logged out.");
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
