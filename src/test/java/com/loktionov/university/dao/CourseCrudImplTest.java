package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.CourseCrudDaoImpl;
import com.loktionov.university.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseCrudImplTest extends AbstractDaoTest {
    private CourseCrudDaoImpl courseCrudImplTest;

    @BeforeEach
    void init() {
        super.init();
        courseCrudImplTest = new CourseCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableCourse() {
        Course expected = Course.builder()
                .withId(5)
                .withName("Music")
                .build();
        courseCrudImplTest.save(expected);

        assertThat(courseCrudImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableCourse() {
        Course expected = Course.builder()
                .withId(4)
                .withName("New course")
                .build();
        courseCrudImplTest.update(expected);

        assertThat(courseCrudImplTest.findById(4).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableCourse() {
        courseCrudImplTest.deleteById(3);
        Optional<Course> expected = Optional.empty();

        assertThat(courseCrudImplTest.findById(3), is(expected));
    }

    @Test
    void findByIdShouldBeReturnCourse() {
        Course expected = Course.builder()
                .withId(5)
                .withName("test")
                .build();
        courseCrudImplTest.save(expected);

        assertEquals(courseCrudImplTest.findById(5).get(), expected);
    }

    @Test
    void findAllEntityShouldBeReturnCourses() {
        List<Course> expected = Arrays.asList(
                Course.builder().withId(1).withName("Math").build(),
                Course.builder().withId(2).withName("Literature").build(),
                Course.builder().withId(3).withName("Geography").build(),
                Course.builder().withId(4).withName("Chemistry").build()
        );

        assertThat(courseCrudImplTest.findAll(10), is(expected));
    }
}
