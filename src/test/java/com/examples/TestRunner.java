package com.examples;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"com.examples.cucumber"},
        tags = "@score",
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
