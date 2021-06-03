package com.loktionov.university.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder(setterPrefix = "with")
@ToString
public abstract class AbstractUser<T> {
    private final Integer id;

    @EqualsAndHashCode.Exclude
    private final String name;

    @EqualsAndHashCode.Exclude
    private final String secondName;

    @EqualsAndHashCode.Exclude
    private final LocalDate birthday;

    @EqualsAndHashCode.Exclude
    private final Phone phone;

    @EqualsAndHashCode.Exclude
    private final String email;

    @EqualsAndHashCode.Exclude
    private final String password;
}
