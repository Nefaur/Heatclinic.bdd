package com.heatclinic.tests;


import org.openqa.selenium.WebDriver;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;

public class TestBase {

	protected WebDriver driver=DriverFactory.initialize(PropertyReader.BROWSER_TO_RUN).getdriver();
	
	
	
}
