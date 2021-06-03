package com.loktionov.university.view;

import com.loktionov.university.entity.Department;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class DepartmentViewProvider extends AbstractViewProvider<Department> implements Viewer {

    public DepartmentViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable, chooseUserNumber, chooseUserString);
    }

    @Override
    public Department insertEntity() {
        return Department.builder()
                .withId(chooseUserNumber.getAsInt())
                .withName(chooseUserString.get())
                .build();
    }
}
