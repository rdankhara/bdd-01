package com.examples.cucumber;

import io.cucumber.cucumberexpressions.PatternCompiler;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class BreakOwnScoreStepDefs {
    List<Integer> scores;

    @ParameterType("(*.)")
    public List<Integer> listOfIntegers(String integers) {
        return Arrays.stream(integers.split(", ?"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
//    @Given("when user plays game with {listOfIntegers}")
//    public void when_user_plays_game_with(List<Integer> inputScore) {
//        log.info("scores:{}", scores);
//    }
    @Given("^when user plays game with (.*)$")
    public void when_user_plays_game_with(String scoreExp) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(scoreExp);
        scores = new ArrayList<>();
        while (matcher.find()) {
            scores.add(Integer.parseInt(matcher.group()));
        }
      log.info("scores:{}", scores);
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
