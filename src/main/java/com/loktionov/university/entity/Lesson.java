package com.loktionov.university.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
public class Lesson {
    Integer id;

    @EqualsAndHashCode.Exclude
    String name;
}
