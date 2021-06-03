package com.loktionov.university.view;

import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;

import java.time.LocalDate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class StudentViewProvider extends AbstractViewProvider<Student> {

    public StudentViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable, chooseUserNumber, chooseUserString);
    }

    @Override
    public Student insertEntity() {
        return Student.builder()
                .withId(chooseUserNumber.getAsInt())
                .withName(chooseUserString.get())
                .withSecondName(chooseUserString.get())
                .withEmail(chooseUserString.get())
                .withPassword(chooseUserString.get())
                .withPhone(new Phone(chooseUserNumber.getAsInt(), chooseUserString.get(),
                        chooseUserString.get(), chooseUserString.get(), chooseUserString.get()))
                .withBirthday(LocalDate.of(chooseUserNumber.getAsInt(), chooseUserNumber.getAsInt(),
                        chooseUserNumber.getAsInt()))
                .build();
    }
}
