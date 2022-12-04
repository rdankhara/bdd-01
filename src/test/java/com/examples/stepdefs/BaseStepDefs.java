package com.examples.stepdefs;

import io.cucumber.java.ParameterType;

import java.time.LocalDate;

public class BaseStepDefs {
//    https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-java#data-tables

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate iso8601Date(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @ParameterType("true|false|True|False")
    public boolean booleanParameter(String boolString) {
        return Boolean.parseBoolean(boolString);
    }
}
