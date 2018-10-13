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

public class HomePage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	WebElement sign_In_Link;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private String expectedHomePageURL = PropertyReader.TEST_HOME_URL;

	public HomePage() {
		loadHomePage();
	}

	private void loadHomePage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void goToHomepage(String website) {
		delay(2000);
		driver.navigate().to(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String homePageURL = driver.getCurrentUrl();
		Assert.assertEquals(homePageURL, expectedHomePageURL);
		System.out.println("Homepage URL is: " + homePageURL);
		String homePageTitle = driver.getTitle();
		System.out.println("Homepage title is: " + homePageTitle);
	}

	public void hoverOnSignIn() {
		delay(4000);
		mousefunction.mouseHover(driver, sign_In_Link);
	}

	public void clickSignIn() {
		mousefunction.mouseClick(driver, sign_In_Link);
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
