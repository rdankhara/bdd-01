package com.examples.api;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/blogPosts.feature",
        glue = {"com.examples.api"},
        plugin = {"pretty", "html:target/cucumber"},
        publish = true
)
public class BlogPostsTestRunner extends AbstractTestNGCucumberTests {
}
