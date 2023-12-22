package com.examples.cucumber;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class WordCounter {

    public static Map<String, List<Map.Entry<String, Integer>>> countWords(String input) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);
        Map<String, Integer> map = new HashMap<>();

        int min = 1, max= 0;
        while (matcher.find()) {
            String word = matcher.group();
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
            min = Math.min(min, count);
            max = Math.max(max, count);
        }
        var maxList = new ArrayList<Map.Entry<String, Integer>>();
        var minList = new ArrayList<Map.Entry<String, Integer>>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) {
                maxList.add(entry);
            }
            if (entry.getValue() == min) {
                minList.add(entry);
            }
        }

        Map<String, List<Map.Entry<String, Integer>>> minMaxMap  = new HashMap<>();
        minMaxMap.put("min", minList);
        minMaxMap.put("max", maxList);
        return minMaxMap;
    }
}
