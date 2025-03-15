package com.sgtesting.api.driver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/resources/FeatureFiles",	
	glue ="com.sgtesting.api.stepdefinitions",
	plugin = {"pretty",
            "html:Reports/cucumber-report.html",
            "json:Reports/cucumber.json"},
	tags ="@Execute"
)
public class DriverScript extends AbstractTestNGCucumberTests{

}
