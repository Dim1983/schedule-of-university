package com.loktionov.university.entity;

import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(setterPrefix = "with")
@ToString(callSuper = true)
public class Teacher extends AbstractUser<Teacher> {
    String rank;
}
