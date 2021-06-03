package com.loktionov.university.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
public class Phone {
    Integer id;

    @EqualsAndHashCode.Exclude
    String codeOfCountry;

    @EqualsAndHashCode.Exclude
    String codeOfCity;

    @EqualsAndHashCode.Exclude
    String phoneNumber;

    @EqualsAndHashCode.Exclude
    String additionalNumber;
}
