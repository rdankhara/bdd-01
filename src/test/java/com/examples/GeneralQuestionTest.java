package com.examples;

import algorithm.RandomNumberWithinRange;
import io.cucumber.java.hu.Ha;
import io.cucumber.java.it.Ma;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        var list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        log.info("original list: {}", list.stream().map(x -> x * 2).toList());
    }

















}


