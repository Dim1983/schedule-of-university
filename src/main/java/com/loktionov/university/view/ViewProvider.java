package com.loktionov.university.view;

import java.util.Scanner;
import java.util.function.IntSupplier;

public class ViewProvider implements Viewer {
    private static final IntSupplier CHOOSE_USER = () -> {
        Scanner inputData = new Scanner(System.in);

        return inputData.nextInt();
    };

    public Integer startChoose() {
        System.out.println("Which data interesting for you:\n" +
                "1. Data of Auditory;\n" +
                "2. Data of Courses;\n" +
                "3. Data of Department;\n" +
                "4. Data of Group;\n" +
                "5. Data of Lesson;\n" +
                "6. Data of Student;\n" +
                "7. Data of Teacher;\n" +
                "8. Exit");

        return CHOOSE_USER.getAsInt();
    }
}
