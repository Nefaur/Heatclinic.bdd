package com.heatclinic.bddrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="I:\\eclipse-workspace\\heatclinic.bdd\\src\\main\\resources\\TestResource\\Features\\Checkout.feature",
		glue= {"com.heatclinic.steps"},
//		dryRun=true,
		strict=true,
		monochrome=true,
//		tags= {"@FunctionalTest", "@SmokeTest"},
		plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml"
        }
		)

public class TestRunner {

}
