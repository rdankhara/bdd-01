package com.examples;

import algorithm.RandomNumberWithinRange;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.*;

@Slf4j
public class GeneralQuestionTest {
    @Test
    public void testAnd() {
        int a = 5, b = 6;
        if (b > ++a || a++ == b) {
            log.info("a :{}, b:{}", a, b);
        }
        log.info("a :{}, b:{}", a, b);
    }


    @Test
    public void randomNumberGenerator() {
        Set<Integer> generated = new HashSet<>();
        //Generate Random number between 25 - 50, should not repeat until all numbers covered
        RandomNumberWithinRange range = new RandomNumberWithinRange(25, 50);
        for (int i = 1; i < 26; i++) {
            log.info("random: {}", range.getNext());
        }
    }

    @Test
    public void collectionGeneric() {
        var list = Arrays.asList(1,2,3,4,5,6,7);
        log.info("original list: {}", list.stream().map(x -> x * 2).toList());
        log.info("original list: {}", list.stream().map(x -> x % 2 == 0 ).toList());
    }

    @Test
    public void mapOfNumbers () {
        var mapOfId = new HashMap<Integer, String>();
        mapOfId.put(1, "Meena");
        mapOfId.put(2, "Narendra");
        mapOfId.put(3, "Nil");

        System.out.println(mapOfId.get(3));
        // --- Name (key) Id will be the value
        Map<String, Integer> mapOfString = new HashMap<>();
        mapOfString.put("Meena", 1);
        mapOfString.put("Narendra", 2);
        mapOfString.put("Nil", 3);

        System.out.println(mapOfString.get("Meena"));
        log.info("value of Meena: {}", mapOfString.get("Meena"));

        System.out.println("Map of String Values begin");
        for(Map.Entry<String, Integer> entry:mapOfString.entrySet()) {
            log.info("key: {}, value: {}, entry", entry.getKey(), entry.getValue());
        }
        System.out.println("Map of String Values begin end");

        Set<String> set = new HashSet<>();
        set.add("Johal");
        set.add("Himalaya");
        set.add("Snowdown");
        System.out.println(set.size());
        System.out.println("Set begin");

        for( var x: set) {
            System.out.println(x.length());
        }
        System.out.println("Set end");

    }








}


