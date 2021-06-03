package com.loktionov.university.view;

import com.loktionov.university.entity.Lesson;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class LessonViewProvider extends AbstractViewProvider<Lesson> {

    public LessonViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable, chooseUserNumber, chooseUserString);
    }

    @Override
    public Lesson insertEntity() {
        return new Lesson(chooseUserNumber.getAsInt(), chooseUserString.get());
    }
}
