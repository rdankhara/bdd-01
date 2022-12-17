package com.examples.cucumber;

import java.util.HashMap;
import java.util.List;

public class NumberPairChecker {
    public static boolean checkNumberPairs(List<Integer> numbers) {
        var counter = new HashMap<Integer, Integer>();
        for (Integer value : numbers) {
            int existingCount = counter.getOrDefault(value, 0).intValue();
            counter.put(value, existingCount + 1);
        }

        for (var value:counter.values()) {
            if (value.intValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
