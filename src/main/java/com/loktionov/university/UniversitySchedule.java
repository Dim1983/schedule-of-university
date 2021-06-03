package com.loktionov.university;

import com.loktionov.university.config.UniversityConfig;
import com.loktionov.university.config.ViewProviderConfig;
import com.loktionov.university.controller.UniversityController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UniversitySchedule {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UniversityConfig.class, ViewProviderConfig.class);

        UniversityController universityController = context.getBean(UniversityController.class);
        universityController.mainChoose();

        context.close();
    }
}
