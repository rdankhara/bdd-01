package com.examples.cucumber;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NumberPairChecker {
    public static boolean checkNumberPairs(List<Integer> numbers) {
        HashMap<Integer, Integer> mapOfNumbers = new HashMap<>();
        for (Integer value : numbers) {
            int existingCount = mapOfNumbers.getOrDefault(value, 0).intValue();
            mapOfNumbers.put(value, existingCount + 1);
        }

        return mapOfNumbers.values().stream().allMatch(x -> x % 2 ==0);
//        for (Integer value : mapOfNumbers.values()) {
//            if (!isEven(value.intValue())) {
//                return false;
//            }
//        }
//        return true;
    }


//    public static boolean isEven (int x) {
//        return x % 2 == 0;
//    }
}
