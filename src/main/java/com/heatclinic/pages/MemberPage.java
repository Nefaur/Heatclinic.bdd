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
import com.heatclinic.utilities.CheckWebLinks;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.Mouseandkeyboardactions;
import com.heatclinic.utilities.ScreenCapture;

public class MemberPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
	private WebElement userMenu;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[2]/li[1]/a[1]")
	private WebElement userProfile;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	private WebElement logOut;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	private String expectedMemberPageURL = PropertyReader.TEST_MEMBER_URL;

	public MemberPage() {
		loadMemberPage();
	}

	private void loadMemberPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_MemberPage() {
		slowBrowser.delay(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String memberPageURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedMemberPageURL, memberPageURL);
		System.out.println("Memberpage URL is: " + memberPageURL);
		String memberPageTitle = driver.getTitle();
		System.out.println("Memberpage title is: " + memberPageTitle);
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void verify_Member() {
		slowBrowser.delay(3000);
		capture.webElementScreenShot(driver, userMenu);
		String userlogged = userProfile.getText();
		System.out.println("User name: " + userlogged.substring(14, 20));
	}

	public void logout() {
		mousefunction.mouseClick(driver, userMenu);
		slowBrowser.sleeper(2000);
		capture.webElementScreenShot(driver, logOut);
		mousefunction.mouseClick(driver, logOut);
		System.out.println("User is logged out.");
	}
}
