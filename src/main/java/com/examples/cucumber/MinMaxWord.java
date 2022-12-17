package com.examples.cucumber;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class MinMaxWord {
    private List<String> minWords;
    private List<String> maxWords;
    private String something = "hello";
}
