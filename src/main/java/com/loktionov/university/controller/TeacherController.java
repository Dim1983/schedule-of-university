package com.loktionov.university.controller;

import com.loktionov.university.dao.TeacherDao;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Teacher;
import com.loktionov.university.view.TeacherViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class TeacherController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final TeacherViewProvider teacherViewProvider;
    private final TeacherDao teacherDao;

    public void actionWithTeacher() {
        boolean flag = true;

        while (flag) {
            Integer choose = teacherViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    teacherDao.save(teacherViewProvider.setEntity());
                    break;
                case 2:
                    Teacher teacher = teacherDao.findById(teacherViewProvider.foundById()).isPresent()
                            ? teacherDao.findById(teacherViewProvider.foundById()).get()
                            : Teacher.builder()
                            .withId(null)
                            .withName(null)
                            .withSecondName(null)
                            .withEmail(null)
                            .withPassword(null)
                            .withBirthday(LocalDate.of(0, 0, 0))
                            .withPhone(new Phone(null, null, null, null, null))
                            .build();
                    teacherViewProvider.printResultFoundById(teacher);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> teacherDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(teacherViewProvider::printResultFoundAll);
                    break;
                case 4:
                    teacherDao.update(teacherViewProvider.updateEntity());
                    break;
                case 5:
                    teacherDao.deleteById(teacherViewProvider.deleteEntity());
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
