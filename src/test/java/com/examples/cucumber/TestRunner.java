package com.examples.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
