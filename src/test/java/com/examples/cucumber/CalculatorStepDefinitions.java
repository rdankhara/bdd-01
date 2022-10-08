package com.examples.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorStepDefinitions {
    Calculator calculator;
    int total;

    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int a, int b) {
        total = calculator.add(a, b);
    }

    @Then("I should get {int}")
    public void iShouldGet(int c) {
        assertThat(total).isEqualTo(c);
    }
}
