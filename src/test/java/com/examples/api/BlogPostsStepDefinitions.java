package com.examples.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BlogPostsStepDefinitions {
    RequestSpecification request;
    Response response;

    @Given("I build request with baseUri {string}")
    public void i_build_request_with_base_uri(String baseUri) {
        // Write code here that turns the phrase above into concrete actions
        request = given()
            .baseUri(baseUri);
    }

    @When("use path {string}")
    public void use_path(String path) {
        request.basePath(path);
    }

    @When("make get request with {string} value {int}")
    public void make_get_request_with_value(String parameter, Integer queryValue) {
        response = request.queryParam(parameter, queryValue)
                .log()
                .everything()
                .get();

    }

    @Then("request should be completed with status {int} and second comment with email {string}")
    public void request_should_be_completed_with_status_and_second_comment_with_email(Integer status, String email) {
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), status);
        Assert.assertEquals(jsonpath.getString("[1].email"), email);
    }
}
