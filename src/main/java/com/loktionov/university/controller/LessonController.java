package com.loktionov.university.controller;

import com.loktionov.university.dao.LessonDao;
import com.loktionov.university.entity.Lesson;
import com.loktionov.university.view.LessonViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class LessonController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final LessonViewProvider lessonViewProvider;
    private final LessonDao lessonDao;

    public void actionWithLesson() {
        boolean flag = true;

        while (flag) {
            Integer choose = lessonViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    lessonDao.save(lessonViewProvider.setEntity());
                    break;
                case 2:
                    Lesson lesson = lessonDao.findById(lessonViewProvider.foundById()).isPresent()
                            ? lessonDao.findById(lessonViewProvider.foundById()).get()
                            : new Lesson(null, null);
                    lessonViewProvider.printResultFoundById(lesson);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> lessonDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(lessonViewProvider::printResultFoundAll);
                    break;
                case 4:
                    lessonDao.update(lessonViewProvider.updateEntity());
                    break;
                case 5:
                    lessonDao.deleteById(lessonViewProvider.deleteEntity());
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
