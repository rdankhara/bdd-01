package com.examples.api;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/citibikes.feature",
        glue = {"com.examples.api"},
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
public class CitiBikeTestRunner extends AbstractTestNGCucumberTests {
}
