package com.examples.cucumber;

import lombok.extern.slf4j.Slf4j;
// Simple Logging Facade for Java
@Slf4j
public class App {

    public static void main(String[] args) {
        Person person = new Person();

        person.setFirstName("Abc");
        person.setLastName("Bcd");

        log.info("FirstName: {} LastName: {}", person.getFirstName(), person.getLastName());
        log.error("something went wrong");
    }
}
