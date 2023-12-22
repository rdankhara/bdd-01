package com.examples.api;

import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class JsonPathTests {
    @Test
    public void getArrayLength() {
        String input = "{\"arr1\" : [1,2,3], \"arr2\" : []}";
        JsonPath jsonPath = JsonPath.from(input);
        log.info("size of arra1: {}", jsonPath.getList("arr1").size());

        assertThat(jsonPath.getList("arr1").size(), Is.is(3));
        assertThat(jsonPath.getList("arr2").size(), Is.is(0));
    }
}
