package com.loktionov.university.view;

import com.loktionov.university.entity.Auditory;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class AuditoryViewProvider extends AbstractViewProvider<Auditory> implements Viewer {

    public AuditoryViewProvider(String nameOfTable, IntSupplier chooseUserNumber, Supplier<String> chooseUserString) {
        super(nameOfTable,chooseUserNumber, chooseUserString);
    }

    @Override
    public Auditory insertEntity() {
        return new Auditory(chooseUserNumber.getAsInt(), chooseUserNumber.getAsInt());
    }
}
