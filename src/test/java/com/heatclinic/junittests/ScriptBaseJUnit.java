package com.heatclinic.junittests;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.pages.PageManager;
import com.heatclinic.tests.TestBase;
import com.heatclinic.utilities.ScreenCapture;

public class ScriptBaseJUnit extends TestBase {

	protected ScreenCapture capture=new ScreenCapture();
	
	@BeforeClass
	public static void beginTests() {
		System.out.println("Starting all tests!");
	}

	@AfterClass
	public static void afterTests() {
		System.out.println("Ending all tests!");
	}

	public void setUp() {
		capture.startCapture("target/Video/",this.getClass().getSimpleName(), false);
		System.out.println("Opening website.");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void tearDown() {
		PageManager.getInstance().closePages();
		System.out.println("Closing browser.");
		capture.endCapture();
		try {
			DriverFactory.initialize().tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
