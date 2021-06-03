package com.loktionov.university.controller;

import com.loktionov.university.dao.StudentDao;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;
import com.loktionov.university.view.StudentViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class StudentController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final StudentViewProvider studentViewProvider;
    private final StudentDao studentDao;

    public void actionWithStudent() {
        boolean flag = true;

        while (flag) {
            Integer choose = studentViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    studentDao.save(studentViewProvider.setEntity());
                    break;
                case 2:
                    Student student = studentDao.findById(studentViewProvider.foundById()).isPresent()
                            ? studentDao.findById(studentViewProvider.foundById()).get()
                            : Student.builder()
                            .withId(null)
                            .withName(null)
                            .withName(null)
                            .withEmail(null)
                            .withPhone(null)
                            .withBirthday(LocalDate.of(0, 0, 0))
                            .withPhone(new Phone(null, null, null, null, null))
                            .build();
                    studentViewProvider.printResultFoundById(student);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> studentDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(studentViewProvider::printResultFoundAll);
                    break;
                case 4:
                    studentDao.update(studentViewProvider.updateEntity());
                    break;
                case 5:
                    studentDao.deleteById(studentViewProvider.deleteEntity());
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
