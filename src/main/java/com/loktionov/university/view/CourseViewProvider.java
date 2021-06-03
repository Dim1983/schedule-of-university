package com.loktionov.university.view;

import com.loktionov.university.entity.Course;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class CourseViewProvider extends AbstractViewProvider<Course> implements Viewer {

    public CourseViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable, chooseUserNumber, chooseUserString);
    }

    @Override
    public Course insertEntity() {
        return Course.builder()
                .withId(chooseUserNumber.getAsInt())
                .withName(chooseUserString.get())
                .build();
    }
}
