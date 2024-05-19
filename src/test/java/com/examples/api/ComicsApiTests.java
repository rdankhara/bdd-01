package com.examples.api;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class ComicsApiTests {

//https://www.marvel.com/documentation/generalinfo
//https://www.marvel.com/documentation/authorization
//https://developer.marvel.com/account

    @Test
    public void verify_character_properties_1() {

        ValidatableResponse response = getResponse();

        response.assertThat().statusCode(200);

        String jsonPathExpression = "data.results[0]";

        response.assertThat()
                .body(jsonPathExpression, hasKey("id"))
                .body(jsonPathExpression, hasKey("description"))
                .body(jsonPathExpression, hasKey("modified"))
                .body(jsonPathExpression, hasKey("resourceURI"))
                .body(jsonPathExpression, hasKey("thumbnail"))
                .body(jsonPathExpression, hasKey("stories"))
                .body(jsonPathExpression, hasKey("events"))
                .body(jsonPathExpression, hasKey("urls"));
    }

    @Test
    public void verify_character_properties_2_failing() {

        ValidatableResponse response = getResponse();
        String jsonPathExpression = "data.results[0]";

        response.assertThat()
                .body(jsonPathExpression, hasKey("comics"))
                .body(jsonPathExpression, hasKey("name"));
    }

    @Test
    public void verify_character_properties_Negative() {

        ValidatableResponse response = getResponse();

        String jsonPathExpression = "data.results[0]";
        response.assertThat()
                .body(jsonPathExpression, not(hasKey("comicsAbcd")));
    }

    @Test
    public void verify_character_count() {

        Response response = getResponse().extract().response();

        //JsonPath results = response.jsonPath().getJsonObject("data.results[0].id");
        assertThat(response.getStatusCode(), Is.is(200));
        String actualId = response.jsonPath().getString("data.results[0].id");
        String expectedId = "82967";

        assertThat(expectedId, equalTo(actualId));

        int expectedCount = response.jsonPath().getInt("data.count");
        System.out.println("counts:" + expectedCount);

//        System.out.println(response.jsonPath().getList("data.results[0].urls", Detail.class));
//        List<Detail> details = response.jsonPath().getList("data.results[0].urls", Detail.class);
//
//        List<String> urls = new ArrayList<>();
//
//        for (Detail a : details){
//            if (a.getUrl().contains(expectedId)) {
//                urls.add(a.getUrl());
//            }
//        }
//
//        for (String url : urls) {
//            System.out.println(url);
//            //Todo: write webdriver methods to visit open url and count characters, it should be equal to expectedCount
//        }
    }

    @Test
    public void get_comics() {
        String privateKey = "4d6e9465c7a3956f1f0153230cfc980ade8dfdec";
        String publicKey = "3750536889898a0565ac71a0eb6920ad";
        String ts = "xyz";
//        String staticHash = "9df35ef657b719ae8195f0b7adc5d995";
        String generatedHash = HashGenerator.getMd5(ts + privateKey + publicKey);

        RequestSpecification request = given();
        request.baseUri("http://gateway.marvel.com/v1/public");
        request.basePath("comics");
        request.queryParam("ts", ts);
        request.queryParam("apikey", publicKey);
        request.queryParam("hash", generatedHash);

        Response response = request.log().everything().get();
        ValidatableResponse validatableResponse = response.then();

        int records = response.jsonPath().getInt("data.count");
        for (int i = 0; i < records; i++ ) {
            String jsonPathExpression = "data.results[" + i +"]";

            validatableResponse.assertThat()
                    .body(jsonPathExpression, hasKey("id"))
                    .body(jsonPathExpression, hasKey("description"))
                    .body(jsonPathExpression, hasKey("modified"))
                    .body(jsonPathExpression, hasKey("resourceURI"))
                    .body(jsonPathExpression, hasKey("thumbnail"))
                    .body(jsonPathExpression, hasKey("stories"))
                    .body(jsonPathExpression, hasKey("events"))
                    .body(jsonPathExpression, hasKey("urls"));
        }
    }

    private ValidatableResponse getResponse() {
//        var ts = new Date().getTime();
        String privateKey = "4d6e9465c7a3956f1f0153230cfc980ade8dfdec";
        String publicKey = "3750536889898a0565ac71a0eb6920ad";
        var ts = "abcd";
        String generatedHash = "9df35ef657b719ae8195f0b7adc5d995";
//        String generatedHash = HashGenerator.getMd5(ts + privateKey + publicKey);

        System.out.println("Hash:" + "9df35ef657b719ae8195f0b7adc5d995");


        Response response = given()
                .baseUri("http://gateway.marvel.com/v1/public")
                .and()
                .basePath("comics")
                .and()
                .queryParam("ts", ts) // any string
                .and()
                .queryParam("apikey", publicKey) // public key
                .and()
                .queryParam("hash", generatedHash)
                .when()
                .log()
                .everything()
                .get()
                ;

        response.prettyPrint();
        return response.then();
    }
}
