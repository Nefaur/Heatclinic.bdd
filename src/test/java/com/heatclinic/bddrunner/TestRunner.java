package com.heatclinic.bddrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/TestResource/Features", 
		glue = { "com.heatclinic.steps" },
		// dryRun=true,
		strict = true, monochrome = true,
		// tags= {"@FunctionalTest", "not @SmokeTest", "not @SanityTest","not
		// @End2EndTests"},
		plugin = { 	"pretty:target/cucumber-test-report/cucumber-pretty.txt", 
					"html:target/cucumber-test-report",
					"json:target/cucumber-test-report/cucumber-report.json",
					"junit:target/cucumber-test-report/test-report.xml" }
				)

public class TestRunner {

}
