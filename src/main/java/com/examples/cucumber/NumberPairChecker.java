package com.examples.cucumber;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NumberPairChecker {
    public static boolean checkNumberPairs(List<Integer> numbers) {
        var counter = new HashMap<Integer, Integer>();
        for (Integer value : numbers) {
            int existingCount = counter.getOrDefault(value, 0).intValue();
            counter.put(value, existingCount + 1);
        }

        return counter.values().stream().allMatch(x -> x % 2 ==0);
//        for (var value:counter.values()) {
//            if (!isEven(value.intValue())) {
//                return false;
//            }
//        }
//        return true;
    }

//
//    public static boolean isEven (int x) {
//        return x % 2 == 0;
//    }
}
