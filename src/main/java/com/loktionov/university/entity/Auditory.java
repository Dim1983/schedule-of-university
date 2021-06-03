package com.loktionov.university.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
public class Auditory {
    Integer id;

    @EqualsAndHashCode.Exclude
    Integer number;
}
