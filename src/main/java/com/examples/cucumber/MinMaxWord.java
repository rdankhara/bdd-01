package com.examples.cucumber;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MinMaxWord {
    private List<Map.Entry<String, Integer>> minWords;
    private List<Map.Entry<String, Integer>> maxWords;
    private String something = "hello";
}
