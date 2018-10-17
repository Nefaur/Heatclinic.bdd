package com.heatclinic.junittests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.pages.PageManager;
import com.heatclinic.tests.TestBase;

public class ScriptBaseJUnit extends TestBase {

	@BeforeClass
	public static void beginTests() {
		System.out.println("Starting all tests!");
	}

	@AfterClass
	public static void afterTests() {
		System.out.println("Ending all tests!");
	}

	@Before
	public void setUp() {
		System.out.println("Opening website.");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		PageManager.getInstance().closePages();
		System.out.println("Closing browser.");
		try {
			DriverFactory.initialize().tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
