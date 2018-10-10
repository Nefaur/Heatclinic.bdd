package com.heatclinic.steps;



import java.util.concurrent.TimeUnit;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.tests.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;




public class ScriptBase extends TestBase{

	//Global hooks
	@Before
	public void setUp() {
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
//	try {
//		DriverFactory.initialize().tearDown();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	}
	
}
	
	
	

