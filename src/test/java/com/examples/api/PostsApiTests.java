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
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Slf4j
public class PostsApiTests {

    @Test
    public void it_should_get_post_by_param_value() {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        Response response =
            given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .when()
            .basePath("posts/{id}")
            .pathParam("id", 2)
            .get("comments");

        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
//        log.info("first Item : {}", jsonPath.getString("title"));
        Assert.assertEquals(jsonPath.getString("[0].email"), "Presley.Mueller@myrl.com");
        Assert.assertEquals(jsonPath.getInt("[0].id"), 6);
//        response.prettyPrint();
    }

    @Test
    public void it_should_get_comments_by_postId() {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        Response response =
                given()
                        .baseUri("https://jsonplaceholder.typicode.com/")
                        .when()
                        .basePath("comments")
                        .param("postId", 1)
                        .log()
                        .everything()
                        .get();

        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("[1].email"), "Jayne_Kuhic@sydney.com");
    }

    @Test
    public void postRequest() {
        Response response = given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-type", "application/json")
            .and()
            .basePath("/posts")
            .and()
            .body("{\"userId\": 110,\"title\": \"my title\",\"body\": \"my post\"}")
            .when()
            .post();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("title"), "my title");
        Assert.assertEquals(response.jsonPath().getString("body"), "my post");
        Assert.assertEquals(response.jsonPath().getInt("id") ,  101);
    }

    @Test
    public void it_should_get_comments_of_post_by_param_value() {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        Response response =
                given()
                        .baseUri("https://jsonplaceholder.typicode.com/")
                        .when()
                        .basePath("posts/{id}")
                        .pathParam("id", 2)
                        .get("comments");

        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();

//        log.info("first Item : {}", jsonPath.getString("title"));
//        Assert.assertEquals(jsonPath.getString("title"), "qui est esse");
//        Assert.assertEquals(jsonPath.getInt("id"), 2);
    }
}
