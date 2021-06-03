package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.StudentCrudDaoImpl;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class StudentCrudDaoImplTest extends AbstractDaoTest {
    private StudentCrudDaoImpl studentCrudDaoImplTest;

    @BeforeEach
    void init() {
        super.init();

        studentCrudDaoImplTest = new StudentCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableStudent() {
        Student expected = Student.builder()
                .withStatus("Daily")
                .withId(5)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "396-78-76", "0432"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .build();
        studentCrudDaoImplTest.save(expected);

        assertThat(studentCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableStudent() {
        Student expected = Student.builder()
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .withStatus("daily")
                .build();

        studentCrudDaoImplTest.update(expected);

        assertThat(studentCrudDaoImplTest.findById(1).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableStudent() {
        studentCrudDaoImplTest.deleteById(1);
        Optional<Student> expected = Optional.empty();

        assertThat(studentCrudDaoImplTest.findById(1), is(expected));
    }

    @Test
    void findByIdShouldBeReturnStudent() {
        Student expected = Student.builder()
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withBirthday(LocalDate.of(1980, 04, 03))
                .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                .withEmail("1@mail.ru")
                .withPassword("12345")
                .withStatus("daily")
                .build();
        studentCrudDaoImplTest.update(expected);

        assertThat(studentCrudDaoImplTest.findById(1).get(), equalTo(expected));
    }

    @Test
    void findAllEntityShouldBeReturnStudents() {
        List<Student> expected = Arrays.asList(
                Student.builder()
                        .withStatus("Daily")
                        .withId(1)
                        .withName("John")
                        .withSecondName("Smith")
                        .withBirthday(LocalDate.of(1983, 3, 7))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("1@mail.ru")
                        .withPassword("12345")
                        .build(),
                Student.builder()
                        .withStatus("Daily")
                        .withId(2)
                        .withName("Alex")
                        .withSecondName("Merfi")
                        .withBirthday(LocalDate.of(1983, 3, 7))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("2@mail.ru")
                        .withPassword("12345")
                        .build(),
                Student.builder()
                        .withStatus("Daily")
                        .withId(3)
                        .withName("Pol")
                        .withSecondName("Crosby")
                        .withBirthday(LocalDate.of(1983, 3, 7))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("3@mail.ru")
                        .withPassword("12345")
                        .build(),
                Student.builder()
                        .withStatus("Daily")
                        .withId(4)
                        .withName("Cary")
                        .withSecondName("Price")
                        .withBirthday(LocalDate.of(1983, 3, 7))
                        .withPhone(new Phone(1, "+7", "812", "3334455", "0987"))
                        .withEmail("4@mail.ru")
                        .withPassword("12345")
                        .build()
        );

        assertThat(studentCrudDaoImplTest.findAll(10), is(expected));
    }
}
