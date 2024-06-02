package com.examples.cucumber;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.testng.Assert;

import java.util.List;

@Slf4j
public class FindNumberPairsSteps {
    boolean hasAllPairs = false;
    List<Integer> numbers;

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Given("an array of:")
    public void an_array_of(List<Integer> numbers) {
        this.numbers = numbers;
        log.info("received array of {}", numbers);
    }

    @When("I check for pairs")
    public void i_check_for_pairs() {
        hasAllPairs = NumberPairChecker.checkNumberPairs(this.numbers);
        log.info("Checking for pairs", this.numbers);
    }

    @Then("It should return {booleanValue}")
    public void it_should_return_true(boolean expectedResult) {
        Assert.assertEquals(hasAllPairs, expectedResult);
        log.info("actual result is {}, expected {}", hasAllPairs, expectedResult);
    }
}
