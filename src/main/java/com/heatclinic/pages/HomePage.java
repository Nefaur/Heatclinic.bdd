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

public class HomePage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	private WebElement signInLink;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	private String expectedHomePageURL = PropertyReader.TEST_HOME_URL;

	public HomePage() {
		loadHomePage();
	}

	private void loadHomePage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void goToHomepage(String website) {
		slowBrowser.delay(2000);
		driver.navigate().to(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String homePageURL = driver.getCurrentUrl();
		Assert.assertEquals(homePageURL, expectedHomePageURL);
		System.out.println("Homepage URL is: " + homePageURL);
		String homePageTitle = driver.getTitle();
		System.out.println("Homepage title is: " + homePageTitle);
		screenShotsOfWebElement();
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void hoverOnSignIn() {
		slowBrowser.delay(4000);
		mousefunction.mouseHover(driver, signInLink);
	}

	public void clickSignIn() {
		mousefunction.mouseClick(driver, signInLink);
	}

	private void screenShotsOfWebElement() {
		capture.webElementScreenShot(driver, signInLink);
	}
}
