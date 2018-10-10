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
import com.heatclinic.utilities.JavaScriptActions;
import com.heatclinic.utilities.Mouseandkeyboardactions;




public class MemberPage {

	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//li[@class='dropdown']//a[@class='dropdown-toggle']")
	WebElement USER_MENU;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'My Profile')]")
	WebElement USER_PROFILE;
		
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]")
	WebElement LOG_OUT;
	
	private Mouseandkeyboardactions mousefunction=new Mouseandkeyboardactions();
	private JavaScriptActions js=new JavaScriptActions();
	private String expectedMemberPageURL="https://demo.broadleafcommerce.org/";
	LoginPage logPage=new LoginPage();
	
	
	public MemberPage() {
		loadMemberPage();
	}
		
	private void loadMemberPage() {
		this.driver=DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}
	
	public void verify_MemberPage() {
		delay(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String memberPageURL=driver.getCurrentUrl();
		Assert.assertEquals(expectedMemberPageURL, memberPageURL);
		System.out.println("Memberpage URL is: "+memberPageURL);
		String memberPageTitle=driver.getTitle();
		System.out.println("Memberpage title is: "+memberPageTitle);
	}

	public void verify_Member(){
		delay(3000);
		js.javaClickWebElement(USER_MENU, driver);
		Boolean userProf=USER_PROFILE.isDisplayed();
		System.out.println("User profile is displayed: "+ userProf);
		}
	
	public void logout() {
		if(USER_PROFILE.isDisplayed()) {
			mousefunction.mouseClick(driver, LOG_OUT);
		}else {
		mousefunction.mouseClick(driver, USER_MENU);
		mousefunction.mouseClick(driver, LOG_OUT);
		}
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


