package com.examples.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class WordCounterSteps {
    Map<String, List<Map.Entry<String, Integer>>> count;

    @Given("When word counter receives {string}")
    public void whenWordCounterReceivesInput(String input) {
        count = WordCounter.countWords(input);
    }

    @Then("outcome should have {int}, {string}, {int} and {string}")
    public void outcomeShouldHaveMaxItemCountMaxNameMinAndMinName(int maxItemCount, String maxName, int minItemCount, String minName) {
        var max = count.get("max");
        var min = count.get("min");
        Assert.assertEquals(max.size(), maxItemCount);
        Assert.assertEquals(min.size(), minItemCount);
        if (maxItemCount > 0) {
//            var hasMaxName = max.stream().anyMatch(e -> e.getKey().equals(maxName));
            boolean hasMaxItem = containsItem(max, maxName);
            Assert.assertEquals(hasMaxItem, true);
        }
    }

    public boolean containsItem(List<Map.Entry<String, Integer>> list, String itemName) {
        boolean containsItem = false;
        for (Map.Entry<String, Integer> entry: list) {
            if (entry.getKey().equals(itemName)) {
                containsItem = true;
            }
        }
        return containsItem;
    }

//    public boolean matchName(Map.Entry<String, Integer> entry) {
//        return entry.getKey().equals(expectedMaxName);
//    }
}
