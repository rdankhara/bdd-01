package com.examples;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
