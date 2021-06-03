package com.loktionov.university.view;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

@AllArgsConstructor
public abstract class AbstractViewProvider<E> {
    private final String nameOfTable;
    protected final IntSupplier chooseUserNumber;
    protected final Supplier<String> chooseUserString;

    public Integer chooseActionUser() {
        System.out.println("Choosing action with data:\n" +
                "1. Save new " + nameOfTable + "\n" +
                "2. Found " + nameOfTable + " by ID; \n" +
                "3. Show all " + nameOfTable + ";\n" +
                "4. Update data of " + nameOfTable + ";\n" +
                "5. Delete " + nameOfTable + " by ID; \n" +
                "6. exit");

        return chooseUserNumber.getAsInt();
    }

    public E setEntity() {
        System.out.println("Input data of" + nameOfTable + ";\n");

        return insertEntity();
    }

    public Integer foundById() {
        System.out.println("Input id " + nameOfTable + ";\n");

        return chooseUserNumber.getAsInt();
    }

    public E updateEntity() {
        System.out.println("Input " + nameOfTable + ";\n");

        return insertEntity();
    }

    public Integer deleteEntity() {
        System.out.println("Input id " + nameOfTable + " for clean!");

        return chooseUserNumber.getAsInt();
    }

    public void printResultFoundById(E entity) {
        System.out.println("Your " + nameOfTable + " is: " + entity);
    }

    public void printResultFoundAll(List<E> entities) {
        Stream.of(entities).forEach(System.out::println);
    }

    public abstract E insertEntity();
}
