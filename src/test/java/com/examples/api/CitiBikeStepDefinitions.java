package com.examples.api;

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

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class CitiBikeStepDefinitions {
    RequestSpecification request;
    Response response;
    @Given("I am on {string} api")
    public void iAmOnApi(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("I am on {string} path")
    public void iAmOnPath(String path) {
        log.info("path: {}", path);
        RestAssured.basePath = path;
    }

    @And("make get request to {string}")
    public void makeGetRequestTo(String city) {
        log.info("make get request for city:{}", city);
        response = given().when().get(city).then().extract().response();
    }

    @Then("response should have country {string} and longitude {double}F and latitude {double}F")
    public void responseShouldHaveCountryAndLongitudeFAndLatitudeF(String arg0, double arg1, double arg2) {
        log.info("arg0:{} arg1:{} arg2:{} ", arg0, arg1, arg2);
        JsonPath jsonPath = response.getBody().jsonPath();

        String country = jsonPath.get("network.location.country");
        assertThat(country).isEqualTo("DE");

        assertThat(jsonPath.getDouble("network.location.longitude")).isEqualTo(arg1);
        assertThat(jsonPath.getDouble("network.location.latitude")).isEqualTo(arg2);
        response.prettyPrint();
    }
}
