package com.examples.cucumber;

import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class Calculator {
    public int add(int a, int b) {
        log.info("a:{} and b:{}", a, b);
        return a + b;
    }
}
