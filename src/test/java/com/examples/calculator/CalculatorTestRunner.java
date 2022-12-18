package com.examples.calculator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features/calculator.feature",
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
public class CalculatorTestRunner extends AbstractTestNGCucumberTests {
}
