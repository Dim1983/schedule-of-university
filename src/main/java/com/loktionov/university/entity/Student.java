package com.loktionov.university.entity;

import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder(setterPrefix = "with")
@ToString(callSuper = true)
public class Student extends AbstractUser<Student> {
    String status;
}
