package com.examples.cucumber;

import java.util.*;

public class Factorial {
    public static Set<Integer> getFactors (Integer num) {
        int start = num.intValue();
        int divider = 2;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(num);
        while (divider <= start) {
            if (start % divider == 0) {
                set.add(divider);
                set.add(start);
                start = start / divider;
            } else {
                divider++;
            }
        }
        return set;
    }

    public static int getMax(List<Integer> numbers) {
        int max = 0;
        for (Integer num : numbers) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static boolean checkIfAllNumberAreFactorOf(List<Integer> nums, Integer value) {
        for (Integer num : nums) {
            if (value % num != 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkNumberIsFactorOfAll(List<Integer> nums, Integer num) {
        for (Integer item : nums) {
            if (item % num != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int maxOfa = getMax(a);
        int count = 0;

        int firstOfB = b.get(0);
        Set<Integer> firstBFactors = getFactors(firstOfB);
        System.out.println("firstBFactors" + firstBFactors);
        for (Integer fact : firstBFactors) {
            if (fact >= maxOfa && fact <= firstOfB) {
                if (checkNumberIsFactorOfAll(b, fact) && checkIfAllNumberAreFactorOf(a, fact)) {
                    System.out.println("--" +  fact);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = getTotalX(new ArrayList<>(Arrays.asList(2, 4)), new ArrayList<>(Arrays.asList(16, 32, 96)));
        System.out.println("count for [2, 4] and [16, 32, 96] should be 3 "  + count);
        count = getTotalX(new ArrayList<>(Arrays.asList(2, 6)), new ArrayList<>(Arrays.asList(24, 36)));
        System.out.println("count for [2, 4] and [16, 32, 96] should be 2 "  + count);
    }
}
