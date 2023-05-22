package com.examples.calculator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        features = "classpath:features/calculator.feature",
        tags = "calculator",
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
//@CucumberOptions(tags = ("@calculator"),
//        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json"
//        })
public class CalculatorTestRunner extends AbstractTestNGCucumberTests {
}
