package com.examples.cucumber;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class WordCount {
    public static MinMaxWord countWords(String input) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);
        Map<String, Integer> map = new HashMap<String, Integer>();

        while (matcher.find()) {
            String word = matcher.group();
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
        }
        int min = 1, max= 1;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            min = Math.min(min, entry.getValue());
            max = Math.max(max, entry.getValue());
        }
        var wordsHavingMaxCount = new ArrayList<String>();
        var wordsHavingMinCount = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) {
                wordsHavingMaxCount.add(entry.getKey());
            }
            if (entry.getValue() == min) {
                wordsHavingMinCount.add(entry.getKey());
            }
        }
        var minmax = new MinMaxWord();
        minmax.setMaxWords(wordsHavingMaxCount);
        minmax.setMinWords(wordsHavingMinCount);
        return minmax;
    }

    public static void main(String[] args) {
        var minmax = countWords("how are you doing, how is your work, how is family, is this your car? hi, how are you doing, how is your work, how is your family, is this your car?");
        log.info("min and max words: {}", minmax);
    }
}
