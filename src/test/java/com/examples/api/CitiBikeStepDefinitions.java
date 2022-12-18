package com.examples.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class CitiBikeStepDefinitions {
    RequestSpecification request;
    Response response;
    @Given("I am on {string} api")
    public void iAmOnApi(String baseUri) {
        request = given().baseUri(baseUri);
    }

    @When("I am on {string} path")
    public void iAmOnPath(String path) {
        log.info("path: {}", path);
        request.basePath(path);
    }

    @And("make get request to {string}")
    public void makeGetRequestTo(String city) {
        log.info("make get request for city:{}", city);
        response = request
                .when()
                .param("fields", "id,name,location")
                .log().everything()
                .get(city);
    }

    @Then("response should have country {string} and longitude {double}F and latitude {double}F")
    public void responseShouldHaveCountryAndLongitudeFAndLatitudeF(String countryCode, double longitude, double latitude) {
        log.info("country code:{} longitude:{} latitude:{} ", countryCode, longitude, latitude);
        JsonPath jsonPath = response.jsonPath();

        String country = jsonPath.get("network.location.country");
        assertThat(country).isEqualTo(countryCode);

        assertThat(jsonPath.getDouble("network.location.longitude")).isEqualTo(longitude);
        assertThat(jsonPath.getDouble("network.location.latitude")).isEqualTo(latitude);
    }
}
