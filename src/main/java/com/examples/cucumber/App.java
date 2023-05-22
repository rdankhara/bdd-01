package com.examples.cucumber;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Simple Logging Facade for Java
@Slf4j
public class App {

    public static void checker(@NonNull String input) {
        log.info("input string is:{}", input);
    }

    public static void main(String[] args) {
        Person person = new Person();

        person.setFirstName("Abc");
        person.setLastName("Bcd");

        log.info("java.class.path:{}", System.getProperty("java.class.path"));
        log.info("FirstName: {} LastName: {}", person.getFirstName(), person.getLastName());
        try {
            checker(null);;
        } catch(Exception e) {
            log.error("something went wrong: {}", e.getMessage());
        }
    }
}
