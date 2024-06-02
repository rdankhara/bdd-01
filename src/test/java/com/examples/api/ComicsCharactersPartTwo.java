package com.examples.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Slf4j
public class ComicsCharactersPartTwo {

    @Test
    public void formatTest() {
        String path = String.format("data.results[%d]", 10);
        System.out.println(path);
    }

    @Test
    public void gets_characters() {
        Response response = getResponse();
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        int count = jsonPath.getInt("data.count");

        for (int i = 0; i< count; i++) {
            String path = String.format("data.results[%d]", i);
            String id = jsonPath.getString(path + ".id");
            String name = jsonPath.getString(path + ".name");
            int available = jsonPath.getInt(path + ".comics.available");
            String urlJsonPath = path + ".urls[?(@.type==\"detail\")]";
            log.info("urlJsonPath", urlJsonPath);


            var list =  jsonPath.getList(path + ".urls");
            String url = getCharacterUrl(list.size(),path, jsonPath);

            log.info("id {} name {} Available {} , url {}", id, name, available, url);
        }
    }

    private String getCharacterUrl (int count, String baseJsonPath, JsonPath jsonPath) {
        for(int i = 0; i < count; i++) {
            String typeJsonPath = baseJsonPath + ".urls[" + i + "].type";
            String urlJsonPath = baseJsonPath + ".urls[" + i + "].url";
            String type = jsonPath.getString(typeJsonPath);
            if (type.equalsIgnoreCase("detail")) {
                return jsonPath.getString(urlJsonPath);
            }
        }
        return null;
    }

    private Response getResponse() {
        String publicKey = "3750536889898a0565ac71a0eb6920ad";
        var ts = "abcd";
        String generatedHash = "9df35ef657b719ae8195f0b7adc5d995";

        System.out.println("Hash:" + "9df35ef657b719ae8195f0b7adc5d995");
        RequestSpecification requestSpecification = given();

        Response response = requestSpecification.baseUri("http://gateway.marvel.com/v1/public")
            .basePath("characters")
            .queryParam("ts", ts) // any string
            .queryParam("apikey", publicKey) // public key
            .queryParam("hash", generatedHash)
            .log().everything()
            .get();

        return response;
    }
}
