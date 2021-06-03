package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.TeacherCrudDaoImpl;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;
import com.loktionov.university.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TeacherCrudDaoImplTest extends AbstractDaoTest {
    private TeacherCrudDaoImpl teacherCrudDaoImplTest;

    @BeforeEach
    void init() {
        super.init();

        teacherCrudDaoImplTest = new TeacherCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableTeacher() {
        Teacher expected = Teacher.builder()
                .withRank("Professor")
                .withId(5)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "396-78-76", "0432"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .build();
        teacherCrudDaoImplTest.save(expected);

        assertThat(teacherCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableTeacher() {
        Teacher expected = Teacher.builder()
                .withRank("Professor")
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "396-78-76", "0432"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .build();
        teacherCrudDaoImplTest.update(expected);

        assertThat(teacherCrudDaoImplTest.findById(1).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableTeacher() {
        teacherCrudDaoImplTest.deleteById(1);
        Optional<Student> expected = Optional.empty();

        assertThat(teacherCrudDaoImplTest.findById(1), is(expected));
    }

    @Test
    void findByIdShouldBeReturnTeacher() {
        Teacher expected = Teacher.builder()
                .withRank("Professor")
                .withId(4)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "396-78-76", "0432"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .build();
        teacherCrudDaoImplTest.update(expected);

        assertThat(teacherCrudDaoImplTest.findById(4).get(), equalTo(expected));
    }

    @Test
    void findAllEntityShouldBeReturnTeacher() {
        List<Teacher> expected = Arrays.asList(
                Teacher.builder()
                        .withRank("Professor")
                        .withId(1)
                        .withName("Alex")
                        .withSecondName("Bloo")
                        .withBirthday(LocalDate.of(1983, 03, 07))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("1@mail.ru")
                        .withPassword("12345")
                        .build(),
                Teacher.builder()
                        .withRank("Professor")
                        .withId(2)
                        .withName("John")
                        .withSecondName("Cambel")
                        .withBirthday(LocalDate.of(1983, 03, 07))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("2@mail.ru")
                        .withPassword("12345")
                        .build(),
                Teacher.builder()
                        .withRank("Professor")
                        .withId(3)
                        .withName("Antony")
                        .withSecondName("Smith")
                        .withBirthday(LocalDate.of(1983, 03, 07))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("3@mail.ru")
                        .withPassword("12345")
                        .build(),
                Teacher.builder()
                        .withRank("Professor")
                        .withId(4)
                        .withName("Pol")
                        .withSecondName("Rassel")
                        .withBirthday(LocalDate.of(1983, 03, 07))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("4@mail.ru")
                        .withPassword("12345")
                        .build()
        );

        assertThat(teacherCrudDaoImplTest.findAll(10), is(expected));
    }
}
