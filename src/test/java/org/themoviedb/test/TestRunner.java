package org.themoviedb.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.themoviedb.stepdefinitions"},
        plugin = {
        				"html:target/cucumber-html-report.html",
        				"json:target/cucumber-json-report.json"
        			})
public class TestRunner extends AbstractTestNGCucumberTests{

}
