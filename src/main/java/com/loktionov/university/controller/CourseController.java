package com.loktionov.university.controller;

import com.loktionov.university.dao.CourseDao;
import com.loktionov.university.entity.Course;
import com.loktionov.university.view.CourseViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class CourseController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final CourseViewProvider courseViewProvider;
    private final CourseDao courseDao;

    public void actionWithCourse() {
        boolean flag = true;

        while (flag) {
            Integer choose = courseViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    courseDao.save(courseViewProvider.setEntity());
                    break;
                case 2:
                    Course course = courseDao.findById(courseViewProvider.foundById()).isPresent()
                            ? courseDao.findById(courseViewProvider.foundById()).get()
                            : Course.builder()
                            .withId(null)
                            .withName(null)
                            .build();
                    courseViewProvider.printResultFoundById(course);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> courseDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(courseViewProvider::printResultFoundAll);
                    break;
                case 4:
                    courseDao.update(courseViewProvider.updateEntity());
                    break;
                case 5:
                    courseDao.deleteById(courseViewProvider.deleteEntity());
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
