package com.examples.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

@Slf4j
public class PostsApiTests {

    @Test
    public void get_comments_with_hardcoding() {
        RequestSpecification requestSpecification = given();
        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("posts/{id}/comments");
        requestSpecification.pathParam("id", 2);
        Response response = requestSpecification.get();

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.jsonPath().getString("[0].name"), "et fugit eligendi deleniti quidem qui sint nihil autem");
        Assert.assertEquals(response.jsonPath().getInt("[0].id"), 6);
    }

    @Test
    public void get_comments_on_post_with_query_parameter() {
        RequestSpecification request = given();
        request.baseUri("https://jsonplaceholder.typicode.com");
        request.basePath("comments");
        request.param("postId", 1);

        Response response = request.get();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("[0].email"), "Eliseo@gardner.biz");
    }

    @Test
    public void create_userPost_using_post_method() {
        RequestSpecification requestSpecification = given();

        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("posts");
        requestSpecification.header("Content-type", "application/json");
        requestSpecification.body("{\n" +
                "    \"userId\": 10,\n" +
                "    \"title\": \"Test Title\",\n" +
                "    \"body\": \"Test Body\"\n" +
                "}");
        Response response = requestSpecification.post();
        Assert.assertEquals(response.statusCode(), 201);
        response.prettyPrint();
    }

    @Test
    public void update_userPost_using_put_method() {
        RequestSpecification requestSpecification = given();

        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("posts/1");
        requestSpecification.header("Content-type", "application/json");
        requestSpecification.body("{\n" +
                "    \"userId\": 1,\n" +
                "    \"title\": \"some title\",\n" +
                "    \"body\": \"some body\"\n" +
                "}");
        Response response = requestSpecification.put();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "some title");
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        response.prettyPrint();
    }

    @Test
    public void update_userPost_using_patch_method() {
        RequestSpecification requestSpecification = given();

        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("posts/1");
        requestSpecification.header("Content-type", "application/json");
        requestSpecification.body("{" +
                "    \"body\": \"some body\"\n" +
                "}");
        Response response = requestSpecification.patch();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertEquals(response.jsonPath().getString("body"), "some body");

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.assertThat()
                        .statusCode(200)
                .body("", hasKey("userId"))
                .body("", hasKey("id"))
                .body("", hasKey("title"))
                .body("", hasKey("body"));

        response.prettyPrint();
    }

    @Test
    public void it_should_get_post_by_param_value() {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        RequestSpecification requestSpecification = given();
        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("posts/{postId}");
        requestSpecification.pathParam("postId", 2);
        requestSpecification.get("comments");

        Response response =
            given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .when()
            .basePath("posts/{postId}")
            .pathParam("postId", 2)
            .get("comments")
                    ;

        response.prettyPrint();
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
