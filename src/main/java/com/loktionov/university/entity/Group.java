package com.loktionov.university.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true, setterPrefix = "with")
public class Group {
    Integer id;

    @EqualsAndHashCode.Exclude
    String name;

    @EqualsAndHashCode.Exclude
    List<Student> students;

    @EqualsAndHashCode.Exclude
    List<Teacher> teachers;
}
