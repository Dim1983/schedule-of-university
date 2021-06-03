package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.LessonCrudDaoImpl;
import com.loktionov.university.entity.Lesson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LessonCrudDaoImplTest extends AbstractDaoTest {
    private LessonCrudDaoImpl lessonCrudDaoImplTest;

    @BeforeEach
    void init() {
        super.init();

        lessonCrudDaoImplTest = new LessonCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableLesson() {
        Lesson expected = new Lesson(5, "Five");
        lessonCrudDaoImplTest.save(expected);

        assertThat(lessonCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableLesson() {
        Lesson expected = new Lesson(4, "New name");
        lessonCrudDaoImplTest.update(expected);

        assertThat(lessonCrudDaoImplTest.findById(4).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableLesson() {
        lessonCrudDaoImplTest.deleteById(3);
        Optional<Lesson> expected = Optional.empty();

        assertThat(lessonCrudDaoImplTest.findById(3), is(expected));
    }

    @Test
    void findByIdShouldBeReturnLesson() {
        Lesson expected = new Lesson(5, "New name");
        lessonCrudDaoImplTest.save(expected);

        assertThat(lessonCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void findAllEntityShouldBeReturnLessons() {
        List<Lesson> expected = Arrays.asList(
                new Lesson(1, "One"),
                new Lesson(2, "Two"),
                new Lesson(3, "Three"),
                new Lesson(4, "Four")
        );

        assertThat(lessonCrudDaoImplTest.findAll(10), is(expected));
    }
}
