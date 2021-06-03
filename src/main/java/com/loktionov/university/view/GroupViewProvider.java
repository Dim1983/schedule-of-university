package com.loktionov.university.view;

import com.loktionov.university.entity.Group;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class GroupViewProvider extends AbstractViewProvider<Group> {

    public GroupViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable, chooseUserNumber, chooseUserString);
    }

    @Override
    public Group insertEntity() {
        return Group.builder()
                .withId(chooseUserNumber.getAsInt())
                .withName(chooseUserString.get())
                .build();
    }
}
