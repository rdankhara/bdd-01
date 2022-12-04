package com.examples.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakOwnScoreStepDefs {
    List<Integer> scores;
    @Given("when user plays game with {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}")
    public void when_user_plays_game_with(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7, Integer int8, Integer int9) {
        scores = new ArrayList<>(Arrays.asList(int1, int2, int3, int4, int5, int6, int7, int8, int9));
    }
    @Then("they should see {int} and {int}")
    public void they_should_see_expected_max_and_min_count(Integer expectedMax, Integer expectedLow) {
        int lastHighScore = scores.get(0), lastLowScore = scores.get(0) , maxCount = 0, minCount = 0;
        for (Integer score: scores) {
            if (score > lastHighScore) {
                lastHighScore = score;
                maxCount++;
            } else if (score < lastLowScore) {
                lastLowScore = score;
                minCount++;
            }
        }
        Assert.assertEquals(maxCount, expectedMax);
        Assert.assertEquals(minCount, expectedLow);
    }
}
