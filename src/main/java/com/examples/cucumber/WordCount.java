package com.examples.cucumber;

import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class WordCount {
    public static void countWords(String input) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);
        var map = new HashMap<String, Integer>();
        while (matcher.find()) {
            String word = matcher.group();
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
        }

        int min = 1, max= 1;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            min = Math.min(min, entry.getValue());
            max = Math.max(max, entry.getValue());
            log.info("{} {}", entry.getKey(), entry.getValue());
        }
        var wordsHavingMaxCount = new HashMap<String, Integer>();
        var wordsHavingMinCount = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) {
                wordsHavingMaxCount.put(entry.getKey(), entry.getValue());
            }
            if (entry.getValue() == min) {
                wordsHavingMinCount.put(entry.getKey(), entry.getValue());
            }
            log.info("{} {}", entry.getKey(), entry.getValue());
        }
        log.info("Max count is: {} and words: {}", max, wordsHavingMaxCount);
        log.info("Min count is: {} and words: {}", min, wordsHavingMinCount);

    }

    public static void main(String[] args) {
        countWords("hi, how are you doing, how is your work, how is your family, is this your car?");
    }
}
