package com.examples.cucumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j()
@Builder()
public class PLDemo {
    private String firstName;
    private String lastName;
}
